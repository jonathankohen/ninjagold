<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<title>Ninja Gold</title>
</head>
<body>
	<div class="container">
		<div class="row my-5">
			<div class="col-sm-8 offset-4">
				<h1 class="display-1">Ninja Gold (will style and resubmit)</h1>
			</div>
		</div>

		<div class="row mb-5">
			<div class="col">
				<h3>
					Your Gold: <span class="border border-dark">${totalSum}</span>
				</h3>
			</div>
		</div>

		<div class="row">
			<div class="col">
				<div class="card-deck">

					<div class="card">
						<div class="card-body">
							<form action="/farm" method="post">
								<h4 class="card-title">Farm</h4>
								<p class="card-text">(earns 10-20 gold)</p>
								<button type="submit" class="btn btn-primary">Find
									Gold!</button>
							</form>
						</div>

					</div>

					<div class="card">
						<div class="card-body">
							<form action="cave" method="post">
								<h4 class="card-title">Cave</h4>
								<p class="card-text">(earns 5-10 gold)</p>
								<button type="submit" class="btn btn-primary">Find
									Gold!</button>
							</form>
						</div>
					</div>

					<div class="card">
						<div class="card-body">
							<form action="house" method="post">
								<h4 class="card-title">House</h4>
								<p class="card-text">(earns 2-5 gold)</p>
								<button type="submit" class="btn btn-primary">Find
									Gold!</button>
							</form>
						</div>
					</div>
					<div class="card">
						<div class="card-body">
							<form action="casino" method="post">
								<h4 class="card-title">Casino!</h4>
								<p class="card-text">(earns/takes 0-50 gold)</p>
								<button type="submit" class="btn btn-primary">Find
									Gold!</button>
							</form>
						</div>
					</div>
				</div>

				<div class="row mt-5 mb-2">
					<div class="col">
						<h3>Activities:</h3>
					</div>
				</div>

				<div class="row mb-5">
					<div class="col">
						<ul>
							<c:forEach items="${logList}" var="item">
    							<li>${item}</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>