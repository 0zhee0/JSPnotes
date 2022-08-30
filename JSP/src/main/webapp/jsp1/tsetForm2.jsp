<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> tsetForm2.jsp </h1>
	
	<fieldset>
	<!-- testPro2.jsp로 정보 전달 후 출력, 전달방식은 POST -->
	<form action="testPro2.jsp" method="post">
		이름 : <input type ="text" name ="name" value="" placeholder="이름을 입력하세요."><br>
		비밀번호 : <input type = "password" name = "pass" value=""><br>		
		성별 : <input type ="radio" name ="gender" value="남">남자
		       <input type ="radio" name ="gender" value="여">여자<br>
		취미 : 
			   <input type ="checkbox" name="hobby" value="게임">게임
			   <input type ="checkbox" name="hobby" value="운동">운동
			   <input type ="checkbox" name="hobby" value="요리">요리<br>
			   
		강의장 : 
				<select name="num">
					<option value="">강의장을 선택하시오.</option>
					<option value="1">1강의장</option>
					<option value="2">2강의장</option>
					<option value="3">3강의장</option>
					<option value="4">4강의장</option>
					<option value="5">5강의장</option>
				</select>
				
				<textarea name ="txt" rows="20" cols="20"></textarea>
		
		
				<input type ="submit" value = "전송하기">	
	</form>	
			
	</fieldset>

</body>
</html>