<%@ page contentType="text/html; charset=UTF-8"%>
    <!-- html  주석문기호. 위 부분은 jsp(java server pages) 에서  지시자라고 한다. 즉   jsp 정의문 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<link rel="stylesheet" type="text/css" href="./css/member.css" />
<link rel="stylesheet" type="text/css" href="./css/board_list.css">
<!-- css 외부 포함파일을 불러오는 것. css는  디자인 UI 를 작성 -->
<script src="./js/jquery.js"></script>
<script src="./js/board.js"></script>
<script src="./js/member.js"></script>
<!-- 글쓰기 폼에서 글쓴이, 글제목, 글내용, 비번 항목을 체크하기 위한 스크립트 -->
<!-- jQuery 자바스크립트 라이브러리 외부 파일을 읽어온다 -->

</head>
<body> 
<div id="main_wrap">
  <!-- 상단 header -->
  <div id="header">
    <div id="logo">
     <a href="./index.jsp" onfocus="this.blur()">
     <img src="./images/MVC log.png" border="0"/></a>
     <!-- 그림삽입 태그 -->
    </div>
    
    <div id="top_menu">
     <ul>
      <li><a href="#" onfocus="this.blur()">공지사항</a>
      <!-- ul li 태그는 목록을 만드는 태그이다. a href 는 다른 주소로 이동
      하는 하이퍼링크를 거는 태그이다. -->
      <li>
      <a href="./board_list.do"
       onfocus="this.blur()">게시판</a></li>
      <li><a href="#" onfocus="this.blur()">자료실</a></li>
      <li><a href="#" onfocus="this.blur()">QNA</a></li>
      <!-- onfocus는 포커스를 가졌을때 발생하는 자바스크립트 
      사건처리기 즉 이벤트 핸들러 이다. 클릭시 사각점선을 사라지게 함 --> 
     </ul>
    </div>
    
    <div id="top_login">
     <ul>
      <li><a href="./index.jsp" onfocus="this.blur()">홈</a></li>
       &nbsp;
      <!-- &nbsp;은 한칸 공백을 띄워준다 .-->
      <li><a href="./member_login.do" 
      onfocus="this.blur()">로그인</a></li>
      <li><a href="./member_join.do"
      onfocus="this.blur()">회원가입</a></li>
     </ul>
    </div>
  </div>
  