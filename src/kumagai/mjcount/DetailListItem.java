package kumagai.mjcount;

/**
 * 詳細表示用戦績情報。
 * @author kumagai
 */
public class DetailListItem
{
	private final PlayDataCollection playCollection;
	private final PlayDataListCollection playListItems;
	private final DetailStatistics statistics;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param playCollection ゲーム情報
	 * @param playListItems 詳細ゲーム情報
	 * @param statistics 集計情報
	 */
	public DetailListItem(PlayDataCollection playCollection,
		PlayDataListCollection playListItems, DetailStatistics statistics)
	{
		this.playCollection = playCollection;
		this.playListItems = playListItems;
		this.statistics = statistics;
	}

	/**
	 * ゲーム情報を取得。
	 * @return ゲーム情報
	 */
	public PlayDataCollection getPlayCollection()
	{
		return playCollection;
	}

	/**
	 * 詳細ゲーム情報を取得。
	 * @return 詳細ゲーム情報
	 */
	public PlayDataListCollection getPlayListCollection()
	{
		return playListItems;
	}

	/**
	 * 集計情報を取得。
	 * @return 集計情報
	 */
	public DetailStatistics getStatistics()
	{
		return statistics;
	}
}
