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


<style>
  .mt-20 {
    margin-top: 200px !important;
  }
  body{
  background: url('https://radiostudent.si/sites/default/files/slike/2017-03-07-%E2%80%9Cpolitika-je-zelo-plehka-obrt%E2%80%9D-69271.jpg') center center no-repeat scroll; !important;
  }
</style>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">

    <!-- FONT AWESOME  no site https://fontawesome.com-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">

    <link rel="stylesheet" href=".css">

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
				<li class="nav-item active"><a class="nav-link" href="index.jsp">Home
						<span class="sr-only">(current)</span>
				<li class="nav-item"><a class="nav-link" href="listaPosts.jsp">Blog</a></li>
				<li class="nav-item"><a class="nav-link" href="register.jsp">Registrar</a></li>
			</ul>
		</div>
	</div>
	</nav>
    <!-- Navigation -->
    Coloque uma navbar aqui!
    <!--<navBar>-->
<div class="d-flex mt-20 justify-content-center" id="center">
  <div class="card border-success  mb-3 " style="width: 20rem;" id="login">
    <div class="card-header bg-transparent border-success">Login</div>
<div class="card-body text-center">
    <form method="POST" action="LoginServlet">
  <div class="form-group row">
    <label for="inputEmail3" class="col-sm-3 col-form-label">Email</label>
    <div class="col-sm-10">
      <input type="email" name="login" class="form-control" id="inputEmail3" placeholder="Email">
    </div>
  </div>
  <div class="form-group row">
    <label for="inputPassword3" class="col-sm-4 col-form-label">Password</label>
    <div class="col-sm-10">
      <input type="password" name="senha" class="form-control" id="inputPassword3" placeholder="Password">
    </div>
  </div>
  <fieldset class="form-group">
 
  </div>
  </fieldset>
  <div class="form-group row">
    <div class="col-sm-10">
      <button type="submit" class="btn btn-primary btn-lg btn-block ml-4">Sign in</button>
    </div>
  </div>
</form>
</div>
</div>
</div>

<!-- Footer -->
	<footer class="py-5 bg-dark mt-4">
	<div class="container">
		<p class="m-0 text-center text-white">Copyright &copy; Polibots
			2018</p>
	</div>
	<!-- /.container --> 
	</footer>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  </body>

</html>
