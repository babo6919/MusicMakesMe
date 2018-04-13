<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="vo.MemberBean"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<body>
<div align="center">
<table>
	<tr><td colspan=2 ><h1>아이디 찾기</h1></td></tr>	
	<tr>
		<td>아이디 : </td>
		<td>${find_ID.ID}</td>
	</tr> 
</table>
</div>
</body>
</html>