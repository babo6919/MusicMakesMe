package action;

import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.MusicUploadService;
import vo.ActionForward;
import vo.MusicBean;;

public class MusicUploadAction implements Action {

	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String MUSIC_FILE_NAME="";
		String IMG_FILE_NAME="";
		String realFolder = "";
		String saveFolder = "/Music";
		
		int maxSize = 10*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
					realFolder, maxSize, "utf-8",
					new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames();
		
		String file1 = (String)files.nextElement();
		IMG_FILE_NAME = multi.getFilesystemName(file1);
		String file2 = (String)files.nextElement();
		MUSIC_FILE_NAME = multi.getFilesystemName(file2);
		
		
		MusicBean Music = new MusicBean();
		Music.setTITLE(multi.getParameter("TITLE"));
		Music.setARTIST(multi.getParameter("ARTIST"));
		Music.setMUSIC_FILE_NAME(MUSIC_FILE_NAME);
		Music.setMUSIC_FILE_DIR(multi.getParameter("MUSIC_FILE_DIR"));
		Music.setIMG_FILE_NAME(IMG_FILE_NAME);
		Music.setDEDUCT_POINT(Integer.parseInt(multi.getParameter("DEDUCT_POINT")));
		MusicUploadService MusicUploadService = new MusicUploadService();
		boolean isUploadSuccess = MusicUploadService.insertMusic(Music);
		
		if(isUploadSuccess==false){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록 실패');");
			out.println("history.back();");
			out.println("</script>");

		}else{
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("./Main.me");
		}		
		return forward;
	}

}
