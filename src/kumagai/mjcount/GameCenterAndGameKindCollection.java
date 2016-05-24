package kumagai.mjcount;

import java.util.*;

/**
 * ゲームセンター名一覧・ゲーム機種一覧。
 * @author kumagai
 */
public class GameCenterAndGameKindCollection
{
	public final ArrayList<String> gameCenterCollection =
		new ArrayList<String>();
	public final ArrayList<String> gameKindCollection =
		new ArrayList<String>();

	/**
	 * ゲームセンター名追加。
	 * @param gameCenter ゲームセンター名
	 */
	public void putGameCenter(String gameCenter)
	{
		boolean find = false;

		for (String gameCenter2 : gameCenterCollection)
		{
			if (gameCenter2.equals(gameCenter))
			{
				// すでにある。

				find = true;
				break;
			}
		}

		if (! find)
		{
			// 初登場。

			gameCenterCollection.add(gameCenter);
		}
	}

	/**
	 * ゲーム機種名追加。
	 * @param gameKind ゲーム機種名
	 */
	public void putGameKind(String gameKind)
	{
		boolean find = false;

		for (String gameKind2 : gameKindCollection)
		{
			if (gameKind2.equals(gameKind))
			{
				// すでにある。

				find = true;
				break;
			}
		}

		if (! find)
		{
			// 初登場。

			gameKindCollection.add(gameKind);
		}
	}
}
