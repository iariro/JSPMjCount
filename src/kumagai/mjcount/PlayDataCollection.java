package kumagai.mjcount;

import java.text.*;
import java.util.*;
import ktool.datetime.*;
import ktool.xml.*;

/**
 * ゲーム情報コレクション。
 * @author kumagai
 */
public class PlayDataCollection
{
	static private final SimpleDateFormat formatDate;
	static private final TimeSpan maxGameTime = new TimeSpan(0, 2, 0);

	/**
	 * 日付書式オブジェクトを構築。
	 */
	static
	{
		formatDate = new SimpleDateFormat();

		formatDate.applyPattern("yyyy/MM/dd HH:mm:ss");
	}

	public String gameCenter;
	public String gameKind;
	public String starttime;
	public String comment;

	public ArrayList<PlayData> gameResults = new ArrayList<PlayData>();

	public void setStarttime(String startdatetime)
	{
		Date date = new Date();
		date.setTime(Long.valueOf(startdatetime));
		this.starttime = formatDate.format(date);
	}

	public PlayDataCollection()
	{
	}

	/**
	 * 指定の要素からゲーム情報コレクションを構築する。
	 * @param element 要素
	 * @throws ParseException
	 */
	public PlayDataCollection(StructElement element)
		throws ParseException
	{
		gameCenter = element.element().getAttribute("gc");
		gameKind = element.element().getAttribute("gk");
		starttime = element.element().getAttribute("st");

		if (element.element().hasAttribute("cmt"))
		{
			// cmt属性あり。

			comment = element.element().getAttribute("cmt");
		}
		else
		{
			// cmt属性なし。

			comment = null;
		}

		StructElement [] items = element.getChildElements();

		for (int i=0 ; i<items.length ; i++)
		{
			gameResults.add(new PlayData(items[i]));
		}
	}

	/**
	 * ゲームセンター名を取得。
	 * @return ゲームセンター名
	 */
	public String getGameCenter()
	{
		return gameCenter;
	}

	/**
	 * ゲーム機種名を取得。
	 * @return ゲーム機種名
	 */
	public String getGameKind()
	{
		return gameKind;
	}

	/**
	 * プレイ年月日を取得。
	 * @return プレイ年月日
	 */
	public String getFullDate()
	{
		return starttime.substring(0, 10);
	}

	/**
	 * プレイ日を取得。
	 * @return プレイ日
	 */
	public String getDate()
	{
		return starttime.substring(5, 10);
	}

	/**
	 * プレイ開始時刻を取得。
	 * @return プレイ開始時刻
	 */
	public String getDateTime()
	{
		return starttime.substring(5, 16);
	}

	/**
	 * コメントを取得。
	 * @return コメント
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * 指定のゲーム結果の回数を取得。
	 * @param results ゲーム結果
	 * @return 指定のゲーム結果の回数
	 */
	public int getResultCount(String ... results)
	{
		int count = 0;

		for (PlayData playData : gameResults)
		{
			for (int i=0 ; i<results.length ; i++)
			{
				if (playData.result.equals(results[i]))
				{
					// 一致する。

					count++;
					break;
				}
			}
		}

		return count;
	}

	/**
	 * プレイ時間を取得。
	 * @return プレイ時間
	 */
	public String getPlayTime()
	{
		if (gameResults.size() > 0)
		{
			// １要素でもある。

			return gameResults.get(gameResults.size() - 1).datetime;
		}
		else
		{
			// １要素もない。

			return null;
		}
	}

	/**
	 * 正味プレイ時間を取得。
	 * @return 正味プレイ時間
	 */
	public String getPlayNetTime()
		throws ParseException
	{
		TimeSpan totalNetTime = new TimeSpan(0);

		TimeSpan time2 = new TimeSpan(0);

		for (PlayData playData : gameResults)
		{
			TimeSpan time = new TimeSpan(playData.datetime);

			TimeSpan diff = time.diff(time2);

			if (diff.compare(maxGameTime) < 0)
			{
				// 閾値未満。

				totalNetTime.add(diff);
			}
			else
			{
				// 閾値以上。

				totalNetTime.add(maxGameTime);
			}

			time2 = time;
		}

		return totalNetTime.toString();
	}

