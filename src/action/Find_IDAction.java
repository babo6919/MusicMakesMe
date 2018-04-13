package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Find_IDService;
import svc.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class Find_IDAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	/*HttpSession session=request.getSession();
	   		String id=(String)session.getAttribute("id");*/
	   		
	   		ActionForward forward = null;

	   		forward = new ActionForward();
	   		String email=request.getParameter("EMAIL");
	   		System.out.println(email);
	   		
	   		Find_IDService find_IDService = new Find_IDService();
	   		
	   		MemberBean find_ID = find_IDService.getMember(email);
	   		request.setAttribute("find_ID", find_ID);
	   		forward.setPath("./LoginMain.jsp?page=Find_ID_Result");
	   		
	   		return forward;
	}
}