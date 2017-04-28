package br.com.drogaria.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.drogaria.dao.DepartamentoDAO;
import br.com.drogaria.domain.Departamento;

public class DepartamentoDAOTest {
	
	@Test
    @Ignore
	public void salvar(){
		
		Departamento dep1 = new Departamento();
		dep1.setDescricao("VINHO");
		
		Departamento dep2 = new Departamento();
		dep2.setDescricao("REFRIGERANTE");
		
		Departamento dep3 = new Departamento();
		dep3.setDescricao("CERVEJA");
			
		DepartamentoDAO dao = new DepartamentoDAO();
		dao.salvar(dep1);
		dao.salvar(dep2);
		dao.salvar(dep3);
	}
		
	@Test
	@Ignore
	public void listar() {
		DepartamentoDAO dao = new DepartamentoDAO();

		List<Departamento> departamentos = dao.listar();

		System.out.println(departamentos);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		DepartamentoDAO dao = new DepartamentoDAO();

		Departamento dep1 = dao.buscarPorCodigo(9L);


		System.out.println(dep1);

	}

	@Test
	@Ignore
	public void excluir() {
		DepartamentoDAO dao = new DepartamentoDAO();
		Departamento dep = dao.buscarPorCodigo(14L);

		dao.excluir(dep);
	}

	@Test
	@Ignore
	public void editar() {
		DepartamentoDAO dao = new DepartamentoDAO();
		Departamento dep = dao.buscarPorCodigo(12L);
		dep.setDescricao("SUCO");
		
		dao.editar(dep);
	}
}



