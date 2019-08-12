<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
						
						<h3>Convert: </h3>
						<input type="number" step="any" class="form-control" placeholder="enter a number" name="number"/>
						<br/><br/>

						<h3>From:</h3>
						<select name="from" class="form-control">
							<option>PLN</option>
							<option>USD</option>
							<option>GBP</option>
						</select>
						<br/><br/>

						<h3>To:</h3>
						<select name="to" class="form-control">
							<option>PLN</option>
							<option>USD</option>
							<option>GBP</option>
						</select>
						<br/><br/>
						
						<input type="submit" class="btn btn-light mt-3 btn-lg" value="submit">
					</form>
				</div>
				<div class="col-lg-5">
					<div>
						<h3>${numb_before} ${from_currency}</h3>
						<p class="py-2">${numb_text_before}</p>
					</div>
					<div>
						<h2 class="py-4">CONVERSION RATE: ${rate}</h2>
					</div>
					<div>
						<h3>${numb_after} ${to_currency}</h3>
						<p class="py-2">${numb_text_after}</p>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>