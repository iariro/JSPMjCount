package kumagai.mjcount;

/**
 * 戦績集計情報。
 * @author kumagai
 */
public class DetailStatistics
{
	private String date;
	private String playTime;
	private String gameCenter;
	private String gameKind;
	private int gameCount;
	private int agarinashiCount;
	private int inCredit;
	private int outCredit;
	private int maxCredit;
	private String agariritsu1;
	private String agariritsu2;
	private String tenpairitsu1;
	private String tenpairitsu2;
	private String lastChance1;
	private String lastChance2;
	private String deritsu1;
	private String deritsu2;
	private String heikinKakutokuCredit1;
	private String heikinKakutokuCredit2;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param date 日付
	 * @param playTime プレイ時間
	 * @param gameCenter ゲームセンター名
	 * @param gameKind ゲーム機種名
	 * @param gameCount 局数
	 * @param agarinashiCount 和がりなしカウント
	 * @param inCredit 投入クレジット数
	 * @param outCredit 獲得クレジット数
	 * @param maxCredit 最大クレジット数
	 * @param agariritsu1 和了率
	 * @param agariritsu2 和了率内訳
	 * @param tenpairitsu1 聴牌率
	 * @param tenpairitsu2 聴牌率内訳
	 * @param lastChance1 ラストチャンス和了率
	 * @param lastChance2 ラストチャンス和了率内訳
	 * @param deritsu1 出率
	 * @param deritsu2 出率内訳
	 * @param heikinKakutokuCredit1 平均獲得クレジット
	 * @param heikinKakutokuCredit2 平均獲得クレジット内訳
	 */
	public DetailStatistics(String date, String playTime, String gameCenter,
		String gameKind, int gameCount, int agarinashiCount, int inCredit,
		int outCredit, int maxCredit, String agariritsu1, String agariritsu2,
		String tenpairitsu1, String tenpairitsu2, String lastChance1,
		String lastChance2, String deritsu1, String deritsu2,
		String heikinKakutokuCredit1, String heikinKakutokuCredit2)
	{
		this.date = date;
		this.playTime = playTime;
		this.gameCenter = gameCenter;
		this.gameKind = gameKind;
		this.gameCount = gameCount;
		this.agarinashiCount = agarinashiCount;
		this.inCredit = inCredit;
		this.outCredit = outCredit;
		this.maxCredit = maxCredit;
		this.agariritsu1 = agariritsu1;
		this.agariritsu2 = agariritsu2;
		this.tenpairitsu1 = tenpairitsu1;
		this.tenpairitsu2 = tenpairitsu2;
		this.lastChance1 = lastChance1;
		this.lastChance2 = lastChance2;
		this.deritsu1 = deritsu1;
		this.deritsu2 = deritsu2;
		this.heikinKakutokuCredit1 = heikinKakutokuCredit1;
		this.heikinKakutokuCredit2 = heikinKakutokuCredit2;
	}

	/**
	 * 日付を取得。
	 * @return 日付
	 */
	public String getDate()
	{
		return date;
	}

	/**
	 * プレイ時間を取得。
	 * @return プレイ時間
	 */
	public String getPlayTime()
	{
		return playTime;
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
	 * 局数を取得。
	 * @return 局数
	 */
	public int getGameCount()
	{
		return gameCount;
	}

	/**
	 * 和がりなしカウントを取得。
	 * @return 和がりなしカウント
	 */
	public int getAgarinashiCount()
	{
		return agarinashiCount;
	}

	/**
	 * 投入クレジット数を取得。
	 * @return 投入クレジット数
	 */
	public int getInCredit()
	{
		return inCredit;
	}

	/**
	 * 獲得クレジット数を取得。
	 * @return 獲得クレジット数
	 */
	public int getOutCredit()
	{
		return outCredit;
	}

	/**
	 * 最大クレジット数を取得。
	 * @return 最大クレジット数
	 */
	public int getMaxCredit()
	{
		return maxCredit;
	}

	/**
	 * 和了率を取得。
	 * @return 和了率
	 */
	public String getAgariritsu1()
	{
		return agariritsu1;
	}

	/**
	 * 和了率内訳を取得。
	 * @return 和了率内訳
	 */
	public String getAgariritsu2()
	{
		return agariritsu2;
	}

	/**
	 * 聴牌率を取得。
	 * @return 聴牌率
	 */
	public String getTenpairitsu1()
	{
		return tenpairitsu1;
	}

	/**
	 * 聴牌率内訳を取得。
	 * @return 聴牌率内訳
	 */
	public String getTenpairitsu2()
	{
		return tenpairitsu2;
	}

	/**
	 * ラストチャンス和了率を取得。
	 * @return ラストチャンス和了率
	 */
	public String getLastChance1()
	{
		return lastChance1;
	}

	/**
	 * ラストチャンス和了率内訳を取得。
	 * @return ラストチャンス和了率内訳
	 */
	public String getLastChance2()
	{
		return lastChance2;
	}

	/**
	 * 出率を取得。
	 * @return 出率
	 */
	public String getDeritsu1()
	{
		return deritsu1;
	}

	/**
	 * 出率内訳を取得。
	 * @return 出率内訳
	 */
	public String getDeritsu2()
	{
		return deritsu2;
	}

	/**
	 * 平均獲得クレジットを取得。
	 * @return 平均獲得クレジット
	 */
	public String getHeikinKakutokuCredit1()
	{
		return heikinKakutokuCredit1;
	}

	/**
	 * 平均獲得クレジット内訳を取得。
	 * @return 平均獲得クレジット内訳
	 */
	public String getHeikinKakutokuCredit2()
	{
		return heikinKakutokuCredit2;
	}
}
