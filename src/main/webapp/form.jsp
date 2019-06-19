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
		<div id="heading" class="text-center text-white">
			<form action="Converter" method="GET">
				<h3>Number you want to convert to text: </h3>
				<input type="text" class="form-control" placeholder="enter a number" name="number"/>
				<br/><br/>
				<h3>Select a language:</h3>
				<select name="language" class="form-control">
					<option>Polish</option>
					<option>British</option>
					<option>American</option>
				</select>
				<br/><br/>
				<input type="submit" class="btn btn-light mt-5 btn-lg" value="submit">
			</form>
			${text_numb}
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	</body>
</html>