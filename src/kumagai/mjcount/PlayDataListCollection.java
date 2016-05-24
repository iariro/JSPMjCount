package kumagai.mjcount;

import java.text.*;
import java.util.*;
import ktool.datetime.*;

/**
 * 詳細ゲーム情報コレクション。
 * @author kumagai
 */
public class PlayDataListCollection
	extends ArrayList<PlayDataList>
{
	static private final NumberFormat format = new DecimalFormat("00.00%");
	static private final NumberFormat format2 = new DecimalFormat("00%");
	static private final NumberFormat format3 = new DecimalFormat("0.00");

	public int credit;
	public final int gameCount;
	public final int inCredit;
	public final int outCredit;
	public int maxCredit;
	public int minCredit;
	public final String agariritsu1;
	public final String agariritsu2;
	public final String tenpairitsu1;
	public final String tenpairitsu2;
	public final String lastChance1;
	public final String lastChance2;
	public String deritsu1;
	public final String deritsu2;
	public String heikinKakutokuCredit1;
	public final String heikinKakutokuCredit2;
	public final DateTime starttime;
	public final String gameKind;

	/**
	 * 指定のゲーム情報コレクションから詳細情報コレクションを構築する。
	 * @param playDataCollection ゲーム情報コレクション
	 * @param creditGraph true=クレジットの遷移グラフ用
	 * @throws ParseException
	 */
	public PlayDataListCollection(PlayDataCollection playDataCollection, boolean creditGraph)
		throws ParseException
	{
		int count1 = 0;
		int count2 = 0;
		boolean agari = true;
		boolean agari2 = true;

		this.gameKind = playDataCollection.gameKind;

		maxCredit = 0;
		minCredit = 0;

		this.starttime = new DateTime(playDataCollection.starttime);

		for (int i=0 ; i<playDataCollection.gameResults.size() ; i++)
		{
			PlayData playData = playDataCollection.gameResults.get(i);

			String count1string = new String();

			TimeSpan time = new TimeSpan(playData.datetime);

			if (! playData.result.equals("ボーナス"))
			{
				// ボーナス以外。

				count1++;
				count1string = Integer.toString(count1);
			}

			String diff;

			if (i <= 0)
			{
				// １個目。

				diff = Integer.toString(time.getTotalSecond());
			}
			else
			{
				// ２個目以降。

				TimeSpan time0 =
					new TimeSpan(playDataCollection.gameResults.get(i - 1).datetime);

				diff = Integer.toString(time.diff(time0).getTotalSecond());
			}

			String bgcolor = "#dddddd";

			if (creditGraph)
			{
				// クレジットの遷移グラフ用。

				credit += playData.outCredit + playData.inCredit;
			}
			else
			{
				// 収支グラフ用。

				credit += playData.outCredit;
			}

			if (playData.result.equals("ボーナス"))
			{
				// ボーナスの場合。

				bgcolor = "pink";
			}
			else
			{
				// ボーナス以外の場合。

				credit -= playData.bet;
			}

			String count2string = new String();

			if (! playData.result.equals("ボーナス"))
			{
				// ボーナス以外。

				if (playData.result.indexOf("和がり") >= 0)
				{
					// 和がり。

					bgcolor = "lightblue";
					agari = true;
				}
				else
				{
					// 和がりなし。

					if (playData.result.indexOf("不聴") >= 0)
					{
						// 不聴の場合。

						bgcolor = "gray";
					}

					agari = false;
				}

				if (agari != agari2)
				{
					// 前のエントリと異なる結果である。

					count2 = 0;
				}

				count2++;
				count2string = Integer.toString(count2);
			}

			agari2 = agari;

			if (credit > maxCredit)
			{
				// 最大を上回る。

				maxCredit = credit;
			}

			if (credit < minCredit)
			{
				// 最大を上回る。

				minCredit = credit;
			}

			add(
				new PlayDataList(
					bgcolor,
					count1string,
					playData.datetime,
					starttime.makeAdd(time).toTimeString(),
					diff,
					playData.result,
					count2string,
					playData.inCredit,
					playData.outCredit,
					credit,
					playData.bet));
		}

		gameCount = playDataCollection.getGameCount();
		inCredit = playDataCollection.getInCreditCount();
		outCredit = playDataCollection.getOutCreditCount();

		int agariCount = playDataCollection.getAgariCount();
		int lastChanceAgari =
			playDataCollection.getResultCount("ラストチャンス和がり");
		int tenpaiFanpai = playDataCollection.getResultCount("聴牌荒牌");
		int tenpaiCount = playDataCollection.getTenpaiCount();

		agariritsu1 = format.format((float)agariCount / gameCount);
		agariritsu2 =
			String.format(
				"%d / %d",
				agariCount,
				gameCount);

		tenpairitsu1 = format.format((float)tenpaiCount / gameCount);
		tenpairitsu2 =
			String.format(
				"%d / %d",
				tenpaiCount,
				gameCount);

		lastChance1 =
			format.format
				((float)lastChanceAgari / (lastChanceAgari + tenpaiFanpai));
		lastChance2 =
			String.format(
				"%d / %d",
				lastChanceAgari,
				lastChanceAgari + tenpaiFanpai);

		deritsu1 = "-";

		if (inCredit > 0)
		{
			// クレジット投入有り。

			deritsu1 = format2.format((float)(gameCount + credit) / inCredit);
		}

		deritsu2 =
			String.format(
				"(%d + %d) / %d",
				gameCount,
				credit,
				inCredit);

		heikinKakutokuCredit1 = "-";

		if (agariCount > 0)
		{
			// 和了あり。

			heikinKakutokuCredit1 =
				format3.format((float)outCredit / agariCount);
		}

		heikinKakutokuCredit2 = String.format("%d / %d", outCredit, agariCount);
	}
}
