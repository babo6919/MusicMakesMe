package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.SearchService;
import vo.ActionForward;
import vo.MemberBean;
import vo.MusicBean;


public class SearchAction implements Action {
	//Action 인터페이스의 execute 실체 메소드 작성
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
		//member 객체에다가 클라이언트가 입력한 id, pw를 입력하세요
		HttpSession session= request.getSession();
		response.setContentType("text/html; chatset=utf-8");
		ActionForward forward = null;
		
		String id= request.getParameter("id");
		String select =request.getParameter("select");
		forward = new ActionForward();
		if(select.equals("Friend")) {
			SearchService friendSearchService=new SearchService();
			ArrayList<MemberBean> searchFriendList = friendSearchService.getSearchList(id);
			session.setAttribute("Friend", select);
			request.setAttribute("searchFriendList", searchFriendList);
			forward.setPath("./Main.jsp?page=FriendSearchList");
		}
		else if(select.equals("Music")) {
			SearchService musicSearchService=new SearchService();
			ArrayList<MusicBean> searchMusicList = musicSearchService.getSearchMusicList(id);
			session.setAttribute("Music", select);
			request.setAttribute("searchMusicList", searchMusicList);
			forward.setPath("./Main.jsp?page=MusicSearchList");		
		}		
		return forward;
	}
}
