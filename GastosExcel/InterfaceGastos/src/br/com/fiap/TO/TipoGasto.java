package br.com.fiap.TO;

public enum TipoGasto {
	
ALIMENTA��O("Alimenta��o"),TRANSPORTE("Transporte"),LAZER("Lazer"),HIGIENE("Higiene");
private String desc;

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

private TipoGasto(String desc) {
	this.desc = desc;
}
	
	
}
