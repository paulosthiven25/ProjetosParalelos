<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.com.polibots.servlet.WatsonServlet"%>
<%@page import="br.com.polibots.beans.Polibot"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- DESABILITANDO O CACHE -->
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Blog Home</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

<!-- FONT AWESOME  no site https://fontawesome.com-->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous">

<link rel="stylesheet" href="css/style.css">

</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">POLIBOTS</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only">(current)</span></a></li>
				<li class="navbar-nav active ml-auto text-light">teste</li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container mt-5">

		<div class="row">

			<!-- Blog Entries Column -->
			<div class="col-md-8">

				<h1 class="my-4">
					Page Heading <small>Secondary Text</small>
				</h1>

				<!-- Blog Post -->
				<div class="card mb-4">
					<img class="card-img-top" src="http://placehold.it/750x300"
						alt="Card image cap">
					<div class="card-body">
						<h2 class="card-title">Post Title</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex
							quis soluta, a laboriosam. Dicta expedita corporis animi vero
							voluptate voluptatibus possimus, veniam magni quis!</p>
						<a href="posts.html" class="btn btn-primary">Read More &rarr;</a>
					</div>
					<div class="card-footer text-muted">
						Posted on January 1, 2017 by <a href="#">Start Bootstrap</a>
					</div>
				</div>

				<!-- Blog Post -->
				<div class="card mb-4">
					<img class="card-img-top" src="http://placehold.it/750x300"
						alt="Card image cap">
					<div class="card-body">
						<h2 class="card-title">Post Title</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex
							quis soluta, a laboriosam. Dicta expedita corporis animi vero
							voluptate voluptatibus possimus, veniam magni quis!</p>
						<a href="posts.html" class="btn btn-primary">Read More &rarr;</a>
					</div>
					<div class="card-footer text-muted">
						Posted on January 1, 2017 by <a href="#">Start Bootstrap</a>
					</div>
				</div>

				<!-- Blog Post -->
				<div class="card mb-4">
					<img class="card-img-top" src="http://placehold.it/750x300"
						alt="Card image cap">
					<div class="card-body">
						<h2 class="card-title">Post Title</h2>
						<p class="card-text">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex
							quis soluta, a laboriosam. Dicta expedita corporis animi vero
							voluptate voluptatibus possimus, veniam magni quis!</p>
						<a href="posts.html" class="btn btn-primary">Read More &rarr;</a>
					</div>
					<div class="card-footer text-muted">
						Posted on January 1, 2017 by <a href="#">Start Bootstrap</a>
					</div>
				</div>

				<!-- Pagination -->
				<ul class="pagination justify-content-center mb-4">
					<li class="page-item"><a class="page-link" href="#">&larr;
							Older</a></li>
					<li class="page-item disabled"><a class="page-link" href="#">Newer
							&rarr;</a></li>
				</ul>

			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<div class="card my-4">
					<h5 class="card-header">Search</h5>
					<div class="card-body">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="button">Go!</button>
							</span>
						</div>
					</div>
				</div>

				<!-- Categories Widget -->
				<div class="card my-4">
					<h5 class="card-header">Categories</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">Web Design</a></li>
									<li><a href="#">HTML</a></li>
									<li><a href="#">Freebies</a></li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">JavaScript</a></li>
									<li><a href="#">CSS</a></li>
									<li><a href="#">Tutorials</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- Side Widget -->
				<div class="card my-4">
					<h5 class="card-header">Side Widget</h5>
					<div class="card-body">You can put anything you want inside
						of these side widgets. They are easy to use, and feature the new
						Bootstrap 4 card containers!</div>
				</div>

			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Polibots
			2018</p>
	</div>
	<!-- /.container --> </footer>
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
