<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String pagefile=request.getParameter("page");
	if(pagefile==null){pagefile="MainContent";}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 헤더파일</title>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="http://malsup.github.com/jquery.cycle2.js">
</script>
<link rel="stylesheet" type="text/css" href="css/Kakao.css">
<link rel="stylesheet" type="text/css" href="css/Main.css">

</head>
<body>
	<!-- 친구목록, 마이페이지, 로그아웃 -->
	<header>
		<ul style="position:absolute; top:62px; right:380px;">
			<li><span style="font-w
			eight:bold; font-size:20px;"><%=session.getAttribute("ID")%></span>님 환영합니다 &nbsp;&nbsp; <a href="LogoutAction.me">로그아웃</a></li>
		</ul>
		<a id="logo" href="UserMain.me"> <img src="Image/Logoz.png" width="140px">
		<!-- 로고 클릭시 메인으로 돌아감 메인 페이지 구현 -->
		</a>
		<div>
			<form action="SearchAction.me" method="post">
				<select name="select">
					<option value="Music">노래검색</option>
					<option value="Friend">친구검색</option>
				</select>
				<input type="text" name="id" id="search">
				<input type="submit" id="submit" value="검색" placeholder="검색어입력">
			</form>
		</div>
		  <ul class='menu closed'>
           <li class='messages button' style="text-align:center;"><a href="FriendAddGiveListAction.me">친구신청</a></li>
           <li class='music button' style="text-align:center;"><a href="FriendAddHaveListAction.me">친구신청확인</a></li>
           <li class='home button' style="text-align:center;"><a href="FriendListAction.me">친구목록</a></li>
           <li class='places button' style="text-align:center;"><a href="MyMusicListAction.me">음악목록</a></li>
           <li class='bookmark button' style="text-align:center;"><a href="MemberViewAction.me">회원정보</a></li>
           <li class='main button'>Menu</li>
      </ul>
	</header>
	<div>
	<jsp:include page='<%=pagefile+".jsp"%>'/>
	</div>

	<footer>
		<p>업체명 : ㈜MusicMakesMe | 사업자등록번호 : 121-86-24448</p>
		<p>주소 : 인천 남구 학익동 663-1 태승빌딩 5층 (1층 홈플러스) | 전화번호 : 032-876-3332</p>
		<p>Copyrights(c) ㈜MusicMakesMe 2015 all rights reserved.</p>
	</footer>
</body>
<script>
$(".menu").click(function(){
	   $(this).toggleClass("closed");
	   if($(this).hasClass("closed")) {
	      $(".main.button").text("Menu");
	   } else {
	      $(".main.button").text("Close");
	   }

	})
</script>
</html>