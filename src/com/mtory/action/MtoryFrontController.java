package com.mtory.action;

import java.io.*;
//import com.bbs.action.*;
//import com.member.action.*;
//import com.board.action.*;
import com.mtory.action.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.util.*;
public class MtoryFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

		//Properties 객체 : 객체를 스트림에 보관하거나 스트림로부터 로드하거나 할 수있음	
		Properties prop = new Properties();

		FileInputStream fis = 
			new FileInputStream("C:/jisu/java_project/MVC_test/build/classes/mtory.properties");
		//프로퍼티화일로드, 자바 경로 구분은 \\ or /
		
		prop.load(fis);
		//load() 메소드 : 입력 바이트 스트림로부터 키와 요소가 대기 된 프로퍼티 리스트를 읽어들임
		
		fis.close();
		
		String value = prop.getProperty(command);
		
		System.out.println("==========================================================테스트");
		System.out.println("프로퍼티로 지정해 놓은 url 스타일!! /board_XXX.do ===== command : " + command);
		System.out.println("========== value : " + value);
		
		if(value.substring(0,7).equals("execute")){	
			try{
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken();
				String url_2 = st.nextToken();
				Class url = Class.forName(url_2);//문자열로 읽어온 클래스 파일명을 객체화 한다.
				//객체화한 클래스는 Object형이다.그러므로 강제 다운캐스팅해야 한다. 
				
				System.out.println("=============== url : " + url);
				
				action  = (Action)url.newInstance();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}catch(ClassNotFoundException ex){
				ex.printStackTrace();
			}catch(InstantiationException ex){
				ex.printStackTrace();
			}catch(IllegalAccessException ex){
				ex.printStackTrace();
			}
		}else{
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath(value);
		}

		if(forward != null){
			if(forward.isRedirect()){
				response.sendRedirect(forward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	} 	    
}
