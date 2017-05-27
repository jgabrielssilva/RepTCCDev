package br.com.sysbebidas.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.sysbebidas.dao.BebidaDAO;
import br.com.sysbebidas.dao.FuncionarioDAO;
import br.com.sysbebidas.dao.ItemDAO;
import br.com.sysbebidas.dao.VendaDAO;
import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.domain.Funcionario;
import br.com.sysbebidas.domain.Item;
import br.com.sysbebidas.domain.Venda;
import br.com.sysbebidas.filter.VendaFilter;
import br.com.sysbebidas.util.FacesUtil;

@ManagedBean
@ViewScoped
public class VendaBean {

	private List<Bebida> listaBebidas;

	private List<Bebida> listaBebidasFiltrados;
	
	private Venda vendaCadastro;
	
	private List<Item> listaItens;
	
	@ManagedProperty(value ="#{autenticacaoBean}")
	private AutenticacaoBean autenticacaoBean;
	
	private VendaFilter filtro;
	private List<Venda> listaVendasFiltrados;

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
	
	public VendaFilter getFiltro() {
		if(filtro == null){
			filtro = new VendaFilter();
		}
		return filtro;
	}
	
	public void setFiltro(VendaFilter filtro) {
		this.filtro = filtro;
	}
	
	
	public Venda getVendaCadastro() {
		if(vendaCadastro == null){
			vendaCadastro = new Venda();
			vendaCadastro.setValor(new BigDecimal("0.00"));
		}
		return vendaCadastro;
	}
	
	public void setVendaCadastro(Venda vendaCadastro) {
		this.vendaCadastro = vendaCadastro;
	}
	
	public List<Item> getListaItens() {
		if(listaItens == null){
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}
	
	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}
	
	public AutenticacaoBean getAutenticacaoBean() {
		return autenticacaoBean;
	}
	
	public void setAutenticacaoBean(AutenticacaoBean autenticacaoBean) {
		this.autenticacaoBean = autenticacaoBean;
	}
	
	public List<Venda> getListaVendasFiltrados() {
		return listaVendasFiltrados;
	}
	
	public void setListaVendasFiltrados(List<Venda> listaVendasFiltrados) {
		this.listaVendasFiltrados = listaVendasFiltrados;
	}
	
	public void carregarBebidas() {
		try {
			BebidaDAO bebidaDAO = new BebidaDAO();
			listaBebidas = bebidaDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar pesquisar bebida:" + ex.getMessage());
		}
	}
	
	
	
	
	
	public void adicionar(Bebida bebida) {
		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaItens.size() && posicaoEncontrada < 0; posicao++) {
			Item itemTemp = listaItens.get(posicao);

			if (itemTemp.getBebida().equals(bebida)) {
				posicaoEncontrada = posicao;
			}
		}

		Item item = new Item();
		item.setBebida(bebida);

		if (posicaoEncontrada < 0) {
			item.setQuantidade(1);
			item.setValor(bebida.getPreco());
			listaItens.add(item);
		} else {
			Item itemTemp = listaItens.get(posicaoEncontrada);
			item.setQuantidade(itemTemp.getQuantidade() + 1);
			item.setValor(bebida.getPreco().multiply(new BigDecimal(item.getQuantidade())));
			listaItens.set(posicaoEncontrada, item);

		}
		
		vendaCadastro.setValor(vendaCadastro.getValor().add(bebida.getPreco()));
	}
		
	public void remover(Item item) {
		int posicaoEncontrada = -1;

		for (int posicao = 0; posicao < listaItens.size() && posicaoEncontrada < 0; posicao++) {
			Item itemTemp = listaItens.get(posicao);

			if (itemTemp.getBebida().equals(item.getBebida())) {
				posicaoEncontrada = posicao;
			}
		}
		
		if(posicaoEncontrada > -1) {
			listaItens.remove(posicaoEncontrada);
			vendaCadastro.setValor(vendaCadastro.getValor().subtract(item.getValor()));
		}
	}
	
	public void carregarDadosVenda(){
		vendaCadastro.setHorario(new Date());
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(autenticacaoBean.getFuncionarioLogado().getCodigo());
		vendaCadastro.setFuncionario(funcionario);
		
	}
	
	public void salvar(){
		try {
			VendaDAO vendaDAO = new VendaDAO();
			
			Long codigoVenda = vendaDAO.salvar(vendaCadastro, listaItens);
			Venda vendaFK = vendaDAO.buscarPorCodigo(codigoVenda);
			
			for(Item item : listaItens){
				item.setVenda(vendaFK);
				
				ItemDAO itemDAO = new ItemDAO();
				itemDAO.salvar(item);
			}
			
			vendaCadastro = new Venda();
			vendaCadastro.setValor(new BigDecimal("0.00"));
			
			listaItens = new ArrayList<Item>();
			
			FacesUtil.adicionarMsgInfo("Venda salva com sucesso" );
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar salvar a venda:" + ex.getMessage());
		}
	}
	
	public void buscar(){
		try {
			VendaDAO vendaDAO = new VendaDAO();
			listaVendasFiltrados = vendaDAO.buscar(filtro);
			
			for(Venda venda : listaVendasFiltrados){
				System.out.println(venda);
			}
			
		} catch (RuntimeException ex) {
			FacesUtil.adicionarMsgErro("Erro ao tentar buscar venda:" + ex.getMessage());
		}
	}
}


