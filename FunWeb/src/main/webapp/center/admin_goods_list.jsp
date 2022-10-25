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
<h1> 관리자 상품등록 리스트 </h1>
<%-- ${adminGoodsList } --%>
<table id="notice">
		<tr>
			<th class="tno">상품번호</th>
			<th class="ttitle">카테고리</th>
			<th class="twrite">이미지</th>
			<th class="tdate">가격</th>
			<th class="tdate">수량</th>
			<th class="tdate">등록일자</th>
			<th class="tread">관리</th>
		</tr>

		<c:forEach var="dto" items="${adminGoodsList }">
			<tr>
				<td>${dto.gno }</td>
				<td class="left">${dto.category }</td>
				<td>
					<img src="./upload/${dto.image.split(',')[0] }" width="50" height="50"> 
					<!-- 서버실제경로입력하면안됨(보안위험) 대신에 가상의 주소를 사용할 것이다. 
						 "./가상주소"이면 ./ 은 webapp폴더이다.-->
				</td>
				<td>${dto.price }</td>
				<td>${dto.amount }</td>
				<td>
					<fmt:formatDate value="${dto.date }"/>
				</td>
				<td>
				 <a href="./AdminGoodsModify.ag?gno=${dto.gno }">수정</a>
				  /
				 <a href="./AdminGoodsRemove.ag?gno=${dto.gno }">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
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




