package br.com.fiap.TO;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class GastoTO {
    private int codigo;
	
	private Calendar dataGasto;
	
	
	private String descricao;
	
	
	private TipoGasto tipoGasto;
	

	private String localGasto;
	
	
	private float valor;
	
	private TipoPagamento tipoPagamento;
	
	


	public GastoTO(Calendar dataGasto, String descricao, TipoGasto tipoGasto, String localGasto, float valor,TipoPagamento tipoPagamento) {
		super();
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
		this.tipoPagamento= tipoPagamento;
	}


	public GastoTO(int codigo, Calendar dataGasto, String descricao, TipoGasto tipoGasto, String localGasto, float valor,TipoPagamento tipoPagamento) {
		super();
		this.codigo = codigo;
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
		this.tipoPagamento= tipoPagamento;
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


	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}


	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}





	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}


	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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
