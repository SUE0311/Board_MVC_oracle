<%@ page contentType="text/html; charset=UTF-8"%>
<div id="left_menu">
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
          class="input_box" size="14" />
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