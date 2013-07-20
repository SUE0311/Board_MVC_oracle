<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.naver.dao.*" %>
<%@ page import="java.util.*" %>

<%@ include file="../include/header.jsp" %>
<!--  ../ 한 단계 상위 폴더로 이동, 외부 포함 파일ㅇ르 읽어오는 jsp 형식  -->

<div class="clear"></div>

<div id="article">
<%@ include file="../include/login.jsp" %>
  
<div id="article_c">
<%
List<BoardBean> boardList = (List<BoardBean>)request.getAttribute("boardList");
%>                            

	<h2 class="boardlist_title">게시물 목록</h2>
	<table id="boardTable">
		<tr>
			<th>글번호</th>
			<th>제 목</th>
			<th>글쓴이</th>
			<th>등록날짜</th>
			<th>조회수</th>
		</tr>
<%
		//게시판의 목록이 1개 이상 존재하는 경우 조건은 참이 된다.
		if((boardList!=null)&&(boardList.size()>0)){
			
			for(int i=0;i< boardList.size();i++){
				//컬렉션 요소 값을 BoardBean 타입으로 가져온다.
				BoardBean board = boardList.get(i);	
%>	
		<tr>
			<!-- 게시판 번호 표시 -->
			<td align="center"><%=board.getBoard02_no() %></td>
		
			<td>
				<!-- 게시물 제목을 클릭하면 해당 게시물의 내용을 볼 수 있도록 
				'*.do?no=글번호'형태의 get 방식으로 글번호를 넘긴다. -->
				<a href="board_cont.do?no=<%=board.getBoard02_no() %>" onfocus="this.blur()">
					<%=board.getBoard02_title() %>
				</a>
			</td>	
		
			<!-- 게시판 글쓴이 표시 -->
			<td>&nbsp;<%=board.getBoard02_name() %>&nbsp;</td>
		
			<!-- 게시판 등록날짜 표시 -->
			<!-- subString(0,10)은 등록날짜에서 앞자리10개만 추출(날짜 부분) -->
			<td>&nbsp;<%=board.getBoard02_regdate().substring(0,10) %>&nbsp;</td>
			
			<!-- 게시판 조회수 표시 -->
			<td align="center"><%=board.getBoard02_hit() %></td>
		</tr>
<%
			}//for end
		}else{
%>
		<tr>
			<td colspan="5">게시물 목록이 없습니다.</td>
		</tr>
<%
		}//if end
%>
	</table>

<div class="btnArea" id="list_btn">
	<input type="button" value="글쓰기" onclick="location='board_write.do'">
</div>

</div><!-- article_c end -->
 	  
</div><!-- article end -->

<div class="clear"></div>

<%@ include file="../include/footer.jsp" %>