package br.com.sysbebidas.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sysbebidas.dao.CategoriaDAO;
import br.com.sysbebidas.domain.Categoria;
import br.com.sysbebidas.util.FacesUtil;

@ManagedBean
@ViewScoped
public class CategoriaBean {
	private Categoria categoriaCadastro;
	
	private List<Categoria> listaCategorias;
	
	private List<Categoria> listaCategoriasFiltrados;
	
	private String acao;
	private Long codigo;

	public Categoria getCategoriaCadastro() {

		return categoriaCadastro;
	}

	public void setCategoriaCadastro(Categoria categoriaCadastro) {
		this.categoriaCadastro = categoriaCadastro;
	}
	

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	
	public List<Categoria> getListaCategoriasFiltrados() {
		return listaCategoriasFiltrados;
	}

	public void setListaCategoriasFiltrados(List<Categoria> listaCategoriasFiltrados) {
		this.listaCategoriasFiltrados = listaCategoriasFiltrados;
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
		categoriaCadastro = new Categoria();
	}

	public void salvar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.salvar(categoriaCadastro);

			categoriaCadastro = new Categoria();

			FacesUtil.adicionarMsgInfo("Categoria salvo com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar incluir categoria:" + ex.getMessage());
		}
	}

	public void carregarPesquisa() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			listaCategorias = categoriaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar pesquisar categorias:" + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				CategoriaDAO categoriaDAO = new CategoriaDAO();
				categoriaCadastro = categoriaDAO.buscarPorCodigo(codigo);
			} else {
				categoriaCadastro = new Categoria();
			}
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar obter dados do categoria:" + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.excluir(categoriaCadastro);

			FacesUtil.adicionarMsgInfo("Categoria removido com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar remover categoria:" + ex.getMessage());
		}
	}

	public void editar() {
		try {
			CategoriaDAO categoriaDAO = new CategoriaDAO();
			categoriaDAO.editar(categoriaCadastro);

			FacesUtil.adicionarMsgInfo("Categoria editado com sucessso");
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar editar categoria:" + ex.getMessage());
		}
	}
}
