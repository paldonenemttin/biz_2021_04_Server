<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int num1 = 10;
int num2 = 20;
int sum = num1 + num2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP(Java Server Page)</h1>
<h3><%= num1 %> + <%= num1 %> = <%= sum %></h3>
<p> html 파일에 java 코드를 덧붙여서 java 코딩으로 다양한 기능을 수행 할 수 있도록 고안된 기술
<p> 1995년에 탄생된 기술로 PHP, ASP 등과 같은 기술들이 사용될때 java 개발자들을 위하여 탄생된 기술
<P>PHP : c언어와 비슷한 문법인 기술, 오픈소스, Linux 등 운영체제와 상관없이 사용 가능
<p>ASP : Basic, c# 등의 언어를 사용하는  MS에서 만든 기술
<H3>정적 Web Page</H3>
<p> ㅇ리반적으로 이미지, text등으로 디자인 된 HTML 파일을 사용하여 작성된 Web 화면
<p>*.html, *.htm 형식으로 작성된 파일은  Response 하는 기술

<h3>동적(Dynamic)</h3> 
</body>
</html>