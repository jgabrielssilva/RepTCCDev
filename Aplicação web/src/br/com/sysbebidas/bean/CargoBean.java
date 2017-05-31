package br.com.sysbebidas.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.sysbebidas.dao.CargoDAO;
import br.com.sysbebidas.dao.DepartamentoDAO;
import br.com.sysbebidas.domain.Cargo;
import br.com.sysbebidas.domain.Departamento;
import br.com.sysbebidas.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CargoBean {
	private Cargo cargoCadastro;

	private List<Cargo> listaCargos;

	private List<Cargo> listaCargosFiltrados;

	private String acao;
	private Long codigo;

	private List<Departamento> listaDepartamentos;

	public Cargo getCargoCadastro() {

		return cargoCadastro;
	}

	public void setCargoCadastro(Cargo cargoCadastro) {
		this.cargoCadastro = cargoCadastro;
	}

	public List<Cargo> getListaCargos() {
		return listaCargos;
	}

	public void setListaCargos(List<Cargo> listaCargos) {
		this.listaCargos = listaCargos;
	}

	public List<Cargo> getListaCargosFiltrados() {
		return listaCargosFiltrados;
	}

	public void setListaCargosFiltrados(List<Cargo> listaCargosFiltrados) {
		this.listaCargosFiltrados = listaCargosFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	public void novo() {
		cargoCadastro = new Cargo();
	}

	public void salvar() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.salvar(cargoCadastro);

			cargoCadastro = new Cargo();

			FacesUtil.adicionarMsgInfo("Cargo salvo com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir cargo" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			listaCargos = cargoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar pesquisar cargo" + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				CargoDAO cargoDAO = new CargoDAO();
				cargoCadastro = cargoDAO.buscarPorCodigo(codigo);
			} else {
				cargoCadastro = new Cargo();
			}

			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			listaDepartamentos = departamentoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter dados do cargo" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.excluir(cargoCadastro);

			FacesUtil.adicionarMsgInfo("Cargo removido com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover cargo" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			CargoDAO cargoDAO = new CargoDAO();
			cargoDAO.editar(cargoCadastro);

			FacesUtil.adicionarMsgInfo("Cargo editado com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar editar cargo" + ex.getMessage());
		}
	}
}