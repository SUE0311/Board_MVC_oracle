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

		//1) 디비 접근을 위해서 DAO 객체 생성
		BoardBean bean = new BoardBean();

		//2) 참조변수를 이용하여 빈의 setter() 메소드로 저장한다. 
		bean.setBoard02_name(board02_name);
		bean.setBoard02_title(board02_title);
		bean.setBoard02_cont(board02_cont);
		bean.setBoard02_pwd(board02_pwd);
		
		//1) DAO 객체를 생성
		BoardDAO dao = new BoardDAO();
			
		//2) 참조변수를 이용하여 저장 메소드를 호출한다. 
		int re = dao.insertBoard(bean);
		
		if(re == 1){ //insert가 성공한 경우
			response.sendRedirect("./board_list.do");
			//response 객체는 서버의 처리결과를 사용자 웹으로 보낼째 사용된다.
			//형식)sendRedirect("이동할 주소 또는 파일명")
			//지정된 주소 또는 파일명으로 제어권이 이동된다.
			//즉, insert문이 성공한 경우 게시물 목록보기(board_list.jsp)로 이동한다.
		}else{ //insert가 실패한 경우
			out.println("<script>");
			out.println("alert('게시물 저장에 실패하였습니다.')");
			out.println("history.back()");
			//자바스크립트의 history 객체에서 지원되는 back()함수를 이용하여
			//바로 이전 페이지로 이동시킨다. 
			out.println("</script>");
		}	
		return null;
	}
}
