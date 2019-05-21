package br.com.fiap.daoImpl;



import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.TypedQuery;



import br.com.fiap.dao.GastoDAO;
import br.com.fiap.entity.Gasto;

public class GastodaoImpl extends GenericDAOImpl<Gasto,Integer> implements GastoDAO{
	public GastodaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	
	
	
	

	@Override
	public List<Gasto> buscarPorMes(int mes) {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public List<Gasto> buscarTudo() {
		
		return em.createQuery("from Gasto g",Gasto.class).getResultList();
	}
	
}
