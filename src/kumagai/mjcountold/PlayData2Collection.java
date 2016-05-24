package kumagai.mjcountold;

import java.util.*;

/**
 * プレイ内容表示情報のコレクション - 旧データ用。
 * @author kumagai
 */
public class PlayData2Collection
	extends ArrayList<PlayData2>
{
	private final String month;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param month 月
	 */
	public PlayData2Collection(String month)
	{
		this.month = month;
	}

	/**
	 * 月を取得。
	 * @return 月
	 */
	public String getMonth()
	{
		return month;
	}
}
