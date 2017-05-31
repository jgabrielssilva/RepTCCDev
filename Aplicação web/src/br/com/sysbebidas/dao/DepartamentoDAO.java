package br.com.sysbebidas.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.sysbebidas.domain.Departamento;
import br.com.sysbebidas.util.HibernateUtil;

public class DepartamentoDAO {

	public void salvar(Departamento departamento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(departamento);
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

	public List<Departamento> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Departamento> departamentos = null;

		try {
			Query consulta = sessao.getNamedQuery("Departamento.listar");
			departamentos = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return departamentos;
	}

	public Departamento buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Departamento departamento = null;

		try {
			Query consulta = sessao.getNamedQuery("Departamento.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			departamento = (Departamento) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			sessao.close();
		}
		return departamento;
	}

	public void excluir(Departamento departamento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.delete(departamento);
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

	public void editar(Departamento departamento) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(departamento);
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
