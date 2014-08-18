package com.jl.spring.service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBCard;
import com.jl.spring.util.HibernateUtil;

@Service
public class TestService {

	@Autowired
	private CardService cardService;

	public DBCard chooseCard(Integer idBundle) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		DBCard card = null;
		
		try {

			Query query = session.createSQLQuery("Select * from cards where idbundle=:id order by correct").addEntity(DBCard.class).setParameter("id", idBundle);
					
			
			card =(DBCard)query.uniqueResult();
			
		} catch (HibernateException e) {

			e.printStackTrace();

		} finally {
			session.close();
		}

		return card;
	}

	public void updateResult(Integer idCard, int result) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		tx = session.beginTransaction();
		DBCard card = null;
		Integer correct;
		Integer all;
		Integer incorrect;
		try {
			card = cardService.findCardById(idCard);
			correct = card.getCorrect();
			all = card.getNumberanswer();
			incorrect = card.getIncorrect();

			if (result == 1) {
				card.setNumberanswer(all + 1);
				card.setCorrect(correct + 1);
			}
			if (result == -1) {
				card.setNumberanswer(all + 1);
				card.setIncorrect(incorrect + 1);
			}

			session.update(card);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
