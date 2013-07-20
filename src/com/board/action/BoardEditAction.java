package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//게시판 수정 폼을 나타내는 액션 클래스
		response.setContentType("text/html;charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO bd = new BoardDAO();
		
		//기존에 저장된 레코드 수정을 위해서 가져온다.
		//getCont()메소드를 호출하면 해당 레코드를 가져올 수 있다. 
		BoardBean board = bd.getCont(no); //게시물 내용 호출
		
		//빈 객체로 속성 set(아니면 속성마다 모두 setAttibute해야함)
		request.setAttribute("board", board);
		
		//board 키에 레코드를 저장한다.
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		//게시물을 수정할 수 있는 view 페이지의 경로와 파일명 지정
		forward.setPath("./board/board_edit.jsp");
		
		//지정된 view 페이지로 포워딩된다.	
		return forward;
	}
}
