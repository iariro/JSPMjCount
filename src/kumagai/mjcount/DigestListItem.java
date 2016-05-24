package kumagai.mjcount;

import java.text.*;
import ktool.datetime.*;

/**
 * ダイジェスト一覧用表示情報。
 * @author kumagai
 */
public class DigestListItem
{
	static private final NumberFormat format2 = new DecimalFormat("00%");

	public int num;
	public String color1;
	public String datetime;
	public String playTime;
	public String playNetTime;
	public String gameCenter;
	public String gameKind;
	public int gameCount;
	public String color2;
	public String agariRatio;
	public String tenpaiRatio;
	public int agarinashiCount;
	public int inCredit;
	public int outCredit;
	public int maxCredit;
	public String filename;
	public int index;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param color1 １行の色
	 * @param datetime 日時
	 * @param playTime プレイ時間
	 * @param playNetTime 正味プレイ時間
	 * @param gameCenter ゲームセンター名
	 * @param gameKind ゲーム機種名
	 * @param gameCount 局数
	 * @param color2 列の色
	 * @param agariRatio 和了率
	 * @param tenpaiRatio 聴牌率
	 * @param agarinashiCount 和がりなしカウント
	 * @param inCredit 投入クレジット
	 * @param outCredit 取得クレジット
	 * @param maxCredit 最大クレジット
	 * @param filename ファイル名
	 * @param index ファイル中の対象インデックス
	 */
	public DigestListItem(String color1, String datetime, String playTime,
		String playNetTime, String gameCenter, String gameKind, int gameCount,
		String color2, String agariRatio, String tenpaiRatio,
		int agarinashiCount, int inCredit, int outCredit, int maxCredit,
		String filename, int index)
	{
		this.color1 = color1;
		this.datetime = datetime;
		this.playTime = playTime;
		this.playNetTime = playNetTime;
		this.gameCenter = gameCenter;
		this.gameKind = gameKind;
		this.gameCount = gameCount;
		this.color2 = color2;
		this.agariRatio = agariRatio;
		this.tenpaiRatio = tenpaiRatio;
		this.agarinashiCount = agarinashiCount;
		this.inCredit = inCredit;
		this.outCredit = outCredit;
		this.maxCredit = maxCredit;
		this.filename = filename;
		this.index = index;
	}

	/**
	 * 日時を取得。
	 * @return 日時
	 */
	public String getDatetime()
	{
		return datetime.substring(0, 10);
	}

	/**
	 * 日時を取得。年は省略。
	 * @return 日時
	 */
	public String getDatetimeWithoutYear()
	{
		return datetime.substring(5, 16);
	}

	/**
	 * 出率を取得。
	 * @return 出率
	 */
	public String getRatioAsString()
	{
		String ratio = "-";

		if (inCredit > 0)
		{
			// 投入クレジットあり。

			ratio = format2.format((float)(inCredit + outCredit) / inCredit);
		}

		return ratio;
	}

	/**
	 * 出率を取得。
	 * @return 出率
	 */
	public int getRatioAsInt()
	{
		if (inCredit > 0)
		{
			// 投入クレジットあり。

			return (inCredit + outCredit) * 100 / inCredit;
		}
		else
		{
			// 投入クレジットなし。

			return 0;
		}
	}

	public boolean getCurrentYear()
	{
		DateTime today = new DateTime();

		if (Integer.valueOf(filename.substring(7, 7 + 4)) == today.getYear())
		{
			// 今年の分である。

			return true;
		}
		else
		{
			// 今年の分ではない。

			return false;
		}
	}
}
