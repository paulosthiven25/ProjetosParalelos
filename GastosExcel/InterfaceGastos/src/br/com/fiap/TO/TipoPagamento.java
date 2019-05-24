package br.com.fiap.TO;

public enum TipoPagamento {
DINHEIRO("Dinheiro"),CARTÃO("Cartão");
private String desc;

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

private TipoPagamento(String desc) {
	this.desc = desc;
}


}
