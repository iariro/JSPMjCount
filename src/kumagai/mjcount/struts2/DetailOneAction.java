package kumagai.mjcount.struts2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;
import ktool.datetime.*;

/**
 * ゲーム詳細情報表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/detailone.jsp")
public class DetailOneAction
{
	public String filename;
	public int index;


	public PlayDataCollection playDataCollection;
	public PlayDataListCollection playDataListCollection;
	public DetailStatistics statistics;

	/**
	 * ゲーム詳細情報表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("detailone")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		String fileFolderMobile =
			context.getInitParameter("maajanFilePathMobile");
		String fileFolderPC =
			context.getInitParameter("maajanFilePathPC");

		DateTime today = new DateTime();

		File file;
		boolean currentYear;

		if (Integer.valueOf(filename.substring(7, 7 + 4)) == today.getYear())
		{
			// 今年の分である。

			file = new File(fileFolderMobile, filename);
			currentYear = true;
		}
		else
		{
			// 今年の分ではない。

			file = new File(fileFolderPC, filename);
			currentYear = false;
		}

		MjCountDocument document =
			new MjCountDocument(
				file.getAbsolutePath(),
				file.getName(),
				currentYear);

		ArrayList<PlayDataCollection> playDataCollections =
			document.getPlayDataCollection();

		playDataCollection = playDataCollections.get(index);

		playDataListCollection =
			new PlayDataListCollection(playDataCollection, true);

		statistics =
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

		return "success";
	}
}
