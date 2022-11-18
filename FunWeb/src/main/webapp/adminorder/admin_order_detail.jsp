<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
	<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 메인이미지 -->
<div id="sub_img_center"></div>
<!-- 메인이미지 -->

<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="#">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->

<!-- 게시판 -->
<article>
<h1> 관리자 주문 상세 목록 </h1>
	<form action="./AdminOrderModify.ao" method="post">
	
	<table id="notice">
	
		<tr>
		   <th class="ttitle" colspan="8">
		     <h3> 관리자 주문상세내역</h3>
		   </th>
		</tr>
		<tr>
			<th class="tno">상품명</th>
			<th class="twrite">상품사이즈</th>
			<th class="tdate">상품컬러</th>
			<th class="tdate">구매 수량</th>
			<th class="tdate">구매 금액</th>
		</tr>
		
		<c:set var="totalSum" value="0"/>
		<c:forEach var="dto" items="${adminOrderDetail }">
			<tr>
				<td>${dto.o_g_name }</td>
				<td>${dto.o_g_size }</td>
				<td>${dto.o_g_color }</td>
				<td>${dto.o_g_amount }</td>
				<td>${dto.o_sum_money }</td>
			</tr>
			<c:set var="totalSum" value="${totalSum +dto.o_sum_money   }"/>
		</c:forEach>
		
		
		<tr>
		   <td colspan="2"></td>
		   <td colspan="3"> <h3>총 주문금액 : <fmt:formatNumber value="${totalSum }"/>원</h3> </td>
		</tr>
		
		<tr>
		   <th class="ttitle" colspan="8">
		     <h3> 배송 정보 </h3>
		   </th>
		</tr>
		<c:set var="aodDTO" value="${adminOrderDetail[0]}" />
		<tr>
		    <td colspan="8">
		       받는사람 : ${adminOrderDetail[0].o_r_name } <br>
		       연락처 : ${adminOrderDetail[0].o_r_phone }<br>
		       주소 : ${aodDTO.o_r_addr1 }<br>
		       메세지 : ${aodDTO.o_r_msg } <br>
		    </td>
		</tr>
		
		<tr>
		   <th class="ttitle" colspan="8">
		     <h3> 결제 정보 </h3>
		   </th>
		</tr>
		
		<tr>
		    <td colspan="8">
		       결제방법 : ${aodDTO.o_trade_type } <br>
		       결제자 : ${aodDTO.o_trade_payer } <br>
		       주문상태 :${aodDTO.o_status }
		        <select name="status">
		        	<option 
		        		<c:if test="${aodDTO.o_status == 0 }">
		        		 selected
		        		</c:if>
		        		
		        		value="0"
		        	>대기중</option>
		        	<option 
		        	    <c:if test="${aodDTO.o_status == 1 }">
		        		 selected
		        		</c:if>
		        		value="1"
		        		 >발송준비</option>
		        	<option 
		        		<c:if test="${aodDTO.o_status == 2 }">
		        		 selected
		        		</c:if> 
		        		value="2"
		        	>발송완료</option>
		        	<option 
		        		<c:if test="${aodDTO.o_status == 3 }">
		        		 selected
		        		</c:if>
		        		value="3"
		        		 >배송중</option>
		        	<option 
		        	    <c:if test="${aodDTO.o_status == 4 }">
		        		 selected
		        		</c:if> 
		        		value="4"
		        		>배송완료</option>
		        	<option 
		        		<c:if test="${aodDTO.o_status == 5 }">
		        		 selected
		        		</c:if>
		        		value="5" 
		        	>주문취소</option>
		        </select>
		        <br>
		       운송장번호 : <input type="text" name="trans_num" value="${aodDTO.o_trans_num }"> <br>
		       <!-- 주문번호 -->
		       <input type="hidden" name="trade_num" value="${aodDTO.o_trade_num }">
		       
		       <input type="submit" value="정보수정하기">
		    </td>
		</tr>
		
	</table>
	
		</form>
		
		<div id="table_search">
		
		</div>
	
	
<div class="clear"></div>
<div id="page_control">
</div>
</article>
<!-- 게시판 -->
<!-- 본문들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
 	<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>