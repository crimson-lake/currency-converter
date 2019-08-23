<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="labels"/>

<!DOCTYPE html>
<html lang="${cookie['lang'].value}">
	<head>
		<meta charset="UTF-8">
		<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet"> 
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
		<link rel="stylesheet" href="style.css">
		<title>Currency Converter</title>
	</head>
	<body>
		<jsp:include page="header.jsp"/>
		<div class="text-center text-white container-fluid">
			<div class="row align-items-center py-2">
				<div class='col-lg-12 py-2'>
						<h4 class="pt-4">
							<fmt:message key="label.rate"/> ${rate}
						</h4>
				</div>
			</div>
			<div class="row align-items-center py-3">
				<div class="col-lg-1"></div>
				<div class="col-lg-5 mx-2">
					<form action="Converter" method="GET">
						<h4>
							<fmt:message key="label.convert" />
						</h4>
						<input type="number" step="any" class="form-control" placeholder="enter a number" name="number"/>
						<br/><br/>

						<h4>
							<fmt:message key="label.from" />
						</h4>
						
						<select name="from" class="form-control">
							<option>PLN</option>
							<option>USD</option>
							<option>GBP</option>
						</select>
						<br/><br/>

						<h4>
							<fmt:message key="label.to" />
						</h4>

						<select name="to" class="form-control">
							<option>PLN</option>
							<option>USD</option>
							<option>GBP</option>
						</select>
						<br/><br/>
						
						<input type="submit" class="btn btn-light mt-2" value="submit">
					</form>
				</div>

				<div class="col-lg-5">
					<div class="py-4">
						<h4>${numb_before} ${from_currency}</h4>
						<p class="py-2">${numb_text_before}</p>
					</div>
					
					<div class="py-4">
						<h4>${numb_after} ${to_currency}</h4>
						<p class="py-2">${numb_text_after}</p>
					</div>
				</div>
				<div class="col-lg-1"></div>		
			</div>
		</div>
		<jsp:include page="footer.jsp"/>

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>