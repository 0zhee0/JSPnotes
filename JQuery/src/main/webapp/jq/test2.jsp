<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 선택자
		$('h2').css('color','RED'); // 태그 선택자
		$('*').css('color','blue'); // * - 전체(모든 요소)
		$('.title1').css('color','orange'); // . - 클래스
		$('#title2').css('color','pink'); // # - 아이디
		
		/* jQuery - 아이디값 가져오기 */
		// alert($('input').val());
		$('input').val('아이티윌'); // val() : 특정요소에 있는 값을 담을 수 있다.
		alert($('input').val()); 
		
		// 비밀번호 - 12345 입력
// 		$('input.pw').val('12345'); // input에 class명 pw로 입력해주고 input.pw 해서 pw클래스 불러와서 값넣기
		$('input[type=password]').val('123456789'); // class 없을 경우 비밀번호 값 넣는 방법
		//alert($('.pw').val()); // 'input.pw' = '.pw'	
		alert($('input[type=password]').val());
		
		// 위치탐색 선택자
		$('tr:odd').css('background','red'); // 홀수
		$('tr:even').css('background','blue'); // 짝수
		$('tr:first').css('background','yellow'); 
		// // idx는 0부터 시작한다.
		
		
		
	});
	
	/* js - 아이디값 가져오기 */
	// document.폼태그명.요소명.value;

	
</script>
</head>
<body>
	<h2>test2.jsp</h2>
	
	<h2 class="title1">제목1</h2>
	<h2 id="title2">제목2</h2>
	
	<form action="">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
	</form>
	
	<table border="1">
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>			
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>			
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>			
		</tr>
		<tr>
			<td>1</td>
			<td>2</td>
			<td>3</td>			
		</tr>
	</table>
	
</body>
</html>
