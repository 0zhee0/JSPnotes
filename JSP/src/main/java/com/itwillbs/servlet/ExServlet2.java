package com.itwillbs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// web.xml 매핑과 @WebServlet 매핑이 동일한 경우 에러 발생
// => 매핑이 다른 경우 사용 가능(권장 X)

// 서블릿 2.3 이후
@WebServlet("/ex2")
public class ExServlet2 extends HttpServlet {
	//http://localhost:8088/JSP/ex2
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" doGET() 호출 2.3 이후 ");
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}

}
