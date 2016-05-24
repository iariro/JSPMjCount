package kumagai.mjcount.struts2;

import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;

/**
 * ゲーム詳細情報リスト表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/detail.jsp")
public class DetailAction
{
	public ArrayList<DetailListItemCollection> listItemsCollection;

	/**
	 * ゲーム詳細情報リスト表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("detail")
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
				(fileFolderMobile, fileFolderPC, false, 1);

		listItemsCollection = new ArrayList<DetailListItemCollection>();

		for (int i=0 ; i<documentCollection.size() && i<1 ; i++)
		{
			// ドキュメント１個取り出し。
			MjCountDocument document = documentCollection.get(i);

			ArrayList<PlayDataCollection> playDataCollections =
				document.getPlayDataCollection();

			DetailListItemCollection detailListItems =
				new DetailListItemCollection(document.month);

			listItemsCollection.add(detailListItems);

			for (int j=0 ; j<playDataCollections.size() ; j++)
			{
				PlayDataCollection playDataCollection =
					playDataCollections.get(playDataCollections.size() - j - 1);

				PlayDataListCollection playDataListCollection =
					new PlayDataListCollection(playDataCollection, true);

				DetailStatistics statistics =
					new DetailStatistics(
						playDataCollection.getDateTime(),
						playDataCollection.getPlayTime(),
						playDataCollection.gameCenter,
						playDataCollection.gameKind,
						playDataListCollection.gameCount,
						playDataCollection.getAgarinashiCount(),
						playDataListCollection.inCredit,
						playDataListCollection.outCredit,
						playDataCollection.getMaxCredit(),
						playDataListCollection.agariritsu1,
						playDataListCollection.agariritsu2,
						playDataListCollection.tenpairitsu1,
						playDataListCollection.tenpairitsu2,
						playDataListCollection.lastChance1,
						playDataListCollection.lastChance2,
						playDataListCollection.deritsu1,
						playDataListCollection.deritsu2,
						playDataListCollection.heikinKakutokuCredit1,
						playDataListCollection.heikinKakutokuCredit2);

				detailListItems.add(
					new DetailListItem(
						playDataCollection,
						playDataListCollection,
						statistics));
			}
		}

		return "success";
	}
}
