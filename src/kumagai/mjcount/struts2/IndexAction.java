package kumagai.mjcount.struts2;

import org.apache.struts2.convention.annotation.*;
import ktool.datetime.*;

/**
 * トップページ表示アクション。
 * @author kumagai
 */
@Namespace("/mjcount")
@Result(name="success", location="/mjcount/index.jsp")
public class IndexAction
{
	private DateTime today = new DateTime();

	/**
	 * 現在の年を取得。
	 * @return 現在の年
	 */
	public int getTodayYear()
	{
		return today.getYear();
	}

	/**
	 * 現在の月を取得。
	 * @return 現在の月
	 */
	public int getTodayMonth()
	{
 		return today.getMonth();
	}

	/**
	 * トップページ表示アクション。
	 * @return 処理結果
	 * @throws Exception
	 */
	@Action("index")
	public String execute()
		throws Exception
	{
		return "success";
	}
}
