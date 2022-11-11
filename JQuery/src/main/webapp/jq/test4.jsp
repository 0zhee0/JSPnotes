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
	    // html(),text()
	    var h = $('h2').html(); // 해당 대상(요소) 처음만나는 값을 1개 가져옴
	    alert(h);
	    var t = $('h2').text(); // 해당 대상(요소) 모든 값을 가져옴
	    alert(t);
	    
	    // 해당요소의 값을 변경(모두)
	    //$('h2').html('Hello Itwill');
	    //$('h2').text('Hello Itwill');
	    
	    // 전달되는 값이 HTML 태그의 경우
// 	    $('h2').html('<h1>Hello Itwill</h1>'); <h2>안에 <h1>을 적용한 거라 일반 <h1>크기보다 좀 더 크기가 커진다.
// 	    $('h2').text('<h1>Hello Itwill</h1>'); // 태그가 적용 X, 단순 텍스트
// 	    $('h2').html('<h1>Hello Itwill'+t+'</h1>'); // 태그가 적용
	    
	    $('h2').html(function(idx,html){
	    	return html+"///"+idx+"@@@@@@@@@@@@@";
	    });
	    
	    // append(), prepend()
	    $('body').append("추가!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    $('body').prepend("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
	    
// 	    $('div').html(function(idx,html){
// 	    	return html+idx;
// 	    });
	    
	    $('div').append(function(i){
	    	return i;
	    });
	    
	    // 배열(2차원배열 형태) => JSON타입
	    var arr = 
	    	[ // 대괄호의 의미 : 배열
		    	{name:"학생1", addr:"부산"},  // 중괄호의 의미 : 객체
		    	{name:"학생2", addr:"울산"},
		    	{name:"학생3", addr:"서울"},
		    	{name:"학생4", addr:"제주"},
		    	{name:"학생5", addr:"대전"}
	    	];
	    
	   // $('tr').append("<td>"+arr[0].name+"</td><td>"+arr[0].addr+"</td></tr>")
// 	    for(var i=0;i<arr.length;i++){
// 		    $('table').append("<tr><td>"+arr[i].name+"</td><td>"+arr[i].addr+"</td></tr>")    	
// 	    }
	   
	   // each()
	   // https://api.jquery.com/css/#css-propertyName
	   // $(요소).each(function(){});
	   // $.each(요소,function(){});
	   
	   // 배열의 값을 테이블에 추가
	   $(arr).each(function(idx,item){
		   //alert('1');
		   //alert(idx+"/"+item); // alert창에 오브젝트형태가 나타난다면 alert창보다 console.log를 이용해서 출력하는 게 낫다
		   console.log(item); // 배열의 객체값
		   $('table').append("<tr><td>"+item.name+"</td><td>"+item.addr+"</td></tr>")
		   
	   });
	   
	   // h3태그 배경색 blue 변경
	   // $('h3').css('background','blue');  
	   
	   // addClass() : 요소에 클래스명을 추가
	   
	   //$('h3').addClass('high_0');
// 	   $('h3').addClass(function(idx){
// 		  return 'high_'+idx; 
// 	   });

	   $('h3').each(function(idx){
		    //alert(idx);
		    $(this).addClass('high_'+idx);
		    // this - 이벤트가 발생한 요소
		    // each 안에 this를 쓰면 모든 요소를 구분할 수 있다.
	   });
	   
	   $('#btn2').click(function(){
		  alert('클릭!'); 
	   });
	   
   });
</script>
<style type="text/css">
/* 	h3{ */
/* 	   background: red; */
/* 	} */ 

	.high_0 {background: maroon;}
	.high_1 {background: aqua;}
	.high_2 {background: orange;}
	.high_3 {background: purple;}
	.high_4 {background: lime;} 


</style>
</head>
<body>
   <h1>test4.jsp</h1>
	
	<h2>head-0</h2>
	<h2>head-1</h2>
	<h2>head-2</h2>
	<h2>head-3</h2>
	<h2>head-4</h2>

	<hr> <!-- div 0 ~ 4 -->
	<div>div</div>
	<div>div</div>
	<div>div</div>
	<div>div</div>
	<div>div</div>
	
	<hr>
	<table border="1">
	    <tr>
	       <td>이름</td>
	       <td>주소</td>
	    </tr>
	    <!-- $('tr').append("<td>"+arr[0].name+"</td><td>"+arr[0].addr+"</td></tr>")의 의미는 여기 위치에 tr태그 추가한 것 -->
	</table>
	
	<hr>
<!-- 	<h3 style="background: red">item-0</h3>
	<h3 class="high_1">item-1</h3>
	<h3>item-2</h3>
	<h3 class="high_3">item-3</h3>
	<h3>item-4</h3> -->
	
 	<h3>item-0</h3>
	<h3>item-1</h3>
	<h3>item-2</h3>
	<h3>item-3</h3>
	<h3>item-4</h3>
	
	<hr>
	
	<input type="button" value="버튼1" onclick="alert('버튼 클릭');">
	<input type="button" value="버튼2" id="btn2">
	
	
	<hr>
	
	
	
</body>
</html>
