<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String pagefile = request.getParameter("page"); 
	if(pagefile==null){pagefile="Login";} %>    	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Login Main</title>
	<link rel="stylesheet" type="text/css" href="css/Join&Login.css">
</head>
<body>
	<p Style="position:absolute; top:0px; left:620px; font-size:80px; font-weight:bold; color:grey">#Music Makes Me</p>
	<div class="ImageArea">
		<img src="Image/Iphone.png" width="314px" height="653px">
		<div class="FadeArea">
			<h2>
  			<span>There's</span>
  			<span class="light">Song</span>
  			<span> even in</span>
  			<span>the darkest</span>
  			<span>places</span>
			</h2>
		</div>
	</div>
	<div class="LoginArea">
	<jsp:include page='<%=pagefile+".jsp"%>'></jsp:include>
	</div>

	<div class="ChangeArea">
		<%if(pagefile.equals("Login")){ %>
		<a href="./LoginMain.jsp?page=Join"><button class="btn-Change">회원가입</button></a><br>
		<%}
		else if(pagefile.equals("Join")){
		%>
		<a href="./LoginMain.jsp?page=Login"><button class="btn-Change">로그인</button></a>
		<%}
		else if(pagefile.equals("Find_ID")){
		%>
		<a href="./LoginMain.jsp?page=Login"><button class="btn-Change">로그인</button></a>
		<a href="./LoginMain.jsp?page=Join"><button class="btn-Change">회원가입</button></a><br>
		<%} 
		else if(pagefile.equals("Find_PW")){
		%>
		<a href="./LoginMain.jsp?page=Login"><button class="btn-Change">로그인</button></a>
		<a href="./LoginMain.jsp?page=Join"><button class="btn-Change">회원가입</button></a><br>
		<%}
		else if(pagefile.equals("Find_ID_Result")){
		%>
		<a href="./LoginMain.jsp?page=Login"><button class="btn-Change">로그인</button></a>
		<a href="./LoginMain.jsp?page=Join"><button class="btn-Change">회원가입</button></a><br>
		<%}
		else if(pagefile.equals("Find_PW_Result")){
		%>
		<a href="./LoginMain.jsp?page=Login"><button class="btn-Change">로그인</button></a>
		<a href="./LoginMain.jsp?page=Join"><button class="btn-Change">회원가입</button></a><br>
		<%} %>
	</div>

</body>
</html>