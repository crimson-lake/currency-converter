<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet"> 
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<link rel="stylesheet" href="style.css">
		<title>Numbers to text converter</title>
	</head>
	<body>
		<div id="heading" class="text-center text-white container-fluid">
			<div class="row align-items-center py-5 bg-blue">
				<div class="col-lg-1"></div>
				<div class="col-lg-5 mx-2">
					<form action="Converter" method="GET">
						
						<h3>Convert this number: </h3>
						<input type="number" class="form-control" placeholder="enter a number" name="number"/>
						<br/><br/>

						<h3>Language:</h3>
						<select name="language" class="form-control">
							<option>Polish</option>
							<option>English</option>
						</select>
						<br/><br/>
						
						<input type="submit" class="btn btn-light mt-3 btn-lg" value="submit">
					</form>
				</div>
				<div class="col-lg-5">
					<h3>${numb}</h3>
					<p class="py-5">${text_numb}</p>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>