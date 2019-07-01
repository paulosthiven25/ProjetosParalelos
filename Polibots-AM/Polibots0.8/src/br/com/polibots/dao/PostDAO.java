package br.com.polibots.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.polibots.beans.Post;
import br.com.polibots.beans.Usuario;
import br.com.polibots.conexao.Conexao;

public class PostDAO {
private Connection con;
private PreparedStatement stmt;
private ResultSet rs;

public PostDAO()throws Exception {
	con= Conexao.abrirConexao();
}

public String cadastrarPost(Post p)throws Exception {
	stmt=con.prepareStatement("INSERT INTO T_BLOG_POST (ID_POST,ID_USUARIO,DS_TITULO,DS_TEXTO,DT_CRIACAO,DS_BANNER) VALUES (?,?,?,?,TO_DATE(SYSDATE,'DD/MM/YYYY'),?)");
	stmt.setInt(1, p.getId());
	stmt.setInt(2, p.getAutor().getId());
	stmt.setString(3,p.getTitulo());
	stmt.setString(4,p.getTexto());
	stmt.setString(5,p.getBanner());
	
	stmt.executeUpdate();
	
	return "Post cadastrado com sucesso";
}
//o metodo funciona mas ele fica retornando null no campo DS_BANNER
public List<Post> consultarPostNome(String nome)throws Exception {
	List<Post>Posts = new ArrayList<Post>();
	stmt=con.prepareStatement("SELECT P.DS_TITULO,P.DS_TEXTO,P.DT_CRIACAO,P.DS_BANNER,U.NM_NOME FROM T_BLOG_POST P INNER JOIN T_BLOG_USUARIO U  USING(ID_USUARIO) WHERE P.DS_TITULO LIKE ?");
	stmt.setString(1,nome);
	rs=stmt.executeQuery();
	
	while(rs.next()) {
	Posts.add(new Post(
			    rs.getString("DS_TITULO"),
				rs.getString("DS_TEXTO"),
				rs.getString("DT_CRIACAO"),
				rs.getString("DS_BANNER"),
				new Usuario(
					rs.getString("NM_NOME")
				)));
			

	}
	for(Post obj : Posts) {System.out.println("Descricao do banner: "+ obj.getBanner());}
	rs.close();
	this.fechar();
	return Posts;
}

public String alterarPost(int codigo,Post p)throws Exception{
	stmt=con.prepareStatement("UPDATE T_BLOG_POST SET DS_TITULO=?,DS_TEXTO=?,DS_BANNER=? WHERE ID_POST=?");
	stmt.setString(1,p.getTitulo());
	stmt.setString(2,p.getTexto());
	stmt.setString(3,p.getBanner());
	stmt.setInt(4,codigo );
	stmt.executeQuery();
	
	return "Alterações feitas com sucesso";
}

public String apagarPost(int codigo)throws Exception{
	stmt=con.prepareStatement("DELETE FROM T_BLOG_POST WHERE ID_POST=?");
	stmt.setInt(1,codigo);
	stmt.executeQuery();
	
	return "Post apagado com sucesso";
}


public void fechar() throws Exception {
	stmt.close();
	con.close();
}


}
