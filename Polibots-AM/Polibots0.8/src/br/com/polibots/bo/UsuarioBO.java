package br.com.polibots.bo;

import br.com.polibots.beans.Usuario;
import br.com.polibots.dao.UsuarioDAO;

public class UsuarioBO {
	public static String novoUsuario(Usuario u) throws Exception {

		if (u.getTelefone().length() != 11) {
			return "telefone inválido";
		}

		u.setNome(u.getNome().toUpperCase());
		UsuarioDAO udao = new UsuarioDAO();
		Usuario rec = new Usuario();
		rec = udao.retornarLogin(u.getLogin());

		if (rec.getLogin().equals(u.getLogin())) {
			udao.fechar();
			return "Usuário Existente";
		}

		String resultado = udao.cadastrarUsuario(u);
		udao.fechar();
		return resultado;
	}

	public static String loginUsuario(Usuario u) throws Exception {
		UsuarioDAO udao = new UsuarioDAO();
		Usuario rec = new Usuario();
		rec = udao.consultarPorLogin(u.getLogin());
		if(rec.getLogin() == null) {
			udao.fechar();
			return "Usuário inválido";
		}else if (!rec.getSenha().equals(u.getSenha())) {
			udao.fechar();
		return "Senha invalida";
		}
		return "login com sucesso";
	}
	
}
