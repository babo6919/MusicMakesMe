<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.MemberBean" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/button.css">
<style type="text/css">
a{
   font-size:20px; font-family:sans-serif ; 
}
</style>
</head>
<body><h1 style="margin:20px; font-family:sans-serif ; text-align:center; ">

회원 목록</h1>

<c:forEach var="member" items="${memberList}">
   <ul style="float: left; padding:50px;">
   <li><a href="MemberViewAction.me?id=${member.ID}" style="margin-left:150px;">
      ${member.ID}
      </a>
      <a href="MemberDeleteAction.me?id=${member.ID}">삭제하기</a></li>
   <li>
      <div class="image" style="width:250px; height:250px;">
      <img src="ProfileImage/${member.PROFILE_IMG}"
         style="width:250px; border-radius:50%; margin-top:20px; margin-bottom:20px;
               margin-left:90px;">
      </div>
   </li>
   </ul>
   <c:if test="List%4=0">
      <div id="clearboth" style="width: 0px; height: 0px; clear: both;">
      </div>
  </c:if>
</c:forEach>
</body>
</html>