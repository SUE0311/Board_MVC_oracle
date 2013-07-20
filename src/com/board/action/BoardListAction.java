package com.board.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�Խ����� �� ������ Ŭ���ϸ� �ش� �� ������ �� �� �ִ� �׼� Ŭ�����̴�.
		
		//���� ����� �ѱ��� ���Ե� ��� ������ �ʰ� ���ڵ��Ѵ�.
		response.setContentType("text/html;charset=UTF-8");
		
		//��� �����ϱ� ���ؼ� DAO ��ü�� �����Ѵ�. 
		BoardDAO bd = new BoardDAO();
		
		List<BoardBean> boardList = bd.getBoardList();
			
		//������ board Ű�� ���ڵ� ���� �����Ѵ�.		
		request.setAttribute("boardList", boardList);

        //view �������� �������ϱ� ���ؼ� ������ ��ü�� �����Ѵ�.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //redirect ���θ� �����Ѵ�.
		
		//����ڿ��� ������ view �������� �����Ѵ�.
		forward.setPath("./board/board_list.jsp");
		
		//�ش� �������� �������Ѵ�.
		return forward;
	}
}
