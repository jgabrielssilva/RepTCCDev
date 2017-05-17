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
		Cargo cargo = cargoDAO.buscarPorCodigo(5L);

		Funcionario fun1 = new Funcionario();
		fun1.setCpf("688.748.339-29");
		fun1.setNome("lala lala");
		fun1.setSenha("en5897799");
		
		fun1.setCargo(cargo);
		

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.salvar(fun1);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO dao = new FuncionarioDAO();

		List<Funcionario> funcionarios = dao.listar();

		System.out.println(funcionarios);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionarioDAO dao = new FuncionarioDAO();

		Funcionario fun1 = dao.buscarPorCodigo(2L);


		System.out.println(fun1);

	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario fun = dao.buscarPorCodigo(7L);

		dao.excluir(fun);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario fun = dao.buscarPorCodigo(5L);
		
		fun.setCpf("444.444.444-44");
	
		CargoDAO cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscarPorCodigo(9L);
		fun.setCargo(cargo);
	
		fun.setNome("PAULO MIRANDA");
		fun.setSenha("for44fqqqqq");
		
		dao.editar(fun);
	}
	
}
