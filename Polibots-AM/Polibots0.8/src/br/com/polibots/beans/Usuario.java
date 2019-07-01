package br.com.polibots.beans;

public class Usuario implements Comparable<Usuario>{
	private int id;
	private String login;
	private String senha;
	private int numero;
	private String nome;
	private String telefone;
	
	public int compareTo(Usuario outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public Usuario() {
	}
	
	public Usuario(String nome) {
		this.nome = nome;
	}
	
	
	public Usuario(int id) {
		this.id = id;
	}
	
	
	
	public Usuario( String login, String senha, int numero, String nome, String telefone) {
		super();
		
		this.login = login;
		this.senha = senha;
		this.numero = numero;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	
	
	public Usuario( String login, String senha,String nome, String telefone) {
		super();
		
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.telefone = telefone;
	}
	public Usuario( String login, String senha) {
		super();
		
		this.login = login;
		this.senha = senha;
	}
	public Usuario(int id, String login, String senha, int tipo) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.numero = tipo;
	}

	public Usuario(int id, String login, String senha, int numero, String nome, String telefone) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.numero = numero;
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
