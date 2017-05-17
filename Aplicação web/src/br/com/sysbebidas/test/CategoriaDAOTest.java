package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

import br.com.sysbebidas.dao.CategoriaDAO;
import br.com.sysbebidas.domain.Categoria;

public class CategoriaDAOTest {
	
	@Test
    @Ignore
	public void salvar(){
		
		Categoria cat81 = new Categoria();
		cat81.setDescricao("refrigerantes");
		

		CategoriaDAO dao = new CategoriaDAO();
		dao.salvar(cat81);

	}
		
	@Test
	@Ignore
	public void listar() {
		CategoriaDAO dao = new CategoriaDAO();

		List<Categoria> categorias = dao.listar();

		System.out.println(categorias);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		CategoriaDAO dao = new CategoriaDAO();

		Categoria cat1 = dao.buscarPorCodigo(9L);


		System.out.println(cat1);

	}

	@Test
	@Ignore
	public void excluir() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria cat = dao.buscarPorCodigo(14L);

		dao.excluir(cat);
	}

	@Test
	@Ignore
	public void editar() {
		CategoriaDAO dao = new CategoriaDAO();
		Categoria cat = dao.buscarPorCodigo(12L);
		cat.setDescricao("MOTOROLA");
		
		dao.editar(cat);
	}
}


