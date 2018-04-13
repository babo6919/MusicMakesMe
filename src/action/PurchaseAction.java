package action;

import java.io.PrintWriter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.PurchaseService;
import vo.ActionForward;


public class PurchaseAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		int Music_Num=Integer.parseInt(request.getParameter("Music_Num"));
		String ID=(String)session.getAttribute("ID");
		
		//Member_Login_Service 클래스로 ID,PW값을 넘겨줌
		//Member_Login_Service 클래스로부터 로그인 성공,실패 여부를 리턴받음.
		PurchaseService purchaseService= new PurchaseService();
		//Member_Login_Service 클래스의 login 메소드를 호출하여 호출 결과값을
		//Login_Result에 받음 매개 값은 Member객체
		boolean Purchase_Result = purchaseService.Purchase(Music_Num, ID);

		ActionForward forward = null;
		response.setContentType("text/html; charset=utf-8");
		
		if(Purchase_Result) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Main.me");
	
	/*		forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./MyMusicAction.me");*/ //DB처리를 하고 어디로갈지
		}else{
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('포인트가 부족 합니다')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}
}
