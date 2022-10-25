<%@page import="org.apache.commons.collections4.bag.SynchronizedSortedBag"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

<%
	/* 로그인 제어 */
	String id = (String) session.getAttribute("id");
	if(id==null || !id.equals("admin")){ // id 세션이 만료되어 로그아웃처리되었거나(id값이 없는경우) 관리자계정로그인이 아닐 경우
		response.sendRedirect("./Main.me");
		System.out.println("비정상적 접근 발생! IP : " + request.getRemoteAddr());
	}
%>





<!-- 게시판 -->
<article>
<h1> 관리자 상품 등록페이지 </h1>
<form action="./AdminGoodsAddAction.ag" method="post" enctype="multipart/form-data">
	<table id="notice">
		<tr>
	    	<th class="ttitle" colspan="2">ITWILL 상품등록</th>
	    </tr>
		<tr>
			<td>카테고리</td>
			<td>
				<select name="category">
				   <option value="outwear">외투</option>
				   <option value="fulldress">정장</option>
				   <option value="Tshirts">티셔츠</option>
				   <option value="shirts">셔츠</option>
				   <option value="pants">바지</option>
				   <option value="shoes">신발</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>상품명</td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>판매가</td>
			<td>
				<input type="text" name="price">
			</td>
		</tr>
		<tr>
			<td>색상</td>
			<td>
				<input type="text" name="color">
			</td>
		</tr>
		<tr>
			<td>수량</td>
			<td>
				<input type="text" name="amount">
			</td>
		</tr>
		<tr>
			<td>사이즈</td>
			<td>
				<input type="text" name="size">
			</td>
		</tr>		
		<tr>
			<td>상품정보</td>
			<td>
				<input type="text" name="content">
			</td>
		</tr>	
		<tr>
			<td>상품 이미지(메인)</td>
			<td>
				<input type="file" name="file1" accept="image/*,.pdf">
			</td>
		</tr>
		<tr>
			<td>상품 이미지</td>
			<td>
				<input type="file" name="file2" accept=".jpg">	<!-- .jpg만 받을 수 있다. -->
			</td>
		</tr>
		<tr>
			<td>상품 이미지</td>
			<td>
				<input type="file" name="file3">
			</td>
		</tr>
		<tr>
			<td>상품 이미지</td>
			<td>
				<input type="file" name="file4">
			</td>
		</tr>				
			
	</table>
	
	<div id="table_search">
		<input type="submit" value="상품등록" class="btn">
	</div>
</form>

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



