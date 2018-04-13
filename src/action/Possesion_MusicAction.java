package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.Possesion_MusicService;
import vo.ActionForward;
import vo.Possesion_MusicBean;

public class Possesion_MusicAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)throws Exception{
	response.setContentType("text/html; chatset=utf-8");			
		HttpSession session= request.getSession();																	
		Possesion_MusicBean MyMusic = new Possesion_MusicBean();					
		boolean MyMusicResult = false;
		
		String Music_NumM=request.getParameter("Music_Num");
		request.setAttribute("Music_Num", Music_NumM);
		String TitleM=request.getParameter("Title");
		request.setAttribute("Title", TitleM);
		String ArtistM=request.getParameter("Artist");
		request.setAttribute("Artist", ArtistM);
		String Music_File_DirM=request.getParameter("Music_File_Dir");
		request.setAttribute("Music_File_Dir", Music_File_DirM);
		String Music_File_NameM=request.getParameter("Music_File_Name");
		request.setAttribute("Music_File_Name", Music_File_NameM);
		String IMG_File_DirM=request.getParameter("IMG_File_DIR");
		request.setAttribute("IMG_File_Dir", IMG_File_DirM);
		String IMG_File_NameM=request.getParameter("IMG_File_Name");
		request.setAttribute("IMG_File_Name", IMG_File_NameM);	
		
		String ID = (String)session.getAttribute("ID");				
		int MUSIC_NUM = Integer.parseInt((String) request.getAttribute("Music_Num"));
		String TITLE = (String) request.getAttribute("Title");
		String ARTIST = (String) request.getAttribute("Artist");
		String MUSIC_FILE_DIR = (String) request.getAttribute("Music_File_Dir");
		String MUSIC_FILE_NAME = (String) request.getAttribute("Music_File_Name");
		String IMG_FILE_NAME = (String) request.getAttribute("IMG_File_Name");
//M이 붙은것은 MyMusic으로 가기위해 변수를 선언해주었기 때문이다.
		
		
		
		MyMusic.setID(ID);
		MyMusic.setMUSIC_NUM(MUSIC_NUM);
		MyMusic.setTITLE(TITLE);
		MyMusic.setARTIST(ARTIST);					
		MyMusic.setMUSIC_FILE_DIR(MUSIC_FILE_DIR);
		MyMusic.setMUSIC_FILE_NAME(MUSIC_FILE_NAME);
		MyMusic.setIMG_FILE_NAME(IMG_FILE_NAME);
		
		Possesion_MusicService myMusicService = new Possesion_MusicService(); 
		MyMusicResult = myMusicService.getMyMusicList(MyMusic);
		ActionForward forward = null;	
		if(MyMusicResult==false) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매가 불가능 합니다..');");
			out.println("history.back();");
			out.println("</script>");
			}else {
				request.setAttribute("Music_Num", MUSIC_NUM);
				request.setAttribute("Title", TITLE);
				request.setAttribute("Artist", ARTIST);
				request.setAttribute("Music_File_Dir", MUSIC_FILE_DIR);
				request.setAttribute("Music_File_Name", MUSIC_FILE_NAME);
				request.setAttribute("IMG_File_Name", IMG_FILE_NAME);
				request.getRequestDispatcher("PurchaseAction.me").forward(request, response);

			}
		return forward;
		}
	}