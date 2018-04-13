package action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.UpdateProfileService;
import vo.ActionForward;
import vo.MemberBean;

public class UpdateProfileAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("utf-8");
		HttpSession session= request.getSession();
		//멤버 객체 만들어서 service 메소드 호출 하면서 member 넘겨줌
		String realFolder = "";
		String saveFolder = "/ProfileImage";
		
		int maxSize = 10*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, "utf-8",
					new DefaultFileRenamePolicy());

		MemberBean Member =new MemberBean();
		Member.setID((String)session.getAttribute("ID"));
		Member.setPROFILE_IMG(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		
		boolean UpdateResult = false;
		//member객체에 담긴 값들을 member_SignUp_Service에 넘김
		UpdateProfileService updateProfileService = new UpdateProfileService();
		//db에 insert문이 정상적으로 처리 됐다면
		//Member_SignUp_Service.SignUp_Member(member)메소드의 호출 결과는 true로 넘어옴.
		//당연히 insert 문이 제대로 처리 안되면 false
		UpdateResult = updateProfileService.UpdateMember(Member);
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
				forward.setPath("./MemberViewAction.me");
			}
		return forward;
	}
}
	
