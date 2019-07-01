package br.com.polibots.beans;



public class Votacao implements Comparable<Votacao> {
	private int id;
	private Usuario usuario;
	private Candidato candidato;
	private String data;
	
	public int compareTo(Votacao outro) {
		return this.data.compareTo(outro.data);
	}
	
	public Votacao() {
		
	}

	public Votacao(int id, Usuario usuario, Candidato candidato, String data) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.candidato = candidato;
		this.data = data;
	}
	
	public Votacao(int id, Candidato candidato) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.candidato = candidato;
		
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

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
}
