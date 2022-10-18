package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;
import com.itwillbs.member.db.MemberDTO;

public class MemberUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(" M : MemberUpdateProAction_execute() 호출");
		
		// 한글처리(필터했으니까 생략)
		
		// 전달된 데이터 저장(수정정보) 
		// 		=> 저장하려는 정보가 많으니까 dto에 먼저 담는다.
		// 		=> 아이디, 비밀번호, 이름, 이메일, 주소, 전화번호, 생년월일, 성별
		MemberDTO dto = new MemberDTO();
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.setEmail(request.getParameter("email"));
		dto.setAddr(request.getParameter("addr"));
		dto.setTel(request.getParameter("tel"));
		dto.setGender(request.getParameter("gender"));
		// 생년월일은 배열이기때문에 단순히 dto에 저장만 해서는 안되고 배열로 저장하여 표현해야한다.
		String birth = request.getParameterValues("birth")[0] + "-"
							+ request.getParameterValues("birth")[1] + "-"
								   + request.getParameterValues("birth")[2];		
		System.out.println(" M : " + birth);		
		dto.setBirth(birth); // 배열로 정리된 String birth 만 불러오면 된다. 
		// 근데 굳이 이렇게 안 해도 된다고 함..
		
		System.out.println(" M : " + dto);
		
		
		// DAO - 회원정보 수정
		MemberDAO dao = new MemberDAO();
		int result = dao.updateMember(dto);
		
		System.out.println(" M : result : " + result);
		
		// 페이지 이동 (JS)
		response.setContentType("text/html; charset=UTF-8"); 
		// => 응답페이지의 형태를 html 형태로 사용하겠다는 말
		
		PrintWriter out = response.getWriter(); 
		// getWriter()는 글을 쓸 수있게 출력(out)해주는 메서드
		// => 응답페이지로 출력하는 통로를 준비
		
		if(result== -1) { // 회원정보가 없음
			out.print("<script>");
			out.print("alert('회원정보가 없음!');");
			out.print("history.back();");
			out.print("</script>");
			out.close();
			
			return null;
			
		}else if (result == 0){ // 비번오류
			out.print("<script>");
			out.print(" alert('비밀번호 오류! 수정 불가');");
			out.print(" history.back(); "); 
			out.print("</script>");				
			out.close();
			
			return null;
				
		}else { // 수정이 되었을 때 result == 1
			out.print("<script>");
			out.print(" alert('회원정보 수정 완료!');");
			out.print(" location.href='./MemberInfo.me'; "); // pageNum 위에 변수에 저장해둔 걸 가져갈거다.
			out.print("</script>");				
			out.close();
			
			return null; 			
		}			
	}
}
