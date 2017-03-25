package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() {

		Funcionario fun1 = new Funcionario();
		fun1.setCpf("339.553.113-83");
		fun1.setFuncao("MOTORISTA");
		fun1.setNome("JOSE CARLOS");
		fun1.setSenha("en9888888");
		

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
		fun.setFuncao("COORDENADOR");
		fun.setNome("PAULO MIRANDA");
		fun.setSenha("for44fqqqqq");
		
		dao.editar(fun);
	}
	
}
