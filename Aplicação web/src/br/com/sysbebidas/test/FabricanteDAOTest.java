package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.FabricanteDAO;
import br.com.sysbebidas.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("TesteFabricanteSalvar");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();

		List<Fabricante> listafabricantes = dao.listar();

		System.out.println(listafabricantes);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();

		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);

		System.out.println(fabricante);
	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);

		fabricanteDAO.excluir(fabricante);
	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		fabricante.setDescricao("TesteFabricanteEditar");

		fabricanteDAO.editar(fabricante);
	}
}

