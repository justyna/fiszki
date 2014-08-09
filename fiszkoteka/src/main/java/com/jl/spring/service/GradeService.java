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

@Service
public class GradeService {

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
	//TODO
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
