<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My TODO List</title>
<style type="text/css">
/* style 지정을 위해 전체 초기화*/
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

h1, form.doit {
	width: 50%;
	margin: 10px auto;
	border-radius: 5px;
}

h1 {
	background-color: rgba(0, 225, 0, 0.3);
	color: white;
	padding: 1rem;
	text-align: center;
	text-shadow: 1px 1px 1px #ddd;
}

form.doit {
	border: 1px solid red;
	padding: 10px;
	text-align: center;
}

form.doit input {
	width: 90%;
	/*
		
		*/
	outline: 0;
	border: 1px solid #eee;
	border-radius: 5px;
	padding: 15px;
	margin: 10px;
	font-weight: bold;
}

form.doit input:hover {
	background-color: #eee;	
}
</style>
</head>
<body>
	<h1>To Do List</h1>

	<%--
from tag의 action 속성
form rag의 action 속성은 form에 담긴 데이터를
sucmit 할때(서버로 전송할때)
어떤 uri path를 통해서 서버에 보낼 것인가를 지정하는 것

만약 이 action 속성을 지정하지 않으면
현재 팡리(home.jsp)을 보여줄때 사용한
uri 주소가 자동으로 설정이 된다

${rootPath}/처럼 주소를 지정하는 것
form, a tag등에 URL, URI를 지정할때

 주소의 지정방식에 따라 상태주소
 절대주소 방법이 있는데
 지정하는 방버벵 따라 연결이 잘 안되는 경우가 많다
 우리 프로젝트는 모두 절대 주소 지정방식으로 통일하고
 항상 주소(URI, URL)과 관련된 모든 항목은
 ${rootPath} 시작하는 주소로 사용한다
 rootPath = http://localhost:8080/insert
 --%>
	<form class="doit" method="post" action="${rootPath}/insert">
		<input name="td_doit" placeholder="할일을 입력한 후 Enter">
	</form>


</body>
</html>