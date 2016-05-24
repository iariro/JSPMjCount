package kumagai.mjcount;

import java.util.*;;

/**
 * 詳細表示用戦績情報コレクション。
 * @author kumagai
 */
public class DetailListItemCollection
	extends ArrayList<DetailListItem>
{
	private final String month;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param month 対象月
	 */
	public DetailListItemCollection(String month)
	{
		this.month = month;
	}

	/**
	 * 対象月を取得。
	 * @return 対象月
	 */
	public String getMonth()
	{
		return month;
	}
}
