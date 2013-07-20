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
		
		//사용자가 전송한 한글 데이터를 깨지지 않게 인코딩한다ㅣ.
		request.setCharacterEncoding("UTF-8");
		
		//글번호를 파라미터로 받는다.
		int no = Integer.parseInt(request.getParameter("no"));
		//System.out.println(no);
		
		//비밀번호를 파라미터로 받는다.
		String db_pwd = request.getParameter("db_pwd");
		
		//글쓴이를 파라미터로 받는다.
		String board02_name = request.getParameter("board02_name").trim();
		
		//글제목 저장
		String board02_title = request.getParameter("board02_title").trim();
		
		//글내용 저장
		String board02_cont = request.getParameter("board02_cont").trim();
		
		//비밀번호 저장
		String board02_pwd = request.getParameter("board02_pwd").trim();
		
//		System.out.println(board02_name);
//		System.out.println(board02_title);
//		System.out.println(board02_cont);
//		System.out.println(board02_pwd);
		
		if(db_pwd.equals(board02_pwd)){	//비밀번호가 일치한 경우
			//equals() 메소드는 두 객체의 내용을 비교하는 메소드이다.
			BoardBean board = new BoardBean(); //빈객체 생성
			
			//자바빈의 setter()를 이용하여 데이터 저장
			board.setBoard02_no(no);
			board.setBoard02_name(board02_name);
			board.setBoard02_title(board02_title);
			board.setBoard02_cont(board02_cont);
			
			//디비 연동을 위한 DAO 객체 생성
			BoardDAO db = new BoardDAO();
			
			//DAO 클래스에 수정 메소드를 호출한다.
			db.boardEdit(board);
			
			response.sendRedirect("board_cont.do?no="+no);
			//*.do?no=글번호 형태의 get 방식으로 글 번호를 넘겨서 
			//수정된 결과를 하기 위해서 내용 보기로 이동한다.
			//jsp에서 sendRedirect("이동주소 또는 파일") 메소드는 원하는 
			//주소 또는 파일로 이동시킨다.		
		}else{
			out.println("<script>");
			out.println("alert('비밀번호가 일치하지 않습니다.')");
			out.println("history.go(-1)"); //바로 이전 페이지로 이동
			out.println("</script>");
		}
		return null;
	}
}
