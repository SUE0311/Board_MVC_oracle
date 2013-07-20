package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardDelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO bd = new BoardDAO();
		
		BoardBean board = bd.getCont(no);
		
		request.setAttribute("b", board);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
		forward.setPath("./board/board_del.jsp");
		
		return forward;
	}
}
