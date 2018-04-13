package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action{
	//Action 인터페이스의 execute 실체 메소드 작성
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
			HttpSession session= request.getSession();
			String ID=(String)session.getAttribute("ID");
			
			if(ID.equals(null)) {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("location.href='/LoginMain.me'");
				out.println("</script");
			}
			response.setContentType("text/html; chatset=utf-8");		
			ActionForward forward = null;
			forward = new ActionForward();
			MemberListService memberListService=new MemberListService();
			ArrayList<MemberBean> memberList = memberListService.getMemberList();
			request.setAttribute("memberList", memberList);
			forward.setPath("./Main.jsp?page=MemberList");

			return forward;
		}
}
