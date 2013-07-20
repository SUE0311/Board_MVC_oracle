<%@ page contentType="text/html; charset=UTF-8"%>
    <!-- html  주석문기호. 위 부분은 jsp(java server pages) 에서
    지시자라고 한다. 즉   jsp 정의문 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 화면</title>
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<!-- css 외부 포함파일을 불러오는 것. css는  디자인 UI 를 작성 -->
<script src="./js/jquery.js"></script>
<!-- jQuery 자바스크립트 라이브러리 외부 파일을 읽어온다 -->
</head>
<body>
 <div id="main_wrap">
  <!-- 상단 header -->
  <div id="header">
    <div id="logo">
     <a href="index.jsp" onfocus="this.blur()">
     <img src="./images/MVC log.png" border="0" /></a>
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
      <li><a href="index.jsp" onfocus="this.blur()">홈</a></li>
       &nbsp;
      <!-- &nbsp;은 한칸 공백을 띄워준다 .-->
      <li><a href="./member_login.do" 
      onfocus="this.blur()">로그인</a></li>
      <li><a href="./member_join.do"
      onfocus="this.blur()">회원가입</a></li>
     </ul>
    </div>
  </div>
  
  <div class="clear"></div>
  
    <!-- 본문 내용 -->
    <div id="article">
     <div id="left_menu">
      <script language="javascript">
       //자바스크립트는 클라이언트 스크립트 언어로서 c언어 문법을따라간다.
       function login_check(){//함수 정의
    	   if(window.document.f.id.value==""){
    		   //자바스크립트 최상위 객체는  window이다.아무것도 입력하지
    		   //않았다면
    		    alert("아이디를 입력하세요!");//경고창 띄운다.
    		    f.id.focus();//포커스를 이동
    		    return false;
    	   }
           if($.trim($("#pwd").val())==""){
        	   //$는 jQuery 이다.trim()을 사용하여 양쪽 공백을 제거
        	   alert("비번을 입력하세요!");
        	   $("#pwd").val("").focus();//초기화 하고 포커스 이동
        	   return false;
       	   }
       }
       
       /* 공지창 띄위기 */
       function pwd_find() { // 함수정의
    	   window.open("./member/pwd_find.jsp", "비번찾기", "width=300px, height=350px scrollbars=yes");
       //자스에서  window 객체의 open() 메서드로 새로운 공지창을 만듬
       // open("공지창파일경로", "공지창이름", "공지창 속성")
       // 폭 300, 높이 300, 스크롤바가 생성되는 공지창을 만듬
       }
      </script>
      <form name="f" method="post" action="member_login_ok.jsp"
      onsubmit="return login_check()">
        <!-- form태그는 사용자에서 입력한 정보를 서버로 보내는 태그이다.
        method=post방식으로 보내면 보안이 좋다.웹주소창에 노출이 안됨.
        action="서버파일주소"를 지정한다. -->
        <table id="login_t">
         <tr>
          <th>아이디</th>
          <!-- th태그는 열을 만들고 글자를 중앙 정렬,진하게 해준다. -->
          <td>
          <input type="text" name="id" id="id" 
          class="input_box" size="14"/>
          <!-- text 는 한줄 입력필드를 만든다. -->
          </td>
         </tr>
         
         <tr>
           <th>비밀번호</th>
           <td>
            <input type="password" name="pwd" id="pwd" 
            size="14" class="input_box" />
           </td>
         </tr>
        </table>
        <div id="login_menu">
         <input type="submit" value="로그인" class="input_b" />
         <input type="button" value="비번찾기" class="input_b" 
         onclick="pwd_find()" />
         <!-- 클릭이벤트를 발생해서   pwd_find()함수 호출 -->
        </div>
      </form>
     </div>
     
     <div id="article_c">
       <p class="article_cont"> <b>메인내용</b></p>
     </div>
    </div>
    
    <div class="clear"></div>
    
    <!-- 하단 내용 -->
    <div id="footer">
    <h2 class="footer_title">
     MVC 패턴을 사용하여 간단한 게시판 만들기 프로그래밍
    </h2>
    </div>
 </div>
</body>
</html>