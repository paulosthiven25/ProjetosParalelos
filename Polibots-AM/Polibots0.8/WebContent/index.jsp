<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.polibots.servlet.WatsonServlet"%>
<%@page import="br.com.polibots.beans.Polibot"%>
<%@page import="br.com.polibots.dao.VotacaoDAO"%>
<%@ page import="java.util.*,java.sql.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- DESABILITANDO O CACHE -->
<%        
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", -1);
%>

<% 

int bolsonaro = 0;
int ciro = 0;
int marina = 0;
int alckmin = 0;
int haddad = 0;

try{
	VotacaoDAO vtdao = new VotacaoDAO();
	haddad = vtdao.consultarVotosCandidato(1);
	bolsonaro = vtdao.consultarVotosCandidato(2);
	ciro = vtdao.consultarVotosCandidato(3);
	alckmin = vtdao.consultarVotosCandidato(4);
	marina = vtdao.consultarVotosCandidato(5);
	vtdao.fechar();
} catch(SQLException e){
	System.out.print("Deu ruim");
	e.printStackTrace();
} 
String user = (String) session.getAttribute("usuario");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Polibots</title>
    
    <!-- Bootstrap core CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="css/main.css" rel="stylesheet" type="text/css">

    <script src="https://www.gstatic.com/firebasejs/5.4.2/firebase.js"></script>
    <script>
        // Initialize Firebase
        var config = {
        apiKey: "AIzaSyC-znkTQ2uXkRbt0-DVXCoakGWjwc3XWIs",
        authDomain: "polibots-ibm.firebaseapp.com",
        databaseURL: "https://polibots-ibm.firebaseio.com",
        projectId: "polibots-ibm",
        storageBucket: "polibots-ibm.appspot.com",
        messagingSenderId: "152370295133"
        };
        firebase.initializeApp(config);
    </script>

    <!-- Chart.js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js"></script>

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
						<span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="listaPosts.jsp">Blog</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<li class="nav-item text-light"></li>
			</ul>
		</div>
	</div>
	</nav>
    <!-- Navigation -->

    <!-- Header with Background Image -->
    <header class="business-header">
      <div class="container">
          <div class="row">
              <div class="col-lg-8 col-md-10 mx-auto">

              </div>
            </div>
        <div class="row">
          <div class="col-lg-12">
          </div>
        </div>
      </div>
    </header>

    <!-- Page Content -->
    <div class="container">
      <br><br>
      <h1>Seja bem vindo ao Polibots!</h1>
      <p>O Polibots foi criado para levar informações pertinentes dos candidatos à presidência da república 2018,  com um aprendizado fácil dinâmico e rápido.
      Chama atenção no Polibots o público alvo abrangente no qual ele é capaz de alcançar, qualquer pessoa, de qualquer idade, ou com quase nenhuma familiaridade com tecnologia, podem facilmente manusear o sistema.</p>

      <img src="https://gerenciamentopolitico.com.br/wp-content/uploads/2018/05/200145-entenda-porque-precisamos-de-mais-mulheres-na-politica-750x488.jpg" class="img-fluid" alt="Responsive image">

      <!-- URNA -->
      <br><br>
      <h1>A Urna</h1>

      <p>Você pode utilizar nossa urna para fazer perguntas de propostas ao seu candidato. Basta digitar o número dele e iniciar a conversa. Caso tenha digitado um número errado basta clicar na tecla CANCELAR. Caso queira mudar de politico basta clicar em BRANCO. Quando tiver certeza do número, clique em CONFIRMA. Sempre que o botão confirma é clicado o nosso grafico é atualizado em tempo real.</p>

      <br>
      
      <span id="scrollUrna"></span>
		
      <div class="main" id="urna">
          <div class="left">
            
              <div class="politico">
                  <div class="cargo-nome">
                      <h1 id="nome-candidato">Escolha o Candidato</h1>
                      <h2 id="cargo-candidato">Cargo</h2>
                      <br>
                      <div class="numero-candidato">
                        <h1>
                          <span id="numero-01">0</span>
                          <span id="numero-02">0</span>
                        </h1>
                      </div>
                  </div>
  
                
                  <img src="img/candidato.jpeg" alt="" id="candidato-urna-img">
  
              </div>
  
                     
              <div class="chat" style="overflow-y: auto" id="chat">
                  <div class="mensagem-enviada">
                      <p id="mensagem-usuario" name="pergunta">${ perguntaUsuario }</p>
                      
                  </div>
  
                  <div class="mensagem-recebida">
                      <img src="img/candidato.jpeg" alt="" id="candidato-resposta-img">
                      <p id="mensagem-candidato" class="d-block">${ respostaCandidato }</p>
                      <img src="img/typing.gif" id="typing" alt="" style="width: 120px; height: 120px; margin-top: -50px;" class="d-none">
                  </div>  
              </div>
              <div class="enviar-mensagem">
                <form method="POST" action="TestWatson">
                    <div class="input-group">
                      <input name="pergunta" id="input-box" type="text" autocomplete="off" class="form-control" placeholder="Pergunte ao seu candidato aqui..." />
                      <input name="numCandidato" id="numCandidato" type="text" class="d-none" value="00"></input>
                      <span class="input-group-btn" id="send-btn">
                          <button class="btn" id="btn-send" type="submit">Send</button>
                      </span>
                      
                    </div>
                  </form>
              </div>
          </div>
  
          <div class="right">
              <div class="urna">
                  <div class="header">
                      <img src="img/justica-eleitoral.png" alt="" style="width: 90px; height: 90px; margin-left: 20px">
                      <h1>POLIBOTS</h1>
                  </div>
  
                  <div class="body">
                      <center>
                          <div class="fileira-numeros">
                              <button type="button" class="btn numero" value="1">1</button>
                              <button type="button" class="btn numero" value="2">2</button>
                              <button type="button" class="btn numero" value="3">3</button>
                          </div>
                          <div class="fileira-numeros">
                              <button type="button" class="btn numero" value="4">4</button>
                              <button type="button" class="btn numero" value="5">5</button>
                              <button type="button" class="btn numero" value="6">6</button>
                          </div>
                          <div class="fileira-numeros">
                              <button type="button" class="btn numero" value="7">7</button>
                              <button type="button" class="btn numero" value="8">8</button>
                              <button type="button" class="btn numero" value="9">9</button>
                          </div>
                          <div class="fileira-numeros">
                              <button type="button" class="btn numero" value="0">0</button>
                          </div>
                      </center>
                      
                  </div>
  
                  <div class="footer">
                      <center>
                          <button type="button" class="btn btn-light" id="btnBranco">Branco</button>
                          <button type="button" class="btn btn-danger" id="btnCancel">Cancela</button>
                          <button type="button" class="btn btn-success" id="btnConfirm">Confirma</button>
                      </center>
                  </div>
  
              </div>
          </div>
      </div>

        
      <br>
      <h2>Corrida Eleitoral</h2>
      <p>Com o nosso sistema de Urna eletronica conseguimos capturar sempre que um candidato é pesquisado (ou votado). Com essas informações geramos um gráfico para mostrar as intenções de votos. O gráfico é atualizado em tempo real e traz as informaçõs de quantas pesquisas foram feitas diariamente.</p>
      <br>

      <!-- CHART JS -->
      <canvas id="line-chart"></canvas>

      <br><br>

      <!-- FIREBASE -->
      <div style="background: #edf4ed; padding: 30px;">
        <div class="d-flex justify-content-center"><h1>Dê o seu voto!</h1></div>
          <div class="d-flex justify-content-center"><p>Coloque seu número de telefone para realizar seu voto. Utilizamos essa forma de autenticação para evitar a duplicação de votos.</p></div>

          <div class="d-flex justify-content-center">


              <form class="form-inline" id="passo01">
                  <div class="form-group">
                      <input type="text" class="form-control" id="telefone-usuario" placeholder="+5511987654321">
                  </div>
                  <button type="button" class="btn btn-primary" id="enviar-token" onclick="enviarToken()">Enviar Token</button>
              </form>


              <form class="form-inline d-none" id="passo02">
                  <div class="form-group">
                      <input type="text" class="form-control" id="token" placeholder="Digite seu Token">
                      <button type="button" class="btn btn-primary" id="verificarToken">Verificar Token</button>
                  </div>
              </form>
			  
              <div class="input-group d-none" id="passo03" style="width: 500px !important">
				  <select class="custom-select" id="idCandidato">
				    <option selected>Escolha seu candidato...</option>
				    <option value="3">Ciro Gomes</option>
				    <option value="1">Fernando Haddad</option>
				    <option value="4">Geraldo Alckmin</option>
				    <option value="2">Jair Bolsonaro</option>
				    <option value="5">Marina Silva</option>
				  </select>
				  <div class="input-group-append">
				    <button class="btn btn-success" type="button" id="confirmaVoto">Confirma</button>
				  </div>
			  </div>
			 

          </div>
          
          <div id="recaptcha-container"></div>
      </div>
      
      <br>
      <h2>Conheça nosso Blog!</h2>
      <div class="row">
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="http://www.politize.com.br/wp-content/uploads/2018/08/fake-news-495x400.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Fake news nas eleições: como podemos combatê-las?</h4>
              <p class="card-text">As notícias falsas, as chamadas fake news, estão cada vez mais em alta. Inclusive, um período propício para o surgimento dessas "notícias" é durante as eleições. Como, então, combater as fakes news nas eleições? Confira!</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Leia Mais</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="http://www.politize.com.br/wp-content/uploads/2018/08/transparencia-dados-publicos-35-495x400.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Transparência de dados públicos: algumas iniciativas</h4>
              <p class="card-text">A transparência dos dados públicos é requisito fundamental para que o cidadão fiscalize o governo. Nesse texto o Politize! vai explicar o que é transparência e algumas ferramentas que você pode usar para ficar de olho nas despesas públicas!</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Leia Mais</a>
            </div>
          </div>
        </div>
        <div class="col-sm-4 my-4">
          <div class="card">
            <img class="card-img-top" src="http://www.politize.com.br/wp-content/uploads/2018/08/autoritarismo-40-495x400.jpg" alt="">
            <div class="card-body">
              <h4 class="card-title">Autoritarismo: 3 pontos para reconhecer um governo autoritário</h4>
              <p class="card-text">Você sabe o que é um governo autoritário? Muitas pessoas usam esse conceito da forma errada. Nesse post vamos te mostrar 3 passos para identificar o autoritarismo.</p>
            </div>
            <div class="card-footer">
              <a href="#" class="btn btn-primary">Leia Mais</a>
            </div>
          </div>
        </div>
      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Polibots 2018</p>
      </div>
      <!-- /.container -->
    </footer>
	
	<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous" type="text/javascript"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" type="text/javascript"></script>
  
    <script src="js/urna.js" type="text/javascript"></script>
    <script src="js/chart.js" type="text/javascript"></script>
    <script src="js/phoneauth.js" type="text/javascript"></script>



	<script>
		var user = <%=user%>
		var ctx = document.getElementById("line-chart");
		var qtdVtGeraldo = <%= alckmin %>;
		var qtdVtJair = <%= bolsonaro %>;
		var qtdVtCiro = <%= ciro %>;
		var qtdVtHaddad = <%= haddad %>;
		var qtdVtMarina = <%= marina %>;
	
	
		var chartGraph = new Chart(ctx, {
		  type: 'bar',
		  data: {
		    datasets: [
		      {
		        label: "Geraldo Alckmin",
		        data: [qtdVtGeraldo],
		        backgroundColor: '#084c61',
		      },
		      {
		        label: "Jair Bolsonaro",
		        data: [qtdVtJair],
		        backgroundColor: '#f9c22e',
		      },
	
		      {
		        label: "Ciro Gomes",
		        data: [qtdVtCiro],
		        backgroundColor: '#53b3cb',
		      },
	
		      {
		        label: "Fernando Haddad",
		        data: [qtdVtHaddad],
		        backgroundColor: '#dc3545',
		      },
	
		      {
		        label: "Marina Silva",
		        data: [qtdVtMarina],
		        backgroundColor: '#28a745',
		      },
		    ]
		  }, 
	
		  options:{
		    labels:{
		      fontStyle: "bold"
		    }
		  }
		});
	
	</script>
  </body>

</html>