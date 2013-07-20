package com.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardDAO;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //redirect 여부를 결정한다.
		
		//사용자에게 보여줄 view 페이지를 지정한다.
		forward.setPath("./board/board_write.jsp");
		
		//해당 페이지로 포워딩한다.
		return forward;
	}
}
