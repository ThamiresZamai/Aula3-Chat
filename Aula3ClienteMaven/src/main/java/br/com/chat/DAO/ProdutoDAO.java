package br.com.chat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.chat.entidade.Produto;

public class ProdutoDAO {

	private EntityManager em;
	
	public ProdutoDAO() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco");
	em = emf.createEntityManager();
	}
	
	
	public boolean insert(Produto prod) {
		try {
			em.getTransaction().begin();
			em.persist(prod);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Produto prod) {
		try {
			em.getTransaction().begin();
			em.merge(prod);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean delete (Produto prod) {
		try {
			em.getTransaction().begin();
			prod = em.find(Produto.class, prod.getId());
			em.remove(prod);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Produto selectTo (String prod) {
		try {
			em.getTransaction().begin();
			Produto produto = em.find(Produto.class, prod);
			em.getTransaction().commit();
			em.close();
			return produto;
		} catch (Exception e) {
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> selectAll () {
		return em.createQuery("FROM " + Produto.class.getName()).getResultList();
	}
}
