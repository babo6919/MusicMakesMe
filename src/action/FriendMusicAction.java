package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.FriendMusicService;
import vo.ActionForward;
import vo.Possesion_MusicBean;

public class FriendMusicAction implements Action{
	//Action 인터페이스의 execute 실체 메소드 작성
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
			//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
			/*HttpSession session= request.getSession();*/
			response.setContentType("text/html; chatset=utf-8");
			
			ActionForward forward = null;
			/*String ID=(String)session.getAttribute("ID");*/
			String ID = request.getParameter("friendList");

			if(ID.equals(null)) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./LoginMain.me");
			} else {
				forward = new ActionForward();
				FriendMusicService friendMusicService=new FriendMusicService();
				//컬렉션 프레임 워크 중의 하나인 ArrayList 사용(자바 15장 내용참고)
				//MemberBean타입의 ML를 사용하여 조회된 전체 회원의 정보를 가져옴.
				ArrayList<Possesion_MusicBean> FriendMusicList = friendMusicService.getMusicList(ID);
				System.out.println("액션 FriendMusicList:" + FriendMusicList);
				request.setAttribute("FriendMusicList", FriendMusicList);

				forward.setPath("./Main.jsp?page=FriendMusic");
			}
			//2.admin인지 확인
				//admin이 아니면, 관리자가 아니라는 alert띄움
			//3.admin이면
				//Member_List_Service() 객체의 메소드를 호출함.
				//호출 결과를 받아서 Member_list.jsp로 포워딩
			return forward;
		}
}
