package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		//����ڰ� ������ �ѱ� �����͸� ������ �ʰ� ���ڵ��Ѵ٤�.
		request.setCharacterEncoding("UTF-8");
		
		//�۹�ȣ�� �Ķ���ͷ� �޴´�.
		int no = Integer.parseInt(request.getParameter("no"));
		//System.out.println(no);
		
		//��й�ȣ�� �Ķ���ͷ� �޴´�.
		String db_pwd = request.getParameter("db_pwd");
		
		//�۾��̸� �Ķ���ͷ� �޴´�.
		String board02_name = request.getParameter("board02_name").trim();
		
		//������ ����
		String board02_title = request.getParameter("board02_title").trim();
		
		//�۳��� ����
		String board02_cont = request.getParameter("board02_cont").trim();
		
		//��й�ȣ ����
		String board02_pwd = request.getParameter("board02_pwd").trim();
		
//		System.out.println(board02_name);
//		System.out.println(board02_title);
//		System.out.println(board02_cont);
//		System.out.println(board02_pwd);
		
		if(db_pwd.equals(board02_pwd)){	//��й�ȣ�� ��ġ�� ���
			//equals() �޼ҵ�� �� ��ü�� ������ ���ϴ� �޼ҵ��̴�.
			BoardBean board = new BoardBean(); //��ü ����
			
			//�ڹٺ��� setter()�� �̿��Ͽ� ������ ����
			board.setBoard02_no(no);
			board.setBoard02_name(board02_name);
			board.setBoard02_title(board02_title);
			board.setBoard02_cont(board02_cont);
			
			//��� ������ ���� DAO ��ü ����
			BoardDAO db = new BoardDAO();
			
			//DAO Ŭ������ ���� �޼ҵ带 ȣ���Ѵ�.
			db.boardEdit(board);
			
			response.sendRedirect("board_cont.do?no="+no);
			//*.do?no=�۹�ȣ ������ get ������� �� ��ȣ�� �Ѱܼ� 
			//������ ����� �ϱ� ���ؼ� ���� ����� �̵��Ѵ�.
			//jsp���� sendRedirect("�̵��ּ� �Ǵ� ����") �޼ҵ�� ���ϴ� 
			//�ּ� �Ǵ� ���Ϸ� �̵���Ų��.		
		}else{
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
			out.println("history.go(-1)"); //�ٷ� ���� �������� �̵�
			out.println("</script>");
		}
		return null;
	}
}
