package kumagai.mjcountold;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.xml.sax.*;
import ktool.io.*;

/**
 * カウント情報ドキュメントのコレクション。
 * @author kumagai
 */
public class MjCountDocument1Collection
	extends ArrayList<MjCountDocument1>
{
	/**
	 * 指定のパスのファイルを読み込み、ドキュメントコレクションを生成する。
	 * @param path ファイルを読み込むフォルダパス
	 * @throws TransformerConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 */
	public MjCountDocument1Collection(String path)
		throws TransformerConfigurationException, IOException, SAXException,
		ParserConfigurationException, TransformerFactoryConfigurationError
	{
		File [] files = Directory.getFiles(path);

		for (int i=0 ; i<files.length ; i++)
		{
			String filename = files[i].getName();

			if (filename.length() == 18 &&
				filename.startsWith("MjCount_") &&
				filename.endsWith(".xml"))
			{
				// ファイル名は条件に合致する。

				add(
					new MjCountDocument1(
						files[i].getAbsolutePath(),
						filename.substring(8, 8 + 4) +
						"/" +
						filename.substring(12, 12 + 2)));
			}
		}
	}
}
