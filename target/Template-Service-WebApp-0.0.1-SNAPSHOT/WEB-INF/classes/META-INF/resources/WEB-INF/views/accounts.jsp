<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<p/>
	<p/>
	<b style=" margin-left: 70px">Part - 1 : Custom Microservice Calling Fineract Account Microservice</b>
	<div style="width: 30%; border: 1; margin-left: 350px" >	 
		<form:form method="post" action="/getAccounts">
			<div class="form-group">
				<label for="exampleInputEmail1">Enter account Identifier to get account details</label>
				<form:input path="identifier" class="form-control" />
			</div>
			<button type="submit" value="Submit" class="btn btn-primary">Get an Account</button>
			<button type="submit" value="Get ALL Accounts" class="btn btn-primary">Get all Accounts</button>
		</form:form>
	</div>
	<br><p><br><p>
	<b style=" margin-left: 70px">Part - 2 : Custom Microservice Interacting with Fineract Database</b>
	<div style="width: 30%; border: 1; margin-left: 350px">	
		<form:form name= "template" method="post" action="/addSample">
			<div class="form-group">
				<label for="exampleInputEmail1">Enter Deposit Identifier </label>
				<form:input path="identifier" class="form-control" />
				<label for="exampleInputEmail1">Enter Description </label>
				<form:input path="payload" class="form-control" />
			</div>
			<button type="submit" value="Add" class="btn btn-primary">Add Deposit Data</button>
		</form:form>
	</div>
</body>
</html>