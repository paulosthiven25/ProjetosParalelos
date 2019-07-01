package br.com.polibots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.polibots.beans.Candidato;
import br.com.polibots.conexao.Conexao;

public class CandidatoDAO {
private Connection con;
private PreparedStatement stmt;
private ResultSet rs;

public CandidatoDAO()throws Exception {
	con= Conexao.abrirConexao();
}

public String cadastrarCandidato(Candidato can) throws Exception {
	stmt=con.prepareStatement("INSERT INTO T_BLOG_CANDIDATO (ID_CANDIDATO,NM_CANDIDATO,NR_CANDIDATO,DS_INFORMAÇOES) VALUES(?,?,?,?)");
	stmt.setInt(1,can.getId());
	stmt.setString(2,can.getNome());
	stmt.setInt(3,can.getNumero());
	stmt.setString(4,can.getInformacoes());
	stmt.executeUpdate();
	return "Candidato criado com sucesso";
}

public String consultarCandidato(int numero)throws Exception {
	stmt=con.prepareStatement("SELECT * FROM T_BLOG_CANDIDATO WHERE NR_CANDIDATO=?");
	stmt.setInt(1,numero);
	rs=stmt.executeQuery();
	Candidato can = new Candidato();
	if(rs.next()) {
		can.setId(rs.getInt("ID_CANDIDATO"));
		can.setNome(rs.getString("NM_CANDIDATO"));
		can.setNumero(rs.getInt("NR_CANDIDATO"));
		can.setInformacoes(rs.getString("DS_INFORMAÇOES"));
	}
	rs.close();
	return "O candidato é : "+ can.getId()+" "+ can.getNome()+" "+can.getInformacoes()+" "+can.getNumero();
}

public String alterarCandidato(int numero,Candidato can) throws Exception {
	stmt=con.prepareStatement("UPDATE T_BLOG_CANDIDATO SET NM_CANDIDATO=?,NR_CANDIDATO=?,DS_INFORMAÇOES=? WHERE ID_CANDIDATO=?");
	stmt.setString(1, can.getNome());
	stmt.setInt(2,can.getNumero());
	stmt.setString(3, can.getInformacoes());
	stmt.setInt(4,numero);
	stmt.executeUpdate();
	return "Candidato alterado com sucesso";
}

public String apagarCandidato(int codigo)throws Exception{
	stmt=con.prepareStatement("DELETE FROM T_BLOG_CANDIDATO WHERE ID_CANDIDATO=?");
	stmt.setInt(1,codigo);
	stmt.executeQuery();
	
	return "Candidato apagado com sucesso";
}


public void fechar() throws Exception {
	stmt.close();
	con.close();
}

}
