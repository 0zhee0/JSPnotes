<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.1.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
// 		$.ajax({
// 			url:"test.json", 
// // 			dataType: "html", // 정보가 안나올거다. "text"로 바꿔도 안나온다.
// 			dataType: "json", // json파일에 저장했기때문에 오로지 json파일을 불러야만 값이 출력된다.
// 			success:function(data){
// 				alert("성공");
// 				console.log(data);
// 				$('body').append(data.name);
// 				$('body').append(data.addr);
// 				$('body').append(data.tel); // 객체 안에 변수처럼 부르는 거다.
// 			}
// 		});

	
	$.getJSON("test.json", function(data){ // test.json으로 가서 data 가져온다.
		console.log(data); // 실행한 웹에서 f12눌러서 console창 보고 배열 가져온 걸 확인할 수 있다.
		$(data).each(function(idx, item){
			$('table').append("<tr> <td>"+item.name+"</td> <td>"+item.addr+"</td> <td>"+item.tel+"</td> </tr>");
		});	
	});
	
	
	});	
</script>
</head>
<body>
   <h1>test6.jsp</h1>
   
  <!--  { "name":"홍길동" } -->
  
  <table>
     <tr>
        <td>이름</td>
        <td>주소</td>
        <td>전화번호</td>
     </tr>
  </table>
  
  

</body>
</html>