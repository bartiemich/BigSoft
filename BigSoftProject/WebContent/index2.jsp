<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>КАССА БАНКА</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
 
<script type="text/javascript">
function validate() {

	var x = document.forms["mainForm"]["login"].value;
	var y = document.forms["mainForm"]["password"].value;

	if (y.length == 0) {
		alert("Введите логин!");
		return false;
	}

	if (x.length == 0) {
		alert("Введите пароль!");
		return false;
	}

	return true;
}
</script>
<link href="../css/bootstrap.css" rel="stylesheet">
<style type="text/css">body{padding-top:40px;padding-bottom:40px;background-color:#f5f5f5;}.form-signin{max-width:300px;padding:19px 29px 29px;margin:0 auto 20px;background-color:#fff;border:1px solid #e5e5e5;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-webkit-box-shadow:0 1px 2px rgba(0,0,0,.05);-moz-box-shadow:0 1px 2px rgba(0,0,0,.05);box-shadow:0 1px 2px rgba(0,0,0,.05);}.form-signin .form-signin-heading,.form-signin .checkbox{margin-bottom:10px;}.form-signin input[type="text"],.form-signin input[type="password"]{font-size:16px;height:auto;margin-bottom:15px;padding:7px 9px;}</style>
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
 
<script type="text/javascript">

</script>
</head>
<body>
<div class="container">
<form class="form-signin" name="mainForm" method="post" onsubmit="return validate()" action="/BigSoftProject/auth" >
<h2 class="form-signin-heading">Введите пароль</h2>
<input type="text" class="input-block-level" placeholder="Логин" name="login">
<input type="password" class="input-block-level" placeholder="Пароль" name="password">
<br>
<button  class="btn btn-large btn-primary" type="submit">Войти</button>
<a href="/BigSoftProject/auth">auth</a>
</form>
</div>  

</body>
</html>
