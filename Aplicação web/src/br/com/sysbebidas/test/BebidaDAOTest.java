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
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(9L);

		Bebida bebida = new Bebida();
		bebida.setDescricao("UMABEBIDA");
		bebida.setPreco(new BigDecimal(5000.99D));
		bebida.setQuantidade(2);
		bebida.setCategoria(categoria);
		bebida.setFabricante(fabricante);
		

		BebidaDAO bebidaDAO = new BebidaDAO();
		bebidaDAO.salvar(bebida);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(3L);

		System.out.println(bebida);
	}

	@Test
	@Ignore
	public void listar() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		List<Bebida> bebidas = bebidaDAO.listar();

		System.out.println(bebidas);
	}

	@Test
	@Ignore
	public void excluir() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(6L);

		bebidaDAO.excluir(bebida);
	}

	@Test
	@Ignore
	public void editar() {
		BebidaDAO bebidaDAO = new BebidaDAO();

		Bebida bebida = bebidaDAO.buscarPorCodigo(4L);

		bebida.setDescricao("TV");
		bebida.setPreco(new BigDecimal(3000.30D));
		bebida.setQuantidade(22);

		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.buscarPorCodigo(9L);
		bebida.setCategoria(categoria);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(9L);
		bebida.setFabricante(fabricante);

		bebidaDAO.editar(bebida);
	}
}
