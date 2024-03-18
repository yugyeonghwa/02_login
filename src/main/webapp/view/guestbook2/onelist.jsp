<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 방 명 록 </title>
<style type="text/css">
	a { text-decoration: none;}
	table{width: 600px; border-collapse:collapse; text-align: center;}
	table,th,td{border: 1px solid black; padding: 3px}
	div{width: 600px; margin:auto; text-align: center;}
</style>
<script type="text/javascript">
	function delete_go(f) {
		f.action="${pageContext.request.contextPath}/Guestbook2Controller?cmd=delete";
		f.submit();
	}
	
	function update_go(f) {
		f.action="${pageContext.request.contextPath}/Guestbook2Controller?cmd=update";
		f.submit();
	}
	
</script>
</head>
<body>
	<div>
		<h2>방명록 : 내용화면</h2>
		<hr />
		<p>[<a href="${pageContext.request.contextPath}/Guestbook2Controller?cmd=list">목록으로 이동</a>]</p>
		<form method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">작성자</td>
					<td>${g2vo.name}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">제  목</td>
					<td>${g2vo.subject}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">email</td>
					<td>${g2vo.email}</td>
				</tr>
				<tr align="center">
					<td bgcolor="#99ccff">첨부파일</td>
					<c:choose>
						<c:when test="${empty g2vo.f_name}">
							<td><b>첨부파일 없음</b></td>
						</c:when>
						<c:otherwise>
							<td>
								<a href="view/guestbook2/down.jsp?path=upload&f_name=${g2vo.f_name}">
								<img src="upload/${g2vo.f_name}" style="width: 80px"><br>${g2vo.f_name}</a>
							</td>
						</c:otherwise>
					</c:choose>
				</tr>
				
				<tr style="text-align: left;">
					<td colspan="2">
						<pre style="padding-left: 15px">${g2vo.content}</pre>
					</td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="hidden" name="idx" value="${g2vo.idx}">
							<input type="hidden" name="pwd" value="${g2vo.pwd}">
							<input type="button" value="수정" onclick="update_go(this.form)" />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="삭제" onclick="delete_go(this.form)"/>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>