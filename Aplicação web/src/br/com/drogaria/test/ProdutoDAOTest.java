package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;


public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(11L);

		Produto produto = new Produto();
		produto.setDescricao("Mac");
		produto.setPreco(new BigDecimal(5000.99D));
		produto.setQuantidade(2);
		produto.setFabricante(fabricante);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);

		System.out.println(produto);
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtos = produtoDAO.listar();

		System.out.println(produtos);
	}

	@Test
	@Ignore
	public void excluir() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(6L);

		produtoDAO.excluir(produto);
	}

	@Test
	@Ignore
	public void editar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();

		Produto produto = produtoDAO.buscarPorCodigo(4L);

		produto.setDescricao("TV");
		produto.setPreco(new BigDecimal(3000.30D));
		produto.setQuantidade(22);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(9L);
		produto.setFabricante(fabricante);

		produtoDAO.editar(produto);
	}
}
