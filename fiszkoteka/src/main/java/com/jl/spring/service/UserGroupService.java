package com.jl.spring.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBGroup;
import com.jl.spring.data.DBUser;
import com.jl.spring.data.DBUsersGroups;
import com.jl.spring.util.HibernateUtil;

@Service
public class UserGroupService {

	/**
	 * utworzenie relacji miêdzy u¿ytkownikiem a grup¹
	 * @param user- u¿ytkownik
	 * @param group- grupa
	 * @return id wiersza w tabeli usersgroups
	 */
	public Integer addUserGroup(DBUser user, DBGroup group) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer idUG = null;
		
		try {
			tx = session.beginTransaction();
			DBUsersGroups dbUG = new DBUsersGroups();
			dbUG.setGroups(group);
			dbUG.setUsers(user);
			idUG = (Integer)session.save(dbUG);
			tx.commit();
		} catch(HibernateException ex) {
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return idUG;
	}
	
	/**
	 * 
	 * @param idUser
	 * @param idGroup
	 * @return 
	 */
	public DBUsersGroups findUsersGroups(Integer idUser, Integer idGroup) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		DBUsersGroups ug = null;
		
		try {
			ug = (DBUsersGroups)session.createCriteria(DBUsersGroups.class)
					.add(Restrictions.eq("groups.idgroup", idGroup))
					.add(Restrictions.eq("users.idUser", idUser)).uniqueResult();
			
			
		} catch(HibernateException ex) {
			
			ex.printStackTrace();
		} finally {
			session.close();
		}
		

		return ug;
	}
	
	/**
	 * usuniêcie relacji miêdzy grup¹ a u¿ytkownikiem
	 * @param idUser- id u¿ytkownika
	 * @param idGroup- id grupy
	 */
	public void deleteUserGroup(Integer idUser, Integer idGroup) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			DBUsersGroups ug = findUsersGroups(idUser, idGroup);
			session.delete(ug);
			tx.commit();
		} catch(HibernateException ex){
			if (tx!=null) tx.rollback();
			ex.printStackTrace();
		} finally {
			session.close();
		}
		
	}
	
	/**
	 * 
	 * @param idGroup- id grupy
	 * @return lista u¿ytkowników nale¿¹cych do grupy
	 */
	public List<DBUser> findUsers (Integer idGroup) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBUser> users = null;
		
		try {
			
			Query query;	
			query = session.createSQLQuery("select * from users u,  usersgroups ug where u.iduser = ug.iduser and ug.idgroup =:id ").addEntity(DBUser.class) ;
			query.setParameter("id", idGroup);
			users = (List<DBUser>)query.list();
			
		} catch(HibernateException ex) {
			
		} finally {
			session.close();
		}

		
		return users;
	}

}
