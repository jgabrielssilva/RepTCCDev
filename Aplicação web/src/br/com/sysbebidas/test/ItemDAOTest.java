package br.com.sysbebidas.test;

import java.math.BigDecimal;
import java.util.List;
import org.junit.Test;
import org.junit.Ignore;
import br.com.sysbebidas.dao.BebidaDAO;
import br.com.sysbebidas.dao.ItemDAO;
import br.com.sysbebidas.dao.VendaDAO;
import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.domain.Item;
import br.com.sysbebidas.domain.Venda;

public class ItemDAOTest {

	@Test
	@Ignore
	public void salvar() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);

		Item item = new Item();
		item.setBebida(bebida);
		item.setQuantidade(1);
		item.setValor(new BigDecimal(1));
		item.setVenda(venda);

		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
	}

	@Test
	@Ignore
	public void listar() {
		ItemDAO itemDAO = new ItemDAO();
		List<Item> listaitens = itemDAO.listar();

		System.out.println(listaitens);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

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
		BebidaDAO bebidaDAO = new BebidaDAO();
		Bebida bebida = bebidaDAO.buscarPorCodigo(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);

		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);

		item.setBebida(bebida);
		item.setQuantidade(1);
		item.setValor(new BigDecimal(1));
		item.setVenda(venda);

		itemDAO.editar(item);
	}
}
