package kumagai.mjcount.importjson;

import java.io.*;
import net.arnx.jsonic.*;
import kumagai.mjcount.*;

public class JsonToJava
{
	public static void main(String[] args)
		throws JSONException, IOException
	{
		if (args.length < 1)
		{
			return;
		}

		FileInputStream stream = new FileInputStream(args[0]);
		PlayDataCollection gameResult =
			JSON.decode(stream, PlayDataCollection.class);
		stream.close();

		System.out.println("gamecenter:" + gameResult.gameCenter);
		System.out.println("gamekind:" + gameResult.gameKind);
		System.out.println("startdatetime:" + gameResult.getDateTime());
		System.out.println("count:" + gameResult.gameResults.size());

		for (PlayData game : gameResult.gameResults)
		{
			System.out.printf("%s %s %d\n", game.datetime, game.result, game.bet);
		}
	}
}
