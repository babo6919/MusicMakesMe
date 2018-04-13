package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;
import vo.MemberBean;

//로그인 요청을 처리하기 위한 Login_Action 클래스
public class LoginAction implements Action{
	//Action 인터페이스의 execute 실체 메소드 작성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		MemberBean Member=new MemberBean();
		Member.setID(request.getParameter("ID"));
		Member.setPW(request.getParameter("PW"));
		
		
		//Member_Login_Service 클래스로 ID,PW값을 넘겨줌
		//Member_Login_Service 클래스로부터 로그인 성공,실패 여부를 리턴받음.
		
		LoginService loginService= new LoginService();
		//Member_Login_Service 클래스의 login 메소드를 호출하여 호출 결과값을
		//Login_Result에 받음 매개 값은 Member객체
		boolean Login_Result = loginService.Login(Member);
		ActionForward forward = null;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(Login_Result) {
			out.println("<script>alert('로그인 성공 ');</script>");
			forward = new ActionForward();
			session.setAttribute("ID", Member.getID());
			session.setAttribute("POINT", Member.getPOINT());
			forward.setRedirect(true);
			forward.setPath("./Main.me");	
		}else{
			out.println("<script>");
			out.println("alert('로그인 실패')");
			out.println("location.href='./LoginMain.me'");
			out.println("</script>");
		}
		return forward;
	}
}
