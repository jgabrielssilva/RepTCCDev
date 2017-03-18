package br.com.drogaria.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Fabricante fab3 = new Fabricante();
		fab3.setDescricao("DESCC");
		
		Fabricante fab4 = new Fabricante();
		fab4.setDescricao("DESCD");
			
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fab3);
		dao.salvar(fab4);
	}
		
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();

		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fab1 = dao.buscarPorCodigo(3L);
		Fabricante fab2 = dao.buscarPorCodigo(7L);

		System.out.println(fab1);
		System.out.println(fab2);
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(5L);

		dao.excluir(fab);
	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(6L);
		fab.setDescricao("DESCC");
		
		dao.editar(fab);
	}
}

