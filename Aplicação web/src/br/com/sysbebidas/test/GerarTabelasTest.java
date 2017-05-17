package br.com.sysbebidas.test;

import org.junit.Test;

import br.com.sysbebidas.util.HibernateUtil;

public class GerarTabelasTest {
	
	@Test
	public void gerar(){
		HibernateUtil.getSessionFactory();	
		HibernateUtil.getSessionFactory().close();
	}

}
