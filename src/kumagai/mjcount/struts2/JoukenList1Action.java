package kumagai.mjcount.struts2;

import java.util.*;
import javax.servlet.*;
import org.apache.struts2.*;
import org.apache.struts2.convention.annotation.*;
import kumagai.mjcount.*;

/**
 * 条件指定リスト条件表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/joukenlist1.jsp")
public class JoukenList1Action
{
	public ArrayList<String> gameCenterCollection = new ArrayList<String>();
	public ArrayList<String> gameKindCollection = new ArrayList<String>();

	/**
	 * ダイジェスト一覧表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("joukenlist1")
	public String execute()
		throws Exception
	{
		ServletContext context = ServletActionContext.getServletContext();

		String fileFolderMobile =
			context.getInitParameter("maajanFilePathMobile");
		String fileFolderPC =
			context.getInitParameter("maajanFilePathPC");

		MjCountDocumentCollection documentCollection =
			new MjCountDocumentCollection
				(fileFolderMobile, fileFolderPC, true, 6);

		GameCenterAndGameKindCollection gameCenterAndGameKindCollection =
			documentCollection.getGameCenterAndGameKindCollection();

		gameCenterCollection =
			gameCenterAndGameKindCollection.gameCenterCollection;
		gameCenterCollection.add(0, "-");
		gameKindCollection =
			gameCenterAndGameKindCollection.gameKindCollection;
		gameKindCollection.add(0, "-");

		return "success";
	}
}
