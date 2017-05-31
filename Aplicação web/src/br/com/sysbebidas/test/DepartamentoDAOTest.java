package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.DepartamentoDAO;
import br.com.sysbebidas.domain.Departamento;

public class DepartamentoDAOTest {
	
	@Test
    @Ignore
	public void salvar(){
		Departamento departamento1 = new Departamento();
		departamento1.setDescricao("TesteDepartamentoSalvar1");
		
		Departamento departamento2 = new Departamento();
		departamento2.setDescricao("TesteDepartamentoSalvar2");
		
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		departamentoDAO.salvar(departamento1);
		departamentoDAO.salvar(departamento2);
	}
		
	@Test
	@Ignore
	public void listar() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();

		List<Departamento> listadepartamentos = departamentoDAO.listar();

		System.out.println(listadepartamentos);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();

		Departamento departamento = departamentoDAO.buscarPorCodigo(1L);


		System.out.println(departamento);
	}

	@Test
	@Ignore
	public void excluir() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento departamento = departamentoDAO.buscarPorCodigo(1L);

		departamentoDAO.excluir(departamento);
	}

	@Test
	@Ignore
	public void editar() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento departamento = departamentoDAO.buscarPorCodigo(1L);
		departamento.setDescricao("TesteDepartamentoEditar");
		
		departamentoDAO.editar(departamento);
	}
}



