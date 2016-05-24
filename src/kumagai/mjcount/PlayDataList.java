package kumagai.mjcount;

/**
 * 詳細ゲーム情報。
 * @author kumagai
 */
public class PlayDataList
{
	private final String bgcolor;
	private final String count;
	private final String progress;
	private final String time;
	private final String diff;
	private final String result;
	private final String count2;
	private final int inCredit;
	private final int outCredit;
	private final int credit;
	private final int bet;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param bgcolor 背景色
	 * @param count カウント
	 * @param progress 経過時間
	 * @param time 時刻
	 * @param diff １ゲームの時間
	 * @param result ゲーム結果
	 * @param count2 同結果カウント
	 * @param inCredit 投入クレジット
	 * @param outCredit 獲得クレジット
	 * @param credit クレジット
	 * @param bet ベットクレジット
	 */
	public PlayDataList(String bgcolor, String count, String progress,
		String time, String diff, String result, String count2, int inCredit,
		int outCredit, int credit, int bet)
	{
		this.bgcolor = bgcolor;
		this.count = count;
		this.progress = progress;
		this.time = time;
		this.diff = diff;
		this.result = result;
		this.count2 = count2;
		this.inCredit = inCredit;
		this.outCredit = outCredit;
		this.credit = credit;
		this.bet = bet;
	}

	/**
	 * 背景色を取得。
	 * @return 背景色
	 */
	public String getBgcolor()
	{
		return bgcolor;
	}

	/**
	 * カウントを取得。
	 * @return カウント
	 */
	public String getCount()
	{
		return count;
	}

	/**
	 * 経過時間を取得。
	 * @return 経過時間
	 */
	public String getProgress()
	{
		return progress;
	}

	/**
	 * 時刻を取得。
	 * @return 時刻
	 */
	public String getTime()
	{
		return time;
	}

	/**
	 * １ゲームの時間を取得。
	 * @return １ゲームの時間
	 */
	public String getDiff()
	{
		return diff;
	}

	/**
	 * ゲーム結果を取得。
	 * @return ゲーム結果
	 */
	public String getResult()
	{
		return result;
	}

	/**
	 * 同結果カウントを取得。
	 * @return 同結果カウント
	 */
	public String getCount2()
	{
		return count2;
	}

	/**
	 * 投入クレジットを取得。
	 * @return 投入クレジット
	 */
	public int getInCredit()
	{
		return inCredit;
	}

	/**
	 * 獲得クレジットを取得。
	 * @return 獲得クレジット
	 */
	public int getOutCredit()
	{
		return outCredit;
	}

	/**
	 * クレジットを取得。
	 * @return クレジット
	 */
	public int getCredit()
	{
		return credit;
	}

	/**
	 * ベットクレジットを取得。
	 * @return ベットクレジット
	 */
	public int getBet()
	{
		return bet;
	}

	/**
	 * 投入クレジット－ベット数を取得。
	 * @return 投入クレジット－ベット数
	 */
	public int getInCreditMinusBet()
	{
		return inCredit - bet;
	}

	/**
	 * 投入クレジットの割合を取得。
	 * @return 投入クレジットの割合
	 */
	public int getInCreditRatio()
	{
		return ((inCredit - bet) * 100) / (inCredit + outCredit - bet);
	}
}
