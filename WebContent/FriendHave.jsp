<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="vo.FriendListBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Mymusic.css">
<link rel="stylesheet" type="text/css" href="css/button.css">
<style>
footer {
   height: 115px;
   width: 100%;
   background-color: #1e1e1e;
   overflow: hidden;
   margin-top: 0px;
   position: fixed;
   top: 810px;
   margin-top: 50px;
}
td{
font-size:20px;
font-family:sans-serif ;
}
</style>
</head>
<body>

   <c:forEach var="friendStateList" items="${friendStateList}">

      <table style="float: left;">
         <tr>
            
            <!---------------------------------------------------------------  -->   
            <td rowspan="3">
               <div class="image">
                     <img src="ProfileImage/${friendStateList.PROFILE_IMG}"
                        style="width:250px; border-radius:50%; margin-top:70px;
                        margin-left:90px;">
               </div>               
            </td>
            <td style="position:absolute; margin-top:105px; margin-left:40px;">
               아이디:${friendStateList.ID}
            </td>
            <!----------------------------------------------------------------->                        
            <td>
            <form action="./FriendAddAction.me" method="post" style="position:absolute; margin-left:20px;">
                  <input type="submit" value="친구 신청  수락" id="add"> <input
                     type="hidden" name="USER_ID" value="${friendStateList.ID}">
            </form>
            </td>
            <!----------------------------------------------------------------->   
            <td>
            <form action="./FriendAddHaveCancleAction.me" method="post" style="margin-top:200px; margin-left:20px;">
                  <input type="submit" value="친구 신청 거절" id="add"> <input
                     type="hidden" name="USER_ID" value="${friendStateList.ID}">
            </form>
            </td>
            
         </tr>
      
      </table>
         <c:if test="List%4=0">
            <div id="clearboth" style="width: 0px; height: 0px; clear: both;">
            </div>
         </c:if>
   </c:forEach>

   

</body>
</html>