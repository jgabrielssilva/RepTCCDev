package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.CategoriaDAO;
import br.com.sysbebidas.domain.Categoria;

public class CategoriaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Categoria categoria = new Categoria();
		categoria.setDescricao("TesteCategoriaSalvar");

		CategoriaDAO dao = new CategoriaDAO();
		dao.salvar(categoria);
	}

	@Test
	@Ignore
	public void listar() {
		CategoriaDAO dao = new CategoriaDAO();

		List<Categoria> listacategorias = dao.listar();

		System.out.println(listacategorias);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		CategoriaDAO dao = new CategoriaDAO();

		Categoria categoria = dao.buscarPorCodigo(1L);

		System.out.println(categoria);
	}

	@Test
	@Ignore
	public void excluir() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria categoria = dao.buscarPorCodigo(1L);

		dao.excluir(categoria);
	}

	@Test
	@Ignore
	public void editar() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscarPorCodigo(1L);
		categoria.setDescricao("TesteCategoriaEditar");

		categoriaDAO.editar(categoria);
	}
}

