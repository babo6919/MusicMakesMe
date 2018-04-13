package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.FriendAddHaveCancleService;
import vo.ActionForward;
import vo.FriendStateBean;

public class FriendAddHaveCancleAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		ActionForward forward = null;
		forward = new ActionForward();
		String ID=(String)session.getAttribute("ID");
		String Delete_Id = request.getParameter("USER_ID");
		
		
		forward = new ActionForward();
		FriendAddHaveCancleService friendAddHaveCancleService = new FriendAddHaveCancleService();
		boolean Delete_Result = friendAddHaveCancleService.AddCancle(ID,Delete_Id);
		if(ID.equals(null)) {
			PrintWriter out = response.getWriter();
			out.println("<scrip>");
			out.println("location.href='LoginMain.me'");
			out.println("</scrip>");
		}else if(Delete_Result) {
			System.out.println("삭제 성공");
			forward.setRedirect(true);
			forward.setPath("./FriendAddHaveListAction.me");
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			System.out.println("삭제 실패");
			out.println("<script>alert('회원정보 삭제 실패')");
			out.println("alert('회원정보 삭제 실패')");
			out.println("location.href='./FriendAddHaveListAction.me");
			out.println("</script>");		
		}
		return forward;
	}
}
