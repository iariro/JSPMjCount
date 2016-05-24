package kumagai.mjcountold;

/**
 * プレイ内容表示情報 - 旧データ用。
 * @author kumagai
 */
public class PlayData2
{
	private String bgcolor1;
	private String bgcolor2;
	private String bgcolor3;
	private String datetime;
	private String playtime;
	private String gamecenter;
	private String gameKind;
	private int totalCount;
	private String agariRatio;
	private String tenpaiRatio;
	private String lastchange;
	private int 和がりなしカウント;
	private String ratio;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param bgcolor1 背景色１
	 * @param bgcolor2 背景色２
	 * @param bgcolor3 背景色３
	 * @param datetime 日時
	 * @param playtime プレイ時間
	 * @param gamecenter ゲームセンター名
	 * @param gameKind ゲーム機種名
	 * @param totalCount トータル局数
	 * @param agariRatio 和了率
	 * @param tenpaiRatio 聴牌率
	 * @param lastchange ラストチャンス和了率
	 * @param 和がりなしカウント 和がりなしカウント
	 * @param ratio 出率
	 */
	public PlayData2(String bgcolor1, String bgcolor2, String bgcolor3,
		String datetime, String playtime, String gamecenter, String gameKind,
		int totalCount, String agariRatio, String tenpaiRatio,
		String lastchange, int 和がりなしカウント, String ratio)
	{
		this.bgcolor1 = bgcolor1;
		this.bgcolor2 = bgcolor2;
		this.bgcolor3 = bgcolor3;
		this.datetime = datetime;
		this.playtime = playtime;
		this.gamecenter = gamecenter;
		this.gameKind = gameKind;
		this.totalCount = totalCount;
		this.agariRatio = agariRatio;
		this.tenpaiRatio = tenpaiRatio;
		this.lastchange = lastchange;
		this.和がりなしカウント = 和がりなしカウント;
		this.ratio = ratio;
	}

	/**
	 * 背景色１を取得。
	 * @return 背景色１
	 */
	public String getBgcolor1()
	{
		return bgcolor1;
	}

	/**
	 * 背景色２を取得。
	 * @return 背景色２
	 */
	public String getBgcolor2()
	{
		return bgcolor2;
	}

	/**
	 * 背景色３を取得。
	 * @return 背景色３
	 */
	public String getBgcolor3()
	{
		return bgcolor3;
	}

	/**
	 * 日時を取得。
	 * @return 日時
	 */
	public String getDatetime()
	{
		return datetime;
	}

	/**
	 * プレイ時間を取得。
	 * @return プレイ時間
	 */
	public String getPlaytime()
	{
		return playtime;
	}

	/**
	 * ゲームセンター名を取得。
	 * @return ゲームセンター名
	 */
	public String getGamecenter()
	{
		return gamecenter;
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
	 *トータル局数を取得。
	 * @return トータル局数
	 */
	public int getTotalCount()
	{
		return totalCount;
	}

	/**
	 * 和了率を取得。
	 * @return 和了率
	 */
	public String getAgariRatio()
	{
		return agariRatio;
	}

	/**
	 * 聴牌率を取得。
	 * @return 聴牌率
	 */
	public String getTenpaiRatio()
	{
		return tenpaiRatio;
	}

	/**
	 * ラストチャンス和了率を取得。
	 * @return ラストチャンス和了率
	 */
	public String getLastchange()
	{
		return lastchange;
	}

	/**
	 * 和がりなしカウントを取得。
	 * @return 和がりなしカウント
	 */
	public int get和がりなしカウント()
	{
		return 和がりなしカウント;
	}

	/**
	 * 出率を取得。
	 * @return 出率
	 */
	public String getRatio()
	{
		return ratio;
	}
}
