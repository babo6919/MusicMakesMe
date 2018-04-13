<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.MemberBean" %>
<%@ page import="java.util.*" %>

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
	
<c:forEach var="searchFriendList" items="${searchFriendList}">
	<div align="center">
	<form action="./FriendAction.me" method="post">
		
		<table>	
   			<tr>
   				<td id="C" rowspan="3" width="120px" height="120px">
   				<img width="120px" height="120px" src="ProfileImage/${searchFriendList.PROFILE_IMG}"></td>
   				<td colspan="4" width="480px" height="40px">아이디:${searchFriendList.ID} </td>
   				  				
   				<td id="C" rowspan="3" width="120px" height="120px">
   				<input type="hidden" name="USER_ID" value="${searchFriendList.ID}">
               	<input type="submit" value="친구신청"></td>
   			</tr>
   			<tr>
   				<td colspan="4" width="480px" height="40px">이름:${searchFriendList.NAME}</td>
   			</tr>
   		</table>	</form>
   		   
   		</div>
</c:forEach>

</body>
</html>