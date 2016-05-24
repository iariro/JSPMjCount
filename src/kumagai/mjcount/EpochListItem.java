package kumagai.mjcount;

/**
 * 記念すべきプレイ一覧表示情報。
 * @author kumagai
 */
public class EpochListItem
{
	private String color1;
	private String dateTime;
	private String gameCenter;
	private String gameKind;
	private String comment;
	private String filename;
	private int index;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param color1 １行の色
	 * @param dateTime 日時
	 * @param gameCenter ゲームセンター名
	 * @param gameKind ゲーム機種名
	 * @param comment コメント
	 * @param filename ファイル名
	 * @param index ファイル中の対象インデックス
	 */
	public EpochListItem(String color1, String dateTime, String gameCenter,
		String gameKind, String comment, String filename, int index)
	{
		this.color1 = color1;
		this.dateTime = dateTime;
		this.gameCenter = gameCenter;
		this.gameKind = gameKind;
		this.comment = comment;
		this.filename = filename;
		this.index = index;
	}

	/**
	 * １行の色を取得。
	 * @return １行の色
	 */
	public String getColor1()
	{
		return color1;
	}

	/**
	 * 日時を取得。
	 * @return 日時
	 */
	public String getDateTime()
	{
		return dateTime;
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
	 * コメントを取得。
	 * @return コメント
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * ファイル名を取得。
	 * @return ファイル名
	 */
	public String getFilename()
	{
		return filename;
	}

	/**
	 * ファイル中の対象インデックスを取得。
	 * @return ファイル中の対象インデックス
	 */
	public int getIndex()
	{
		return index;
	}
}
