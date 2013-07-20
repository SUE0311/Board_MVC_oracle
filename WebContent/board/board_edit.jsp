<%@page import="com.naver.dao.BoardBean"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../include/header.jsp" %>

<div class="clear"></div>

 <div id="article">
<%@ include file="../include/login.jsp" %>
 
<div id="article_c">
 	
<%
	//setAttibute()메소드로 지정된 값을 가져온다. 
	//board키에는 수정을 위한 레코드 정보를 가지고 온다. 
	BoardBean board = (BoardBean)request.getAttribute("board");
%> 	
 	
<h2 class="boardlist_title">게시물 수정하기</h2>

<form method="post" action="board_edit_ok.do" id="boardwrite_form">

<!-- 히든으로 글 번호와 비밀번호를 넘긴다. 히든은 웹상에서 안보이게 하는 역할을 한다.  -->
	<input type="hidden" name="no" value=<%=board.getBoard02_no() %> />
	<input type="hidden" name="db_pwd" value=<%=board.getBoard02_pwd() %> />

	<table id="boardTable">
		<tr>
			<td colspan="2" style="font-size:12px;color:red;text-align:right">
				* 표시는 반드시 입력해주세요.
			</td>
		</tr>
		<tr>
			<th>글쓴이 *</th>
			<td>
				<input name="board02_name" id="board_name" size="90" value="<%=board.getBoard02_name() %>" class="input_box"/>				
			</td>
		</tr>
		<tr>
			<th>제목 *</th>
			<td>
				<input name="board02_title" id="board_title" size="90" value="<%=board.getBoard02_title() %>" class="input_box"/>
			</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>
				<textarea name="board02_cont" rows="10" cols="78" class="input_box"><%=board.getBoard02_cont() %></textarea>
			</td>
		</tr>
		<tr>
			<th>비밀번호 *</th>
			<td>	
				<input type="password" name="board02_pwd" id="board_pwd" size="14" class="input_box" />
			</td>
		</tr>
	</table>
	
	<div class="btnArea">
		<input type="button" value="수정" onclick="boardwrite_ok()"/>
		<input type="reset" value="취소" onclick="$('#board_name').focus();"/>
		<input type="button" value="목록으로" 
			onclick="location='board_list.do'"/>	<!-- ../board/board_list.jsp -->
	</div>
	<!-- 입력 내용을 초기화하면서 글쓴이 입력창으로 포커스를 이동시킨다. -->	
</form>
 
</div><!-- article_c end -->
 	  
</div><!-- article end -->

<div class="clear"></div>
<%@ include file="../include/footer.jsp" %>