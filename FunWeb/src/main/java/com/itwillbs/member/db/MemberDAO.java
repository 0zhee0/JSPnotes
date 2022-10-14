package com.itwillbs.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.member.action.MemberIdCheckAction;

public class MemberDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	// 디비 연결해주는 메서드(커넥션풀)
	private Connection getConnection() throws Exception {
		// 1. 드라이버 로드	// 2. 디비연결
		
		// Context 객체 생성 (JNDI API)
		Context initCTX = new InitialContext();
		// 디비연동정보 불러오기 (context.xml 파일정보)
		DataSource ds 
		      = (DataSource)initCTX.lookup("java:comp/env/jdbc/funweb");
		// 디비정보(연결)  불러오기
		con = ds.getConnection();
		
		System.out.println(" DAO : 디비연결 성공(커넥션풀) ");
		System.out.println(" DAO : con : "+con);
		
		return con;
	}
	

	// 자원해제 메서드-closeDB()
	public void closeDB() {
		System.out.println("DAO : 디비연결자원 해제");

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 자원해제 메서드-closeDB()
	
	// 회원가입 - memberJoin(DTO)
	/**	(document 주석)
	 * 회원가입 해주는 메서드, 실행할 때 회원정보(DTO)받아서 사용
	 * 리턴X, 실행결과가 0보다 클 때 메시지 출력
	 */
	public void memberJoin(MemberDTO dto) {
		
		try {
			// 1.2. 디비연결
			con = getConnection();
			
			// 3. SQL 작성 & pstmt 객체				// (날짜정보) 회원가입일은 안 적을 거다.
			sql = "insert into itwill_member(id, pw, name, birth, gender, email, addr, tel) "
					+ "values(?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getEmail());
			pstmt.setString(7, dto.getAddr());
			pstmt.setString(8, dto.getTel());
			
			// 4. SQL 실행						// 실행한 결과를 리턴(반환한다.)
			int result = pstmt.executeUpdate(); // pstmt.executeUpdate(); = 1
			
			if(result > 0) { // 회원가입을 성공했다.
				System.out.println(" DAO : 회원가입 성공!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	// 회원가입 - memberJoin(DTO)
	
	// 아이디 중복체크 - memberIdCheck(ID)
		public int memberIdCheck(String id) {
			int result = 0; // 0 - 중복X(아이디사용O) , 1 - 중복O(아이디사용X)
			
			try {
			// 1.2. 디비연결
				con = getConnection();
			// 3. SQL & pstmt
				sql = "select pw from itwill_member where id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
			// 4. sql 실행				
				rs = pstmt.executeQuery(); // select는 항상 리코드셋의 형태로 들고다니기때문에 rs에 저장해줘야한다.
			// 5. 데이터처리
				if(rs.next()) { // 값이 존재할 때
					// 회원이 있다(중복) 
					result = 1;
					System.out.println(" DAO : 아이디 중복결과 ("+result+")"); // 1
					
				}
				// 값이 존재하지 않을 때 (워크벤치에 ▶ 커서가 없을 때)
				// result = 0
				System.out.println(" DAO : 아이디 중복결과 ("+result+")");
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
			return result;
		}
	// 아이디 중복체크 - memberIdCheck(ID)
	
	// 로그인 여부체크 - memberLoginCheck(id,pw)
		public void memberLoginCheck(String id, String pw) {	
			
			try {
				// 1.2. 디비연결
				con = getConnection();
				
				// 3. SQL & pstmt
				sql = "select pw from itwill_member where id=?"; 
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				// 4. sql 실행	
				ResultSet rs = pstmt.executeQuery();
				
				// 5. 데이터처리
				if(rs.next()) {
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			
		}
	// 로그인 여부체크 - memberLoginCheck(id,pw)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
