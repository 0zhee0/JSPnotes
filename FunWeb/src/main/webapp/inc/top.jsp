<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<!-- 로그인 성공 시 해당 링크를 유저 정보와 로그아웃으로 변경해주기 -->
	<div id="login">
		<c:if test="${id == null }">
			<a href="./MemberLogin.me">login</a> | <a href="./MemberJoin.me">join</a>
		</c:if>
		<c:if test="${id != null }">
		<a href="./MemberInfo.me">${id }님의 info</a> 
		|
		<a href="./BasketList.ba">장바구니</a>
		|
		<a href="./MemberLogout.me">logout</a>
		</c:if>
	</div>
	<!-- 로그인 성공 시 해당 링크를 유저 정보와 로그아웃으로 변경해주기 -->
			
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src="./images/logo.gif" width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href="./Main.me">HOME</a></li>	<!-- ./main/main.jsp -> ./Main.me 가상주소로 변경 -->
	<li><a href="./GoodsList.go">쇼핑몰</a></li>
	<li><a href="#">SOLUTIONS</a></li>
	<li><a href="./AdminGoodsList.ag">관리자페이지</a></li>
	<li><a href="#">CONTACT US</a></li>
</ul>
</nav>
</header>

