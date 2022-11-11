<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">

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
 		function isBasket(){
 			// 옵션 선택 체스 (크기, 색상)
 			// alert(document.fr.size.value);
 			//alert(document.fr.size);
 			//console.log(document.fr.size);
 			if(document.fr.size.value == ""){ // 크기옵션 선택 X
 				alert("크기를 선택하시오.");
 				document.fr.size.focus();
 				return;
 			}
 			if(document.fr.color.value == ""){ // 색상옵션 선택 X
 				alert("색상을 선택하시오.");
 				document.fr.color.focus();
 				return;
 			}
 			
 			// 장바구니 페이지 이동
 			// 장바구니 버튼 클릭 시 장바구니로 갈래 아니면 좀 더 구경할래? 옵션이 생성된다.
 			var isMove = confirm("장바구니 페이지로 이동할까요?"); // confirm은 ok(true) and cancle(false) 버튼을 가지고 있고, 타입은 boolean이다.
 			
 			if(isMove){ // true=ok 일 때
 				// 장바구니 페이지 이동
 				alert('장바구니 페이지로 이동');
 				document.fr.action="./BasketAddAction.ba";
	 			document.fr.isMove.value=isMove; // true
	 			document.fr.submit();
 				
 			} else{ // false=cancle 일 때
 				// 계속 쇼핑하기 이동
 				alert("계속 쇼핑하기!");
 				// 장바구니 정보 전달&저장을 먼저 하고 그 후에 페이지 이동할 수 있게 해야한다.
 				// ./BasketAddAction.ba 라는 가상주소로 이동하게 한 다음에 작업을 완료하고 'GoodsList.go'로 보내야한다.
 				// + 쇼핑정보
 				// 근데 지금은 왜 저장 안 하고 넘어가지, 근데 이거 저장해두려면 폼태그에 또 키값 지정해두고 하는 방법이 있댔음..
 				
 				document.fr.action="./BasketAddAction.ba";
	 			document.fr.isMove.value=isMove; // false
	 			document.fr.submit();
 				
 				location.href='GoodsList.go';	
 				//location.href='./BasketAddAction.ba';
 			}			
 		} // isBasket()
 		
 		
 		// 바로구매하기 버튼 클릭 시 수행하는 작업	
 		function isOrder(){
 			if(document.fr.size.value == ""){ // 크기옵션 선택 X
 				alert("크기를 선택하시오.");
 				document.fr.size.focus();
 				return;
 			}
 			if(document.fr.color.value == ""){ // 색상옵션 선택 X
 				alert("색상을 선택하시오.");
 				document.fr.color.focus();
 				return;
 		}
 		
 			alert('구매 페이지 이동(미구현!)');
 			
 	}//isOrder
 	</script>
 
 
</head>
<body>
<div id="wrap">
<!-- 헤더가 들어가는 곳 -->
	<jsp:include page="../inc/top.jsp"></jsp:include>
<!-- 헤더가 들어가는 곳 -->

<!-- 본문 들어가는 곳 -->
<!-- 서브페이지 메인이미지 -->
<div id="sub_img"></div>
<!-- 서브페이지 메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Welcome</a></li>
<li><a href="#">History</a></li>
<li><a href="#">Newsroom</a></li>
<li><a href="#">Public Policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 내용 -->
<%-- ${goodsList } --%>
<article>
	<h1>ITWILL's 쇼핑몰 상세페이지</h1>
	
  <form action="" method="post" name="fr">
  	<input type="hidden" name="gno" value="${dto.gno }"> <!-- 자스코드에서 장바구니 페이지 이동코드 작성 시에 gno 식별위한 기능 추가함 -->
  	<input type="hidden" name="isMove" value=""> <!-- 장바구니로갈건지말건지이동정보만저장한다. -->
  
	<table border="1" id="notice">  <!-- id="notice" 지웟다가 생성했다가 실행해서 비교해보기 -->
		<tr>
			 <td width="310">
	       		 <img src="./upload/${dto.image.split(',')[0] }" 
	          		width="300" height="300">
	     	 </td>
			<td>
			상품정보(구매옵션) <br>
			<h2> 상품명 : ${dto.name } </h2>
			<h2> 판매가격 : <fmt:formatNumber value="${dto.price }"/>원 </h2>
			<h2> 구매수량 : <input type="number" name="amount" value="1"></h2>
			<h2> (남은 수량 : ${dto.amount }개) </h2>
			<hr>
			<h2> 구매 옵션 </h2>
			<h2> 크기 : 
			  <select name="size">	<!-- items안에 배열이나 리스트계열만 들어갈 수 있다. size는 뭔데? 우리는 String으로 저장했었다. -->
			   <option value="">크기를 선택하세요</option>
		         <c:forEach var="size" items="${dto.size.split(',') }">
			         <option value="${size }">${size }</option>
		         </c:forEach>
		       </select>
			</h2>
			<h2> 색상 </h2>
			  <select name="color">							<!-- forTokens 기능에는 delims는 구분자가 존재. split안써도됨 -->
			    <option value="">색상을 선택하세요</option>
		         <c:forTokens var="color" items="${dto.color }" delims=",">
			         <option value="${color }">${color }</option>
		         </c:forTokens>
		       </select>
			<hr>
			<h2>총 가격 : <fmt:formatNumber value="${dto.price * 1 }"/>원</h2>
			
			<h2> 
	        <a href="javascript: isBasket();">[장바구니 담기]</a>        <!-- head태그안에서 자스코드 작성완. -->
	        <a href="javascript: isOrder();">[바로 구매하기]</a>
	       </h2>
	          
	      </td>
	   </tr>
	   <tr>
	      <td colspan="2">
	        <c:forTokens var="img" items="${dto.image }" delims=",">
	          <c:if test="${img != 'null' }">  <!-- 왜 'null' 문자열로 저장해야하는지? 이미지에서는 null이라는 문자열 데이터가 존재 -->
			  	<img src="./upload/${img }" width="400" height="500"> <br>
			  </c:if>	
			  <c:if test="${img == 'null' }">  <!-- 업로드사진이없을경우 저장해놓은 default.png 이미지 사진으로 출력 -->
			  	<img src="./upload/default.png" width="400" height="500"> <br>
			  </c:if> 
			</c:forTokens>     
	      </td>
		</tr>	
		<tr>
			<td colspan="2">리뷰/QnA</td>
		</tr>		
	</table>
  </form>  <!-- form 태그는 내가 필요한 만큼까지만 감싸야한다. -->
</article>
<!-- 내용 -->
<!-- 본문 들어가는 곳 -->
<div class="clear"></div>
<!-- 푸터 들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp"></jsp:include>
<!-- 푸터 들어가는 곳 -->
</div>
</body>
</html>



