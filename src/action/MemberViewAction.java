package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements Action{

	//Action 인터페이스의 execute 실체 메소드 작성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		response.setContentType("text/html; charset=utf-8");
		HttpSession session= request.getSession();
		ActionForward forward = null;
		String ID=(String)session.getAttribute("ID");
		//1.아이디가 비어있는지 확인
			//id가 비어 있다면 로그인 페이지로 가도록 함.
		if(ID.equals(null)) {
			PrintWriter out = response.getWriter();
			out.println("<scrip>");
			out.println("location.href='LoginMain.me'");
			out.println("</scrip>");
		}else if(ID.equals("admin")){
			forward = new ActionForward();
			String View_Id =request.getParameter("id");
			MemberViewService memberViewService = new MemberViewService();
			MemberBean memberView = memberViewService.getMember(View_Id);
			request.setAttribute("memberView", memberView);
			forward.setPath("/Main.jsp?page=MemberInfo");
		}else {
			forward = new ActionForward();
			String View_Id =ID;
			MemberViewService memberViewService = new MemberViewService();
			MemberBean memberView = memberViewService.getMember(View_Id);
			request.setAttribute("memberView", memberView);
			forward.setPath("/Main.jsp?page=MemberInfo");
		}
		return forward;
	}
}
