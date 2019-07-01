package br.com.polibots.bo;

import br.com.polibots.beans.Votacao;
import br.com.polibots.dao.VotacaoDAO;

public class VotacaoBO {
public static String novoVotacao(Votacao voto)throws Exception {
	VotacaoDAO udao= new VotacaoDAO();
	String resultado= udao.cadastrarVoto(voto);
	udao.fechar();
	return resultado;
}
}
