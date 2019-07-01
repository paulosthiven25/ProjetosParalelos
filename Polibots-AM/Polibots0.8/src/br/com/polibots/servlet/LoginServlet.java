package br.com.polibots.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.polibots.bo.UsuarioBO;
import br.com.polibots.dao.UsuarioDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = request.getParameter("login");
		String senha = request.getParameter("senha");
		try{
			UsuarioDAO udao = new UsuarioDAO();
			UsuarioBO ubo = new UsuarioBO();
			
			System.out.println(ubo.loginUsuario(udao.consultarPorLogin(usuario)));
			HttpSession session = request.getSession();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
