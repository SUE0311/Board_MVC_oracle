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
		forward.setRedirect(false); //redirect ���θ� �����Ѵ�.
		
		//����ڿ��� ������ view �������� �����Ѵ�.
		forward.setPath("./board/board_write.jsp");
		
		//�ش� �������� �������Ѵ�.
		return forward;
	}
}
