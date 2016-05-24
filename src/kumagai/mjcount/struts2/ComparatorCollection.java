package kumagai.mjcount.struts2;

import java.util.*;
import kumagai.mjcount.*;

/**
 * ランキングソート用Comparatorコレクション。
 */
public class ComparatorCollection
	extends HashMap<String, Comparator<DigestListItem>>
{
	/**
	 * Comparatorコレクションを構築。
	 */
	public ComparatorCollection()
	{
		put(
			"gameCount",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - Integer.compare(item1.gameCount, item2.gameCount);
				}
			});

		put(
			"playTime",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - item1.playTime.compareTo(item2.playTime);
				}
			});

		put(
			"playNetTime",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - item1.playNetTime.compareTo(item2.playNetTime);
				}
			});

		put(
			"agarinashiCount",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - Integer.compare(
						item1.agarinashiCount,
						item2.agarinashiCount);
				}
			});

		put(
			"inputCredit",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - Integer.compare(item1.inCredit, item2.inCredit);
				}
			});

		put(
			"maxCredit",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - Integer.compare(item1.maxCredit, item2.maxCredit);
				}
			});

		put(
			"ratio",
			new Comparator<DigestListItem>()
			{
				@Override
				public int compare(DigestListItem item1, DigestListItem item2)
				{
					return - Integer.compare(item1.getRatioAsInt(), item2.getRatioAsInt());
				}
			});
	}
}
