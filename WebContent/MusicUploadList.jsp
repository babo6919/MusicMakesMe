<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import = "vo.MusicBean" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
        #playlist{
            list-style: none;
        }
        #playlist li a{
            color:black;
            text-decoration: none;
        }
        #playlist .current-song a{
            color:blue;
        }
    </style>
</head>
<body>
<audio src="" controls id="audioPlayer">
</audio>
<ul id="playlist">
<c:forEach var = "music" items ="${musicList}">
		<li class="current-song"><a href="${music.MUSIC_FILE_DIR}/${music.MUSIC_FILE_NAME}">${music.TITLE}</a></li>
</c:forEach>
</ul>
    <script src="https://code.jquery.com/jquery-2.2.0.js"></script>
    <script src="audioPlayer.js"></script>
    <script>
    audioPlayer();
    function audioPlayer(){
        var currentSong = 0;
        $("#audioPlayer")[0].src = $("#playlist li a")[0];
        $("#audioPlayer")[0].play();
        $("#playlist li a").click(function(e){
           e.preventDefault(); 
           $("#audioPlayer")[0].src = this;
           $("#audioPlayer")[0].play();
           $("#playlist li").removeClass("current-song");
            currentSong = $(this).parent().index();
            $(this).parent().addClass("current-song");
        });
        
        $("#audioPlayer")[0].addEventListener("ended", function(){
           currentSong++;
            if(currentSong == $("#playlist li a").length)
                currentSong = 0;
            $("#playlist li").removeClass("current-song");
            $("#playlist li:eq("+currentSong+")").addClass("current-song");
            $("#audioPlayer")[0].src = $("#playlist li a")[currentSong].href;
            $("#audioPlayer")[0].play();
        });
    }
        audioPlayer();
    </script>
</body>
</html>