package br.com.fiap.TO;

public enum TipoPagamento {
DINHEIRO("Dinheiro"),CART�O("Cart�o");
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
