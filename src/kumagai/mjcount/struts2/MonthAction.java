package kumagai.mjcount.struts2;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import ktool.datetime.*;
import kumagai.mjcount.*;

/**
 * 月指定詳細戦績表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/month.jsp")
public class MonthAction
{
	public int year;
	public int month;
	public String monthString;
	public DetailListItemCollection detailListItems;

	/**
	 * 月指定詳細戦績表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("month")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		String parameterName;

		boolean currentYear = year >= new DateTime().getYear();

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

		monthString = String.format("%04d年%02d月", year, month);
		String path =
			String.format("%s\\MjCount%04d%02d.xml", fileFolder, year, month);

		ArrayList<PlayDataCollection> playDataCollections;

		try
		{
			MjCountDocument document =
				new MjCountDocument(path, monthString, currentYear);
			playDataCollections = document.getPlayDataCollection();

			detailListItems = new DetailListItemCollection(document.month);

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

			return "success";
		}
		catch (FileNotFoundException exception)
		{
			return "success";
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
			return "error";
		}
	}

}
