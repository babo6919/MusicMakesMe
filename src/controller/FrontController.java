package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.Find_IDAction;
import action.Find_PWAction;
import action.FriendAction;
import action.FriendAddAction;
import action.FriendAddGiveCancleAction;
import action.FriendListAction;
import action.FriendMusicAction;
import action.FriendAddGiveListAction;
import action.FriendAddHaveCancleAction;
import action.FriendAddHaveListAction;
import action.SearchAction;
import action.UpdateMemberAction;
import action.UpdateProfileAction;
import action.JoinAction;
import action.LoginAction;
import action.LogoutAction;
import action.MemberDeleteAction;
import action.MemberListAction;
import action.MemberViewAction;
import action.MusicListAction;
import action.MusicUploadAction;
import action.MyMusicListAction;
import action.Possesion_MusicAction;
import action.PurchaseAction;
import vo.ActionForward;


@WebServlet("*.me")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�겢�씪�씠�뼵�듃�쓽 �슂泥��쑝濡� 遺��꽣 �쟾�넚�맂 �럹�씠吏��쓽 �븵遺�遺꾩� 嫄몃윭�궡怨� �븘�슂�븳 遺�遺꾨쭔 �옒�씪�궡�뒗 怨쇱젙
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Action action =null;
		
		//if~else if(臾몄쓣 �씠�슜�븯�뿬 �겢�씪�씠�뼵�듃媛� �슂泥��븳 �럹�씠吏� 蹂꾨줈 �빐�떦 湲곕뒫�쓣 �닔�뻾�븷 �닔 �엳�룄濡� �룷�썙�뵫�븯�뒗 遺�遺�
		
		if(command.equals("/Login.me")) {	//濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Login_Page.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./Login.jsp");
			
		}else if(command.equals("/Join.me")) { //�쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Login_Page.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./Join.jsp");
			
		}else if(command.equals("/MyPage.me")) { //�쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Login_Page.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./MyPage.jsp");
			
		}else if(command.equals("/AdminMain.me")) { //硫붿씤 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Main.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./AdminMain.jsp");
			
			
		}else if(command.equals("/UserMain.me")) { //硫붿씤 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Main.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./UserMain.jsp");
			
			
		}else if(command.equals("/Main.me")) { //硫붿씤 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Main.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./Main.jsp");
			
		}else if(command.equals("/LoginMain.me")) { //�쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞
				//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
				forward = new ActionForward();
				//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
				forward.setRedirect(true);
				//濡쒓렇�씤 �슂泥��씠 �삤硫� Login_Page.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
				forward.setPath("./LoginMain.jsp");
				
		}else if(command.equals("/ImageUpload.me")) { //�쉶�썝媛��엯 �럹�씠吏�濡� �씠�룞
			//Action_Forward()�뿉 ���븳 媛앹껜 �깮�꽦
			forward = new ActionForward();
			//Action_Forward()�쓽 setRedirect()硫붿냼�뱶 �샇異�
			forward.setRedirect(true);
			//濡쒓렇�씤 �슂泥��씠 �삤硫� Login_Page.jsp�럹�씠吏�濡� 由щ떎�씠�젆�듃 �떆�궡
			forward.setPath("./ImageUpload.jsp");
			
		}else if(command.equals("/LoginAction.me")) {//濡쒓렇�씤 �븸�뀡
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("LoginAction 에러"+e);
			}
			
		}else if(command.equals("/Possesion_MusicAction.me")) {//濡쒓렇�씤 �븸�뀡
			action = new Possesion_MusicAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("/Possesion_MusicAction 에러"+e);
			}
			
		}else if(command.equals("/MyMusicListAction.me")) {//濡쒓렇�씤 �븸�뀡
			action = new MyMusicListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("/MyMusicListAction 에러"+e);
			}
			
		}else if(command.equals("/JoinAction.me")) {//�쉶�썝 媛��엯 �븸�뀡
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("JoinAction 에러"+e);
			}
		}else if(command.equals("/MusicUploadAction.me")) {//�쉶�썝 媛��엯 �븸�뀡
			action = new MusicUploadAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("MusicUploadAction 에러"+e);
			}
		}else if(command.equals("/MusicListAction.me")) {//�쉶�썝 由ъ뒪�듃�븸�뀡
			action = new MusicListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("MusicListAction 에러"+e);
			}
		}else if(command.equals("/LogoutAction.me")) {//濡쒓렇�븘�썐�븸�뀡
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("LogoutAction 에러"+e);
			}
		}else if(command.equals("/SearchAction.me")) {//濡쒓렇�븘�썐�븸�뀡
			action = new SearchAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("SearchAction 에러"+e);
			}
		}else if(command.equals("/UpdateMemberAction.me")) {//濡쒓렇�븘�썐�븸�뀡
			action = new UpdateMemberAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("UpdateMemberAction 에러"+e);
			}
		}else if(command.equals("/PurchaseAction.me")) {//援щℓ�븸�뀡
			action = new PurchaseAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("PurchaseAction 에러"+e);
			}
		} else if(command.equals("/MemberListAction.me")) {//援щℓ�븸�뀡
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("MemberListAction 에러"+e);
			}
		} else if(command.equals("/MemberDeleteAction.me")) {//�쉶�썝 �궘�젣 �븸�뀡
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/MemberViewAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new MemberViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FriendAddAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAddAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendAddGiveListAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAddGiveListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendListAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendMusicAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendMusicAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Find_IDAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new Find_IDAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/Find_PWAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new Find_PWAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendAddCancleAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAddGiveCancleAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendAddHaveListAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAddHaveListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendAddHaveCancleAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAddHaveCancleAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/FriendAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new FriendAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/UpdateProfileAction.me")) {//�쉶�썝 �젙蹂대낫湲� �븸�뀡
			action = new UpdateProfileAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
