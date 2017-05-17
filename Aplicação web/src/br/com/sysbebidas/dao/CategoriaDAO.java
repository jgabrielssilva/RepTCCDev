package br.com.sysbebidas.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sysbebidas.domain.Categoria;
import br.com.sysbebidas.util.HibernateUtil;

public class CategoriaDAO {
	
	public void salvar(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(categoria);
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

	public List<Categoria> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Categoria> categorias = null;

		try {
			Query consulta = sessao.getNamedQuery("Categoria.listar");
			categorias = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return categorias;
	}
	
	public Categoria buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Categoria categoria = null;

		try {
			Query consulta = sessao.getNamedQuery("Categoria.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			categoria = (Categoria) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return categoria;
	}
	
	public void excluir(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(categoria);
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
	
	public void editar(Categoria categoria) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(categoria);
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
}

