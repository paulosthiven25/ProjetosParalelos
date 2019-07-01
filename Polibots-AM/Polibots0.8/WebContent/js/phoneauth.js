// Torna o reCAPTCHA invisivel
window.recaptchaVerifier = new firebase.auth.RecaptchaVerifier('enviar-token', {
    'size': 'invisible',
    'callback': function(response) {
        // reCAPTCHA solved, allow signInWithPhoneNumber.
        onSignInSubmit();
    }
});

// TODO: VERIFICAR SE O NÚMERO ESTÁ NO BANCO DE DADOS.
// CASO NÃO, CADASTRAR. CASO SIM, NÃO PERMITIR O CADASTRO
var enviarToken = function(){
    var phoneNumber = document.getElementById("telefone-usuario").value;
    var appVerifier = window.recaptchaVerifier;
    firebase.auth().signInWithPhoneNumber(phoneNumber, appVerifier)
        .then(function (confirmationResult) {
            // SMS sent. Prompt user to type the code from the message, then sign the
            // user in with confirmationResult.confirm(code).
            console.log("Mensagem enviada");
            
            $("#passo01").addClass("d-none");
            $("#passo02").removeClass("d-none").addClass("d-block");
            
            
            $("#verificarToken").click(function(){
            	var code = document.getElementById("token").value;
            	confirmationResult.confirm(document.getElementById("token").value)
                .then(function(result) {
                    $("#passo02").removeClass("d-block").addClass("d-none");
                    $("#passo03").removeClass("d-none");
                    console.log("Login Realizado com Sucesso!");
                    
                    $("#confirmaVoto").click(function(){
                    	$("#passo03").addClass("d-none");
                    	$("#votoConfirmado").removeClass("d-none").addClass("d-block");
                    	var idCandidato = $("#idCandidato").val();
                    	
                	  var data = { telefoneUsuario: phoneNumber, idCandidato: idCandidato };
                	  
                	  $.ajax({
                		  type: "POST",
                		  url: "VotacaoServlet",
                		  data: data,
                		  success: function(msg) {
                			  console.log("Voto cadastrado com sucesso!");
                		  }
                	  });
                    	
                    });
                    
                }, function(error) { 
                        console.log("TOKEN INVÁLIDO!");
                    }); 
            });
            
            }).catch(function (error) {
            // Error; SMS not sent
            // ...
            console.log("Erro no envio");
            });
};

/*

var verificarToken = function(){ 
	
	var code = document.getElementById("token").value;
	confirmationResult.confirm(code).then(function (result) {
	  // User signed in successfully.
	  var user = result.user;
	  // ...
	}).catch(function (error) {
	  // User couldn't sign in (bad verification code?)
	  // ...
	});
	

	window.confirmationResult.confirm(document.getElementById("token").value)
    .then(function(result) {
        //$("#passo02").addClass("d-none").remove("d-block");
        //$("#passo03").removeClass("d-none").addClass("d-block");
        console.log("Login Realizado com Sucesso!");
    }, function(error) { 
            console.log("TOKEN INVÁLIDO!");
        }); 


};*/