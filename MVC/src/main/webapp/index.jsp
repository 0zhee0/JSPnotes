<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>index.jsp</h1>
     * 프로젝트의 시작지점 
     * MVC프로젝트 사용하면서 실행가능한 유일한 jsp파일
     * url에  ~~~.jsp 페이지 주소 나오면 잘못 실행
     
     <%
       //response.sendRedirect("./board");
       //response.sendRedirect("./test.bo");
//        response.sendRedirect("./BoardWrite.bo");
     	  response.sendRedirect("./BoardList.bo");    
//        response.sendRedirect("./BoardUpdate.bo"); // (X) 이렇게 바로 실행하면 안된다.
       	// 젤 첫번째 동작이 전달되는 페이지 정보를 받아야하는데 여기부터 실행하면 그럴수가 없다.
     %>