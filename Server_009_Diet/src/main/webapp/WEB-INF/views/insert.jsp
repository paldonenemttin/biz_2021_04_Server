<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<style>
	h1, form {
		width: 80%;
		margin: 10px auto;
	}
	
	h1 {
		background-color: rgba(0, 225, 0, 0.6);
		color: white;
		padding: 1.2rem;
		text-align: center;
	}
	
	form {
		border: 1px soild green;
		border-radius: 20px;
		padding: 10px;
	}
	
	label {
		display: inline-block;
		width: 20%;
		text-align: right;
	}
	
	input {
		width: 60%;
		padding: 8px;
		margin: 5px;
	}
	
	butten {
		background-color: blue;
		color: white;
		padding: 8px;
		width: 10%;
		outline: 0;
		border: 0;
		border-radius: 10px;
		cursor: pointer;
	}
	
	button:hover {
		/* x=offset y-offset blue spread color*/
		box-shadow: 3px 3px 3px 3px rgba(( 0, 0, 0, 0.3);
	}

	</style>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>식품 섭취 내역 입력</h1>
	<form method="POST">
		<p>
			<label>식품코드</label><input name="mf_code" value="${FOOD.fd_code}">
		</p>
		<p>
			<label>식품이름</label><input name="mf_name" value="${FOOD.fd_name}">
		</p>
		<p>
			<label>섭취일자</label><input type="date" name="mf_date" value="${TODAY}">
		</p>
		<p>
			<label>섭취량</label><input type="number" name="mf_amt" value="1">
		</p>
		<button>등록</button>
	</form>
</body>
</html>