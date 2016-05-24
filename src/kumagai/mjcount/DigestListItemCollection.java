package kumagai.mjcount;

import java.util.*;

/**
 * ダイジェスト一覧用表示情報のコレクション。
 * @author kumagai
 */
public class DigestListItemCollection
	extends ArrayList<DigestListItem>
{
	private String month;
	private boolean currentYear;

	/**
	 * 指定の値をメンバーに割り当てる。
	 * @param month 月
	 * @param currentYear true=今年の分／false=去年以前の分
	 */
	public DigestListItemCollection(String month, boolean currentYear)
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
	 * ファイル配置場所フラグを割り当て。
	 * @param currentYear ファイル配置場所フラグ
	 */
	public void setCurrentYear(boolean currentYear)
	{
		this.currentYear = currentYear;
	}
}
