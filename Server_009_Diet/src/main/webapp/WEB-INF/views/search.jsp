<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
					 <th>출시연도</th>
					 <th>제조사코드</th>
					 <th>분류코드</th>
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
					<td>${FOOD.fd_name}</td>
					<td>${FOOD.fd_year}</td>
					<td>${FOOD.fd_ccode}</td>
					<td>${FOOD.fd_icode}</td>
					<td>${FOOD.fd_once}</td>
					<td>${FOOD.fd_capa}</td>
					<td>${FOOD.fd_cal}</td>
					<td>${FOOD.fd_protein}</td>
					<td>${FOOD.fd_fat}</td>
					<td>${FOOD.fd_carbo}</td>
					<td>${FOOD.fd_sugar}</td>
					</tr>
					</forEach>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>