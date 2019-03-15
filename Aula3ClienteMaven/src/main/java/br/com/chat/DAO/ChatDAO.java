package br.com.chat.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.chat.entidade.Chat;

public class ChatDAO {

	private EntityManager em;
	
	public ChatDAO() {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Banco");
	em = emf.createEntityManager();
	}
	
	
	public boolean insert(Chat chat) {
		try {
			em.getTransaction().begin();
			em.persist(chat);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean update(Chat chat) {
		try {
			em.getTransaction().begin();
			em.merge(chat);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean delete (Chat chat) {
		try {
			em.getTransaction().begin();
			chat = em.find(Chat.class, chat.getUser());
			em.remove(chat);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public Chat selectTo (String user) {
		try {
			em.getTransaction().begin();
			Chat chat = em.find(Chat.class, user);
			em.getTransaction().commit();
			em.close();
			return chat;
		} catch (Exception e) {
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Chat> selectAll () {
		return em.createQuery("FROM " + Chat.class.getName()).getResultList();
	}
}
