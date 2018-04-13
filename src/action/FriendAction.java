package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.FriendService;
import vo.ActionForward;
import vo.FriendStateBean;

public class FriendAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		//멤버 객체 만들어서 service 메소드 호출 하면서 member 넘겨줌
		FriendStateBean friend = new FriendStateBean();
		HttpSession session= request.getSession();
		
		String ID = (String)session.getAttribute("ID");
		String USER_ID = request.getParameter("USER_ID");
		friend.setID(ID);
		friend.setFRIEND_ID(USER_ID);
	
		System.out.println("FriendAction : "+ USER_ID);
		boolean FriendResult = false;

		FriendService friendService = new FriendService();
		FriendResult = friendService.FriendMember(friend, ID, USER_ID);
		ActionForward forward=null;
		if(FriendResult==false) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('이미 친구 신청을 해놓은 상대입니다.');");
			out.println("history.back();");
			out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./Main.me");
			}
		return forward;
	}
}
