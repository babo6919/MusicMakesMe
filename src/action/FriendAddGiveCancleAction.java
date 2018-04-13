package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.FriendAddGiveCancleService;
import vo.ActionForward;
import vo.FriendStateBean;

public class FriendAddGiveCancleAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		ActionForward forward = null;
		forward = new ActionForward();
		String ID=(String)session.getAttribute("ID");
		String Delete_Id = request.getParameter("friendaddList");
		
		
		forward = new ActionForward();
		FriendAddGiveCancleService friendAddCancleService = new FriendAddGiveCancleService();
		boolean Delete_Result = friendAddCancleService.AddCancle(ID,Delete_Id);
		if(ID.equals(null)) {
			PrintWriter out = response.getWriter();
			out.println("<scrip>");
			out.println("location.href='LoginMain.me'");
			out.println("</scrip>");
		}else if(Delete_Result) {
			System.out.println("삭제 성공");
			forward.setRedirect(true);
			forward.setPath("./FriendAddGiveListAction.me");
		}else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			System.out.println("삭제 실패");
			out.println("<script>alert('회원정보 삭제 실패')");
			out.println("alert('회원정보 삭제 실패')");
			out.println("location.href='./FriendAddGiveListAction.me");
			out.println("</script>");		
		}
		return forward;
	}
}
