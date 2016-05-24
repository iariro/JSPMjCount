package kumagai.mjcount;

import java.util.*;

/**
 * 記念すべきプレイ一覧表示情報のコレクション。
 * @author kumagai
 */
public class EpochListItemCollection
	extends ArrayList<EpochListItem>
{
	private String month;
	private boolean currentYear;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param month 月
	 * @param currentYear true=今年の分／false=去年以前の分
	 */
	public EpochListItemCollection(String month, boolean currentYear)
	{
		this.month = month;
		this.currentYear = currentYear;
	}

	/**
	 * 月を取得。
	 * @return 月
	 */
	public String getMonth()
	{
		return month;
	}

	/**
	 * ファイル配置場所フラグを取得。
	 * @return ファイル配置場所フラグ
	 */
	public boolean getCurrentYear()
	{
		return currentYear;
	}

	/**
	 * 情報数を取得。
	 * @return 情報数
	 */
	public int getSize()
	{
		return size();
	}
}
