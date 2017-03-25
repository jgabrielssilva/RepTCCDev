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
		
		Fabricante fab1 = new Fabricante();
		fab1.setDescricao("LENOVO");
		
		Fabricante fab2 = new Fabricante();
		fab2.setDescricao("SONY");
		
		Fabricante fab3 = new Fabricante();
		fab3.setDescricao("INTEL");
			
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fab1);
		dao.salvar(fab2);
		dao.salvar(fab3);
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

		Fabricante fab1 = dao.buscarPorCodigo(9L);


		System.out.println(fab1);

	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(14L);

		dao.excluir(fab);
	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(12L);
		fab.setDescricao("MOTOROLA");
		
		dao.editar(fab);
	}
}

