package kumagai.mjcount.struts2;

import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;

/**
 * 記念すべきプレイ一覧表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/epoch.jsp")
public class EpochAction
{
	public ArrayList<EpochListItemCollection> epochListItemCollection;

	/**
	 * 記念すべきプレイ一覧表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("epoch")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		String fileFolderMobile =
			context.getInitParameter("maajanFilePathMobile");
		String fileFolderPC =
			context.getInitParameter("maajanFilePathPC");

		MjCountDocumentCollection documentCollection =
			new MjCountDocumentCollection
				(fileFolderMobile, fileFolderPC, false, 24);

		epochListItemCollection = new ArrayList<EpochListItemCollection>();

		for (int i=0 ; i<documentCollection.size() && i<24 ; i++)
		{
			// ドキュメント１個取り出し。
			MjCountDocument document = documentCollection.get(i);

			ArrayList<PlayDataCollection> playDataCollections =
				document.getPlayDataCollection();

			EpochListItemCollection items =
				new EpochListItemCollection
					(document.month, document.currentYear);
			epochListItemCollection.add(items);

			String gamecenter2 = new String();
			String starttime2 = new String();
			String color1 = new String();

			for (int j=0 ; j<playDataCollections.size() ; j++)
			{
				int index = playDataCollections.size() - j - 1;
				PlayDataCollection playDataCollection = playDataCollections.get(index);

				if (playDataCollection.comment != null)
				{
					// コメント指定あり。

					if (playDataCollection.gameResults.size() > 0)
					{
						// １個でも情報あり。

						if (! playDataCollection.gameCenter.equals(gamecenter2) ||
							!playDataCollection.starttime.substring(0, 10).equals(starttime2.substring(0, 10)))
						{
							// １個前と別のゲームセンター、または別の日であ
							// る。

							if (color1.equals("white"))
							{
								// 直前は白だった。

								color1 = "#dddddd";
							}
							else
							{
								// 直前は灰だった。

								color1 = "white";
							}
						}

						EpochListItem item =
							new EpochListItem(
								color1,
								playDataCollection.starttime.substring(5, 16),
								playDataCollection.gameCenter,
								playDataCollection.gameKind,
								playDataCollection.comment,
								document.filename,
								index);

						items.add(item);
					}
				}

				gamecenter2 = playDataCollection.gameCenter;
				starttime2 = playDataCollection.starttime;
			}
		}

		return "success";
	}
}
