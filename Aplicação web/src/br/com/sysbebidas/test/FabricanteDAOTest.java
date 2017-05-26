package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.sysbebidas.dao.FabricanteDAO;
import br.com.sysbebidas.dao.FuncionarioDAO;
import br.com.sysbebidas.domain.Fabricante;
import br.com.sysbebidas.domain.Funcionario;

public class FabricanteDAOTest {
	
	@Test
    @Ignore
	public void salvar(){
		
		Fabricante fab81 = new Fabricante();
		fab81.setDescricao("LENOVO");
		
		Fabricante fab82 = new Fabricante();
		fab82.setDescricao("SONY");
		
		Fabricante fab83 = new Fabricante();
		fab83.setDescricao("INTEL");
			
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fab81);
		dao.salvar(fab82);
		dao.salvar(fab83);
	}
		
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();

		List<Fabricante> fabricantes = dao.listar();

		System.out.println(fabricantes);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante fab1 = dao.buscarPorCodigo(9L);


		System.out.println(fab1);

	}

	@Test
	@Ignore
	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(14L);

		dao.excluir(fab);
	}

	@Test
	@Ignore
	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fab = dao.buscarPorCodigo(12L);
		fab.setDescricao("MOTOROLA");
		
		dao.editar(fab);
	}
	
	@Test
	@Ignore
	public void autenticar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario funcionario = funcionarioDAO.autenticar("181.012.107-84", "gabriel");
		
		System.out.println("Funcionario:" + funcionario);
	}
}

