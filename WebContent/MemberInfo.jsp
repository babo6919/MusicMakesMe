<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/Memberinfo.css">

</head>
<body>
	<div class="container" align="center">
		<div class="view-account">
			<section class="module">
				<div class="module-inner">
					<div class="side-bar">
						<div class="user-info">
							<img width="250" height="250" class="img-profile img-circle img-responsive center-block"
								src="ProfileImage/${memberView.PROFILE_IMG}">
						</div>
					</div>
					<div class="content-panel">
						<div class="billing">
							<form id="billing" method="post" action="Main.jsp?page=InfoChange" role="form">
								아이디 :${memberView.ID}<br><br><br>
								이름 : ${memberView.NAME}<br><br><br>
								주소 : ${memberView.ADDR}<br><br><br>
								이메일 :${memberView.EMAIL}<br><br><br>
								포인트 :${memberView.POINT}<br><br><br>	
								<%if(!session.getAttribute("ID").equals("admin")){%>
								<input type="submit" value="변경">
							</form>
							<br>
							<br>
							<form action="MemberDeleteAction.me">
							<input type="submit" value="탈퇴">
							</form>
							<%} %>	
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>
</body>
</html>