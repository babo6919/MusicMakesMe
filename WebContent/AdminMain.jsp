<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String session_id = (String)session.getAttribute("ID"); %>
<% String pagefile=request.getParameter("page");
	if(pagefile==null){pagefile="MainContent";}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 헤더파일</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js"></script>
<link rel="stylesheet" type="text/css" href="css/Kakao.css">
<link rel="stylesheet" type="text/css" href="css/Main.css">
</head>
<body>
	<header>
		<a id="logo" href="Main.me"> <img src="Image/Logoz.png"
			width="140px"> <!-- 로고 클릭시 메인으로 돌아감 메인 페이지 구현 -->
		</a>
		<div>
			<form action="SearchAction.me" method="post">
				<select name="select">
					<option value="Music">노래검색</option>
					<option value="Friend">친구검색</option>
				</select>
				<input type="text" id="search" name="id" placeholder="검색어 입력">
				<input type="submit" id="submit" value="검색">
			</form>
		</div>
		<nav id="top_menu">
			<!-- 친구목록, 마이페이지, 로그아웃 -->
			<ul>
				<li class="green"><a href="MemberListAction.me">회원 목록</a></li>
				<!--  a태그는 친구목록 페이지 연동할것-->	
				<li class="green"><a href="Main.jsp?page=MusicUpload">업로드</a></li>
				<li class="green"><a href="MusicListAction.me">업로드목록</a></li>
				<!--  a태그는 마이페이지 연동할것-->
				<li><a href="LogoutAction.me">로그아웃</a></li>
				<!--  세션초기화-->
			</ul>
		</nav>
	</header>

	<jsp:include page='<%=pagefile+".jsp"%>'/>
	<footer>
		<p>업체명 : ㈜MusicMakesMe | 사업자등록번호 : 121-86-24448</p>
		<p>주소 : 인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스) | 전화번호 : 032-876-3332</p>
		<p>Copyrights(c) ㈜MusicMakesMe 2015 all rights reserved.</p>
	</footer>

</body>
</html>