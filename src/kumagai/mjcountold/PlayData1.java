package kumagai.mjcountold;

import java.text.*;
import ktool.datetime.*;
import ktool.xml.*;

/**
 * ゲームデータ。
 * @author kumagai
 */
public class PlayData1
{
	public String datetime1;
	public String datetime2;
	public String gamecenter;
	public String gameKind;

	public int ツモ和がり;
	public int ロン和がり;
	public int ラストチャンス和がり;
	public int 聴牌ツモ和がられ;
	public int 聴牌ロン和がられ;
	public int 不聴ツモ和がられ;
	public int 不聴ロン和がられ;
	public int 聴牌荒牌;
	public int 不聴荒牌;
	public int total;
	public int 和がりなしカウント;
	public int 料金;

	/**
	 * XML要素からデータオブジェクトを構築する。
	 * @param item ゲーム要素
	 */
	public PlayData1(StructElement item)
	{
		datetime1 = item.element().getAttribute("datetime1");
		datetime2 = item.element().getAttribute("datetime2");
		gamecenter = item.element().getAttribute("gamecenter");
		gameKind = item.element().getAttribute("gameKind");

		ツモ和がり =
			Integer.valueOf(item.element().getAttribute("ツモ和がり"));
		ロン和がり =
			Integer.valueOf(item.element().getAttribute("ロン和がり"));
		ラストチャンス和がり =
			Integer.valueOf(item.element().getAttribute("ラストチャンス和がり"));
		聴牌ツモ和がられ =
			Integer.valueOf(item.element().getAttribute("聴牌ツモ和がられ"));
		聴牌ロン和がられ =
			Integer.valueOf(item.element().getAttribute("聴牌ロン和がられ"));
		不聴ツモ和がられ =
			Integer.valueOf(item.element().getAttribute("不聴ツモ和がられ"));
		不聴ロン和がられ =
			Integer.valueOf(item.element().getAttribute("不聴ロン和がられ"));
		聴牌荒牌 =
			Integer.valueOf(item.element().getAttribute("聴牌荒牌"));
		不聴荒牌 =
			Integer.valueOf(item.element().getAttribute("不聴荒牌"));

		String agarinashiCount =
			item.element().getAttribute("和がりなしカウント");

		if (agarinashiCount != null)
		{
			// 和がりなしカウント要素あり。

			if (agarinashiCount.length() > 0)
			{
				// 要素は空文字列ではない。

				和がりなしカウント = Integer.valueOf(agarinashiCount);
			}
		}

		String ryoukin =
			item.element().getAttribute("料金");

		if (ryoukin != null)
		{
			// 料金要素あり。

			if (ryoukin.length() > 0)
			{
				// 要素は空文字列ではない。

				料金 = Integer.valueOf(ryoukin);
			}
		}

		total =
			ツモ和がり +
			ロン和がり +
			ラストチャンス和がり +
			聴牌ツモ和がられ +
			聴牌ロン和がられ +
			不聴ツモ和がられ +
			不聴ロン和がられ +
			聴牌荒牌 +
			不聴荒牌;
	}

	/**
	 * プレイ時間
	 * @return プレイ時間
	 * @throws ParseException
	 */
	public String getPlayTime()
		throws ParseException
	{
		DateTime start = new DateTime(datetime1);
		DateTime end = new DateTime(datetime2);

		return end.diff(start).toString();
	}

	/**
	 * 和がり率を取得。
	 * @return 和がり率
	 */
	public float getAgariRatio()
	{
		return (float)(ツモ和がり + ロン和がり + ラストチャンス和がり) / (float)total;
	}

	/**
	 * 聴牌率を取得。
	 * @return 聴牌率
	 */
	public float getTenpaiRatio()
	{
		return
			(float)(
				ツモ和がり +
				ロン和がり +
				ラストチャンス和がり +
				聴牌ツモ和がられ +
				聴牌ロン和がられ +
				聴牌荒牌) / (float)total;
	}

	/**
	 * ラストチャンス和がり率を取得。
	 * @return ラストチャンス和がり率
	 */
	public float getLastChanceRatio()
	{
		return
			(float)ラストチャンス和がり /
			(float)(ラストチャンス和がり + 聴牌荒牌);
	}

	/**
	 * ゲーム数を取得。
	 * @return ゲーム数
	 */
	public int getTotalCount()
	{
		return total;
	}
}
