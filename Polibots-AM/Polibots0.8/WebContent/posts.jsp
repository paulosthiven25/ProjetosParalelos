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
<html lang="en">

<head>

<!-- Meta tags Obrigatórias -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
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
<title>Post</title>

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
					<li class="nav-item"><a class="nav-link"
						href="listaPosts.jsp">Blog</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="index.jsp">Home <span class="sr-only">(current)</span></a>
				</ul>
			</div>
		</div>
	</nav>


	<!-- Page Content -->
	<div class="container ">

		<div class="row">

			<!-- Post Content Column -->
			<div class="col-lg-8">

				<!-- Title -->
				<h1 class="mt-4">Post Title</h1>

				<!-- Author -->
				<p class="lead">
					by <a href="#">Start Bootstrap</a>
				</p>

				<hr>

				<!-- Date/Time -->
				<p>Posted on January 1, 2018 at 12:00 PM</p>

				<hr>

				<!-- Preview Image -->
				<img class="img-fluid rounded" src="http://placehold.it/900x300"
					alt="">

				<hr>

				<!-- Post Content -->
				<p class="lead">Lorem ipsum dolor sit amet, consectetur
					adipisicing elit. Ducimus, vero, obcaecati, aut, error quam
					sapiente nemo saepe quibusdam sit excepturi nam quia corporis
					eligendi eos magni recusandae laborum minus inventore?</p>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ut,
					tenetur natus doloremque laborum quos iste ipsum rerum obcaecati
					impedit odit illo dolorum ab tempora nihil dicta earum fugiat.
					Temporibus, voluptatibus.</p>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Eos, doloribus, dolorem iusto blanditiis unde eius illum
					consequuntur neque dicta incidunt ullam ea hic porro optio ratione
					repellat perspiciatis. Enim, iure!</p>

				<blockquote class="blockquote">
					<p class="mb-0">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit. Integer posuere erat a ante.</p>
					<footer class="blockquote-footer">
						Someone famous in <cite title="Source Title">Source Title</cite>
					</footer>
				</blockquote>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Error, nostrum, aliquid, animi, ut quas placeat totam sunt tempora
					commodi nihil ullam alias modi dicta saepe minima ab quo voluptatem
					obcaecati?</p>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Harum, dolor quis. Sunt, ut, explicabo, aliquam tenetur ratione
					tempore quidem voluptates cupiditate voluptas illo saepe quaerat
					numquam recusandae? Qui, necessitatibus, est!</p>

				<hr>

				<!-- Comments Form -->
				<div class="card my-4">
					<h5 class="card-header">Leave a Comment:</h5>
					<div class="card-body">
						<form>
							<div class="form-group">
								<textarea class="form-control" rows="3"></textarea>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>

				<!-- Single Comment -->
				<div class="media mb-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
					</div>
				</div>

				<!-- Comment with nested comments -->
				<div class="media mb-4">
					<img class="d-flex mr-3 rounded-circle"
						src="http://placehold.it/50x50" alt="">
					<div class="media-body">
						<h5 class="mt-0">Commenter Name</h5>
						Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
						scelerisque ante sollicitudin. Cras purus odio, vestibulum in
						vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
						nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

						<div class="media mt-4">
							<img class="d-flex mr-3 rounded-circle"
								src="http://placehold.it/50x50" alt="">
							<div class="media-body">
								<h5 class="mt-0">Commenter Name</h5>
								Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
								scelerisque ante sollicitudin. Cras purus odio, vestibulum in
								vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
								nisi vulputate fringilla. Donec lacinia congue felis in
								faucibus.
							</div>
						</div>

						<div class="media mt-4">
							<img class="d-flex mr-3 rounded-circle"
								src="http://placehold.it/50x50" alt="">
							<div class="media-body">
								<h5 class="mt-0">Commenter Name</h5>
								Cras sit amet nibh libero, in gravida nulla. Nulla vel metus
								scelerisque ante sollicitudin. Cras purus odio, vestibulum in
								vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
								nisi vulputate fringilla. Donec lacinia congue felis in
								faucibus.
							</div>
						</div>

					</div>
				</div>

			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<div class="card my-4">
					<h5 class="card-header  ">Pesquisar</h5>
					<div class="card-body">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Porcurar por..."> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="button">
									<m>
									<i class="fas fa-search"></i></m>
								</button>
							</span>
						</div>
					</div>
				</div>

				<!-- Categories Widget -->
				<div class="card my-4">
					<h5 class="card-header ">Categorias</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">lnik 1</a></li>
									<li><a href="#">lnik 2</a></li>
									<li><a href="#">lnik 3</a></li>
								</ul>
							</div>
							<div class="col-lg-6">
								<ul class="list-unstyled mb-0">
									<li><a href="#">lnik 1</a></li>
									<li><a href="#">lnik 2</a></li>
									<li><a href="#">lnik 3</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- Side Widget -->
				<div class="card my-4">
					<h5 class="card-header text-white bg-dark">Widget de lado</h5>
					<div class="card-body text-black">Lorem ipsum dolor sit amet
					</div>
				</div>

			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="bd-footer text-muted" id="section5">
		<div class="container-fluid p-3 p-md-5">
			<p>
				Contruido por <br> Victor Muchon Gindro <br>
			<p>v:0.5</p>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/script.js"></script>
	<script>
		// Este JQUERY é para acionar o POPOVER de ajuda do formulário
		$(function() {
			$('[data-toggle="popover"]').popover()
		})
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</body>

</html>
