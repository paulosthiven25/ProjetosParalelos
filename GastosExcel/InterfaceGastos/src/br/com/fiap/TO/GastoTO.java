package br.com.fiap.TO;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GastoTO {
    private int codigo;
	
	private Calendar dataGasto;
	
	
	private String descricao;
	
	
	private String tipoGasto;
	

	private String localGasto;
	
	
	private float valor;
	
	


	public GastoTO(Calendar dataGasto, String descricao, String tipoGasto, String localGasto, float valor) {
		super();
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
	}


	public GastoTO(int codigo, Calendar dataGasto, String descricao, String tipoGasto, String localGasto, float valor) {
		super();
		this.codigo = codigo;
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
	}


	public GastoTO() {
		super();
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Calendar getDataGasto() {
		return dataGasto;
	}


	public void setDataGasto(Calendar dataGasto) {
		this.dataGasto = dataGasto;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipoGasto() {
		return tipoGasto;
	}


	public void setTipoGasto(String tipoGasto) {
		this.tipoGasto = tipoGasto;
	}


	public String getLocalGasto() {
		return localGasto;
	}


	public void setLocalGasto(String localGasto) {
		this.localGasto = localGasto;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	
	
	
}
