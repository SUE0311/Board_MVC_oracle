package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*디비와 직접적으로 연동하는 클래스*/
public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource ds = null;
	String sql = null;

	/*디비 연동과 쿼리문 수행을 위한 클래스의 참조변수 선언*/
	public BoardDAO() {
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*DB작업에 필요한 내용을 메소드 단위로 작성*/
	
	/*게시물 목록보기*/
	public List<BoardBean> getBoardList(){
		//java.util 패키지에 있는 List 컬렉션을 임포트
		
		//List 컬렉션에 제네릭(BoardBean 타입)을 적용하여 객체 생성
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		
		try{
			sql = "select * from board02 order by board02_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); //select 문 실행
			
			while(rs.next()){ //레코드가 존재하면 반복 수행
				BoardBean board = new BoardBean();
				
				//레코드의 각 필드 값을 객체에 담는다.
				//실제db를 대상으로 게시물 번호를 가져와서 
				//자바 빈의 setter()메소드로 값을 지정한다.
				
				//7개의 필드를 db에 가져온 후 java bean으로 레코드를 구성하였음
				board.setBoard02_no(rs.getInt("board02_no"));
				board.setBoard02_name(rs.getString("board02_name"));
				board.setBoard02_title(rs.getString("board02_title"));
				board.setBoard02_cont(rs.getString("board02_cont"));
				board.setBoard02_pwd(rs.getString("board02_pwd"));
				board.setBoard02_hit(rs.getInt("board02_hit"));
				board.setBoard02_regdate(rs.getString("board02_regdate"));
				//DTO 완성됨!!
				
				//값을 담은 객체를 컬렉션(리스트)에 저장한다. 
				boardList.add(board); //첫번째 레코드 추가했음
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return boardList;
	}
	
	/*게시물 삽입하기*/
	public int insertBoard(BoardBean bean){
		int re = 0;
		
		try{			
			sql = "insert into board02" + 
			  			" values(board_seq.nextval,?,?,?,?,default,sysdate)";
			
			pstmt = con.prepareStatement(sql); //sql문 선행 처리
			
			pstmt.setString(1, bean.getBoard02_name());   //첫번째 물음표에 글쓴이 배정
			pstmt.setString(2, bean.getBoard02_title());  //두번째 물음표에 글제목 배정
			pstmt.setString(3, bean.getBoard02_cont());   //세번째 물음표에 글내용 배정
			pstmt.setString(4, bean.getBoard02_pwd());    //베번째 물음표에 비밀번호 배정

			re = pstmt.executeUpdate(); //insert문을 실행하고 실행결과를 re에 저장
	
			//열린 객체를 닫는다.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return re;
	}

	/*조회수 증가*/
	public void boardHit(int no) {
		try{
			//매개변수로 넘겨받은 번호에 해당하는 레코드의 조회수를 1증가 시킨다.
			sql = "update board02 set board02_hit=board02_hit+1 "
					+ " where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql문 선행 처리
			
			pstmt.setInt(1, no); //물음표에 번호를 배정한다.
			pstmt.executeUpdate(); //update 쿼리문을 실행한다. 
			
			//열린 객체를 닫는다.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	/*게시물 내용 보기*/
	public BoardBean getCont(int no) {
		BoardBean board = null;
		
		try{
			con = ds.getConnection();	
			
			sql = "select * from board02 where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql문 선행 처리
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){ //검색된 레코드가 존재한 경우
				board = new BoardBean(); //빈 객체 생성
				
				board.setBoard02_no(rs.getInt("board02_no"));
				board.setBoard02_name(rs.getString("board02_name"));
				board.setBoard02_title(rs.getString("board02_title"));
				board.setBoard02_cont(rs.getString("board02_cont"));
				board.setBoard02_pwd(rs.getString("board02_pwd"));
				board.setBoard02_hit(rs.getInt("board02_hit"));
				board.setBoard02_regdate(rs.getString("board02_regdate"));
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		//자바빈에 저장된 레코드를 반환한다.
		return board; //no에 해당하는 레코드를 호출한 곳으로 리턴
	}

	/*게시물 내용 수정*/
	public void boardEdit(BoardBean board) {
		//board 매개변수의 내용은 하나의 레코드를 관리한다. 
		try{
			sql = "update board02 " +
					" set board02_name=?, board02_title=?, board02_cont=? " +
					" where board02_no=?";
			
			pstmt = con.prepareStatement(sql);
			
			//빈 객체를 이용하여 해당 필드 값을 각 물음표에 배정한다. 
			pstmt.setString(1, board.getBoard02_name());
			pstmt.setString(2, board.getBoard02_title());
			pstmt.setString(3, board.getBoard02_cont());
			
			//System.out.println(board.getBoard02_name());
			
			pstmt.setInt(4, board.getBoard02_no());
			//물음표에 값을 배정할 경우 타입에 맞게 배정해야 한다.
			//문자열인 경우는 setString()
			//정수형인 경우는 setInt()
			
			pstmt.executeUpdate();
			 
			 //쿼리문은 실행에서 select는 exeCuteQuery()를 이용하고
			 //나머지는(insert, update, delete)는 executeUpdate() 사용
			 
			 pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*게시물 삭제하기*/
	public void boardDel(int no){
		try{			
			sql = "delete from board02 where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql문 선행 처리
			
			pstmt.setInt(1, no);   //첫번째 물음표에 글쓴이 배정

			pstmt.executeUpdate(); //insert문을 실행하고 실행결과를 re에 저장
	
			//열린 객체를 닫는다.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}	