	/**
	 * 和了率を取得。
	 * @return 和了率
	 */
	public float getAgariRatio()
	{
		int count =
			getResultCount("ツモ和がり", "ロン和がり", "ラストチャンス和がり");

		return (float)(count / (float)gameResults.size());
	}

	/**
	 * 和了の回数を取得。
	 * @return 和了の回数
	 */
	public int getAgariCount()
	{
		return
			getResultCount("ツモ和がり", "ロン和がり", "ラストチャンス和がり");
	}

	/**
	 * 聴牌率を取得。
	 * @return 聴牌率
	 */
	public float getTenpaiRatio()
	{
		int count =
			getResultCount(
				"ツモ和がり",
				"ロン和がり",
				"ラストチャンス和がり",
				"聴牌ツモ和がられ",
				"聴牌ロン和がられ",
				"聴牌荒牌");

		return (float)(count / (float)getGameCount());
	}

	/**
	 * 聴牌の回数を取得。
	 * @return 聴牌の回数
	 */
	public int getTenpaiCount()
	{
		return
			getResultCount(
				"ツモ和がり",
				"ロン和がり",
				"ラストチャンス和がり",
				"聴牌ツモ和がられ",
				"聴牌ロン和がられ",
				"聴牌荒牌");
	}

	/**
	 * ラストチャンス和がりの和了率を取得。
	 * @return ラストチャンス和がりの和了率
	 */
	public float getLastChanceRatio()
	{
		float atari = (float)getResultCount("ラストチャンス和がり");
		float hazure = (float)getResultCount("聴牌荒牌");

		return (float) atari / (float)(atari + hazure);
	}

	/**
	 * 最大和がりなしゲーム数を取得。
	 * @return 最大和がりなしゲーム数
	 */
	public int getAgarinashiCount()
	{
		int count = 0;
		int maxCount = 0;

		for (int i=0 ; i<gameResults.size() ; i++)
		{
			if (gameResults.get(i).result.indexOf("和がり") >= 0)
			{
				// 和がり。

				count = 0;
			}
			else if (! gameResults.get(i).result.equals("ボーナス"))
			{
				// 和がれず。

				count++;
			}

			if (count > maxCount)
			{
				// 最高記録。

				maxCount = count;
			}
		}

		return maxCount;
	}

	/**
	 * 投入クレジット数を取得。
	 * @return 投入クレジット数
	 */
	public int getInCreditCount()
	{
		int count = 0;

		for (PlayData playData : gameResults)
		{
			count += playData.inCredit;
		}

		return count;
	}

	/**
	 * 取得クレジット数を取得。
	 * @return 取得クレジット数
	 */
	public int getOutCreditCount()
	{
		int count = 0;

		for (PlayData game : gameResults)
		{
			count += game.outCredit;
		}

		return count;
	}

	/**
	 * ゲーム数を取得。
	 * @return ゲーム数
	 */
	public int getGameCount()
	{
		return gameResults.size() - getResultCount("ボーナス");
	}

	/**
	 * 最大クレジット数を取得。
	 * @return 最大クレジット数
	 */
	public int getMaxCredit()
	{
		int credit = 0;
		int max = 0;

		for (PlayData playData : gameResults)
		{
			if (playData.result.equals("ボーナス"))
			{
				// ボーナス。

				credit += playData.outCredit + playData.inCredit;
			}
			else
			{
				// ボーナス以外。

				credit += playData.outCredit + playData.inCredit - playData.bet;
			}

			if (credit > max)
			{
				// 現在の最大を越えた。

				max = credit;
			}
		}

		return max;
	}
}
