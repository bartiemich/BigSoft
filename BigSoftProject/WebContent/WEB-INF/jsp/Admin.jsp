<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function editUser() {
		t = event.target || event.srcElement;
		document.all.cmd.value = t.id;
		document.all.mainForm.action = "/BigSoftProject/edit";
		document.all.mainForm.submit();
	}
	function removeUser() {
		t = event.target || event.srcElement;
		document.all.cmd.value = t.id;
		document.all.mainForm.action = "/BigSoftProject/remove";
		document.all.mainForm.submit();
	}
</script>
<link href="../css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
}
</style>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">

</head>
<body>
	<a href="/BigSoftProject/adduser">ADD USER</a>
	<a href="/BigSoftProject/logout">LOGOUT</a>
	<br />
	<form name="mainForm" method="post">
		<input type="hidden" name="cmd">
		<div>
			List of users:
			<table class="table table-striped table-bordered table-condensed">
				<tr>
					<td>Id</td>
					<td>Username</td>
					<td>Login</td>
					<td>Password</td>
					<td>RoleId</td>
					<td>Status</td>
					<td>EDIT</td>
					<td>REMOVE</td>
				</tr>
				<c:forEach var="entry" items="${listOfUsers}">
					<tr>
						<td><c:out value="${entry.id}" /></td>
						<td><c:out value="${entry.name}" /></td>
						<td><c:out value="${entry.login}" /></td>
						<td><c:out value="${entry.password}" /></td>
						<td><c:out value="${entry.role.name}" /></td>
						<td><c:out value="${entry.status}" /></td>
						<td>
							<button id=<c:out value="${entry.id}" /> 
								onclick="javascript:editUser()">EDIT</button>
						</td>
						<td>
							<button id=<c:out value="${entry.id}" /> 
								onclick="javascript:removeUser()">REMOVE</button>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>