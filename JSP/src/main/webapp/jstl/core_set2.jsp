<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>﻿core_set2.jsp</h1>
	
	<h2>전달된 정보 출력하기</h2>
	모델명 : ${model }, ${requestScope.model } <br>
	색상 : ${color } <br>
	가격 : ${price } <br>
	
	<hr>
	영역객체의 정보 삭제
	( 영역객체 정보가 없을 경우 모든 영역에 값을 삭제)
	특정 데이터만 삭제하고 싶을 때는 해당 영역을 명시!
	<br>
	<c:remove var="price" scope="request"/>
	모델명 : ${model }, ${requestScope.model } <br>
	색상 : ${color } <br>
	가격 : ${requestScope.price } <br>
	가격 : ${sessionScope.price } <br>
	가격 : ${price } <br>
	
	<hr>
	<h3>서블릿에서 전달된 정보 출력하기</h3>
	
	아이디 : ${requestScope.memberBean.id } <br>
	비밀번호 : ${requestScope.memberBean.pw } <br>
	이름 : ${memberBean.name } <br>
	나이 : ${memberBean.age } <br>
	
	<h4> jstl-set 사용해서 출력하기 </h4>
	request.setAttribute("m",memberBean); <br>
	<c:set var="m" value="${requestScope.memberBean }"/>
	성별 : ${m.gender } <br>
	이메일 : ${m.email } <br>
	회원가입일 : ${m.regdate } <br>
	
	<h3> ArrayList 저장된 정보 출력 </h3>
	마지막 회원정보 <br>
	아이디 : ${requestScope.memberList[2].id } <br>
	비밀번호 : ${requestScope.memberList[2].pw } <br>
	이름 : ${memberList[2].name } <br>
	나이 : ${memberList[2].age } <br>
	
	<h4> jstl-set 사용해서 출력하기 </h4>
	<c:set var="list" value="${memberList }"/>
	성별 : ${list[2].gender } <br>
	
	<c:set var="l2" value="${memberList[2] }"/>
	이메일 : ${l2.email } <br>
	회원가입일 : ${l2.regdate } <br>
	






</body>
</html>