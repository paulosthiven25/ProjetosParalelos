package br.com.fiap.dao;


import java.util.List;

import br.com.fiap.entity.Gasto;

public interface GastoDAO extends GenericDAO<Gasto,Integer> {
	public List<Gasto> buscarTudo();
	public List<Gasto> buscarPorMes(int mes);
	public void gerarPlanilha(List<Gasto> lista,String arquivo);
	
}
