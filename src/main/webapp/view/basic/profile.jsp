<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send_go(f) {
		const pwd = "${pwd}";
		const pwd2 = f.pwd.value;
		if (pwd==pwd2) {
			f.submit();
		} else {
			alert("비밀번호가 틀렸습니다.");
			f.pwd.value = "";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>
<body>
	<form action="/02_login/MyController" method="post" autocomplete="off">
		<fieldset style="width: 500px">
			<legend style="font-weight: bold; font-size: 20px">비밀번호확인</legend>
			<label for="pwd">PW : <input type="password" id="pwd" name="pwd"></label>
			<input type="hidden" name="cmd" value="profile_ok">
			<input type="hidden" name="id" value="${id}">
			<input type="button" value="비밀번호확인" onclick="send_go(this.form)">
		</fieldset>
	</form>
</body>
</html>