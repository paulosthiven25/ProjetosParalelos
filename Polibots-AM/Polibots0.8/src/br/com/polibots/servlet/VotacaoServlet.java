package br.com.polibots.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.polibots.beans.Candidato;
import br.com.polibots.beans.Usuario;
import br.com.polibots.beans.Votacao;
import br.com.polibots.dao.VotacaoDAO;

@WebServlet("/VotacaoServlet")
public class VotacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public VotacaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String telefone = request.getParameter("");
		int idCandidato = Integer.parseInt(request.getParameter("idCandidato"));
		
		try {
			VotacaoDAO vtdao = new VotacaoDAO();
			Votacao voto = new Votacao(vtdao.gerarId(), new Candidato(idCandidato));
			
			vtdao.cadastrarVoto(voto);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
