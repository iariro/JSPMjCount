package kumagai.mjcountold;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.xml.sax.*;
import ktool.xml.*;

/**
 * カウント情報XMLドキュメント。
 * @author kumagai
 */
public class MjCountDocument1
	extends KDocument
{
	public String month;

	/**
	 * 指定のXMLファイルからドキュメントオブジェクトを構築する。
	 * @param path ファイルパス
	 * @param month 月
	 * @throws TransformerConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 */
	public MjCountDocument1(String path, String month)
		throws TransformerConfigurationException, IOException, SAXException, ParserConfigurationException, TransformerFactoryConfigurationError
	{
		super(path);

		this.month = month;
	}

	/**
	 * 全ゲーム情報を取得する。
	 * @return ゲーム情報コレクション
	 */
	public Vector<PlayData1> getPlayDataCollection()
	{
		StructElement [] items =
			new StructElement(getDocumentElement()).getChildElements();

		Vector<PlayData1> playDataCollection = new Vector<PlayData1>();

		for (int i=0 ; i<items.length ; i++)
		{
			playDataCollection.add(new PlayData1(items[i]));
		}

		return playDataCollection;
	}
}
