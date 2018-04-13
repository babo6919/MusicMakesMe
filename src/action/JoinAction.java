package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.JoinService;
import vo.ActionForward;
import vo.MemberBean;

public class JoinAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		//멤버 객체 만들어서 service 메소드 호출 하면서 member 넘겨줌
		MemberBean Member=new MemberBean();
		boolean JoinResult = false;
		Member.setID(request.getParameter("ID"));
		Member.setPW(request.getParameter("PW"));
		Member.setNAME(request.getParameter("NAME"));
		Member.setEMAIL(request.getParameter("EMAIL"));
		Member.setADDR(request.getParameter("ADDR"));
		//member객체에 담긴 값들을 member_SignUp_Service에 넘김
		JoinService joinService = new JoinService();
		//db에 insert문이 정상적으로 처리 됐다면
		//Member_SignUp_Service.SignUp_Member(member)메소드의 호출 결과는 true로 넘어옴.
		//당연히 insert 문이 제대로 처리 안되면 false
		JoinResult = joinService.JoinMember(Member);
		ActionForward forward=null;
		if(JoinResult==false) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원가입 실패');");
			out.println("history.back();");
			out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./LoginMain.me");
			}
		return forward;
	}
}
