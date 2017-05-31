package br.com.sysbebidas.test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.BebidaDAO;
import br.com.sysbebidas.dao.CategoriaDAO;
import br.com.sysbebidas.dao.FabricanteDAO;
import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.domain.Categoria;
import br.com.sysbebidas.domain.Fabricante;

public class BebidaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscarPorCodigo(1L);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);

		Bebida bebida = new Bebida();
		bebida.setDescricao("TesteBebidaSalvar");
		bebida.setPreco(new BigDecimal(1));
		bebida.setQuantidade(1);
		bebida.setCategoria(categoria);
		bebida.setFabricante(fabricante);

		BebidaDAO bebidaDAO = new BebidaDAO();
		bebidaDAO.salvar(bebida);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(1L);

		System.out.println(bebida);
	}

	@Test
	@Ignore
	public void listar() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		List<Bebida> listabebidas = bebidaDAO.listar();

		System.out.println(listabebidas);
	}

	@Test
	@Ignore
	public void excluir() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(1L);

		bebidaDAO.excluir(bebida);
	}

	@Test
	@Ignore
	public void editar() {
		BebidaDAO bebidaDAO = new BebidaDAO();

		Bebida bebida = bebidaDAO.buscarPorCodigo(1L);

		bebida.setDescricao("TesteBebidaEditar");
		bebida.setPreco(new BigDecimal(1));
		bebida.setQuantidade(1);

		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscarPorCodigo(1L);
		bebida.setCategoria(categoria);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		bebida.setFabricante(fabricante);

		bebidaDAO.editar(bebida);
	}
}
