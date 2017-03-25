package br.com.drogaria.test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;
import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemDAOTest {
	
	@Test
	@Ignore
	public void salvar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(4L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(5L);
		
		
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(8);
		item.setValor(new BigDecimal(5335.92D));
		item.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item> vendas = itemDAO.listar();

		System.out.println(vendas);
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(2L);

		System.out.println(item);
	}
	
	@Test
	@Ignore
	public void excluir() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

		itemDAO.excluir(item);
	}
	
	@Test
	@Ignore
	public void editar() {
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(4L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(5L);
		
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(2L);

        item.setProduto(produto);
        item.setQuantidade(10);
        item.setValor(new BigDecimal(6669.09D));
        item.setVenda(venda);
        

		itemDAO.editar(item);
	}
}
