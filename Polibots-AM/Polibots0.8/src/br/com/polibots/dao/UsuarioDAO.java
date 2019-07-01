package br.com.polibots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.polibots.beans.Usuario;
import br.com.polibots.conexao.Conexao;

public class UsuarioDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public UsuarioDAO()throws Exception {
		con= Conexao.abrirConexao();
	}
	
	public String cadastrarUsuario(Usuario u)throws Exception {
		stmt=con.prepareStatement("INSERT INTO T_BLOG_USUARIO (ID_USUARIO,DS_LOGIN,DS_SENHA,NR_TIPO,NM_NOME,DS_TELEFONE) VALUES(?,?,?,?,?,?)");
		stmt.setInt(1,u.getId());
		stmt.setString(2,u.getLogin());
		stmt.setString(3, u.getSenha());
		stmt.setInt(4, u.getNumero());
		stmt.setString(5, u.getNome());
		stmt.setString(6,u.getTelefone());
		stmt.executeUpdate();
		return "Usuario cadastrado com sucesso";
	}
	
	public Usuario consultarUsuario(int numero) throws Exception {
		stmt=con.prepareStatement("SELECT * FROM T_BLOG_USUARIO WHERE ID_USUARIO=? ");
		stmt.setInt(1, numero);
		rs=stmt.executeQuery();
		Usuario u = new Usuario();
		if(rs.next()) {
			u.setLogin(rs.getString("DS_LOGIN"));
			u.setSenha(rs.getString("DS_SENHA"));
			u.setNumero(rs.getInt("NR_TIPO"));
			u.setNome(rs.getString("NM_NOME"));
			u.setTelefone(rs.getString("DS_TELEFONE"));
		}
		rs.close();
		return u;
	}
	public Usuario consultarPorLogin(String login) throws Exception {
		stmt=con.prepareStatement("SELECT * FROM T_BLOG_USUARIO WHERE DS_LOGIN=?");
		stmt.setString(1, login);
		rs=stmt.executeQuery();
		Usuario u = new Usuario();
		if(rs.next()) {
			u.setLogin(rs.getString("DS_LOGIN"));
			u.setSenha(rs.getString("DS_SENHA"));
			u.setNumero(rs.getInt("NR_TIPO"));
			u.setNome(rs.getString("NM_NOME"));
			u.setTelefone(rs.getString("DS_TELEFONE"));
		}
		rs.close();
		return u;
	}
	
	public String alterarUsuario(int numero,Usuario u)throws Exception {
		stmt=con.prepareStatement("UPDATE T_BLOG_USUARIO SET DS_LOGIN=?,DS_SENHA=?,NM_NOME=?,DS_TELEFONE=? WHERE ID_USUARIO=?");
		stmt.setString(1,u.getLogin());
		stmt.setString(2,u.getSenha());
		stmt.setString(3,u.getNome());
		stmt.setString(4, u.getTelefone());
		stmt.setInt(5,numero);
		stmt.executeUpdate();
		return "Usuario alterado com sucesso ";
	}
	
	
	public String apagarUsuario(int codigo)throws Exception{
		stmt=con.prepareStatement("DELETE FROM T_BLOG_USUARIO WHERE ID_USUARIO=?");
		stmt.setInt(1,codigo);
		stmt.executeQuery();
		
		return "Usuario apagado com sucesso";
	}
	
public Usuario retornarLogin(String u)throws Exception {
	stmt=con.prepareStatement("SELECT DS_LOGIN,DS_SENHA FROM T_BLOG_USUARIO WHERE DS_LOGIN LIKE ?");
	stmt.setString(1,u);
	rs=stmt.executeQuery();
	Usuario ui =new Usuario();
	if(rs.next()) {
		ui.setLogin(rs.getString("DS_LOGIN"));
		ui.setSenha(rs.getString("DS_SENHA"));
	}
	return ui;
}

public int gerarUsuario() throws SQLException{
	stmt=con.prepareStatement("SELECT ID_USUARIO max FROM T_BLOG_USUARIO");
	rs=stmt.executeQuery();
	int n=0;
	while(rs.next()) {
		n++;
	}
	System.out.println(n);
	return n+1;	
}


	public void fechar() throws Exception {
		stmt.close();
		con.close();
	}
}
