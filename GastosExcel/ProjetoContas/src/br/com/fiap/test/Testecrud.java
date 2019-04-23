package br.com.fiap.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.filechooser.FileSystemView;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.fiap.dao.GastoDAO;
import br.com.fiap.daoImpl.GastodaoImpl;
import br.com.fiap.entity.Gasto;
import br.com.fiap.entity.TipoPagamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

class Testecrud {
	private static GastoDAO gdao;
	private Gasto gasto1;
	
	
	/*@BeforeEach
	public void cadastrar() {
		 gasto1= new Gasto(new GregorianCalendar(2010,Calendar.APRIL,27),"transporte",120,TipoPagamento.CARTAO);
		
		try {
			//escoladao.cadastrar(escola);
			gdao.cadastrar(gasto1);
			gdao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Deu pau!!");
			assertNotEquals(gasto1.getCodigo(),0);
			
		}
	}*/
	
	@BeforeAll
	public static void inicializar() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		gdao=new GastodaoImpl(em);
		
		
		
	}

	
	/*public void cadastro() {
		
		
		try {
			//escoladao.cadastrar(escola);
			gdao.cadastrar(gasto1);
			gdao.commit();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Deu pau!!");
			assertNotEquals(gasto1.getCodigo(),0);
			
		}
	}*/
	@Test
	public void listarTudo() {
		
		try {
			List<Gasto> g1 = new ArrayList<>();
			g1=gdao.buscarTudo();
			assertEquals(g1.size(),13);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("PAO");
		}
	}
	@Test
	public void gerarPlanilha() {
		
		List<Gasto> g1 = new ArrayList<>();
		g1=gdao.buscarTudo();
		
		try {
			gdao.gerarPlanilha(g1,"D:/planilha1.xlsx");
		} catch (Exception e) {
		e.printStackTrace();
		}
}
	
}
