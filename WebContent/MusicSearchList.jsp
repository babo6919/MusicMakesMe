<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.MemberBean" %>
<%@ page import="vo.MusicBean" %>
<%@ page import="java.util.*" %>
<% 
	@SuppressWarnings("unchecked")
   ArrayList<MusicBean> searchMusicList=(ArrayList<MusicBean>)request.getAttribute("searchMusicList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js"></script>
<link rel="stylesheet" type="text/css" href="css/Kakao.css">
<link rel="stylesheet" type="text/css" href="css/Main.css">
</head>
<body>
   	<%for(int i=0; i<searchMusicList.size();i++){ %>
   	<form action="Possesion_MusicAction.me" method="post">	
   	<div align="center" style="margin-top:50px; margin-bottom:-50px;">

		<table>	
   			<tr>
   				<td  id="C" rowspan="3" width="120px" height="120px">
   				<img width="120px" height="120px" src="<%=searchMusicList.get(i).getMUSIC_FILE_DIR() %>/<%=searchMusicList.get(i).getIMG_FILE_NAME() %>"></td>
   				<td colspan="4" width="480px" height="40px">아티스트:<%=searchMusicList.get(i).getARTIST() %></td>
   				<td  id="C" rowspan="3" width="120px" height="120px">
   	
   					<input type="hidden" name="Music_Num" value="<%=searchMusicList.get(i).getMUSIC_NUM() %>">
   					<input type="hidden" name="Title" value="<%=searchMusicList.get(i).getTITLE() %>">
   					<input type="hidden" name="Artist" value="<%=searchMusicList.get(i).getARTIST() %>">
   					<input type="hidden" name="Music_File_Dir" value="<%=searchMusicList.get(i).getMUSIC_FILE_DIR()%>">
   					<input type="hidden" name="Music_File_Name" value="<%=searchMusicList.get(i).getMUSIC_FILE_NAME() %>">
   					<input type="hidden" name="Deduct_Point" value="<%=searchMusicList.get(i).getDEDUCT_POINT()%>">
   					<input type="hidden" name="IMG_File_Name" value="<%=searchMusicList.get(i).getIMG_FILE_NAME() %>">
   					<input type="submit" value="구매">
   					
   				</td>
   			</tr>
   			<tr>
   				<td colspan="4" width="480px" height="40px">제목:<%=searchMusicList.get(i).getTITLE() %></td>
   			</tr>
   			<tr>
   				<td colspan="4" width="480px" height="40px">구매포인트:<%=searchMusicList.get(i).getDEDUCT_POINT()%></td>
   			</tr>
   		</table>

   		</div>
   	</form>
   		<%} %>
</body>
</html>