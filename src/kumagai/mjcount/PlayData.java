package kumagai.mjcount;

import java.text.*;
import java.util.*;
import ktool.xml.*;

/**
 * １局の情報。
 * @author kumagai
 */
public class PlayData
{
	static private final HashMap<String, String> resultTable;

	/**
	 * 変換テーブル初期化。
	 */
	static
	{
		resultTable = new HashMap<String, String>();

		resultTable.put("ツモ和", "ツモ和がり");
		resultTable.put("ロン和", "ロン和がり");
		resultTable.put("ラス和", "ラストチャンス和がり");
		resultTable.put("聴ツモ", "聴牌ツモ和がられ");
		resultTable.put("聴ロン", "聴牌ロン和がられ");
		resultTable.put("不ツモ", "不聴ツモ和がられ");
		resultTable.put("不ロン", "不聴ロン和がられ");
		resultTable.put("聴荒牌", "聴牌荒牌");
		resultTable.put("不荒牌", "不聴荒牌");
		resultTable.put("ボーナス", "ボーナス");
	}

	public String result;
	public String datetime;
	public int inCredit;
	public int outCredit;
	public int bet = 1;

	public void setTime(String datetime)
	{
		this.datetime = datetime;
	}

	public void setIn(int inCredit)
	{
		this.inCredit = inCredit;
	}

	public void setOut(int outCredit)
	{
		this.outCredit = outCredit;
	}

	public PlayData()
	{
	}

	/**
	 * 指定の要素から１局の情報を構築する。
	 * @param item 要素
	 * @throws ParseException
	 */
	public PlayData(StructElement item)
		throws ParseException
	{
		result = resultTable.get(item.element().getAttribute("result"));
		datetime = item.element().getAttribute("dt");
		inCredit = Integer.valueOf(item.element().getAttribute("in"));
		outCredit = Integer.valueOf(item.element().getAttribute("out"));

		String betString = item.element().getAttribute("bet");

		bet = 1;

		if (betString != null)
		{
			// bet指定あり。

			if (betString.length() > 0)
			{
				// bet指定は空文字列ではない。

				bet = Integer.valueOf(betString);
			}
		}
	}
}
