<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
nav#main {
	background-color: aqua;
}

/*
 ul tag는 본문에서 보편적으로 style을
 nav#main ul{}
 id가 main인 nav Box 내부에 있는  
*/
nav#main ul {
	margin: 0px;
	background-color: blue;
}

nav#main li {
	display: inline-block;
	list-style: none;
	margin: 0px;
	padding: 10px;
	color: white;
}

nav#main li:hover {
	background-color: gray;
	color: white;
	cursor: pointer;
}

nav#main a {
	display: inline-block; /* box style로 변경*/
	color: inherit; /**/
	text-decoration: none;
}
</style>
<script>
/*
 html 문서를 DOM(document Object Model)이라고 한다
 tag로 둘러쌓인 모든 속성은 하나의 객체가 된다
 
 html 문서의 모든 객체의 시작점 객체는 document
 
 */
 document.addEventListener("DOMContentLoaded",function(){
	
	 /*
	 상단 메뉴의 항목을 클릭했을때
	 url을 전환하여 다른 화면으로 점프하기
	 => 다른 page로 전환하기
	 
	 메뉴의 항목인 ul > li tag를 클릭했을때
	 이벤트 버블링 효과에 의해
	 상단으로 이벤드가 전파되는 것을 역 이용하여
	 id main인 nav tag에 클릭 event를 선언하였다
	 nav tag를 클릭하면
	 선택된 li tag의 메뉴 제목을 캐치하여
	 메뉴제목에 따라 필요한 page로 전환을 한다
	 */
	 document.querySelector("nav#main").addEventListener("click",function(ev){
			
			let text = ev.target.textContent;
			
			alert(text + "클릭되었음")
			
			let url ="$[rootPath]"
			if(text == "HOME"){
				url += "/"
			}else if(text == "공지사항"){
				url += "/notice"
			}else if(text == "회사소개"){
				url += "/profile"
			}else if(text == "회원가입"){
				url += "/join"
			}else if(text == "로그인"){
				url += "login"
			}
			
			document.location.herf = url;
			
		});	 
 });


</script>
<h1>방명록 2021</h1>
<%-- 메뉴를 설정할때 사용하는 tag --%>
<%-- div 라는 tag사용하여 layout을 설정했는데 --%>
<%-- HTML 5에서는 Symatec(의미있는 이름으로) tag를 --%>
<%--사용하는 것을 권장한다 --%>
<nav id="main">
	<ul>
		<li><a href="${rootPath}/">Home</a></li>
		<li><a href="${rootPath}/notice">공지사항</a></li>
		<li>회사소개</li>
		<li>로그인</li>
		<li>회원가입</li>
	</ul>
</nav>




