$("#mensagem-usuario").html("Como funciona o chat?");
$("#mensagem-candidato").html("Basta digitar o número do seu candidato");


var data = new Date();
var hora = data.getHours();
var saudacao = "";
if(hora<=12){
  saudacao = "Bom dia!";
} else if(hora > 12 && hora <=18){
  saudacao = "Boa tarde! ";
} else{
  saudacao = "Boa noite!";
}

var numeroCandidato = "";
var selectNum = true;

$(".btn.numero").click(function(){
  if(selectNum){
    $("#numero-01").text($(this).val());
    selectNum = false;
  } else{
    $("#numero-02").text($(this).val());
    selectNum = true;
  }
});

$("#btnBranco").click(function(){
  $("#numero-01").text("0");
  $("#numero-02").text("0");
  selectNum = true;
});

$("#btnCancel").click(function(){
  $("#numero-01").text("0");
  $("#numero-02").text("0");
  $("#nome-candidato").html('Escolha seu candidato');
  $("#cargo-candidato").html('Cargo');
  $("#candidato-urna-img").attr('src', 'img/candidato.jpeg');
  $("#candidato-resposta-img").attr('src', 'img/candidato.jpeg');
});

$("#btnConfirm").click(function(){
  numeroCandidato = $("#numero-01").text() + $("#numero-02").text();
  $("#numCandidato").val(numeroCandidato);
  if(numeroCandidato == "13"){
      $("#nome-candidato").html('Fernando Haddad');
      $("#cargo-candidato").html('Presidente');

      $("#candidato-urna-img").attr('src', 'img/haddad.jpeg');
      $("#candidato-resposta-img").attr('src', 'img/haddad.jpeg');

      $("#mensagem-usuario").html(saudacao);
      $("#mensagem-candidato").html(saudacao+" Eu sou o Haddad!");
      
  } else if(numeroCandidato == "12"){
      $("#nome-candidato").html('Ciro Gomes');
      $("#cargo-candidato").html('Presidente');

      $("#candidato-urna-img").attr('src', 'img/ciro.jpg');
      $("#candidato-resposta-img").attr('src', 'img/ciro.jpg');

      $("#mensagem-usuario").html(saudacao);
      $("#mensagem-candidato").html(saudacao+" Eu sou o Ciro!"); 
      
  } else if(numeroCandidato == "45"){
      $("#nome-candidato").html('Geraldo Alckmin');
      $("#cargo-candidato").html('Presidente');

      $("#candidato-urna-img").attr('src', 'img/alckmin.jpg');
      $("#candidato-resposta-img").attr('src', 'img/alckmin.jpg');

      $("#mensagem-usuario").html(saudacao);
      $("#mensagem-candidato").html(saudacao+" Eu sou o Alckmin!");  
      
  } else if(numeroCandidato == "18"){
      $("#nome-candidato").html('Marina Silva');
      $("#cargo-candidato").html('Presidente');

      $("#candidato-urna-img").attr('src', 'img/marina.jpeg');
      $("#candidato-resposta-img").attr('src', 'img/marina.jpeg');

      $("#mensagem-usuario").html(saudacao);
      $("#mensagem-candidato").html(saudacao+" Eu sou a Marina!");  
      
  } else if(numeroCandidato == "17"){
      $("#nome-candidato").html('Jair Bolsonaro');
      $("#cargo-candidato").html('Presidente');

      $("#candidato-urna-img").attr('src', 'img/bolsonaro.jpg');
      $("#candidato-resposta-img").attr('src', 'img/bolsonaro.jpg');

      $("#mensagem-usuario").html(saudacao);
      $("#mensagem-candidato").html(saudacao+" Eu sou o Bolsonaro!");  
      
  }
});

// ENVIO DA PERGUNTA
$("#btn-send").click(function(){

  event.preventDefault();
  
	
  perguntaUsuario = $("#input-box").val();
  numeroCandidato = $("#numero-01").text() + $("#numero-02").text();
  var respostaCandidato = "";
  
  //var posting = $.post("TestWatson", { numCandidato: numeroCandidato, pergunta: perguntaUsuario });
  
  //posting.done(function(data){
	  //console.log(data.attr());
	  
  var data = { numCandidato: numeroCandidato, pergunta: perguntaUsuario, respostaCandidato: "" };
  
  $.ajax({
	  type: "POST",
	  url: "WatsonServlet",
	  data: data,
	  success: function(msg) {
		  console.log(msg);
		  perguntaUsuario = $(msg).find("#mensagem-usuario").text();
		  respostaCandidato = $(msg).find("#mensagem-candidato").text();
		  updateChat(perguntaUsuario, respostaCandidato);
		  //console.log(perguntaUsuario);
		  //console.log(respostaCandidato);
	  }
  });

  /*
  $("#mensagem-usuario").html(perguntaUsuario);
  $("#mensagem-candidato").removeClass("d-block").addClass("d-none");
  $("#typing").removeClass("d-none").addClass("d-block");
  
  setInterval(resposta,1500);*/

});

function updateChat(perguntaUsuario, respostaCandidato){
	$("#mensagem-usuario").html(perguntaUsuario);
	$("#mensagem-candidato").html(respostaCandidato);
}

/*

function resposta(){
  perguntaUsuario = $("#mensagem-usuario").val();
  numeroCandidato = $("#numero-01").text() + $("#numero-02").text();
  $("#numCandidato").html(numeroCandidato);
  $("#mensagem-candidato").removeClass("d-none").addClass("d-block");
  $("#typing").removeClass("d-block").addClass("d-none");
}
*/

