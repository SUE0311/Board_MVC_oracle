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

		//Properties ��ü : ��ü�� ��Ʈ���� �����ϰų� ��Ʈ���κ��� �ε��ϰų� �� ������	
		Properties prop = new Properties();

		FileInputStream fis = 
			new FileInputStream("C:/jisu/java_project/MVC_test/build/classes/mtory.properties");
		//������Ƽȭ�Ϸε�, �ڹ� ��� ������ \\ or /
		
		prop.load(fis);
		//load() �޼ҵ� : �Է� ����Ʈ ��Ʈ���κ��� Ű�� ��Ұ� ��� �� ������Ƽ ����Ʈ�� �о����
		
		fis.close();
		
		String value = prop.getProperty(command);
		
		System.out.println("==========================================================�׽�Ʈ");
		System.out.println("������Ƽ�� ������ ���� url ��Ÿ��!! /board_XXX.do ===== command : " + command);
		System.out.println("========== value : " + value);
		
		if(value.substring(0,7).equals("execute")){	
			try{
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken();
				String url_2 = st.nextToken();
				Class url = Class.forName(url_2);//���ڿ��� �о�� Ŭ���� ���ϸ��� ��üȭ �Ѵ�.
				//��üȭ�� Ŭ������ Object���̴�.�׷��Ƿ� ���� �ٿ�ĳ�����ؾ� �Ѵ�. 
				
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
