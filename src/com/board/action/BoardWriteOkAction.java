package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		String board02_name = request.getParameter("board02_name").trim();
		String board02_title = request.getParameter("board02_title").trim();
		String board02_cont = request.getParameter("board02_cont").trim();
		String board02_pwd = request.getParameter("board02_pwd").trim();

		//1) ��� ������ ���ؼ� DAO ��ü ����
		BoardBean bean = new BoardBean();

		//2) ���������� �̿��Ͽ� ���� setter() �޼ҵ�� �����Ѵ�. 
		bean.setBoard02_name(board02_name);
		bean.setBoard02_title(board02_title);
		bean.setBoard02_cont(board02_cont);
		bean.setBoard02_pwd(board02_pwd);
		
		//1) DAO ��ü�� ����
		BoardDAO dao = new BoardDAO();
			
		//2) ���������� �̿��Ͽ� ���� �޼ҵ带 ȣ���Ѵ�. 
		int re = dao.insertBoard(bean);
		
		if(re == 1){ //insert�� ������ ���
			response.sendRedirect("./board_list.do");
			//response ��ü�� ������ ó������� ����� ������ ����° ���ȴ�.
			//����)sendRedirect("�̵��� �ּ� �Ǵ� ���ϸ�")
			//������ �ּ� �Ǵ� ���ϸ����� ������� �̵��ȴ�.
			//��, insert���� ������ ��� �Խù� ��Ϻ���(board_list.jsp)�� �̵��Ѵ�.
		}else{ //insert�� ������ ���
			out.println("<script>");
			out.println("alert('�Խù� ���忡 �����Ͽ����ϴ�.')");
			out.println("history.back()");
			//�ڹٽ�ũ��Ʈ�� history ��ü���� �����Ǵ� back()�Լ��� �̿��Ͽ�
			//�ٷ� ���� �������� �̵���Ų��. 
			out.println("</script>");
		}	
		return null;
	}
}
