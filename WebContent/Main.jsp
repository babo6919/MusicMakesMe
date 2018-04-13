<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ID= (String)session.getAttribute("ID");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(ID==null){ %>
	<jsp:forward page="LoginMain.jsp"/>
	<%}else if(ID.equals("admin")){ %>
	<jsp:forward page="AdminMain.jsp"/>
	<%}else{%>
	<jsp:forward page="UserMain.jsp"/>
	<%} %>
</body>
</html>