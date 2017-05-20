package br.com.sysbebidas.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.sysbebidas.dao.BebidaDAO;
import br.com.sysbebidas.dao.FabricanteDAO;
import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.domain.Fabricante;
import br.com.sysbebidas.util.FacesUtil;
import br.com.sysbebidas.domain.Categoria;
import br.com.sysbebidas.dao.CategoriaDAO;

@ManagedBean
@ViewScoped
public class BebidaBean {
	private Bebida bebidaCadastro;

	private List<Bebida> listaBebidas;

	private List<Bebida> listaBebidasFiltrados;

	private String acao;
	private Long codigo;

	private List<Fabricante> listaFabricantes;
	private List<Categoria> listaCategorias;

	public Bebida getBebidaCadastro() {

		return bebidaCadastro;
	}

	public void setBebidaCadastro(Bebida bebidaCadastro) {
		this.bebidaCadastro = bebidaCadastro;
	}

	public List<Bebida> getListaBebidas() {
		return listaBebidas;
	}

	public void setListaBebidas(List<Bebida> listaBebidas) {
		this.listaBebidas = listaBebidas;
	}

	public List<Bebida> getListaBebidasFiltrados() {
		return listaBebidasFiltrados;
	}

	public void setListaBebidasFiltrados(List<Bebida> listaBebidasFiltrados) {
		this.listaBebidasFiltrados = listaBebidasFiltrados;
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

	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}

	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}
	
	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}
	
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public void novo() {
		bebidaCadastro = new Bebida();
	}

	public void salvar() {
		try {
			BebidaDAO bebidaDAO = new BebidaDAO();
			bebidaDAO.salvar(bebidaCadastro);

			bebidaCadastro = new Bebida();

			FacesUtil.adicionarMsgInfo("Bebida salvo com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir bebida:" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			BebidaDAO bebidaDAO = new BebidaDAO();
			listaBebidas = bebidaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar pesquisar bebida:" + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				BebidaDAO bebidaDAO = new BebidaDAO();
				bebidaCadastro = bebidaDAO.buscarPorCodigo(codigo);
			} else {
				bebidaCadastro = new Bebida();
			}

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();
			
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			listaCategorias = categoriaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter dados do bebida:" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			BebidaDAO bebidaDAO = new BebidaDAO();
			bebidaDAO.excluir(bebidaCadastro);

			FacesUtil.adicionarMsgInfo("Bebida removido com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover bebida:" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			BebidaDAO bebidaDAO = new BebidaDAO();
			bebidaDAO.editar(bebidaCadastro);

			FacesUtil.adicionarMsgInfo("Bebida editado com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar editar bebida:" + ex.getMessage());
		}
	}
}