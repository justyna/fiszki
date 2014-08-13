package com.jl.spring.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBBundle;
import com.jl.spring.data.DBCard;
import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.util.HibernateUtil;
/**
 * 
 * @author oem1
 * Klasa obs³uguj¹ca operacje na bazie danych zwi¹zane z fiszkami
 */
@Service
public class CardService {

	@Autowired
	BundleService bundleService;
	
	/**
	 * 
	 * @param card- fiszka
	 * @param idBundle- id wi¹zki
	 * @return id dodanej fiszki
	 */
	public Integer addCard(DBCard card, int idBundle){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx= null;
		Integer cardID = null;
		
		
		try {
			tx = session.beginTransaction();
			
			DBBundle bundle = bundleService.findBundleById(idBundle);
			card.setBundles(bundle);
	
			
			cardID = (Integer)session.save(card);
			
			tx.commit();
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cardID;
	}
	
	/**
	 * aktualizacja fiszki
	 * @param card- fiszka
	 */
	public void updateCard(DBCard card) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(card);
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * Usuwanie fiszki
	 * @param card- fiszka
	 */
	public void deleteCard(DBCard card) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(card);
			tx.commit();
		} catch(HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	/**
	 * 
	 * @param user- u¿ytkownik
	 * @return lista fiszek u¿ytkownika
	 */
	public List<DBCard> listCardByUser(DBUser user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBCard> list = null;
		try {
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
		
	}
	
	public DBCard test(){
		
		
		
		return null;
	}

	/**
	 * 
	 * @param id- id wi¹zki
	 * @param length- liczba fiszek
	 * @param offset- numer pierwszej fiszki
	 * @return lista fiszek
	 */
	public List<DBCard> findByBundleId(int id, Integer length, Integer offset) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBCard> cards = null;
		try {
			Query query;
			
				
				query = session.createSQLQuery("select * from cards c where c.idbundle=:id ").addEntity(DBCard.class) ;
				query.setParameter("id", id);
				cards = (List<DBCard>)query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return cards;
	}
	/**
	 * 
	 * @param id- id fiszki
	 * @return fiszka
	 */
	public DBCard findCardById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		DBCard card = null;
		try {
			card = (DBCard)session.createCriteria(DBCard.class)
					.add(Restrictions.eq("idcard", id)).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return card;
	}
	
}
