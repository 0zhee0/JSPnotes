<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.1.js"></script>
<script type="text/javascript">
   $(function(){
	   // h2태그 글자색변경
	   alert($('h2').css('color'));// 제이쿼리 도큐먼트에 가서 보면 의미의 이유가 나온다. https://api.jquery.com/css/#css-propertyName
	   $('h2').css('color','#5F00FF'); // 'bule' 같은 색상 명 안 적어도 됨
	   alert($('h2').css('color'));
	   
	   // h2 태그의 글자색을 모두 다른 색 변경
	   $('h2').css('color','red');
	   var colorArr = ['red', 'orange', 'yellow'];
	   $('h2').css('color',function(idx,val){
		  // 글자색 값을 표현 -> 리턴
 		  // alert(idx+"/"+val);
		  return colorArr[idx]; // h2태그의 순서(idx)에 따라 red->orange->yellow로 글자마다 색이 바뀐다.
	   });
	   
	   // 속성 여러개 한 번에 사용
	   $('h2').css({
		 color:"green", 
		 background:"yellow"
	   });
	   
	   // 속성 여러개 각각 적용
	   $('h2').css({
			 color:"green", 
			 background:function(idx){
				 return colorArr[idx];
			 }
		});
	   
	   // attr(속성명,속성값);
	   $('img').attr('src','default.png');
	   // 이미지 가로크기 조절(100)
	   $('img').attr('width',100);
	   
	   // 이미지 가로크기 각각 다른 크기로 조절
	   $('img').attr('width', function(idx){   // https://api.jquery.com/css/#css-propertyName 들어가면 attr에 function사용법 나온다.
		   return (idx+1)*100;
	   }); // idx는 0부터 시작한다.
	   
	   // 이미지 가로/세로 크기 각각 다른 크기로 조절
	   $('img').attr({
		   width:function(a){
			   return (a+1)*100;
		   },
		   height:function(b){
			   return (b+1)*50;
		   }
	   });
	   
   });
</script>
</head>
<body>
	<h1>test3.jsp</h1>
	
	<h2>head - 0</h2>
	<h2>head - 1</h2>
	<h2>head - 2</h2>
	<h2>head - 3</h2> <!-- 의 경우 빨간색으로 바뀐다 지정색이 3개라서 4번째는 다시 돌아간다. -->
	
	<hr>
	
	<img src="best-gifs-19.gif">
	<img src="best-gifs-19.gif">
	<img src="best-gifs-19.gif">
</body>
</html>