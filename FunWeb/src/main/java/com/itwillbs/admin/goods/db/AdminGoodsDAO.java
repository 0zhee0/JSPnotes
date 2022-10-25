package com.itwillbs.admin.goods.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AdminGoodsDAO {

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

	
	// 상품등록메서드 - insertGoods(DTO)
	
	public void insertGoods(GoodsDTO dto) {
		int gno = 0;
		try {
			// 1. 상품번호 계산
			con = getConnection();
			sql = "select max(gno) from itwill_goods";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				gno = rs.getInt(1)+1;
			}
			System.out.println(" DAO : gno : "+gno);
			
			// 2. 상품 등록	
			sql ="insert into itwill_goods(gno,category,name,content,size,color,"
					+ "amount,price,image,best) values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, gno);
			pstmt.setString(2, dto.getCategory());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getSize());
			pstmt.setString(6, dto.getColor());
			pstmt.setInt(7, dto.getAmount());
			pstmt.setInt(8, dto.getPrice());
			pstmt.setString(9, dto.getImage());
			pstmt.setInt(10, dto.getBest());
			
			pstmt.executeUpdate();
			
			System.out.println(" DAO : 상품 등록 완료! ");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}	
	// 상품등록메서드 - insertGoods(DTO)
	
	// 상품 리스트 - getAdminGoodsList()
	public List getAdminGoodsList() {
		List adminGoodsList = new ArrayList();
		
		try {
			// 1.2. 디비연결
			con = getConnection();
			// 3. sql 작성 &  pstmt객체
			sql = "select * from itwill_goods";
			pstmt = con.prepareStatement(sql);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			while(rs.next()) {
				// DB(테이블) -> DTO -> List 
				GoodsDTO dto = new GoodsDTO();
				
				dto.setAmount(rs.getInt("amount"));
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getTimestamp("date"));
				dto.setGno(rs.getInt("gno"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
				
				adminGoodsList.add(dto); // 배열에 저장
			} // while() 끝
			System.out.println(" DAO : 관리자 상품리스트 저장완료!");
			System.out.println(" DAO : " + adminGoodsList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return adminGoodsList; //adminGoodsList 를 리턴해야 가져다 쓸 수 있다.
	}
	// 상품 리스트 - getAdminGoodsList()
	
	// 상품 1개의 정보를 가져오기 - getAdminGoods(gno)
	public GoodsDTO getAdminGoods(int gno) {
		
		GoodsDTO dto = null;
//		GoodsDTO dto2;
//		System.out.println(dto.getAmount());
//		System.out.println(dto2.getAmount());
//		GoodsDTO dto = new GoodsDTO(); 
		// 객체를 만들지않고 null을 만드는 이유? rs가 false가 되면 dto가 필요할까? 필요없음
		// => 그러면 new GoodsDTO();로 만들어 놓은 게 불피리요한 메모리가 된다.
		// 그래서 전역으로는 레퍼런스로 만들어 null값을 지정하고 if문 안에서 객체를 생성한다. (rs가 존재할 때만 객체를 불러)
		
		try {
			con = getConnection();
			sql = "select * from itwill_goods where gno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // db에 있는 내용을 출력하려면 dto가 필요하겠죠 그럼 전역변수로 dto 레퍼런스를 하나 생성하겠습니다. 
				dto = new GoodsDTO();
				
				dto.setAmount(rs.getInt("amount"));  // getAdminGoodsList()에서 작성한 걸 붙인다. 굳이 일일이 작성할 필요 없다. 어차피 같은 로직이라서
				dto.setBest(rs.getInt("best"));
				dto.setCategory(rs.getString("category"));
				dto.setColor(rs.getString("color"));
				dto.setContent(rs.getString("content"));
				dto.setDate(rs.getTimestamp("date"));
				dto.setGno(rs.getInt("gno"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setSize(rs.getString("size"));
			} // if
			
			System.out.println(" DAO : 상품정보 가져오기 완료! ");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return dto; // 리턴하기 위해 try 구문 밖에 쓴다.
	}
	// 상품 1개의 정보를 가져오기 - getAdminGoods(gno)
	
	// 상품정보 수정메서드 - adminModifyGoods(DTO)
	public void adminModifyGoods(GoodsDTO dto) {
		
		try {
			con = getConnection();
			sql = "update itwill_goods set "
					+ "category=?, name=?, price=?, amount=?, size=?, content=?, best=? "
					+ "where gno=?"; // 특정상품의 정보만 수정할 수 있도록 gno 걸어주기 , 안 걸어주면 모든 정보가 수정됨
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getPrice());
			pstmt.setString(4, dto.getColor());
			pstmt.setInt(5, dto.getAmount());
			pstmt.setString(6, dto.getSize());
			pstmt.setString(7, dto.getContent());
			pstmt.setInt(8,dto.getBest());
			pstmt.setInt(9, dto.getGno());
			
			pstmt.executeUpdate(); // 값 1
			
			System.out.println(" DAO : 관리자 상품정보 수정 ");	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	// 상품정보 수정메서드 - adminModifyGoods(DTO)
	
	// 상품정보 삭제메서드 - adminRemoveGoods(gno)
	public void adminRemoveGoods(int gno) {
		
		try {
			con = getConnection();
			sql ="delete from itwill_goods where gno=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gno);
			pstmt.executeUpdate();
			System.out.println(" DAO : 상품 관리 삭제!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	// 상품정보 삭제메서드 - adminRemoveGoods(gno)
	
	
	
	
}
