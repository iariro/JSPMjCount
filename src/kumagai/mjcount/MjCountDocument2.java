package kumagai.mjcount;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import ktool.xml.*;

/**
 * 戦績ドキュメント。
 * @author kumagai
 */
public class MjCountDocument2
	extends KDocument
{
	/**
	 * 戦績データを受けてドキュメントを構築する。
	 * @param playDataCollections 戦績データ
	 * @throws ParserConfigurationException
	 * @throws TransformerConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 */
	public MjCountDocument2(ArrayList<PlayDataCollection> playDataCollections)
		throws ParserConfigurationException, TransformerConfigurationException,
			TransformerFactoryConfigurationError
	{
		Element top = createElement("MjCount");
		appendChild(top);

		for (PlayDataCollection playDataCollection : playDataCollections)
		{
			Element games = createElement("games");
			top.appendChild(games);

			games.setAttribute("gameCenter", playDataCollection.gameCenter);
			games.setAttribute("gameKind", playDataCollection.gameKind);
			games.setAttribute("starttime", playDataCollection.starttime);
		}
	}

	/**
	 * 戦績データファイルからドキュメントを構築する。
	 * @param fileName 戦績データファイル
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws TransformerConfigurationException
	 * @throws TransformerFactoryConfigurationError
	 */
	public MjCountDocument2(String fileName)
		throws IOException, SAXException, ParserConfigurationException,
			TransformerConfigurationException,
			TransformerFactoryConfigurationError
	{
		super(fileName);
	}
}
