package com.itwillbs.order.db;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderDTO {
	private int o_num;
	private String o_trade_num;
	
	private int o_g_num;
	private String o_g_name;
	private int o_g_amount;
	private String o_g_size;
	private String o_g_color;
	
	private String o_m_id;
	
	private String o_r_name;
	private String o_r_phone;
	private String o_r_addr1;
	private String o_r_addr2;
	private String o_r_msg;
	
	private int o_sum_money;
	
	private String o_trade_type;
	private String o_trade_payer;
	private Timestamp o_trade_date;
	private String o_trans_num;
	
	private Timestamp o_date;
	
	private int o_status;
		
}
