package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Find_IDService;
import svc.Find_PWService;
import vo.ActionForward;
import vo.MemberBean;

public class Find_PWAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	/*HttpSession session=request.getSession();
	   		String id=(String)session.getAttribute("id");*/
	   		
	   		ActionForward forward = null;

	   		forward = new ActionForward();
	   		String email=request.getParameter("EMAIL");
	   		String id=request.getParameter("ID");
	   		System.out.println(email);
	   		
	   		Find_PWService find_PWService = new Find_PWService();
	   		
	   		MemberBean find_PW = find_PWService.getMember(email , id);
	   		request.setAttribute("find_PW", find_PW);
	   		forward.setPath("./LoginMain.jsp?page=Find_PW_Result");
	   		
	   		return forward;
	}
}