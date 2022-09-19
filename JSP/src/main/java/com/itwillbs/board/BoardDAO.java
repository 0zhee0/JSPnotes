package com.itwillbs.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDAO {
	// DAO (Data Access Object) : 데이터(DB) 처리 객체
	// => DB에 관한 모든 동작을 수행
	
	// 공통변수 선언
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql ="";
	
	// 생성자
	public BoardDAO() {
		System.out.println("DAO : BoardDAO() 객체 생성");
		System.out.println("DAO : itwill_board 테이블 접근 준비 완료");
	}
	// 디비 연결 메서드()
	private Connection getConnection() throws Exception {
		// 디비연결정보 (상수)
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DBURL = "jdbc:mysql://localhost:3306/jspdb";
		final String DBID = "root";
		final String DBPW = "1234";
		
		// 1. 드라이버 로드
		Class.forName(DRIVER);
		// 2. 디비 연결
		con = DriverManager.getConnection(DBURL, DBID, DBPW);
		System.out.println(" DAO : 디비연결 성공 ");
		System.out.println(" DAO : "+ con);
		
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
	
		// 글쓰기 메서드 - insertBoard()
		public void insertBoard(BoardDTO dto) {
			System.out.println("DAO : insertBoard() 호출 ");
			int bno = 0;	// 글번호 저장
			try {
				// 1,2 디비 연결
				con = getConnection();
				
				// 3. sql 작성(글번호 계산) & pstmt 객체
				sql = "select max(bno) from itwill_board";
				pstmt=con.prepareStatement(sql);
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터처리 (글번호 계산-번호최대값 + 1)
				// * rs.next() = true/false 구분
				//	=> 워크벤치에 실행(select)했을 때
				//	   결과 |> (삼각형 커서) : true (커서 이동이 가능, sql null 상관없음)
				//	   결과 * , 커서x : false (커서 이동 불가능)
				
				if(rs.next()) {
					// bno = rs.getInt("max(bno)")+1; // 컬럼명을 통해 접근
					bno = rs.getInt(1)+1; // 컬럼인덱스 위치를 통한 접근
					// => rs.getInt() : 리턴데이터의 값이 sql-null인 경우 0 리턴
				}
				
				System.out.println(" DAO : 글번호 = " + bno);
				
				// 3. sql 작성(insert) & pstmt 객체
				sql = "insert into itwill_board(bno,name,pass,subject,content,"
						+ "readcount,re_ref,re_lev,re_seq,date,ip,file) "
						+ "values(?,?,?,?,?,?,?,?,?,now(),?,?)";
				pstmt = con.prepareStatement(sql);
				
				// ???
				pstmt.setInt(1, bno);
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getPass());
				pstmt.setString(4, dto.getSubject());
				pstmt.setString(5, dto.getContent());
				
				pstmt.setInt(6, 0); // 조회수 0 초기화
				pstmt.setInt(7, bno); // ref 그룹번호 (bno 초기화)
				pstmt.setInt(8, 0); // lev 들여쓰기 (0 초기화)
				pstmt.setInt(9, 0); // seq 순서 (0 초기화)
				
				pstmt.setString(10, dto.getIp()); 
				pstmt.setString(11, dto.getFile());
								
				// 4. sql 실행
				pstmt.executeUpdate();
				
				System.out.println(" DAO : 게시판 글쓰기 완료! ");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
	
		}		
		// 글쓰기 메서드 - insertBoard()

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
		
		// 글정보 가져오기 - getBoardList(int startRow, int pageSize)
			public ArrayList getBoardList(int startRow, int pageSize) {
			System.out.println(" DAO : getBoardList() 호출 ");
			// 글정보 모두 저장하는 배열
			ArrayList boardList = new ArrayList();
			
			try {
				// 1,2 디비연결
				con = getConnection();
				
				// 3. sql 작성(select) & pstmt 객체
				sql = "select * from itwill_board "
					  + "order by re_ref desc, re_seq asc limit ?,?";
				pstmt=con.prepareStatement(sql);
				
				//????
				pstmt.setInt(1, startRow-1); // 시작행 - 1
				pstmt.setInt(2, pageSize); // 개수
				
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
		
		// 전체 글의 개수 - getBoardCount()
		public int getBoardCount() {
			int cnt = 0;
			
			try {
				// 1, 2. 디비연결
				con = getConnection();
				
				// 3. sql 작성 & pstmt 객체 생성
				sql = "select count(*) from itwill_board";
				pstmt = con.prepareStatement(sql);
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터 처리
				if(rs.next()) {
					//cnt = rs.getInt("count(*)");
					cnt = rs.getInt(1); // 1 : 첫번째 컬럼 인덱스
				}
				
				System.out.println(" DAO : 전체 글의 개수 " + cnt + "개 ");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
			return cnt;			
		}
		// 전체 글의 개수 - getBoardCount()
		
		// 조회수 1증가 - updateReadcount(bno)
		public void updateReadcount(int bno) {
					
			try {
				// 1.2. 디비연결
				con = getConnection();
				
				// 3. sql 작성(update) & pstmt 객체
				sql = "update itwill_board set readcount=readcount+1 "
						+ " where bno=?";
				pstmt = con.prepareStatement(sql);
				
				// ???
				pstmt.setInt(1, bno);
				
				// 4. sql 실행
				pstmt.executeUpdate();
				
				System.out.println(" DAO : 조회수 1증가 완료! ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
		
		}
		// 조회수 1증가 - updateReadcount(bno)
		
		// 게시판 글 1 개의 정보 조회 - getBorad(bno)
		public BoardDTO getBoard(int bno) {
			BoardDTO dto = null;		
			try {
				// 1.2. 디비연결
				con = getConnection();
				
				// 3. sql 작성 & pstmt 객체
				sql = "select * from itwill_board where bno = ?";
				pstmt=con.prepareStatement(sql);
				
				// ???
				pstmt.setInt(1, bno);
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터처리
				if(rs.next()) {
					// 데이터가 있을 때만 dto 객체 생성
					dto = new BoardDTO();
					
					// DB정보(rs) -> dto 저장
					dto.setBno(rs.getInt("bno"));
					dto.setContent(rs.getString("content"));
					dto.setDate(rs.getDate("date"));
					dto.setFile(rs.getString("file"));
					dto.setIp(rs.getString("ip"));
					dto.setName(rs.getString("name"));
					dto.setPass(rs.getString("pass"));
					dto.setRe_lev(rs.getInt("re_lev"));
					dto.setRe_ref(rs.getInt("re_ref"));
					dto.setRe_seq(rs.getInt("re_seq"));
					dto.setReadcount(rs.getInt("readcount"));
					dto.setSubject(rs.getString("subject"));		
				}
				
				System.out.println(" dao : 글 정보 1개 저장 완료! ");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return dto;
		}
		// 게시판 글 1 개의 정보 조회 - getBorad(bno)
		
		// 게시글 수정 - updateBoard(DTO)
		public int updateBoard(BoardDTO dto) {
			int result = -1;
				
			try {
				// 1.2. 디비 연결
				con = getConnection();
				
				// 3. sql 작성(select) & pstmt 객체
				sql = "select pass from itwill_board where bno=?";
				pstmt = con.prepareStatement(sql);
				
				//????
//				pstmt.setInt(1, bno);
				pstmt.setInt(1, dto.getBno());
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터처리
				if(rs.next()) {	
					if(dto.getPass().equals(rs.getString("pass"))) {
					 // 3. sql 작성(update) & pstmt 객체
					 sql = "update itwill_board set subject=?, name=?, content=? where bno=?";
					 pstmt = con.prepareStatement(sql);
					 
					 //???
					 pstmt.setString(1, dto.getSubject());
					 pstmt.setString(2, dto.getName());
					 pstmt.setString(3, dto.getContent());
					 pstmt.setInt(4, dto.getBno());
					 
					 // 4. sql 실행
					 result = pstmt.executeUpdate();
					 
					}else {
						// 비밀번호 오류
						result = 0;
					}
				}else {
						// 게시판글 없음
						result = -1;
					}
				
				System.out.println(" DAO : 게시판 정보 수정완료(" +result+")");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return result;
		}
		// 게시글 수정 - updateBoard(DTO)
		
		// 게시글 삭제 = deleteBoard(bno, pass)
		public int deleteBoard(int bno, String pass) {
			int result = -1;
			
			try {
				// 1.2. 디비 연결
				con = getConnection();
				
				// 3. sql 작성(select) & pstmt 객체
				sql = "select pass from itwill_board where bno=?";
				pstmt = con.prepareStatement(sql);
				
				// ????
				pstmt.setInt(1, bno);
				
				// 4. sql 실행
				rs = pstmt.executeQuery();
				
				// 5. 데이터처리
				if(rs.next()) {	
					if(pass.equals(rs.getString("pass"))) {
					 // 3. sql 작성(update) & pstmt 객체
					 sql = "delete from itwill_board where bno=?";
					 pstmt = con.prepareStatement(sql);
					 
					 pstmt.setInt(1, bno);
					 
					 // 4. sql 실행
					 result = pstmt.executeUpdate();
					 
					}else {
						// 비밀번호 오류
						result = 0;
					}
				}else {
						// 게시판글 없음
						result = -1;
					}
				
				System.out.println(" DAO : 게시판 정보 삭제완료(" +result+")");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return result;
		}
		// 게시글 삭제 = deleteBoard(bno, pass)
		
		/**
		 * 	메서드 설명 작성하기
		 * 
		 */
		// 답글쓰기 - reInsertBoard(DTO)
		public void reInsertBoard(BoardDTO dto) {
			int bno = 0;

				try {
					//////////////////////////////////////
					//1. 글번호 계산하기(bno)
					
						// 1.2. 디비연결
						con = getConnection();
						
						// 3. sql 작성 & pstmt 객체
						sql = "select max(bno) from itwill_board";
						pstmt = con.prepareStatement(sql);
						
						// 4. sql 실행
						rs = pstmt.executeQuery();
						
						// 5. 데이터처리
						if(rs.next()) {
							bno = rs.getInt(1)+1;
							// bno = rs.getInt("max(bno)")+1;
						}
						
						System.out.println(" DAO : 답글 번호(bno) "+ bno + "여기다~~~~");
						
					//////////////////////////////////////
					//2. 답글 순서 재배치
						
						// 3. sql 작성(update) & pstmt 객체
						//	  => 같은 그룹에 있으면서, 기존의 seq 값보다 큰 값이 있을 때
						sql = "update itwill_board set re_seq = re_seq+1 "
								+ " where re_ref=? and re_seq>?";
						pstmt = con.prepareStatement(sql);
						
						// ???
						pstmt.setInt(1, dto.getRe_ref());
						pstmt.setInt(2, dto.getRe_seq());
						
						// 4. sql 실행
						int cnt = pstmt.executeUpdate();
						// => cnt(update 구문이 적용된 수)
						if(cnt>0) {						
							System.out.println(" DAO : 답글 재정렬 완료!");
						}

					//////////////////////////////////////
					//3. 답글 쓰기(insert)
						sql = "insert into itwill_board(bno, name, pass, subject, content, "
								+ "readcount, re_ref, re_lev, re_seq, date, ip, file) "
								+ "values(?,?,?,?,?,?,?,?,?,now(),?,?) ";
						pstmt= con.prepareStatement(sql);
						
						// ???
						pstmt.setInt(1, bno);
						pstmt.setString(2, dto.getName());
						pstmt.setString(3, dto.getPass());
						pstmt.setString(4, dto.getSubject());
						pstmt.setString(5, dto.getContent());
						
						pstmt.setInt(6, 0); // 조회수 0
						pstmt.setInt(7, dto.getRe_ref()); // re_ref : 원글의 번호와 동일
						pstmt.setInt(8, dto.getRe_lev()+1); // re_lev : 원글의 lev + 1
						pstmt.setInt(9,dto.getRe_seq()+1); // re_seq : 원글의 seq + 1
						
						pstmt.setString(10, dto.getIp());
						pstmt.setString(11, dto.getFile());
						
						// 4. sql 실행
						pstmt.executeUpdate();
						
						System.out.println(" DAO : 답글 재정렬 완료!");
															
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					closeDB();
				}	
		}
		// 답글쓰기 - reInsertBoard(DTO)
						
} // class







