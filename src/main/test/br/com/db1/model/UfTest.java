
package br.com.db1.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UfTest {
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	@Before
	public void init(){
		factory = Persistence.createEntityManagerFactory("db1start");
		manager = factory.createEntityManager();
	}
	
	@After
	public void fim(){
		factory.close();
	}
	
	@Test
	public void inserirTest() {
		Uf uf = new Uf();
		uf.setNome("RR");
		
		manager.getTransaction().begin();
		manager.persist(uf);
		manager.getTransaction().commit();
	}
	
	@Test
	public void updateTest(){
		Query q = manager.createQuery("from uf where nome = :pNome");
		q.setParameter("pNome", "RR");
		q.setMaxResults(1);
		Uf uf = (Uf) q.getSingleResult();
				
		System.out.println(uf);
		
		uf.setNome("AA");
		manager.getTransaction().begin();
		manager.persist(uf);
		manager.getTransaction().commit();
	}
	
	@Test
	public void insertTest(){
		Query c = manager.createQuery("from cidade where nome = :pNome");
		c.setParameter("pNome", "Cianorte");
		c.setMaxResults(1);
		Cidade cidade = (Cidade) c.getSingleResult();
		
		System.out.println(cidade);
		
		cidade.setNome("Campo Mourão");
		manager.getTransaction().begin();
		manager.persist(cidade);
		manager.getTransaction().commit();
		
	}
}