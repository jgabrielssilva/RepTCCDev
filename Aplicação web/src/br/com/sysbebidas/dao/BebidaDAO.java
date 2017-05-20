package br.com.sysbebidas.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.sysbebidas.domain.Bebida;
import br.com.sysbebidas.util.HibernateUtil;

public class BebidaDAO {

	public void salvar(Bebida bebida) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(bebida);
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
	public List<Bebida> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Bebida> bebidas = null;

		try {
			Query consulta = sessao.getNamedQuery("Bebida.listar");
			bebidas = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return bebidas;
	}

	public Bebida buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Bebida bebida = null;

		try {
			Query consulta = sessao.getNamedQuery("Bebida.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			bebida = (Bebida) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return bebida;
	}

	public void excluir(Bebida bebida) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(bebida);
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

	public void editar(Bebida bebida) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(bebida);
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
