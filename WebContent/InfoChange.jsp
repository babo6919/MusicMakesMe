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

   <div class="container" align="center" style="border:1px solid grey; width:350px; 
   margin-left:720px; margin-top:30px;">
      <div class="view-account">
         <section class="module" >
            <div class="module-inner">
                           <form action="UpdateProfileAction.me" method="post" enctype="multipart/form-data">
       						<input type="file" name="PROFILE_IMG">
      						<input type="submit" value="등록">
  							</form>
                  <span class="fa fa-user"></span>프로필 사진 수정


               </div>
               <div class="content-panel">
                  <div class="billing">
                     <form id="billing" method="post" action="UpdateMemberAction.me" role="form">
                        아이디 :<%=session.getAttribute("ID") %> <br><br><br>
                        비밀번호 : <input type="password" class="form-control" name="PW"placeholder="비밀번호"><br><br><br>
                        이름 : <input type="text" class="form-control" name="NAME"placeholder="이름"><br><br><br>
                        주소 : <input type="text" class="form-control"name="ADDR" placeholder="전화번호"><br><br><br>
                        이메일 : <input type="text" class="form-control" name="EMAIL"placeholder="이메일"><br><br><br>   
                        <input type="submit" value="변경">
                     </form>
                  </div>
            </div>
         </section>
      </div>
   </div>
 
</body>
</html>