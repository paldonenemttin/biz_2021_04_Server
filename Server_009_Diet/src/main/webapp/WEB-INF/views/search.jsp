<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식품정보 검색</title>
<style>
* {
	/*
		tag에 padding을 설정하면
		실제 width보다 더 커지는 현상이 발생한다
		이러한 현상은 UI 화면을 눈에 거슬리게 한다
		
		padding 주엇을때
		좌, 우의 padding을 밖으로 보내지 않고
		내부로 흡수하는 옵션
		
		이 설정을 style의 맨 상단에 설정하면
		padding으로 인한 Layout의 흐트러짐을 막을 수 있다
		*/
	box-sizing: border-box;
}

h1, form, table {
	width: 80;
	margin: 0px auto;
}

h1 {
	background-color: rgba(0, 225, 0, 0.7);
	padding: 1rem;
	text-align: center;
	color: white;
}

form {
	border: 1px solid green;
	padding-left: 10px;
	margin-top: 5px;
}

table {
	border: 1px solid green;
	margin-top: 5px;
	border-collapse: collapse;
	color: blue;
}

td, th {
	border: 1px solid green;
	padding: 5px;
}

tb {
	color: blue;
}

tr:nth-child(odd) {
	background-color: #ccc;
}

tr:nth-child(even) {
	background-color: #eee;
}

/*
	table의 어떤 row에 커서가 올라가면 바탕색을 #aaa로
	*/
tr:hover {
	background-color: green;
	cusor: pointer;
}

input {
	border: 1px solid green;
	padding: 8px;
	width: 60%;
	border-radius: 5px;
}

a {
	text-decoration: none;
	/*
	스타일의 상속
	a tag를 감싸고 있는 td tag의 컬러가 바뀌면
	a tag도 td tag를 따라 바뀜
	*/
	color: inherit;
}
</style>
</head>
<body>
	<h1>그만 좀 처먹어라</h1>
	<%--
	Form의 method를 POST로 지정하면
	Controller의 doPost() 함수가 받아서 처리를 한다
	
	보여지는 search.jsp 파일을 요청한 요청주소는 /food/search이다
	form에 action을 지정하지 않으면 action="/from/search"가 자동 지정된다
	
	 --%>
	<form method="POST">
		<p>
			<label>식품명</label>
			<%-- input placeholder : 입력받스의 안내메시지 --%>
			<input name="f_name" placeholder="식품명을 입력한 후 Enter" />
		</p>
	</form>
	<div>
		<%--
	        <c:choose>
	          <c:when> 
	          </c:when>
	          <c:otherwise> 
	          </c:otherwise>
		 --%>
		<c:choose>
			<c:when test="${not empty FOODS}">
				<table>
					<tr>
						<th>식품코드</th>
						<th>식품명</th>
						<th>출시년도</th>
						<th>제공량</th>
						<th>총내용량</th>
						<th>에너지</th>
						<th>단백질</th>
						<th>지방</th>
						<th>탄수화물</th>
						<th>총당류</th>
					</tr>
					<c:forEach items="${FOODS}" var="FOOD">
						<tr>
							<td>${FOOD.fd_code}</td>
							<td><a href="${rootPath}/food/insert?fd_code=${FOOD.fd_code}">
							${FOOD.fd_name}</a></td>

							<td>${FOOD.fd_year}</td>
							<td>${FOOD.fd_once}</td>
							<td>${FOOD.fd_capa}</td>
							<td>${FOOD.fd_cal}</td>
							<td>${FOOD.fd_protein}</td>
							<td>${FOOD.fd_fat}</td>
							<td>${FOOD.fd_carbo}</td>
							<td>${FOOD.fd_sugar}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>