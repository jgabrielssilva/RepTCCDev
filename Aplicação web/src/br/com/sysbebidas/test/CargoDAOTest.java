package br.com.sysbebidas.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sysbebidas.dao.CargoDAO;
import br.com.sysbebidas.dao.DepartamentoDAO;
import br.com.sysbebidas.domain.Cargo;
import br.com.sysbebidas.domain.Departamento;

public class CargoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento departamento = departamentoDAO.buscarPorCodigo(1L);

		Cargo cargo = new Cargo();
		cargo.setDescricao("TesteCargoSalvar");
		cargo.setDepartamento(departamento);

		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.salvar(cargo);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		CargoDAO cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscarPorCodigo(1L);

		System.out.println(cargo);
	}

	@Test
	@Ignore
	public void listar() {
		CargoDAO cargoDAO = new CargoDAO();
		List<Cargo> listacargos = cargoDAO.listar();

		System.out.println(listacargos);
	}

	@Test
	@Ignore
	public void excluir() {
		CargoDAO cargoDAO = new CargoDAO();
		Cargo cargo = cargoDAO.buscarPorCodigo(1L);

		cargoDAO.excluir(cargo);
	}

	@Test
	@Ignore
	public void editar() {
		CargoDAO cargoDAO = new CargoDAO();

		Cargo cargo = cargoDAO.buscarPorCodigo(1L);

		cargo.setDescricao("TesteCargoEditar");

		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		Departamento departamento = departamentoDAO.buscarPorCodigo(1L);
		cargo.setDepartamento(departamento);

		cargoDAO.editar(cargo);
	}
}
