package kumagai.mjcount.struts2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.xml.transform.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.convention.annotation.Result;
import kumagai.mjcount.*;

/**
 * 作曲家登録アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/creditgraph.jsp")
public class CreditGraphAction
{
	public String filename;
	public int index;
	public int style;
	public boolean currentYear;
	public CreditProgressGraphDocument graphDocument;

	/**
	 * グラフSVGドキュメントを文字列として取得。
	 * @return 文字列によるグラフSVGドキュメント
	 * @throws TransformerException
	 */
	public String getXml()
		throws TransformerFactoryConfigurationError, TransformerException
	{
		// XML書き出し準備。
		Transformer transformer =
			TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

		StringWriter writer = new StringWriter();

		// XML書き出し。
		graphDocument.write(transformer, writer);

		return writer.toString();
	}

	/**
	 * 作曲家登録アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("creditgraph")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		String parameterName;

		if (currentYear)
		{
			// 今年分。

			parameterName = "maajanFilePathMobile";
		}
		else
		{
			// 去年以前分。

			parameterName = "maajanFilePathPC";
		}

		String fileFolder = context.getInitParameter(parameterName);

		String filepath = String.format("%s\\%s", fileFolder, filename);

		// データXML読み込み。
		MjCountDocument document =
			new MjCountDocument(filepath, null, currentYear);

		// 全内容取得。
		ArrayList<PlayDataCollection> playDataCollections =
			document.getPlayDataCollection();

		switch (style)
		{
			case 0:
			case 1:
				// 対象の対戦結果取得。
				PlayDataCollection playDataCollection =
					playDataCollections.get(index);

				// クレジット遷移を含む表示形式データ生成。
				PlayDataListCollection playDataListCollection =
					new PlayDataListCollection(playDataCollection, style == 0);

				// クレジット遷移グラフドキュメント生成。
				graphDocument =
					new CreditProgressGraphDocument(
						playDataCollection.gameCenter,
						playDataCollection.comment,
						new PlayDataListCollection []
						{
							playDataListCollection
						},
						style == 0);
				break;

			case 2:
			case 3:
				String targetdate =
					playDataCollections.get(index).starttime.substring(0, 10);
				String targetGameCenter =
					playDataCollections.get(index).gameCenter;

				ArrayList<PlayDataListCollection> playDataListCollections =
					new ArrayList<PlayDataListCollection>();

				for (int i=0 ; i<playDataCollections.size() ; i++)
				{
					// 対象の対戦結果取得。
					PlayDataCollection playDataCollection3 =
						playDataCollections.get(i);

					if (playDataCollection3.starttime.substring(0, 10).equals(targetdate) &&
						playDataCollection3.gameCenter.equals(targetGameCenter))
					{
						// クレジット遷移を含む表示形式データ生成。
						playDataListCollections.add(
							new PlayDataListCollection(
								playDataCollection3,
								style == 2));
					}
				}

				// クレジット遷移グラフドキュメント生成。
				graphDocument =
					new CreditProgressGraphDocument(
						targetGameCenter,
						new String(),
						playDataListCollections.toArray
							(new PlayDataListCollection [0]),
						style == 2);
				break;

			default:
				throw new Exception(String.format("style=%d", style));
		}

		return "success";
	}
}
