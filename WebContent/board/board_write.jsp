<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../include/header.jsp" %>

<div class="clear"></div>

<div id="article">
<%@ include file="../include/login.jsp" %>
 
<div id="article_c">

 	<h2 class="boardlist_title">게시물 글쓰기</h2>

	<form method="post" action="board_write_ok.do" id="boardwrite_form">
		<table id="boardTable">
			<tr>
				<td colspan="2" style="font-size:12px;color:red;text-align:right">
					* 표시는 반드시 입력해주세요.
				</td>
			</tr>
			<tr>
				<th>글쓴이 *</th>
				<td>
					<input name="board02_name" id="board_name" size="90" placeholder="필수입력 사항입니다." autofocus="autofocus" />
				</td>
			</tr>
			<tr>
				<th>제목 *</th>
				<td>
					<input name="board02_title" id="board_title" size="90" placeholder="필수입력 사항입니다." />
				</td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<!-- textarea 태그는 2줄 이상의 문단을 입력할 수 있는 텍스트 필드 양식 -->
					<textarea name="board02_cont" rows="10" cols="78" ></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호 *</th>
				<td>	
					<input type="password" name="board02_pwd" id="board_pwd" size="14" placeholder="필수입력 " />
				</td>
			</tr>
		</table>
		
		<div class="btnArea">
			<input type="button" value="입력" onclick="boardwrite_ok()"/>
			<input type="reset" value="취소" onclick="$('#board_name').focus();"/>
			<input type="button" value="목록보기" 
				onclick="location='board_list.do'"/>	<!-- ../board/board_list.jsp -->
		</div>
		<!-- 입력 내용을 초기화하면서 글쓴이 입력창으로 포커스를 이동시킨다. -->	
	</form>
 
</div><!-- article_c end -->
 	  
</div><!-- article end -->

<div class="clear"></div>

<%@ include file="../include/footer.jsp" %>