<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accounts data here</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<p/>
		<div class="table-responsive-sm">
		<c:if test="${not empty accountList}">
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Identifier</th>
					<th scope="col">Name</th>
					<th scope="col">Type</th>
					<th scope="col">Balance</th>
					<th scope="col">Created On</th>
					<th scope="col">Creator</th>
					<th scope="col">State</th>
					<th scope="col">Ledger</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${accountList}" var="account"> 
				<tr>
			    	<td>${account.identifier}</td>
			    	<td>${account.name}</td>
			    	<td>${account.type}</td>
			    	<td>${account.balance}</td>
			    	<td>${account.createdOn}</td>
			    	<td>${account.createdBy}</td>
			    	<td>${account.state}</td>
			    	<td>${account.ledger}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</c:if>
		<c:if test="${not empty Error}">
			<div style="padding:1%;">${Error}</div>
		</c:if>
	</div>
	</body>
</html>