<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:Set value="${pageContext.request.contextPath} var="rootPath"/>
<%--
외부의 css file 가져오기
webapp 폴더는 프로젝트 외부에서 접근할때
root Folder로 인식된다
슬래시(/)로 시작되는 경로는 webapp 폴더로 인식된다

그런데 지금 프로젝트에서 슬래시(/)로 접근하는 모든 요청은
homeController가 catcher 하도록 만들어져 있기 때문에
어떠한 파일로 연결을 할 수 없다 
 --%>
<link href="${rootPath}/home.css" rel="stylesheet" type="css.test">
</head>
<body>
	<h1>다이어트를 도와줘</h1>
	<%-- --%>
	<a href="${pageContext.request.contextPath}/food/search">섭취정보등록</a>
	<%@ include file="/WEB-INF/views/list.jsp" %>
	
	<div>
        <form>
        <label>날짜</label>
        <input name="mf_date" type="date"/>
    </form>
    </div>

</body>
</html>


