package br.com.fiap.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GastoDAO;
import br.com.fiap.daoImpl.GastodaoImpl;
import br.com.fiap.entity.Gasto;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteRaiz {

	public static void main(String[] args) {
		GastoDAO gdao;
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		gdao=new GastodaoImpl(em);
		
		try {
			List<Gasto> gastos = new ArrayList<>();
			gastos=gdao.buscarTudo();
			
			for(Gasto g:gastos) {
				System.out.println(g.getDataGasto()+"\n"+
			g.getDescricao()+"\n"+
						g.getValor()+"\n"+
			g.getTipoPagamento());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
