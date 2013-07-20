package com.naver.dao;

/*자바빈 DTO*/
public class BoardBean {
	private int board02_no; 			//글번호
	private String board02_name;		//게시자
	private String board02_title;		//글제목
	private String board02_cont;		//글내용
	private String board02_pwd;			//비밀번호
	private int board02_hit;			//조회수
	private String board02_regdate; 	//등록날짜
	
	public int getBoard02_no() {
		return board02_no;
	}
	public void setBoard02_no(int board02_no) {
		this.board02_no = board02_no;
	}
	public String getBoard02_name() {
		return board02_name;
	}
	public void setBoard02_name(String board02_name) {
		this.board02_name = board02_name;
	}
	public String getBoard02_title() {
		return board02_title;
	}
	public void setBoard02_title(String board02_title) {
		this.board02_title = board02_title;
	}
	public String getBoard02_cont() {
		return board02_cont;
	}
	public void setBoard02_cont(String board02_cont) {
		this.board02_cont = board02_cont;
	}
	public String getBoard02_pwd() {
		return board02_pwd;
	}
	public void setBoard02_pwd(String board02_pwd) {
		this.board02_pwd = board02_pwd;
	}
	public int getBoard02_hit() {
		return board02_hit;
	}
	public void setBoard02_hit(int board02_hit) {
		this.board02_hit = board02_hit;
	}
	public String getBoard02_regdate() {
		return board02_regdate;
	}
	public void setBoard02_regdate(String board02_regdate) {
		this.board02_regdate = board02_regdate;
	}
}
