<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="MusicUploadAction.me" method="post" enctype="multipart/form-data">
	제목<input type="text" name="TITLE">
	아티스트<input type="text" name="ARTIST">
	음악 파일<input type="file" name="MUSIC_FILE_NAME">
	파일 경로<input type="text" name="MUSIC_FILE_DIR">
	이미지 파일<input type="file" name="IMG_FILE_NAME">
	사용되는 포인트<input type="text" name="DEDUCT_POINT">
	<input type="submit" value="업로드">
	</form>
</body>
</html>