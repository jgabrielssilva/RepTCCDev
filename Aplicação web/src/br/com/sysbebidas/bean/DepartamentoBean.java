package br.com.sysbebidas.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sysbebidas.dao.DepartamentoDAO;
import br.com.sysbebidas.domain.Departamento;
import br.com.sysbebidas.util.FacesUtil;

@ManagedBean
@ViewScoped
public class DepartamentoBean {
	private Departamento departamentoCadastro;
	
	private List<Departamento> listaDepartamentos;
	
	private List<Departamento> listaDepartamentosFiltrados;
	
	private String acao;
	private Long codigo;

	public Departamento getDepartamentoCadastro() {

		return departamentoCadastro;
	}

	public void setDepartamentoCadastro(Departamento departamentoCadastro) {
		this.departamentoCadastro = departamentoCadastro;
	}
	

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	
	public List<Departamento> getListaDepartamentosFiltrados() {
		return listaDepartamentosFiltrados;
	}

	public void setListaDepartamentosFiltrados(List<Departamento> listaDepartamentosFiltrados) {
		this.listaDepartamentosFiltrados = listaDepartamentosFiltrados;
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
	
	
	
	
	public void novo() {
		departamentoCadastro = new Departamento();
	}

	public void salvar() {
		try {
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			departamentoDAO.salvar(departamentoCadastro);

			departamentoCadastro = new Departamento();

			FacesUtil.adicionarMsgInfo("Departamento salvo com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir departamento:" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			listaDepartamentos = departamentoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar pesquisar departamento:" + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				DepartamentoDAO departamentoDAO = new DepartamentoDAO();
				departamentoCadastro = departamentoDAO.buscarPorCodigo(codigo);
			} else {
				departamentoCadastro = new Departamento();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter dados do departamento:" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			departamentoDAO.excluir(departamentoCadastro);

			FacesUtil.adicionarMsgInfo("Departamento removido com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover departamento:" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			DepartamentoDAO departamentoDAO = new DepartamentoDAO();
			departamentoDAO.editar(departamentoCadastro);

			FacesUtil.adicionarMsgInfo("Departamento editado com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar editar departamento:" + ex.getMessage());
		}
	}
}