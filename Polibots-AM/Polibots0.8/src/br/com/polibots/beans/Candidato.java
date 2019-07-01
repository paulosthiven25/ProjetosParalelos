package br.com.polibots.beans;

public class Candidato implements Comparable<Candidato>{
	private int id;
	private int numero;
	private String nome;
	private String informacoes;
	
	public int compareTo(Candidato outro) {
		return this.nome.compareTo(outro.nome);
	}
	
	public Candidato() {
	}

	public Candidato(int id, int numero, String nome, String informacoes) {
		super();
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.informacoes = informacoes;
	}
	
	public Candidato(int id) {
		super();
		this.id = id;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	
}
