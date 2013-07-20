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
		//글번호에 해당하는 레코드 삭제 액션 클래스
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		//클라이언트에서 히든(hidden)으로 넘어온 값을 파라미터로 받는다.
		//글번호(no)는 해당 삭제할 레코드를 찾기 위해서
		//비밀번호(db_pwd)는 삭제가 입력한 비밀번호와 일치하는 지 비교하기 위해서
		int no = Integer.parseInt(request.getParameter("no"));
		String db_pwd = request.getParameter("db_pwd");
		
		//사용자가 입력한 비밀번호를 파라미터로 받는다. 
		String del_pwd = request.getParameter("del_pwd").trim();
		
		if(db_pwd.equals(del_pwd)){ //비밀번호가 일치한 경우
			BoardDAO db = new BoardDAO();
			
			db.boardDel(no);
			
			//레코드가 삭제외었는지 확인하기 위해서 목록보기로 이동
			response.sendRedirect("board_list.do");
		}else{
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.go(-1)"); //바로 이전 페이지로 이동
			out.println("</script>");
		}
		return null;
	}
}
