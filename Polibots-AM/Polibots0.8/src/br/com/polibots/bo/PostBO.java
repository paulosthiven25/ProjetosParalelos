package br.com.polibots.bo;

import br.com.polibots.beans.Post;
import br.com.polibots.dao.PostDAO;

public class PostBO {
	public static String novoPost(Post p)throws Exception{
		PostDAO udao= new PostDAO();
		String resultado=udao.cadastrarPost(p);
		udao.fechar();
		return resultado;
	}
}
