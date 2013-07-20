package com.naver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*���� ���������� �����ϴ� Ŭ����*/
public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	DataSource ds = null;
	String sql = null;

	/*��� ������ ������ ������ ���� Ŭ������ �������� ����*/
	public BoardDAO() {
		try{
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/OracleDB");
			con = ds.getConnection();		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*DB�۾��� �ʿ��� ������ �޼ҵ� ������ �ۼ�*/
	
	/*�Խù� ��Ϻ���*/
	public List<BoardBean> getBoardList(){
		//java.util ��Ű���� �ִ� List �÷����� ����Ʈ
		
		//List �÷��ǿ� ���׸�(BoardBean Ÿ��)�� �����Ͽ� ��ü ����
		List<BoardBean> boardList = new ArrayList<BoardBean>();
		
		try{
			sql = "select * from board02 order by board02_no desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); //select �� ����
			
			while(rs.next()){ //���ڵ尡 �����ϸ� �ݺ� ����
				BoardBean board = new BoardBean();
				
				//���ڵ��� �� �ʵ� ���� ��ü�� ��´�.
				//����db�� ������� �Խù� ��ȣ�� �����ͼ� 
				//�ڹ� ���� setter()�޼ҵ�� ���� �����Ѵ�.
				
				//7���� �ʵ带 db�� ������ �� java bean���� ���ڵ带 �����Ͽ���
				board.setBoard02_no(rs.getInt("board02_no"));
				board.setBoard02_name(rs.getString("board02_name"));
				board.setBoard02_title(rs.getString("board02_title"));
				board.setBoard02_cont(rs.getString("board02_cont"));
				board.setBoard02_pwd(rs.getString("board02_pwd"));
				board.setBoard02_hit(rs.getInt("board02_hit"));
				board.setBoard02_regdate(rs.getString("board02_regdate"));
				//DTO �ϼ���!!
				
				//���� ���� ��ü�� �÷���(����Ʈ)�� �����Ѵ�. 
				boardList.add(board); //ù��° ���ڵ� �߰�����
			}
			rs.close(); pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return boardList;
	}
	
	/*�Խù� �����ϱ�*/
	public int insertBoard(BoardBean bean){
		int re = 0;
		
		try{			
			sql = "insert into board02" + 
			  			" values(board_seq.nextval,?,?,?,?,default,sysdate)";
			
			pstmt = con.prepareStatement(sql); //sql�� ���� ó��
			
			pstmt.setString(1, bean.getBoard02_name());   //ù��° ����ǥ�� �۾��� ����
			pstmt.setString(2, bean.getBoard02_title());  //�ι�° ����ǥ�� ������ ����
			pstmt.setString(3, bean.getBoard02_cont());   //����° ����ǥ�� �۳��� ����
			pstmt.setString(4, bean.getBoard02_pwd());    //����° ����ǥ�� ��й�ȣ ����

			re = pstmt.executeUpdate(); //insert���� �����ϰ� �������� re�� ����
	
			//���� ��ü�� �ݴ´�.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return re;
	}

	/*��ȸ�� ����*/
	public void boardHit(int no) {
		try{
			//�Ű������� �Ѱܹ��� ��ȣ�� �ش��ϴ� ���ڵ��� ��ȸ���� 1���� ��Ų��.
			sql = "update board02 set board02_hit=board02_hit+1 "
					+ " where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql�� ���� ó��
			
			pstmt.setInt(1, no); //����ǥ�� ��ȣ�� �����Ѵ�.
			pstmt.executeUpdate(); //update �������� �����Ѵ�. 
			
			//���� ��ü�� �ݴ´�.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	/*�Խù� ���� ����*/
	public BoardBean getCont(int no) {
		BoardBean board = null;
		
		try{
			con = ds.getConnection();	
			
			sql = "select * from board02 where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql�� ���� ó��
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){ //�˻��� ���ڵ尡 ������ ���
				board = new BoardBean(); //�� ��ü ����
				
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
		//�ڹٺ� ����� ���ڵ带 ��ȯ�Ѵ�.
		return board; //no�� �ش��ϴ� ���ڵ带 ȣ���� ������ ����
	}

	/*�Խù� ���� ����*/
	public void boardEdit(BoardBean board) {
		//board �Ű������� ������ �ϳ��� ���ڵ带 �����Ѵ�. 
		try{
			sql = "update board02 " +
					" set board02_name=?, board02_title=?, board02_cont=? " +
					" where board02_no=?";
			
			pstmt = con.prepareStatement(sql);
			
			//�� ��ü�� �̿��Ͽ� �ش� �ʵ� ���� �� ����ǥ�� �����Ѵ�. 
			pstmt.setString(1, board.getBoard02_name());
			pstmt.setString(2, board.getBoard02_title());
			pstmt.setString(3, board.getBoard02_cont());
			
			//System.out.println(board.getBoard02_name());
			
			pstmt.setInt(4, board.getBoard02_no());
			//����ǥ�� ���� ������ ��� Ÿ�Կ� �°� �����ؾ� �Ѵ�.
			//���ڿ��� ���� setString()
			//�������� ���� setInt()
			
			pstmt.executeUpdate();
			 
			 //�������� ���࿡�� select�� exeCuteQuery()�� �̿��ϰ�
			 //��������(insert, update, delete)�� executeUpdate() ���
			 
			 pstmt.close(); con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*�Խù� �����ϱ�*/
	public void boardDel(int no){
		try{			
			sql = "delete from board02 where board02_no=?";
			
			pstmt = con.prepareStatement(sql); //sql�� ���� ó��
			
			pstmt.setInt(1, no);   //ù��° ����ǥ�� �۾��� ����

			pstmt.executeUpdate(); //insert���� �����ϰ� �������� re�� ����
	
			//���� ��ü�� �ݴ´�.
			con.close();
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}	
