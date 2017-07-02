package kumagai.mjcount;

import java.io.*;
import java.text.*;
import java.util.*;
import com.sun.org.apache.xerces.internal.impl.io.*;
import ktool.io.*;

/**
 * MjCountドキュメントのコレクション。
 * @author kumagai
 */
public class MjCountDocumentCollection
	extends ArrayList<MjCountDocument>
{
	/**
	 * テストコード。
	 * @param args 未使用
	 * @throws Exception
	 */
	public static void main(String [] args)
		throws Exception
	{
		MjCountDocumentCollection documents =
			new MjCountDocumentCollection(
				"C:\\Users\\kumagai\\Documents\\Nefertiti の文書\\Private\\MjCount\\",
				"C:\\Users\\kumagai\\Documents\\Private\\ゲーム\\MjCount\\",
				false,
				2);

		for (MjCountDocument document : documents)
		{
			System.out.println(
				document.month +
				" " +
				document.currentYear +
				" " +
				document.getPlayDataCollection().size());

			ArrayList<PlayDataCollection> playDataCollections =
				document.getPlayDataCollection();

			for (int j=0 ; j<playDataCollections.size() ; j++)
			{
				int index = playDataCollections.size() - j - 1;
				PlayDataCollection playData = playDataCollections.get(index);
				System.out.println(playData.starttime);
			}
		}
	}

	/**
	 * 指定のパスのファイルを指定個読み込む。
	 * @param path1 ファイルがあるパス - 今年分
	 * @param path2 ファイルがあるパス - 去年以前分
	 * @param all true=全部／false=num分
	 * @param num ファイル数
	 */
	public MjCountDocumentCollection
		(String path1, String path2, boolean all, int num)
		throws Exception
	{
		File [][] files =
			new File [][]
			{
				Directory.getFiles(path1),
				Directory.getFiles(path2)
			};

		int count = 0;

		for (int i=0 ; i<files.length ; i++)
		{
			if (files[i] == null)
			{
				continue;
			}

			for (int j=0 ; j<files[i].length && (all || count < num) ; j++)
			{
				int index = files[i].length - j - 1;

				String filename = files[i][index].getName();

				if (filename.length() == 17 &&
					filename.startsWith("MjCount") &&
					filename.endsWith(".xml"))
				{
					// ファイル名は所定の形式である。

					try
					{
						add(
							new MjCountDocument(
								files[i][index].getAbsolutePath(),
								filename.substring(7, 7 + 4) +
								"/" +
								filename.substring(11, 11 + 2),
								i == 0));
					}
					catch (MalformedByteSequenceException exception)
					{
						System.out.println(exception.toString());
					}

					count++;
				}
			}
		}
	}

	/**
	 * ゲームセンター名一覧・ゲーム機種一覧を取得。
	 * @return ゲームセンター名一覧・ゲーム機種一覧
	 */
	public GameCenterAndGameKindCollection getGameCenterAndGameKindCollection()
		throws ParseException
	{
		GameCenterAndGameKindCollection collection =
			new GameCenterAndGameKindCollection();

		for (MjCountDocument document : this)
		{
			ArrayList<PlayDataCollection> PlayDataCollections =
				document.getPlayDataCollection();

			for (PlayDataCollection playDataCollection : PlayDataCollections)
			{
				collection.putGameCenter(playDataCollection.gameCenter);
				collection.putGameKind(playDataCollection.gameKind);
			}
		}

		return collection;
	}
}
