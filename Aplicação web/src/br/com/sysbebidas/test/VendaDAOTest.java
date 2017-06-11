package br.com.sysbebidas.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.FuncionarioDAO;
import br.com.sysbebidas.dao.VendaDAO;
import br.com.sysbebidas.domain.Funcionario;
import br.com.sysbebidas.domain.Venda;
import br.com.sysbebidas.filter.VendaFilter;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(18L);

		Venda venda = new Venda();
		venda.setFuncionario(funcionario);
		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(1));

		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.salvar(venda, null);
	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> listavendas = vendaDAO.listar();

		System.out.println(listavendas);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);

		System.out.println(venda);
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);

		vendaDAO.excluir(venda);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(1L);

		venda.setHorario(new Date());
		venda.setValor(new BigDecimal(1));
		venda.setFuncionario(funcionario);

		vendaDAO.editar(venda);
	}

	@Test
	@Ignore
	public void pesquisar() throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		VendaFilter filtro = new VendaFilter();
		filtro.setDataInicial(formato.parse("20/05/2017"));
		filtro.setDataFinal(formato.parse("26/05/2017"));

		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> vendas = vendaDAO.pesquisar(filtro);

		for (Venda venda : vendas) {
			System.out.println(venda);
		}
	}
}
