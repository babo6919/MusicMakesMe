package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.UpdateMemberService;
import vo.ActionForward;
import vo.MemberBean;

public class UpdateMemberAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		//멤버 객체 만들어서 service 메소드 호출 하면서 member 넘겨줌
		MemberBean Member=new MemberBean();
		String id=(String)session.getAttribute("ID");
		boolean UpdateResult = false;
		Member.setID(request.getParameter("ID"));
		Member.setPW(request.getParameter("PW"));
		Member.setNAME(request.getParameter("NAME"));
		Member.setEMAIL(request.getParameter("EMAIL"));
		Member.setADDR(request.getParameter("ADDR"));
		//member객체에 담긴 값들을 member_SignUp_Service에 넘김
		UpdateMemberService updateMemberService = new UpdateMemberService();
		//db에 insert문이 정상적으로 처리 됐다면
		//Member_SignUp_Service.SignUp_Member(member)메소드의 호출 결과는 true로 넘어옴.
		//당연히 insert 문이 제대로 처리 안되면 false
		UpdateResult = updateMemberService.UpdateMember(Member, id);
		ActionForward forward=null;
		if(UpdateResult==false) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보 수정 실패');");
			out.println("history.back();");
			out.println("</script>");
			}else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./MyPage.me");
			}
		return forward;
	}
}
	
