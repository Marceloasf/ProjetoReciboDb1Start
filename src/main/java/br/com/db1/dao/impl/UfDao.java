package br.com.db1.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.db1.dao.DAO;
import br.com.db1.model.Uf;

public class UfDao implements DAO<Uf> {

	private EntityManager manager;
	
	@Inject
	public UfDao(EntityManager manager) {
		this.manager = manager;
}
	@SuppressWarnings("unchecked")
	public List<Uf> findAll() {
		return manager.createQuery("from uf").getResultList();
	}

	public Uf findById(Integer id) {
		Query q = manager.createQuery("from uf where id = :pid");
		q.setParameter("pid", id);
		return (Uf) q.getSingleResult();
	}

	public List<Uf> findByName(String name) {
		Query q = manager.createQuery("from uf where nome = :pNome");
		q.setParameter("pNome", name);
		return q.getResultList();
	}

	public boolean save(Uf uf) {
		manager.persist(uf);
		return true;
		
	}

	public boolean delete(Integer id) {
		Uf uf = findById(id);
		manager.remove(uf);
		return true;
	}

}
