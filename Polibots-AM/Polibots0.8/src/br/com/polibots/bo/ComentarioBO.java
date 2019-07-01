package br.com.polibots.bo;

import br.com.polibots.beans.Comentario;
import br.com.polibots.dao.ComentarioDAO;

public class ComentarioBO {
public static String novoComentario(Comentario con)throws Exception{
	ComentarioDAO udao = new ComentarioDAO();
	String resultado= udao.cadastrarComentario(con);
	udao.fechar();
	return resultado;
}
}
