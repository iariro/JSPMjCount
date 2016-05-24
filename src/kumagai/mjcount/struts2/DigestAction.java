package kumagai.mjcount.struts2;

import java.text.*;
import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;

/**
 * ダイジェスト一覧表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/digest.jsp")
public class DigestAction
{
	public String all;
	public ArrayList<DigestListItemCollection> itemsCollection;

	/**
	 * ダイジェスト一覧表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("digest")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		NumberFormat format = new DecimalFormat("00.00%");

		String fileFolderMobile =
			context.getInitParameter("maajanFilePathMobile");
		String fileFolderPC =
			context.getInitParameter("maajanFilePathPC");

		boolean all = Boolean.valueOf(this.all);

		MjCountDocumentCollection documentCollection =
			new MjCountDocumentCollection
				(fileFolderMobile, fileFolderPC, all, 6);

		itemsCollection = new ArrayList<DigestListItemCollection>();

		for (int i=0 ; i<documentCollection.size() && (all || i<6) ; i++)
		{
			// ドキュメント１個取り出し。
			MjCountDocument document = documentCollection.get(i);

			ArrayList<PlayDataCollection> playDataCollections =
				document.getPlayDataCollection();

			DigestListItemCollection items =
				new DigestListItemCollection
					(document.month, document.currentYear);
			itemsCollection.add(items);

			String gamecenter2 = new String();
			String starttime2 = new String();
			String color1 = new String();

			for (int j=0 ; j<playDataCollections.size() ; j++)
			{
				int index = playDataCollections.size() - j - 1;
				PlayDataCollection playDataCollection =
					playDataCollections.get(index);

				if (playDataCollection.gameResults.size() > 0)
				{
					// １個でも情報がある。

					if (! playDataCollection.gameCenter.equals(gamecenter2) ||
						!playDataCollection.starttime.substring(0, 10).equals(starttime2.substring(0, 10)))
					{
						// １個前と別のゲームセンター、または別の日である。

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

					int inCredit = playDataCollection.getInCreditCount();
					int outCredit = playDataCollection.getOutCreditCount();

					String color2 = "white";
					float agariRatio = playDataCollection.getAgariRatio();

					if (agariRatio == 0)
					{
						// 和了率＝０。

						color2 = "gray";
					}
					else if (agariRatio < 0.1f)
					{
						// 和了率１０％未満。

						color2 = "#cccccc";
					}
					else if (agariRatio < 0.2f)
					{
						// 和了率２０％未満。

						color2 = "white";
					}
					else if (agariRatio < 0.3f)
					{
						// 和了率３０％未満。

						color2 = "lightyellow";
					}
					else
					{
						// 和了率３０％以上。

						color2 = "lightblue";
					}

					DigestListItem item =
						new DigestListItem(
							color1,
							playDataCollection.starttime.substring(5, 16),
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

					items.add(item);
				}

				gamecenter2 = playDataCollection.gameCenter;
				starttime2 = playDataCollection.starttime;
			}
		}

		return "success";
	}
}
