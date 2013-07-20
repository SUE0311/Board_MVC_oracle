package com.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.BoardBean;
import com.naver.dao.BoardDAO;

/*
 * Controller(Action) 역할
 * 1. mtoryFrontController(전방처리기)에 의해서 호출되는 클래스이다.
 * 2. DAO클래스(model 영역)에 정의된 메소드를 호출하여 db에 접근한다.
 * 3. 처리결과를 사용자에게 보여줄 수 있는 view 페이지로 포워딩시킨다. 
 * 4. 구현방법의 Action 인터페이스를 상속받아서 클래스를 작성한다.
 *    - ActionForward() 메소드를 재정의한다. 
 *    - db 작업에 관한 내용, view 페이지로 포워딩할 내용 
 */

public class BoardContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//게시판의 글 제목을 클릭하면 해당 글 내용을 볼 수 있는 액션 클래스이다.
		
		//응답 결과에 한글이 포함된 경우 깨지지 않게 인코딩한다.
		response.setContentType("text/html;charset=UTF-8");
		
		//출력 스크림 객체를 생성한다. 
		PrintWriter out = response.getWriter();
		
		//클라이언트에서 보낸 데이터를 파라미터로 받는다.
		//글번호를 파라미터로 받아서 정수형 태입으로 형 변환하여 변수에 저장한다.
		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println(no);
		
		//디비에 접근하기 위해서 DAO 객체를 생성한다. 
		BoardDAO bd = new BoardDAO();
		
		bd.boardHit(no); //조회수을 증가시키는 메소드 호출(미 정의됨)
		BoardBean board = bd.getCont(no); //번호를 기준으로 내용을 가져온다.
			
		//좌측의 board 키에 레코드 값을 저장한다.		
		request.setAttribute("board", board);

        //view 페이지로 포워딩하기 위해서 포워딩 객체를 생성한다.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //redirect 여부를 결정한다.
		
		//사용자에게 보여줄 view 페이지를 지정한다.
		forward.setPath("./board/board_cont.jsp");
		
		//해당 페이지로 포워딩한다.
		return forward;
	}
}
