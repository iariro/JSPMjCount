package kumagai.mjcount;

import java.io.*;
import java.text.*;
import java.util.*;
import ktool.xml.*;

/**
 * MjCountドキュメント。
 * @author kumagai
 */
public class MjCountDocument
	extends KDocument
{
	public boolean currentYear;

	/**
	 * テストコード。
	 * @param args 未使用
	 * @throws Exception
	 */
	public static void main(String[] args)
		throws Exception
	{
		String path =
			"C:/Users/kumagai/Documents/Nefertiti の文書/Private/MjCount/mjcount201406.xml";

		MjCountDocument document = new MjCountDocument(path, "2014/06", true);

		for (PlayDataCollection playDataCollection :
			document.getPlayDataCollection())
		{
			System.out.printf(
				"%s %s\n",
				playDataCollection.getPlayTime(),
				playDataCollection.getPlayNetTime());
		}
	}

	public final String filename;
	public final String month;

	/**
	 * 指定のファイルを読み込む。
	 * @param path ファイルがあるパス
	 * @param month 対象の月
	 * @param currentYear true=今年分／false=去年以前分
	 */
	public MjCountDocument(String path, String month, boolean currentYear)
		throws Exception
	{
		super(path);

		this.filename = new File(path).getName();
		this.month = month;
		this.currentYear = currentYear;
	}

	/**
	 * ゲーム情報コレクションを取得。
	 * @return ゲーム情報コレクション
	 */
	public ArrayList<PlayDataCollection> getPlayDataCollection()
		throws ParseException
	{
		StructElement [] items =
			new StructElement(getDocumentElement()).getChildElements();

		ArrayList<PlayDataCollection> playDataCollection =
			new ArrayList<PlayDataCollection>();

		for (int i=0 ; i<items.length ; i++)
		{
			playDataCollection.add(new PlayDataCollection(items[i]));
		}

		return playDataCollection;
	}
}
