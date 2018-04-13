package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberDeleteService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberDeleteAction implements Action{
	//Action 인터페이스의 execute 실체 메소드 작성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		ActionForward forward = null;
		forward = new ActionForward();
		String ID=(String)session.getAttribute("ID");
		String Delete_Id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		if(ID.equals(null)) {
			out.println("<scrip>");
			out.println("location.href='LoginMain.me'");
			out.println("</scrip>");
		}else if(ID.equals("admin")) {
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean Delete_Result = memberDeleteService.Delete_Member(Delete_Id);
			forward = new ActionForward();
			if(Delete_Result) {
				System.out.println("삭제 성공");
				forward.setRedirect(true);
				forward.setPath("./MemberListAction.me");
			}else {
				response.setContentType("text/html; charset=utf-8");
				System.out.println("삭제 실패");
				out.println("<script>alert('회원정보 삭제 실패')");
				out.println("alert('회원정보 삭제 실패')");
				out.println("location.href='./MemberListAction.me'");
				out.println("</script>");		
			}
		}else if(!ID.equals("admin")) {
			MemberDeleteService memberDeleteService = new MemberDeleteService();
			boolean Draw_Result = memberDeleteService.Draw_Member(ID);
			forward = new ActionForward();
			if(Draw_Result) {
				System.out.println("삭제 성공");
				forward.setRedirect(true);
				forward.setPath("./LoginMain.me");
			}else {
				response.setContentType("text/html; charset=utf-8");
				System.out.println("삭제 실패");
				out.println("<script>alert('회원정보 삭제 실패')");
				out.println("alert('회원정보 삭제 실패')");
				out.println("location.href='./MyPage.me'");
				out.println("</script>");		
			}
		}return forward;
	}
}

