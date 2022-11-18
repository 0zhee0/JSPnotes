package com.itwillbs.admin.order.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itwillbs.order.db.OrderDTO;

public class AdminOrderDAO {
	
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
	
	
	
	// 주문목록 조회(관리자)-adminOrderList()
		public List<OrderDTO> adminOrderList() {
			List<OrderDTO> adminOrderList = new ArrayList<OrderDTO>();

			try {
				con = getConnection();
				sql = "select "
						+ "o_trade_num,o_g_name,o_g_amount,o_g_color,o_g_size,"
						+ "sum(o_sum_money) as o_sum_money, o_trans_num,o_date,o_status,o_trade_type,o_m_id "
						+ "from itwill_order "
						+ "group by o_trade_num "
						+ "order by o_trade_num desc";

				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// DB(rs) -> OrderDTO 저장 -> OrderList저장
					OrderDTO dto = new OrderDTO();

					dto.setO_trade_num(rs.getString(1));
					dto.setO_g_name(rs.getString(2));
					dto.setO_g_amount(rs.getInt(3));
					dto.setO_g_color(rs.getString(4));
					dto.setO_g_size(rs.getString(5));
					dto.setO_sum_money(rs.getInt(6));
					dto.setO_trans_num(rs.getString(7));
					dto.setO_date(rs.getTimestamp(8));
					dto.setO_status(rs.getInt(9));
					dto.setO_trade_type(rs.getString(10));
					dto.setO_m_id(rs.getString(11));

					adminOrderList.add(dto);
				} // while

				System.out.println(" DAO : 주문정보 저장완료");
				System.out.println(" DAO : " + adminOrderList.size());

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}

			return adminOrderList;
		}
		// 주문목록 조회(관리자)-adminOrderList()
	
		
		
	//  주문정보 상세페이지(관리자 수정정보) - getAdminOrderDetail(trade_num)
		public List<OrderDTO> getAdminOrderDetail(String trade_num){
			List<OrderDTO> adminOrderList = new ArrayList<OrderDTO>();
			
			try {
				con = getConnection();
				sql = "select * from itwill_order where o_trade_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, trade_num);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					OrderDTO dto = new OrderDTO();
					
					dto.setO_r_name(rs.getString("o_r_name"));
					dto.setO_r_phone(rs.getString("o_r_phone"));
					dto.setO_r_addr1(rs.getString("o_r_addr1"));
					dto.setO_r_msg(rs.getString("o_r_msg"));
					
					dto.setO_date(rs.getTimestamp("o_date"));
					dto.setO_g_amount(rs.getInt("o_g_amount"));
					dto.setO_g_color(rs.getString("o_g_color"));
					dto.setO_g_size(rs.getString("o_g_size"));
					dto.setO_g_name(rs.getString("o_g_name"));
					dto.setO_trade_num(rs.getString("o_trade_num"));
					dto.setO_trans_num(rs.getString("o_trans_num"));
					dto.setO_sum_money(rs.getInt("o_sum_money"));
					dto.setO_status(rs.getInt("o_status"));
					dto.setO_trade_type(rs.getString("o_trade_type"));
					
					adminOrderList.add(dto);				
				}// while
				System.out.println(" DAO : 주문번호 상세정보 조회 성공 ");
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
			return adminOrderList;
		}
		
		//  주문정보 상세페이지(관리자 수정정보) - getAdminOrderDetail(trade_num)
		
		// 주문정보 수정(상태, 운송장번호) - updateOrder(DTO)
		public void updateOrder(OrderDTO dto) {
			
			try {
				con = getConnection();
				sql = "update itwill_order set o_status=?, o_trans_num=? "
						+ "where o_trade_num=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1,dto.getO_status());
				pstmt.setString(2, dto.getO_trans_num());
				pstmt.setString(3, dto.getO_trade_num());
				
				pstmt.executeUpdate();
				System.out.println(" DAO : 관리자 상품상태, 운송장번호 수정완료!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 주문정보 수정(상태, 운송장번호) - updateOrder(DTO)
		
	
}




















