package kumagai.mjcountold.struts2;

import java.text.*;
import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcountold.*;

/**
 * 戦績詳細リスト表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/oldlist.jsp")
public class OldListAction
{
	public ArrayList<PlayData2Collection> playDataCollections;

	/**
	 * 戦績詳細リスト表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("oldlist")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		NumberFormat format = new DecimalFormat("00.00%");
		NumberFormat format2 = new DecimalFormat("00%");

		String fileFolder = context.getInitParameter("maajanFilePathOld");

		MjCountDocument1Collection documentCollection =
			new MjCountDocument1Collection(fileFolder);

		playDataCollections = new ArrayList<PlayData2Collection>();

		for (int i=0 ; i<3 ; i++)
		{
			MjCountDocument1 document =
				documentCollection.get(documentCollection.size() - i - 1);

			Vector<PlayData1> playData1Collection =
				document.getPlayDataCollection();

			PlayData2Collection playData2Collection =
				new PlayData2Collection(document.month);
			playDataCollections.add(playData2Collection);

			String gamecenter = new String();
			int bgcolor1index = 0;

			for (PlayData1 playData : playData1Collection)
			{
				float agariRatio = playData.getAgariRatio();
				String bgcolor1, bgcolor2, bgcolor3;
				String lastchange;

				// bgcolor1
				if (! gamecenter.equals(playData.gamecenter))
				{
					bgcolor1index = (bgcolor1index + 1) % 2;
				}

				if (bgcolor1index == 0)
				{
					bgcolor1 = "white";
				}
				else
				{
					bgcolor1 = "#cccccc";
				}

				// bgcolor2
				if (agariRatio <= 0)
				{
					bgcolor2 = "gray";
				}
				else if (agariRatio < 0.1)
				{
					bgcolor2 = "#cccccc";
				}
				else if (agariRatio < 0.2)
				{
					bgcolor2 = "#ffffdd";
				}
				else if (agariRatio < 0.3)
				{
					bgcolor2 = "white";
				}
				else
				{
					bgcolor2 = "#ccffff";
				}

				// bgcolor3
				if (playData.getLastChanceRatio() <= 0)
				{
					bgcolor3 = "gray";
				}
				else
				{
					bgcolor3 = bgcolor1;
				}

				// lastchange
				if (playData.ラストチャンス和がり + playData.聴牌荒牌 > 0)
				{
					lastchange =
						playData.ラストチャンス和がり + " / " +
						(playData.ラストチャンス和がり + playData.聴牌荒牌) + " = " +
						format.format(playData.getLastChanceRatio());
				}
				else
				{
					lastchange =
						playData.ラストチャンス和がり + " / " +
						(playData.ラストチャンス和がり + playData.聴牌荒牌) + " = " +
						"--.--%";
				}

				String ratio = "-";

				if (playData.料金 > 0)
				{
					ratio =
						format2.format((float)(playData.getTotalCount() * 100) / playData.料金);
				}

				PlayData2 game2 =
					new PlayData2(
						bgcolor1,
						bgcolor2,
						bgcolor3,
						playData.datetime1.substring(5, 16),
						playData.getPlayTime(),
						playData.gamecenter,
						playData.gameKind,
						playData.getTotalCount(),
						format.format(agariRatio),
						format.format(playData.getTenpaiRatio()),
						lastchange,
						playData.和がりなしカウント,
						ratio);
				playData2Collection.add(game2);

				gamecenter = playData.gamecenter;
			}
		}

		return "success";
	}
}
