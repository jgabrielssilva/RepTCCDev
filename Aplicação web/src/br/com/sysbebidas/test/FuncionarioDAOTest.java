package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.CargoDAO;
import br.com.sysbebidas.dao.FuncionarioDAO;
import br.com.sysbebidas.domain.Cargo;
import br.com.sysbebidas.domain.Funcionario;

public class FuncionarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		CargoDAO cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscarPorCodigo(1L);

		Funcionario funcionario = new Funcionario();
		funcionario.setCpf("111.111.111-11");
		funcionario.setNome("TesteFuncionarioSalvar");
		funcionario.setSenha("111111");
		funcionario.setCargo(cargo);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		List<Funcionario> listafuncionarios = funcionarioDAO.listar();

		System.out.println(listafuncionarios);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);

		System.out.println(funcionario);
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(7L);

		funcionarioDAO.excluir(funcionario);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);

		funcionario.setCpf("933.172.694-56");
		CargoDAO cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscarPorCodigo(1L);
		funcionario.setCargo(cargo);
		funcionario.setNome("TesteFuncionarioEditar");
		funcionario.setSenha("111111");

		funcionarioDAO.editar(funcionario);
	}

	@Test
	@Ignore
	public void autenticar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		Funcionario funcionario = funcionarioDAO.autenticar("181.012.107-84", "52c69e3a57331081823331c4e69d3f2e");

		System.out.println("Funcionario:" + funcionario);
	}
}
