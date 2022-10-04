package com.itwillbs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// ctrl shift o => 해당파일에 필요없는 패키지 삭제
// import com.itwillbs.board.BoardDTO;

public class BoardDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
//	// 디비 연결 메서드()
//	private Connection getConnection() throws Exception {
//		// 디비연결정보 (상수)
//		final String DRIVER = "com.mysql.cj.jdbc.Driver";
//		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
//		final String DBID = "root";
//		final String DBPW = "1234";
//		
//		// 1. 드라이버 로드
//		Class.forName(DRIVER);
//		// 2. 디비 연결
//		con = DriverManager.getConnection(DBURL, DBID, DBPW);
//		System.out.println(" DAO : 디비연결 성공 ");
//		System.out.println(" DAO : "+ con);
//		
//		return con;
//		}
	
	// 디비 연결 메서드()
	private Connection getConnection() throws Exception {
		// 1. 드라이버 로드 // 2. 디비 연결
		
		// Context 객체 생성 (JNDI API) 자바네이밍디렉러티아이디 
		Context initCTX = new InitialContext(); // 인터페이스를 구현하는 업캐스팅 ( 두 개 타입이 다른데 오류가 안나서)
						// = 프로젝트정보초기화	// Context을 상속하고있는 InitialContext 클래스 객체 
		
		// 디비연동정보 불러오기 (context.xml 파일정보)
		DataSource ds // type="javax.sql.DataSource"에서 DataSource 객체를 생성
			= (DataSource)initCTX.lookup("java:comp/env/jdbc/mvc"); // java:comp/env/ 까지는 고정, jdbc/mvc는 유동
						// 다운캐스팅해주기
		
		// DataSource가지고 디비정보(연결) 불러오기
		con = ds.getConnection();
		
		System.out.println(" DAO : 디비연결 성공(커넥션풀)");
		System.out.println(" con : "+ con);
		
		return con;
	}
	
		// 자원해제 메서드 - closeDB()
		public void closeDB() {
			System.out.println("DAO : 디비연결자원 해제");
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 자원해제 메서드 - closeDB()
		
		// 글쓰기 메서드 - insertBoard(DTO)
		public void insertBoard(BoardDTO dto) {
			int bno = 0;
			
			try {
				// 1.2. 디비연결
				con = getConnection();
				// 3. sql 작성 & pstmt 객체
				sql = "select max(bno) from itwill_board";
				pstmt = con.prepareStatement(sql);
				// 4. sql 실행
				rs = pstmt.executeQuery();
				// 5. 데이터 처리
				if(rs.next()) {
					bno = rs.getInt(1) + 1;
				}
				System.out.println(" DAO : bno : " + bno);
				
				// 3. 
				sql = "insert into itwill_board(bno,name,pass,subject,content,"
						+ "readcount,re_ref,re_lev,re_seq,date,ip,file) "
						+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
				
				pstmt = con.prepareStatement(sql);
				
				//  ???
				pstmt.setInt(1, bno);
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getPass());
				pstmt.setString(4, dto.getSubject());
				pstmt.setString(5, dto.getContent());
				pstmt.setInt(6, 0); // 조회수 0
				pstmt.setInt(7, bno); // ref == bno
				pstmt.setInt(8, 0); // lev 0
				pstmt.setInt(9, 0); // seq 0 
				pstmt.setString(10, dto.getIp());
				pstmt.setString(11, dto.getFile());
				
				// 4. 
				pstmt.executeUpdate();
				
				System.out.println(" DAO : 글쓰기 완료! ");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeDB();
			}			
		}	
		// 글쓰기 메서드 - insertBoard(DTO)
		
		// 글 전체 개수 확인 = getBoardCount()
		public int getBoardCount() {
			int cnt = 0;
			
			try {
				// 1.2. 디비 열결
				con = getConnection();
				// 3. sql
				sql = "select count(*) from itwill_board";
				pstmt = con.prepareStatement(sql);
				// 4. sql 실행
				rs = pstmt.executeQuery();
				// 5. 데이터 처리
				if(rs.next()) {
//					cnt = rs.getInt(1);
					cnt = rs.getInt("count(*)");
				}
				System.out.println(" DAO : 전체 글 개수 : " + cnt+ "개");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeDB();
			}
			return cnt;
		}
		// 글 전체 개수 확인 = getBoardCount()
		
		// 글정보 가져오기 - getBoardList()
		public ArrayList getBoardList() {
			System.out.println(" DAO : getBoardList() 호출 ");
			// 글정보 모두 저장하는 배열
			ArrayList boardList = new ArrayList();
			
			try {
				// 1,2 디비연결
				con = getConnection();
				
				// 3. sql 작성(select) & pstmt 객체
				sql = "select * from itwill_board";
				pstmt=con.prepareStatement(sql);
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터처리(DB->DTO->List)
				while(rs.next()) {
					
					// DB -> DTO
					BoardDTO dto = new BoardDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setContent(rs.getString("content"));
					dto.setDate(rs.getDate("date"));
					dto.setFile(rs.getString("file"));
					dto.setName(rs.getString("name"));
					dto.setPass(rs.getString("pass"));
					dto.setRe_lev(rs.getInt("re_lev"));
					dto.setRe_ref(rs.getInt("re_ref"));
					dto.setRe_seq(rs.getInt("re_seq"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setSubject(rs.getString("subject"));
					dto.setIp(rs.getString("ip"));
				   
					// DTO -> List
					boardList.add(dto);
					
				}// while
				
				System.out.println(" DAO : 게시판 목록 저장완료! ");
								
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	finally {
				closeDB();
			}	
			return boardList;
		}		
		// 글정보 가져오기 - getBoardList()
		
		
		
		
		
}
