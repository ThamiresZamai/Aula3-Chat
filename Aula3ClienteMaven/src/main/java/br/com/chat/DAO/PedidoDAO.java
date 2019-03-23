package br.com.chat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.chat.entidade.Pedido;

public class PedidoDAO {

private EntityManager em;
	
	public PedidoDAO() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("chat");
	em = emf.createEntityManager();
	}
	
	
	public boolean insert(Pedido ped) {
		try {
			em.getTransaction().begin();
			em.persist(ped);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Pedido ped) {
		try {
			em.getTransaction().begin();
			em.merge(ped);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean delete (Pedido ped) {
		try {
			em.getTransaction().begin();
			ped = em.find(Pedido.class, ped.getId());
			em.remove(ped);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Pedido selectTo (String ped) {
		try {
			em.getTransaction().begin();
			Pedido pededido = em.find(Pedido.class, ped);
			em.getTransaction().commit();
			em.close();
			return pededido;
		} catch (Exception e) {
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> selectAll () {
		return em.createQuery("FROM " + Pedido.class.getName()).getResultList();
	}
}
