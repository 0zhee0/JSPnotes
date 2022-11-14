package com.itwillbs.basket.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.admin.goods.db.GoodsDTO;

public class BasketDAO {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	// 디비 연결해주는 메서드(커넥션풀)
	private Connection getConnection() throws Exception {
		// 1. 드라이버 로드 // 2. 디비연결

		// Context 객체 생성 (JNDI API)
		Context initCTX = new InitialContext();
		// 디비연동정보 불러오기 (context.xml 파일정보)
		DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/funweb");
		// 디비정보(연결) 불러오기
		con = ds.getConnection();

		System.out.println(" DAO : 디비연결 성공(커넥션풀) ");
		System.out.println(" DAO : con : " + con);

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
	
	// 기존의 장바구니 체크 - checkBasket(DTO)
	public boolean checkBasket(BasketDTO dto) { // dto를 받아와서 처리하고 마지막에 boolean 데이터로 리턴한다.
		boolean result = false;
		
		try {
			con = getConnection();
			// 동일상품 정보 체크
			sql = "select * from itwill_basket "
					+ "where b_m_id=? and b_g_num=? and b_g_size && b_g_color=?"; // 회원 id에 옷번호,사이크,색상 이 모든 정보들의 값이 다 같을 때 값을 가져온다.
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getB_m_id());
			pstmt.setInt(2, dto.getB_g_num());
			pstmt.setString(3, dto.getB_g_size());
			pstmt.setString(4, dto.getB_g_color());
			
			rs = pstmt.executeQuery(); // select 문의 결과는 하나밖에 안나온다. 하나이상금지 / 0 또는 1
									   // 왜 ? id는 pk이고 pk는 여러개가 있을 수 없다.	
			
			if(rs.next()) { // 기존 동일상품 존재 -> 수량만 수정
				sql = "update itwill_basket set b_g_amount +?"  // // b_g_amount +? : ?를 통해 전달개수를 누적하겠다.
						+ "where b_m_id=? and b_g_num=? and b_g_size && b_g_color=?"; 
						// 특정 상품중에 특정 조건을 가진 상품의 수량만 변경해야해서 select문의 where 을 그대로 들고온다.
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dto.getB_g_amount());
				pstmt.setString(2, dto.getB_m_id());
				pstmt.setInt(3, dto.getB_g_num());
				pstmt.setString(4, dto.getB_g_size());
				pstmt.setString(5, dto.getB_g_color());
				
				int tmp = pstmt.executeUpdate(); // 업데이트에 해당하는 결과가 0 또는 1로 리턴이 될거다.
					// 이 아이디에 이 옵션들은 하나밖에 없으니까 1 로 리턴이된다. 1이상 불가능
				if(tmp == 1) {
					result = true;
				}
			}
			System.out.println(" DAO : "+(result? "기존의 정보 수정":"기존의 상품 없음"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}
	// 기존의 장바구니 체크 - checkBasket(DTO)
	
	// 장바구니 상품 추가 - basketAdd(DTO)
	public void basketAdd(BasketDTO dto) {
		
		int b_num = 0;
		
		try {
			con = getConnection();
			// 1) 장바구니 번호 b_num 계산하는 법 만들고
			sql = "select max(b_num) from itwill_basket";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b_num = rs.getInt(1)+1;
			}
			
			// 2) 장바구니 저장 (insert)
			sql="insert into itwill_basket(b_num, b_m_id, b_g_num, b_g_amount, b_g_size, b_g_color) " // ""줄바꿈할 때 공백있어야한다 확인필수
					+ "values(?, ?, ?, ?, ?, ?)";
			// 테이블에 컬럼명을 적지 않으면 순서대로 values 값을 전부 작성해야한다.
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, b_num); // 위에 1번에서 계산한 값(b_num = rs.getInt(1)+1)을 넣는다.
			pstmt.setString(2, dto.getB_m_id());
			pstmt.setInt(3, dto.getB_g_num());
			pstmt.setInt(4, dto.getB_g_amount());
			pstmt.setString(5, dto.getB_g_size());
			pstmt.setString(6, dto.getB_g_color());
			
			pstmt.executeUpdate();
			
			System.out.println(" DAO : 장바구니 등록완료! ");		
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	// 장바구니 상품 추가 - basketAdd(DTO)
	
	// 장바구니 목록 조회 - getBasketList(id)
	public Vector getBasketList(String id) { // ArrayList를 써도 된다. (ArrayList =비슷= Vector) 여기서 ArrayList 3개쓸거라서 하나는 Vector로 바꾼것임 둘다 아예똑같지는 않지만 여기서는 비슷한 기능을 함
		Vector totalList = new Vector();
		List basketList = new ArrayList();
		List goodsList = new ArrayList();
		
		try {
			con = getConnection();
			// sql - id 값에 해당하는 장바구니 정보 조회
			sql = "select * from itwill_basket where b_m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				// 장바구니 정보 저장
				// DB -> DTO -> List
				BasketDTO bkDTO = new BasketDTO();
				
				bkDTO.setB_date(rs.getTimestamp("b_date"));
				bkDTO.setB_g_amount(rs.getInt("b_g_amount"));
				bkDTO.setB_g_color(rs.getString("b_g_color"));
				bkDTO.setB_g_num(rs.getInt("b_g_num"));
				bkDTO.setB_g_size(rs.getString("b_g_size"));
				bkDTO.setB_m_id(rs.getString("b_m_id"));
				bkDTO.setB_num(rs.getInt("b_num"));
				 
				basketList.add(bkDTO);
//				System.out.println(" DAO : " + basketList);
					// 장바구니 상품에 해당하는 상품정보 조회
					// DB -> DTO -> List
					// sql - 상품정보 조회 동작
//					sql="select * from itwill_goods where b_g_num=?"; // 내가 샀던 상품조회
				sql="select * from itwill_goods where gno=?";		// b_g_num은 basket 테이블에 있는 것니까 우리는 Goods 테이블에 있는 값을 들고오기위해 gno 사용
				PreparedStatement pstmt2 = con.prepareStatement(sql);
				pstmt2.setInt(1, bkDTO.getB_g_num());
				
				ResultSet rs2 = pstmt2.executeQuery();
				
				if(rs2.next()) {
					// 장바구니 상품정보를 찾음 -> 저장
					GoodsDTO gDTO = new GoodsDTO();
					
						// GoodsDTO에서 우리가 쓸 것만 가져오자.
					gDTO.setName(rs2.getString("name"));
					gDTO.setPrice(rs2.getInt("price"));
					gDTO.setImage(rs2.getString("image"));
					gDTO.setGno(rs2.getInt("gno"));
						// .... 나머디 정보는 필요에 따라 추가
					
					// list 저장
					goodsList.add(gDTO); // 상품정보 저장 완료
					
				} // 상품정보 저장 완료
				
			} // while
			  // totalList 저장
			
			totalList.add(basketList);
			totalList.add(goodsList);
				
				System.out.println(" DAO : 장바구니 정보 + 상품정보 저장완료!");
			
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return totalList;
	}
	// 장바구니 목록 조회 - getBasketList(id)
	
	// 장바구니 삭제(b_num) - deleteBasket(b_num)
		public int deleteBasket(int b_num) {
			int result = -1;
			
			try {
				con = getConnection();
				sql = "delete from itwill_basket where b_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, b_num);
				result = pstmt.executeUpdate();
				
				System.out.println(" DAO : " +b_num+"번 장바구니 삭제 완료! ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} finally {
			closeDB();
		}
			
		return result;
	}
	// 장바구니 삭제(b_num) - deleteBasket(b_num)
	
	
	// 장바구니 삭제(id) - deleteBasket(id)
			public int deleteBasket(String id) {
				int result = -1;
				
				try {
					con = getConnection();
					sql = "delete from itwill_basket where b_m_id=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					result = pstmt.executeUpdate();
					
					System.out.println(" DAO : " +id+"님 구매 후 장바구니 삭제 완료! ");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			} finally {
				closeDB();
			}
				
			return result;
		}
		// 장바구니 삭제(id) - deleteBasket(id)
	
	
	
	
	
	
}
