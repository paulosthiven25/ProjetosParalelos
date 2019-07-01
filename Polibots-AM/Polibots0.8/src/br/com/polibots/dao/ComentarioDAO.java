package br.com.polibots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.polibots.beans.Comentario;
import br.com.polibots.conexao.Conexao;


public class ComentarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	
	public ComentarioDAO()throws Exception {
		con= Conexao.abrirConexao();
	}
	
	public String cadastrarComentario(Comentario c)throws Exception {
		stmt=con.prepareStatement("INSERT INTO T_BLOG_COMENTARIO (ID_COMENTARIO, ID_USUARIO, ID_POST, DT_CRIACAO, DS_TEXTO) VALUES (?, ?, ?, TO_DATE(SYSDATE , 'DD/MM/RR'),?)");
		stmt.setInt(1,c.getId());
		stmt.setInt(2,c.getUsuario().getId());
		stmt.setInt(3,c.getPost().getId());
		stmt.setString(4,c.getTexto());
		stmt.executeUpdate();
		return "Comentario criado com sucesso";
	}
	
	public String alterarComentario(Comentario c ,int numero) throws Exception {
		stmt=con.prepareStatement("UPDATE T_BLOG_COMENTARIO SET DT_CRIACAO=SYSDATE,DS_TEXTO=? WHERE ID_COMENTARIO=?");
		stmt.setString(1,c.getTexto());
		stmt.setInt(2,numero);
		stmt.executeUpdate();
		return "Comentario alterado com sucesso";
	}

	
	public String apagarComentario(int codigo)throws Exception{
		stmt=con.prepareStatement("DELETE FROM T_BLOG_COMENTARIO WHERE ID_COMENTARIO=?");
		stmt.setInt(1,codigo);
		stmt.executeQuery();
		
		return "Comentario apagado com sucesso";
	}


	public void fechar() throws Exception {
		stmt.close();
		con.close();
	}
}
