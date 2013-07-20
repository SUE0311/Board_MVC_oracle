package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

/*
 * Controller(Action) ����
 * 1. mtoryFrontController(����ó����)�� ���ؼ� ȣ��Ǵ� Ŭ�����̴�.
 * 2. DAOŬ����(model ����)�� ���ǵ� �޼ҵ带 ȣ���Ͽ� db�� �����Ѵ�.
 * 3. ó������� ����ڿ��� ������ �� �ִ� view �������� ��������Ų��. 
 * 4. ��������� Action �������̽��� ��ӹ޾Ƽ� Ŭ������ �ۼ��Ѵ�.
 *    - ActionForward() �޼ҵ带 �������Ѵ�. 
 *    - db �۾��� ���� ����, view �������� �������� ���� 
 */

public class BoardContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�Խ����� �� ������ Ŭ���ϸ� �ش� �� ������ �� �� �ִ� �׼� Ŭ�����̴�.
		
		//���� ����� �ѱ��� ���Ե� ��� ������ �ʰ� ���ڵ��Ѵ�.
		response.setContentType("text/html;charset=UTF-8");
		
		//��� ��ũ�� ��ü�� �����Ѵ�. 
		PrintWriter out = response.getWriter();
		
		//Ŭ���̾�Ʈ���� ���� �����͸� �Ķ���ͷ� �޴´�.
		//�۹�ȣ�� �Ķ���ͷ� �޾Ƽ� ������ �������� �� ��ȯ�Ͽ� ������ �����Ѵ�.
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		//��� �����ϱ� ���ؼ� DAO ��ü�� �����Ѵ�. 
		BoardDAO bd = new BoardDAO();
		
		bd.boardHit(no); //��ȸ���� ������Ű�� �޼ҵ� ȣ��(�� ���ǵ�)
		BoardBean board = bd.getCont(no); //��ȣ�� �������� ������ �����´�.
			
		//������ board Ű�� ���ڵ� ���� �����Ѵ�.		
		request.setAttribute("board", board);

        //view �������� �������ϱ� ���ؼ� ������ ��ü�� �����Ѵ�.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //redirect ���θ� �����Ѵ�.
		
		//����ڿ��� ������ view �������� �����Ѵ�.
		forward.setPath("./board/board_cont.jsp");
		
		//�ش� �������� �������Ѵ�.
		return forward;
	}
}
