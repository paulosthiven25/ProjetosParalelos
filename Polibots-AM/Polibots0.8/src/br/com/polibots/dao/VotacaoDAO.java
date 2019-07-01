package br.com.polibots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.polibots.beans.Votacao;
import br.com.polibots.conexao.Conexao;

public class VotacaoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public VotacaoDAO()throws Exception {
		con= Conexao.abrirConexao();
	}

	
	public String cadastrarVoto(Votacao voto)throws Exception{
		stmt=con.prepareStatement("INSERT INTO T_BLOG_VOTACAO (ID_VOTO,ID_CANDIDATO,DT_VOTACAO) VALUES (?,?,TO_DATE(SYSDATE,'DD/MM/YYYY'))");
		stmt.setInt(1, voto.getId());
		stmt.setInt(2,voto.getCandidato().getId());
	
		stmt.executeUpdate();
		return "Voto registrado com sucesso";
	}
	
public int consultarVotosCandidato(int numero)throws Exception {
	int count=0;
	stmt=con.prepareStatement("SELECT  COUNT (*) \"TOTAL\" FROM T_BLOG_VOTACAO WHERE ID_CANDIDATO=?");
	stmt.setInt(1, numero);
	rs=stmt.executeQuery();
	while(rs.next()) {
		count=rs.getInt("TOTAL");
	}
	return count;
	
}


public int gerarId() throws Exception {
	stmt = con.prepareStatement("SELECT ID_VOTO max FROM T_BLOG_VOTACAO");
	rs = stmt.executeQuery();
	int n = 0;
	while (rs.next()) {
		n++;
	}

	return n+1;
}
	
	public void fechar() throws Exception {
		stmt.close();
		con.close();
	}
}
