

package br.com.db1.dao.impl;

import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.db1.dao.impl.AbstractTestCase;
import br.com.db1.model.Uf;

public class UfDaoTest extends AbstractTestCase {

	private UfDao dao;

	@Before
	public void init() {
		dao = new UfDao(manager);
	}

	@Test
	public void findAllTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUf = manager.createNativeQuery("DELETE FROM Uf");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Uf uf = new Uf();
		uf.setNome("PP");
		manager.persist(uf);

		Assert.assertTrue(dao.findAll().size() > 0);

	}

	@Test
	public void findByIdTest() {
		Uf uf = dao.findById(4);
		Assert.assertEquals("SC", uf.getNome());
		Assert.assertNotEquals("PR", uf.getNome());
		
	}

	@Test
	public void findByNameTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM cidade");
		queryCidade.executeUpdate();

		Query queryUf = manager.createNativeQuery("DELETE FROM uf where nome = :pNome");
		queryUf.setParameter("pNome", "PP");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findByName("PP").size() == 0);

		Uf uf = new Uf();
		uf.setNome("PP");
		manager.persist(uf);

		Assert.assertTrue(dao.findByName("PP").size() == 1);
	}

	@Test
	public void saveTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM cidade");
		queryCidade.executeUpdate();

		Query queryUf = manager.createNativeQuery("DELETE FROM uf");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Uf uf = new Uf();
		uf.setNome("PP");
		dao.save(uf);

		Assert.assertTrue(dao.findByName("PP").size() == 1);
		
		uf.setNome("RR");
		dao.save(uf);
		Assert.assertTrue(dao.findAll().size() == 1);


	}

	@Test
	public void deleteTest() {
		Query queryCidade = manager.createNativeQuery("DELETE FROM Cidade");
		queryCidade.executeUpdate();

		Query queryUf = manager.createNativeQuery("DELETE FROM Uf");
		queryUf.executeUpdate();
		Assert.assertTrue(dao.findAll().size() == 0);

		Uf uf = new Uf();
		uf.setNome("PP");
		dao.save(uf);

		Assert.assertTrue(dao.findAll().size() == 1);
		
		dao.delete(uf.getId());
		Assert.assertTrue(dao.findAll().size() == 0);

	}

}