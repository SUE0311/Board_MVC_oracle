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
		//게시판의 글 제목을 클릭하면 해당 글 내용을 볼 수 있는 액션 클래스이다.
		
		//응답 결과에 한글이 포함된 경우 깨지지 않게 인코딩한다.
		response.setContentType("text/html;charset=UTF-8");
		
		//디비에 접근하기 위해서 DAO 객체를 생성한다. 
		BoardDAO bd = new BoardDAO();
		
		List<BoardBean> boardList = bd.getBoardList();
			
		//좌측의 board 키에 레코드 값을 저장한다.		
		request.setAttribute("boardList", boardList);

        //view 페이지로 포워딩하기 위해서 포워딩 객체를 생성한다.
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); //redirect 여부를 결정한다.
		
		//사용자에게 보여줄 view 페이지를 지정한다.
		forward.setPath("./board/board_list.jsp");
		
		//해당 페이지로 포워딩한다.
		return forward;
	}
}
