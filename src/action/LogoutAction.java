package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vo.ActionForward;


public class LogoutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		HttpSession session= request.getSession();
		ActionForward forward = null;		
		forward = new ActionForward();
		session.removeAttribute("ID");
		forward.setRedirect(true);
		forward.setPath("./LoginMain.me");
		return forward;
	};
}

