<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.naver.dao.*" %>
<%@ page import="java.util.*" %>

<%@ include file="../include/header.jsp" %>

<div class="clear"></div>

<div id="article">

<%@ include file="../include/login.jsp" %>
 
<div id="article_c">
 	
<%
	//getAttribute() 메소드로 board 키 값을 받는다.
	//리턴 타입이 Object 형이기 때문에 BoardBean 타입으로 다운 캐스팅한다.
	BoardBean board = (BoardBean)request.getAttribute("board");
%> 	
 	
	<h2 class="boardlist_title">게시물 내용보기</h2>

	<table id="boardTable">
		<tr>
			<th>작성자</th>
			<td>
				<%=board.getBoard02_name() %>
			</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>
				<%=board.getBoard02_hit() %>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<%=board.getBoard02_title() %>			
			</td>
		</tr>
		<tr>
			<th>글내용</th>
			<td>
				<%=board.getBoard02_cont() %>
			</td>
		</tr>
	</table>
	
	<div class="btnArea">
		<input type="button" value="수정" 
			onclick="location='board_edit.do?no=<%=board.getBoard02_no()%>'"/>
		<input type="button" value="삭제" 
			onclick="location='board_del.do?no=<%=board.getBoard02_no()%>'"/>
		<input type="button" value="목록보기" 
			onclick="location='board_list.do'"/>
	</div>
 
</div><!-- article_c end -->
 	  
</div><!-- article end -->

<div class="clear"></div>

<%@ include file="../include/footer.jsp" %>