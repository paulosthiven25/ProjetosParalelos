package br.com.polibots.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.polibots.beans.Usuario;
import br.com.polibots.bo.UsuarioBO;
import br.com.polibots.dao.UsuarioDAO;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		try {
		UsuarioDAO udao = new UsuarioDAO();
		UsuarioBO ubo = new UsuarioBO();
		System.out.println(usuario +" " + senha);
		System.out.println(udao.cadastrarUsuario(new Usuario(udao.gerarUsuario(), usuario, senha, 1, "teste", "tetseFone")));
		udao.fechar();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
