package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_GASTOS")
@SequenceGenerator(name="gasto",sequenceName="SQ_T_GASTOS",allocationSize=1)

public class Gasto {
	@GeneratedValue(generator="gasto",strategy=GenerationType.SEQUENCE)
	@Id
	@Column(name="CD_GASTO")
    private int codigo;
	@Temporal(TemporalType.DATE)
	@Column(name="DT_GASTO",nullable=false)
	private Calendar dataGasto;
	public TipoGasto getTipoGasto() {
		return tipoGasto;
	}
	public void setTipoGasto(TipoGasto tipoGasto) {
		this.tipoGasto = tipoGasto;
	}
	public String getLocalGasto() {
		return localGasto;
	}
	public void setLocalGasto(String localGasto) {
		this.localGasto = localGasto;
	}
	@Column(name="DS_GASTO")
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TP_GASTO")
	private TipoGasto tipoGasto;
	
	@Column(name="DS_LOCAL_GASTO")
	private String localGasto;
	
	@Column(name="VL_GASTO",nullable=false)
	private float valor;
	@Enumerated(EnumType.STRING)
	@Column(name="DS_PAG_GASTO")
	private TipoPagamento tipoPagamento;
	
	
	
	
	
	
	
	
	
	
	public Gasto() {
		super();
	}
	public Gasto(Calendar dataGasto, String descricao, TipoGasto tipoGasto, String localGasto, float valor,
			TipoPagamento tipoPagamento) {
		super();
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
		this.tipoPagamento = tipoPagamento;
	}
	public Gasto(int codigo, Calendar dataGasto, String descricao, TipoGasto tipoGasto, String localGasto, float valor,
			TipoPagamento tipoPagamento) {
		super();
		this.codigo = codigo;
		this.dataGasto = dataGasto;
		this.descricao = descricao;
		this.tipoGasto = tipoGasto;
		this.localGasto = localGasto;
		this.valor = valor;
		this.tipoPagamento = tipoPagamento;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	
	
	
	

}
