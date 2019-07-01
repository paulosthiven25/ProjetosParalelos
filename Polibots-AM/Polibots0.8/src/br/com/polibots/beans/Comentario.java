package br.com.polibots.beans;



public class Comentario implements Comparable<Comentario>{
	
	private int id;
	private Usuario usuario;
	private Post post;
	private String criacao;
	private String texto;
	
	public int compareTo(Comentario outro) {
		return this.criacao.compareTo(outro.criacao);
	}
	public Comentario(String texto) {
		super();
		this.texto = texto;
	}
	public Comentario() {
		super();
	}
	public Comentario(int id, Usuario usuario, Post post, String criacao, String texto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.post = post;
		this.criacao = criacao;
		this.texto = texto;
	}
	

	public Comentario(int id, Usuario usuario, Post post,String texto) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.post = post;
		
		this.texto = texto;
	}	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public String getCriacao() {
		return criacao;
	}
	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
}
