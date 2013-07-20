<%@ page contentType="text/html; charset=UTF-8" %>

<%@ page import="com.naver.dao.*" %>

<%@ include file="../include/header.jsp" %>

<div class="clear"></div>

<div id="article">

<%@ include file="../include/login.jsp" %>

<div id="article_c">

<%
	//setAttribute("b", board);
	//리턴 타입이 Object 형이기 때문에 BoardBean 타입으로 다운 캐스팅	
	BoardBean board = (BoardBean)request.getAttribute("b");
%>
<script>
	//삭제할 레코드의 비번을 반드시 입력받기 위해서
	function del_check(){
		if($.trim($("#del_pwd").val())==""){
			alert("삭제 비밀번호를 입력하세요");
			$("#del_pwd").focus();
			return false;
		}	
	}
</script>

	<h2 class="boardlist_title">삭제 창입니다.</h2>
	
	<form method="post" action="board_del_ok.do" 
			onsubmit="return del_check()">
	<!-- action="*.do"로 지정한다는 의미는 MVC(모델2) 방식으로  처리하겠다는 의미임 -->	
		
		<input type="hidden" name="no" value=<%=board.getBoard02_no() %> />
		<input type="hidden" name="db_pwd" value=<%=board.getBoard02_pwd() %> />
		<!-- 글번호(no), 비밀번호(pwd)는 히든으로 넘긴다. -->	
		
		<table id="boardTable">
			<tr>
				<th>삭제 비번</th>
				<td>
					<input type="password" name="del_pwd" id="del_pwd"
						size="14" class="input_box" autofocus="autofocus"/>
				</td>
			</tr>
		</table>	
		
		<div class="btnArea">
			<input type="submit" value="삭제" />
			<input type="reset" value="취소" 
					onclick="$('#del_pwd').focus();" />
		</div>
				
	</form>		

</div><!-- article_c end -->

</div><!-- article end -->
