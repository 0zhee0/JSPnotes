<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 외부 CDN링크 추가 -->
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script> -->

<!-- 직접파일 추가 -->
<script src="jquery-3.6.1.js"></script>
<script type="text/javascript">
	alert('1111');
	
    $(document).ready(function(){
    	alert('22222');
    });
    
    $(function(){
    	alert('44444');
    });
    
    jQuery(document).ready(function(){
    	alert('555555');
    });
    
    jQuery(function(){
    	alert('6666');
    });
    
    alert('33333');
</script>


</head>
<body>
	<h1>test1.jsp</h1>
	
</body>
</html>