package br.com.sysbebidas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.domain.Item;
import br.com.sysbebidas.domain.Venda;
import br.com.sysbebidas.filter.VendaFilter;
import br.com.sysbebidas.util.HibernateUtil;

public class VendaDAO {

	public Long salvar(Venda venda, List<Item> itens) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		Long codigo = null;
		
		try {
			transacao = sessao.beginTransaction();
			codigo = (Long) sessao.save(venda);
			
			for(int posicao = 0; posicao < itens.size(); posicao++){
				Item item = itens.get(posicao);
				item.setVenda(venda);
				
				sessao.save(item);
				
				Bebida bebida = item.getBebida();
				int quantidade = bebida.getQuantidade() - item.getQuantidade();
				if(quantidade >= 0){
					bebida.setQuantidade(quantidade);
					sessao.update(bebida);
				} else{
					throw new RuntimeException(" Quantidade insuficiente em estoque");
				}	
			     
			}
			
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
		return codigo;
	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> vendas = null;

		try {
			Query consulta = sessao.getNamedQuery("Venda.listar");
			vendas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return vendas;
	}

	public Venda buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;

		try {
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			venda = (Venda) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return venda;
	}

	public void excluir(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(venda);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}

	public void editar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(venda);
			transacao.commit();
		} catch (RuntimeException ex) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw ex;
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> buscar(VendaFilter filtro) {
		List<Venda> vendas = null;

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT venda FROM Venda venda ");
		
		if(filtro.getDataInicial() != null && filtro.getDataFinal() != null){
			sql.append("WHERE venda.horario BETWEEN :dataInicial AND :dataFinal ");
		}
		
		sql.append("ORDER BY venda.horario ");
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		try {
			Query consulta = sessao.createQuery(sql.toString()); 
			if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
				consulta.setDate("dataInicial", filtro.getDataInicial());
				consulta.setDate("dataFinal", filtro.getDataFinal());
			}
			
			vendas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return vendas;
	}
}

