package br.com.polibots.bo;

import br.com.polibots.beans.Candidato;
import br.com.polibots.dao.CandidatoDAO;

public class CandidatoBO {
public static String novoCandidato(Candidato can)throws Exception{
	
	
	CandidatoDAO udao =new CandidatoDAO();
	String resultado = udao.cadastrarCandidato(can);
	udao.fechar();
	return resultado;
}
}
