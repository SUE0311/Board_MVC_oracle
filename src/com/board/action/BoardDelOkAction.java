package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

public class BoardDelOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//�۹�ȣ�� �ش��ϴ� ���ڵ� ���� �׼� Ŭ����
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		//Ŭ���̾�Ʈ���� ����(hidden)���� �Ѿ�� ���� �Ķ���ͷ� �޴´�.
		//�۹�ȣ(no)�� �ش� ������ ���ڵ带 ã�� ���ؼ�
		//��й�ȣ(db_pwd)�� ������ �Է��� ��й�ȣ�� ��ġ�ϴ� �� ���ϱ� ���ؼ�
		int no = Integer.parseInt(request.getParameter("no"));
		String db_pwd = request.getParameter("db_pwd");
		
		//����ڰ� �Է��� ��й�ȣ�� �Ķ���ͷ� �޴´�. 
		String del_pwd = request.getParameter("del_pwd").trim();
		
		if(db_pwd.equals(del_pwd)){ //��й�ȣ�� ��ġ�� ���
			BoardDAO db = new BoardDAO();
			
			db.boardDel(no);
			
			//���ڵ尡 �����ܾ����� Ȯ���ϱ� ���ؼ� ��Ϻ���� �̵�
			response.sendRedirect("board_list.do");
		}else{
			out.println("<script>");
			out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
			out.println("history.go(-1)"); //�ٷ� ���� �������� �̵�
			out.println("</script>");
		}
		return null;
	}
}
