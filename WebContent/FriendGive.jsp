<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.FriendListBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
#add {
	border: 3px solid #222;
    background: transparent;
    overflow: hidden;
    outline: none;
    width: 147px;
    font-family: sans-serif;
    text-transform: uppercase;
    font-weight: 700;
    font-size: 18px;
    color: #222;
    display: block;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
    overflow: hidden;
    padding: 11px;
    margin-top: 110px;
    margin-left: 45px;
}
submit :hover {
  cursor: pointer;
}

</style>
</head>
<body>

<c:forEach var="friendStateList" items="${friendStateList}">
<form action="./FriendAddCancleAction.me" method="post">
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
            <td style="position:absolute; margin-top:135px; margin-left:58px;">
               	아이디:${friendStateList.FRIEND_ID}
            </td>
            <!----------------------------------------------------------------->                        
            <td>
                  <input type="submit" value="친구 신청 취소" id="add"> 
                  <input type="hidden" name="friendaddList" value="${friendStateList.FRIEND_ID}">
            </td>

         </tr>
      
      </table>
         <c:if test="List%4=0">
            <div id="clearboth" style="width: 0px; height: 0px; clear: both;">
            </div>
         </c:if>
         </form>
   </c:forEach>
	
</body>
</html>