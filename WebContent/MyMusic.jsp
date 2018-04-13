<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.Possesion_MusicBean"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Main.css">
<style>
#playlist {
   list-style: none;
}

#playlist li a {
   color: black;
   text-decoration: none;
}

#playlist .current-song a {
   color: blue;
}

footer {
   height: 115px;
   width: 100%;
   background-color: #1e1e1e;
   overflow: hidden;
}
</style>

</head>
<body>
   <c:forEach var="musicList" items="${mymusicList}">
      <div class="one" align="center">
         <div class="box person" style="float: left; margin: 50px;">
            <div class="image round">
               <ul id="playlist">
                  <li><a
                     href="${musicList.MUSIC_FILE_DIR}/${musicList.MUSIC_FILE_NAME}">
                        <img alt="Person 1"
                        src="./${musicList.MUSIC_FILE_DIR}/${musicList.IMG_FILE_NAME}"
                        style="border-radius: 50%; margin-left: 70px;" width="280px"
                        height="280px">
                  </a></li>
               </ul>
            </div>
            <c:set var="Title" value="${musicList.TITLE}" />
            <%String Title=(String)request.getAttribute("Title");%>
            <c:set var="Artist" value="${musicList.ARTIST}" />
            <%String Artist=(String)request.getAttribute("Artist");%>
            <c:set var="Dir" value="${musicList.MUSIC_FILE_DIR}" />
            <%String Dir=(String)request.getAttribute("Dir");%>
            <c:set var="IMG" value="${musicList.IMG_FILE_NAME}" />
            <%String IMG=(String)request.getAttribute("IMG");%>
            <c:set var="FILE" value="${musicList.MUSIC_FILE_NAME}" />
            <%String FILE=(String)request.getAttribute("FILE");%>

            <br>
            <h2 style="margin-left: 70px;">${musicList.TITLE}</h2>
            <h2 style="margin-left: 70px;">${musicList.ARTIST}</h2>
         </div>

         <c:if test="List%4=0">
            <div id="clearboth" style="width: 0px; height: 0px; clear: both;">
            </div>
         </c:if>
      </div>
   </c:forEach>

<div style="width:1900px; height:30px; bottom:110px;">
      <script src="https://code.jquery.com/jquery-2.2.0.js"></script>
      <script src="audioPlayer.js"></script>
   <audio controls src="" controls id="audioPlayer"
      style="width: 1900px; margin-bottom:-150px; left:20; top:20;">
   </audio>
   
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
</div> 
</body>
</html>