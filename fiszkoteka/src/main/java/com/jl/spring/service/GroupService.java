package com.jl.spring.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.util.HibernateUtil;

@Service
public class GroupService {
	
	@Autowired
	private UserService userService;
	
	public Integer addGroup(DBGroup group){
		Session session =HibernateUtil.getSessionFactory().openSession();
		Transaction tx= null;
		Integer groupID = null;
				
		try {
			tx = session.beginTransaction();			
			groupID = (Integer)session.save(group);		
			tx.commit();
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace();
		} finally {
			session.close();
		}
		return groupID;
	}
	
	public DBGroup findGroup(DBGroup group){
		
		return null;
	}
	public List<DBGroup> findGroupByName(String name, Integer maxResult, Integer firstResult){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBGroup> list = null;
		try {
		
			Criteria criteria = session.createCriteria(DBGroup.class);
			if(name != null) {		
				   criteria.add(Restrictions.like("nameBundle", name));
			}
			if(maxResult != null) {
				criteria.setMaxResults(maxResult);
			 }
			if(firstResult != null) {
				criteria.setFirstResult(firstResult);
			}
			list = (List<DBGroup>)criteria.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return  list;
	}

public List<DBGroup> findGroupByIdUser(Integer idUser, Integer maxResult, Byte firstResult){
		
		Session session =HibernateUtil.getSessionFactory().openSession();
		List<DBGroup> list = null;
		try {
			Query query;
			
			if(idUser != null){		
				query = session.createSQLQuery("select * from groups g,  usersgroups ug where g.idgroup = ug.idgroup and ug.iduser =:id ").addEntity(DBGroup.class) ;
				query.setParameter("id", idUser);
			} else {
				query = session.createSQLQuery("select * from groups g").addEntity(DBGroup.class) ;
				
			}
			if(maxResult != null){
				query.setMaxResults(maxResult);
			 }
			if(firstResult != null){
				query.setFirstResult(firstResult);
			}
				list = (List<DBGroup>)query.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return  list;
	}

public DBGroup findGroupByIdGroup(Integer idGroup){
	
	Session session =HibernateUtil.getSessionFactory().openSession();
	DBGroup group = null;
	
	try {
		Criteria criteria = session.createCriteria(DBGroup.class)
				.add(Restrictions.eq("idgroup", idGroup));
		group=(DBGroup) criteria.uniqueResult();
	} catch(HibernateException e) {
		e.printStackTrace();
	} finally {
		session.close();
	}
	
	return group;
	
}
	
	
	
}
