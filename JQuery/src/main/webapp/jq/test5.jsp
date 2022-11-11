<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.1.js"></script>
<script type="text/javascript">
    /*
      AJAX란 비동기 자바스크립트와 XML 
             (Asynchronous JavaScript And XML)을 말합니다
             
      동기화 <-> 비동기화
      
      동기 : 서버의 데이터와 클라이언트의 데이터를 동일하게 만드는 작업
      		 (화면전환 O)
      
      비동기 : 서버의 데이터와 클라이언트의 데이터를 동일하게 만드는 작업
      		   (화면전환 X)
    */
	$(function(){
		
		$('input').click(function(){
			
		// 비동기방식 처리
// 		$.ajax("test.jsp"); //  이 페이지로 비동기방식으로 갔다와서 처리해라
		$.ajax({
			url:"test.jsp", // = $.ajax("test.jsp"); 와 같은 의미
// 			data:{name:"홍길동", tel:"010-1234-1234"}, // data라는 속성을 쓰면 test.jsp에 정보를 보낼 수도 있게 된다.
			success:function(data){
				//alert('ajax 성공!');
				//alert(data);
				$('body').append(data);
			},
			error:function(){
				alert('ajax 실패!');  // 주소 잘못 쓴 경우
			},
			complete:function(){
				alert("ajax 완전 끝"); // 성공하든 실패하든 제일 마지막에 실행시키는 속성문법
			}
		});
		
		
		}); // click끝
		
		$('#btnNews').click(function(){
			alert("뉴스 정보 가져오기");
			
			$.ajax({
				url:"http://fs.jtbc.co.kr//RSS/sports.xml", 
				success:function(data){
					alert('성공!');
					// $('body').append(data); 오류
					// console.log(data);
					$(data).find('item').each(function(){
						$('body').append( "<img src='https://photo.jtbc.co.kr/news/2022/11/08/202211080758154580_LC.jpg.tn350.jpg'>");
						$('body').append( "<a href='"+$(this).find('link').text()+"'>"+$(this).find('title').text() +"</a><hr>");
					
					}); 
				}
			});
		});
		
	}); // jquery끝
</script>	

</head>
<body>
	<h1>test5.jsp</h1>
	
	<input type="button" value="정보 불러오기">
	
	<input type="button" id="btnNews" value="뉴스 정보 불러오기">
</body>
</html>