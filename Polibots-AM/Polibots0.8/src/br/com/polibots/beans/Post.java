package br.com.polibots.beans;




public class Post implements Comparable<Post> {
	private int id;
	private String titulo;
	private String texto;
	private String criacao;
	private String banner;
	private String resumo;
	private Usuario autor;
	private Comentario comentarios;
	
	public int compareTo(Post outro) {
		return this.criacao.compareTo(outro.criacao);
	}

	public Post(int id) {
		super();
		this.id = id;
	}

	public Post() {
		
	}
	
	public Post(int id, String titulo, String texto, String criacao, String banner, String resumo, Usuario autor) {
		
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.criacao = criacao;
		this.banner = banner;
		this.resumo = resumo;
		this.autor = autor;
	
	}
	
	
public Post(String titulo, String texto, String criacao, String banner, String resumo, Usuario autor) {
		
		
		this.titulo = titulo;
		this.texto = texto;
		this.criacao = criacao;
		this.banner = banner;
		this.resumo = resumo;
		this.autor = autor;
	
	}

public Post(String titulo, String texto, String criacao, String banner,Usuario autor) {
	
	
	this.titulo = titulo;
	this.texto = texto;
	this.criacao = criacao;
	this.banner = banner;
	this.autor = autor;
	
	

}

	
public Post(int id, String titulo, String texto,String banner, String resumo) {
		
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.banner = banner;
		this.resumo = resumo;
		
	
	}

public Post(int id,Usuario autor, String titulo, String texto,String resumo, String banner) {
	
	this.id = id;
	this.titulo = titulo;
	this.texto = texto;
	this.banner = banner;
	this.resumo = resumo;
	this.autor = autor;

}

public Post( String titulo, String texto,String banner) {
	
	
	this.titulo = titulo;
	this.texto = texto;
	this.banner = banner;
	
}	
	
	
	public Post(int id, String titulo, String texto, String criacao, String banner, String resumo, Usuario autor,
			Comentario comentarios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.criacao = criacao;
		this.banner = banner;
		this.resumo = resumo;
		this.autor = autor;
		this.comentarios = comentarios;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getCriacao() {
		return criacao;
	}
	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}
	public String getBanner() {
		return banner;
	}
	public void setBanner(String banner) {
		this.banner = banner;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Comentario getComentarios() {
		return comentarios;
	}

	public void setComentarios(Comentario comentarios) {
		this.comentarios = comentarios;
	}


}
