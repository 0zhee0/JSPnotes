package com.itwillbs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.test.Person;
import com.itwill.test.Phone;

@WebServlet("/test3")
public class TestServlet3 extends HttpServlet {
	// http://localhost:8088/JSP/test3
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// [/test3] 가상주소 사용하여 실행
		System.out.println(" TestServlet3 - doGet() 호출 ");
		
		// Person 객체 정보 생성후 저장해서 전달
		
		// Person - com.itwill.test 패키지에 생성됨
		//  이름,나이,휴대폰
		//  휴대폰 - 모델명,전화번호
		
		// ["김학생" 20  아이폰14 010-1234-1234]
		Phone iPhone = new Phone();
		iPhone.setModel("아이폰14");
		iPhone.setTel("010-1234-1234");
		
		
		Person kim = new Person();
		kim.setName("김학생");
		kim.setAge(20);
		kim.setP(iPhone);
		
		// request 영역 저장
		request.setAttribute("person", kim);
		
		// ./el/Beans.jsp 이동후 출력(jsp/el)
		RequestDispatcher dis =
				request.getRequestDispatcher("./el/Beans.jsp");
		
		dis.forward(request, response);
	
	}
	
}

