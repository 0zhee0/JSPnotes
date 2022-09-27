package com.itwillbs.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.MemberBean;

@WebServlet("/jstl1")
public class JSTLServlet1 extends HttpServlet{

	// http://localhost:8088/JSP/jstl1
	
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		// MemberBean 객체를 사용해서 사용자 한 명의 정보를 생성
		// 사용자의 정보를 core_set2.jsp 페이지에서 출력
		// (id, pw, name, age, gender, email, regdate)
		
		MemberBean mb = new MemberBean();
		mb.setId("itwill");
		mb.setPw("1234");
		mb.setName("아이티윌");
		mb.setAge(20);
		mb.setGender("남");
		mb.setEmail("itwill@itwill.com");
		mb.setRegdate(new Timestamp(System.currentTimeMillis()));
		
		// request 영역에 저장
		request.setAttribute("memberBean", mb);
		
		// 회원정보 2개 더 생성(총3개) => ArrayList 에 저장 => set2.jsp 출력		
		ArrayList memberList = new ArrayList();
		
		for(int i=0;i<3;i++) {
			MemberBean mb2 = new MemberBean();
			mb2.setId("itwill"+i);
			mb2.setPw("1234"+i);
			mb2.setName("아이티윌"+i);
			mb2.setAge(20+i);
			mb2.setGender("남");
			mb2.setEmail("itwill"+i+"@itwill.com");
			mb2.setRegdate(new Timestamp(System.currentTimeMillis()));
			
			memberList.add(mb2);
		}
		
		System.out.println(memberList);
		
		request.setAttribute("memberList", memberList);
				
		// forward 이동
		RequestDispatcher dis = 
				request.getRequestDispatcher("./jstl/core_set2.jsp");
		dis.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}
	
}
