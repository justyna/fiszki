package com.jl.spring.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBCard;
import com.jl.spring.data.DBStats;
import com.jl.spring.data.DBUser;
import com.jl.spring.util.HibernateUtil;

@Service
public class StatsService {

	/*@Autowired
	private CardService cardService;*/
	
	@Autowired
	private UserService userService;
	
	/**
	 * 
	 * @param idUser- id u¿ytkownika
	 * @param idCard- id fiszki
	 * 
	 */
	public void addStats(Integer idUser, DBCard card){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		DBUser user = userService.findUserById(idUser);
		
		DBStats stats = new DBStats();
		stats.setUsers(user);
		stats.setCards(card);
		Transaction tx;
		tx =session.beginTransaction();
		try {
			
			session.save(stats);
			tx.commit();
		} catch(HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	/**
	 * 
	 * @param idUser
	 * @param card
	 * @param answer
	 */
	public void upadateStats(DBStats stats, Integer answer){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		
	}
	
	public DBStats findStatsByUserId(){
		return null;
	}
}
