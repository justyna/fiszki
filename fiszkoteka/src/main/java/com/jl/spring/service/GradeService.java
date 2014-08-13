package com.jl.spring.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBGrade;
import com.jl.spring.util.HibernateUtil;
/**
 * 
 * @author oem1
 * Klasa obs³uguj¹ca operacje na bazie danych zwi¹zane z ocenami
 */
@Service
public class GradeService {
	
/**
 * dodaje ocenê do bazy
 * @param grade- ocena
 * @return id dodanej oceny
 */
	public Integer addGrade(DBGrade grade){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer gradeID = null;
		
		try {
			tx = session.beginTransaction();
			gradeID =(Integer)session.save(grade);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return gradeID;
	}
	
	
	/**
	 * znajduje listê ocen przypisanych do u¿ytkownika
	 * @param idUser- id u¿ytkownika
	 * @return lista ocen
	 */
	public List<DBGrade> findGradeByUserId(Integer idUser){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBGrade> list = null;
		Query query;
		try {
			
			query = session.createSQLQuery("select * from grades g where g.iduser =:iduser ").addEntity(DBGrade.class);
			query.setParameter("iduser", idUser);	
			list = (List<DBGrade>)query.list();
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	
	/**
	 * 
	 * @param idUser- id u¿ytkownika
	 * @param idGroup- id grupy
	 * @return lista ocen u¿ytkowników nale¿¹cych do grupy
	 */
	public List<DBGrade> findGradeByUserIdGroupId(Integer idUser, Integer idGroup){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBGrade> list = null;
		Query query;
		try {
			query = session.createSQLQuery("select * from grades g, usersgroups ug  where g.iduser=:iduser and ug.idgroup=:idgroup and g.iduser=ug.iduser").addEntity(DBGrade.class);
			query.setParameter("iduser", idUser);
			query.setParameter("idgroup", idGroup);
			list = (List<DBGrade>)query.list();
			
			
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	/**
	 * aktualizacja oceny
	 * @param grade- ocena
	 */
	public void updateGrade(DBGrade grade) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.update(grade);
			tx.commit();
		} catch(HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	/**
	 * metoda usuwa ocenê
	 * @param grade-ocena
	 */
	public void deleteGrade(DBGrade grade) {
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			session.delete(grade);
			tx.commit();
		} catch (HibernateException ex) {
			if(tx != null) tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * metoda znajduje ocenê o podanym numerze id
	 * @param idGrade id oceny
	 * @return ocena
	 */
	public DBGrade findGradeById(Integer idGrade){
		Session session = HibernateUtil.getSessionFactory().openSession();
		DBGrade grade = null;
		try {
			Criteria criteria = session.createCriteria(DBGrade.class);
			criteria.add(Restrictions.eq("idgrades", idGrade));
			grade = (DBGrade)criteria.uniqueResult();
		} catch(HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
		return grade;
		
	}

}
