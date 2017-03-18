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

		Funcionario fun = new Funcionario();
		fun.setCpf("222.222.222-22");
		fun.setFuncao("ADMINISTRADORA");
		fun.setNome("BRUNA SILVA");
		fun.setSenha("fdg8888549489te");

		FuncionarioDAO dao = new FuncionarioDAO();

		dao.salvar(fun);
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

		Funcionario fun = dao.buscarPorCodigo(2L);

		System.out.println(fun);
	}

	@Test
	
	public void excluir() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario fun = dao.buscarPorCodigo(2L);

		dao.excluir(fun);
	}

	@Test
	@Ignore
	public void editar() {
		FuncionarioDAO dao = new FuncionarioDAO();
		Funcionario fun = dao.buscarPorCodigo(2L);
		
		fun.setCpf("333.333.333-33");
		fun.setFuncao("TESTE DE FUNCAO");
		fun.setNome("TESTE DE USUARIO");
		fun.setSenha("testedesenha");
		
		dao.editar(fun);
	}
	
}
