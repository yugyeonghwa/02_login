<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과보기</h2>
	<h3>
		<ul>
			<li>올린사람 : ${name}</li>
			<li>파일이름 : ${f_name}</li>
			<li>파일타입 : ${contentType}</li>
			<%-- KB-MB-GB-TB --%>
			<li>파일크기 : <fmt:formatNumber type="number" pattern="#,###" value="${f_size /1024}" /> KB</li>
			<li>마지막수정날짜 : ${f_last2}</li>
			<li><img src="upload/${f_name}"></li>
			<li>다운로드 : <a href="view/fileup_down/down.jsp?path=upload&f_name=${f_name}"><b>${f_name}</b></a></li>
		</ul>
	</h3>
</body>
</html>