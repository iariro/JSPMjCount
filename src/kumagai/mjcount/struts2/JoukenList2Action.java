package kumagai.mjcount.struts2;

import java.text.*;
import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;

/**
 * 条件指定リスト表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/joukenlist2.jsp")
public class JoukenList2Action
{
	public String gameCenter;
	public String gameKind;
	public ArrayList<DigestListItem> itemsCollection;

	/**
	 * 条件指定リスト表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("joukenlist2")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		NumberFormat format = new DecimalFormat("00.00%");

		String fileFolderMobile =
			context.getInitParameter("maajanFilePathMobile");
		String fileFolderPC =
			context.getInitParameter("maajanFilePathPC");

		MjCountDocumentCollection documentCollection =
			new MjCountDocumentCollection
				(fileFolderMobile, fileFolderPC, true, 6);

		itemsCollection = new ArrayList<DigestListItem>();

		for (int i=0 ; i<documentCollection.size() ; i++)
		{
			// ドキュメント１個取り出し。
			MjCountDocument document = documentCollection.get(i);

			ArrayList<PlayDataCollection> playDataCollections =
				document.getPlayDataCollection();

			String color1 = new String();

			for (int j=0 ; j<playDataCollections.size() ; j++)
			{
				int index = playDataCollections.size() - j - 1;
				PlayDataCollection playDataCollection =
					playDataCollections.get(index);

				if (playDataCollection.gameResults.size() > 0)
				{
					// １個でも情報がある。

					boolean match = true;

					if (!gameCenter.equals("-") &&
						!gameCenter.equals(playDataCollection.gameCenter))
					{
						match = false;
					}

					if (!gameKind.equals("-") &&
						!gameKind.equals(playDataCollection.gameKind))
					{
						match = false;
					}

					if (match)
					{
						// 条件に合致する。

						int inCredit = playDataCollection.getInCreditCount();
						int outCredit = playDataCollection.getOutCreditCount();

						String color2 = "white";
						float agariRatio = playDataCollection.getAgariRatio();

						DigestListItem item =
							new DigestListItem(
								color1,
								playDataCollection.starttime,
								playDataCollection.getPlayTime(),
								playDataCollection.getPlayNetTime(),
								playDataCollection.gameCenter,
								playDataCollection.gameKind,
								playDataCollection.gameResults.size(),
								color2,
								format.format(agariRatio),
								format.format(playDataCollection.getTenpaiRatio()),
								playDataCollection.getAgarinashiCount(),
								inCredit,
								outCredit,
								playDataCollection.getMaxCredit(),
								document.filename,
								index);

						itemsCollection.add(item);
					}
				}
			}

			for (int j=0 ; j<itemsCollection.size() ; j++)
			{
				itemsCollection.get(j).num = j + 1;
			}
		}

		return "success";
	}
}
