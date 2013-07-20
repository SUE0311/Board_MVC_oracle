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
		
		//�Խ��� ���� ���� ��Ÿ���� �׼� Ŭ����
		response.setContentType("text/html;charset=UTF-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO bd = new BoardDAO();
		
		//������ ����� ���ڵ� ������ ���ؼ� �����´�.
		//getCont()�޼ҵ带 ȣ���ϸ� �ش� ���ڵ带 ������ �� �ִ�. 
		BoardBean board = bd.getCont(no); //�Խù� ���� ȣ��
		
		//�� ��ü�� �Ӽ� set(�ƴϸ� �Ӽ����� ��� setAttibute�ؾ���)
		request.setAttribute("board", board);
		
		//board Ű�� ���ڵ带 �����Ѵ�.
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		//�Խù��� ������ �� �ִ� view �������� ��ο� ���ϸ� ����
		forward.setPath("./board/board_edit.jsp");
		
		//������ view �������� �������ȴ�.	
		return forward;
	}
}
