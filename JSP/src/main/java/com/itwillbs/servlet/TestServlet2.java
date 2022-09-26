package com.itwillbs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	
	// alt shift s + v
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// 배열
		// String[] foods
		String[] foods = {"햄버거", "피자", "서브웨이", "삼겹살", "아이스크림"};
		
		// 배열정보를 request 영역에 저장
		request.setAttribute("foods", foods);
		
		System.out.println("-----------------------------------");
		
		// 스포츠 종류를 ArrayList 저장 - 출력
		// ArrayList sports = new ArrayList();
		List sports = new ArrayList(); 
		// 자동으로 바꼈으면 업캐스팅된것임(=상속관계로 묶여있다.)
		 
		sports.add("축구");
		sports.add("야구");
		sports.add("농구");
		sports.add("배구");
		sports.add("족구");
		
		// request 영역 저장
		request.setAttribute("sports", sports);
		
		// forward 방식 이동 - ./el/Arrays.jsp
		RequestDispatcher dis
			= request.getRequestDispatcher("./el/Arrays.jsp");
		
		dis.forward(request, response);
		
	}
	
}
