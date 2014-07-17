<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="/SpringBigSoftSkeleton/news">News</a>  <a href="/SpringBigSoftSkeleton/shop">Shop</a>  <a href="/SpringBigSoftSkeleton/company">Company</a>  <a href="/SpringBigSoftSkeleton/fun">Fun</a>  <a href=" /SpringBigSoftSkeleton/administrating/">Admin</a>
	<br/>
<div>
	List of users:
	<ul>
		<c:forEach var="entry" items="${listOfUsers}">
			<li>
				<c:out value="${entry.toString()}"/> 
			</li>  	
		</c:forEach>
	</ul>
	</div> 
</body>
</html>