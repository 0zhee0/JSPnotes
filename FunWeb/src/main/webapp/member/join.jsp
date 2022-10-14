<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<!-- 원래 ../ 이었는데 이러면 실행했을 때 화면에 사진이 안뜬다.
			 그래서 상대경로 ./ 로 바꿔주어 (./ = webapp폴더) 해결한다. -->
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
 <script type="text/javascript">
 	function winopen(){
 		alert('아이디 중복체크 시작');
 		
 		// 아이디창에 아이디 입력여부 확인
 		if(document.fr.id.value == ""){
 			alert('아이디를 입력하세요!');
 			document.fr.id.focus();
 			return;
 		}
 		
 		// 입력된 아이디 정보
 		var inputID = document.fr.id.value;
 		
 		// 새창열기
 		window.open("./MemberIdCheck.me?inputID="+inputID,"","width=400. height=200,top=600,left=500");
 		
 	}
 </script>
</head>
<body>
	<div id="wrap">
		<!-- 헤더들어가는 곳 -->
		<jsp:include page="../inc/top.jsp" />
		<!-- 추가할 페이지를 컴파일 후 페이지를 추가 -->
		<!-- 헤더들어가는 곳 -->

		<!-- 본문들어가는 곳 -->
		<!-- 본문메인이미지 -->
		<div id="sub_img_member"></div>
		<!-- 본문메인이미지 -->
		<!-- 왼쪽메뉴 -->
		<nav id="sub_menu">
			<ul>
				<li><a href="#">Join us</a></li>
				<li><a href="#">Privacy policy</a></li>
			</ul>
		</nav>
		<!-- 왼쪽메뉴 -->
		<!-- 본문내용 -->
		<article>
			<h1>회원가입</h1>
			<form action="./MemberJoinAction.me" method="post" id="join"
				  name = "fr" onsubmit="alert('데이터 유효성체크 완료');">
				<fieldset>
					<legend>기본정보</legend>
					<label>아이디</label> <input type="text" name="id" class="id">
					<input type="button" value="중복체크" class="dup" onclick="winopen();"><br>
					<label>비밀번호</label> <input type="password" name="pw"><br>
					<label>이름</label> <input type="text" name="name"><br>
					<label>E-Mail</label> <input type="email" name="email"><br>
					<legend>Optional</legend>
					<label>주소</label> <input type="text" name="addr"><br>
					<label>연락처</label> <input type="text" name="tel"><br>
					<label>생년월일</label> 
						<select name="birth">
							<option>년</option>
							<c:forEach var="y" begin="2000" end="2022" step="1">
								<option value="${y }">${y }년</option>
							</c:forEach>
						</select>
						<select name="birth">
							<option>월</option>
							<c:forEach var="m" begin="1" end="12" step="1">
								<option value="${m }">${m }월</option>
							</c:forEach>
						</select>	
						<select name="birth">
							<option>일</option>
							<c:forEach var="d" begin="1" end="31" step="1">
								<option value="${d }">${d }일</option>
							</c:forEach>
						</select>		
					<hr>
					<label>성별</label> 
						<input type="radio" name="gender" value="남">남<br>
						<input type="radio" name="gender" value="여">여<br>
				</fieldset>
				
				<div class="clear"></div>
				<div id="buttons">
					<input type="submit" value="회원가입" class="submit"> 
					<input type="reset" value="초기화" class="cancel">
				</div>
			</form>
		</article>
		<!-- 본문내용 -->
		<!-- 본문들어가는 곳 -->

		<div class="clear"></div>
		<!-- 푸터들어가는 곳 -->
		<jsp:include page="../inc/bottom.jsp"></jsp:include>
		<!-- 푸터들어가는 곳 -->
	</div>
</body>
</html>




























