package com.jl.spring.service;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.jl.spring.data.DBUser;
import com.jl.spring.util.HibernateUtil;

@Service
public class UserService {

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public Integer addUser(String email, String password) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer userID = null;

		try {
			tx = session.beginTransaction();
			DBUser user = new DBUser();

			user.setEmail(email);
			user.setPass(password);
			user.setRoleUser("ROLE_USER");

			userID = (Integer) session.save(user);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userID;
	}

	/**
	 * 
	 * @param user
	 */
	public void updateUser(DBUser user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public Integer addUser(DBUser user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		Integer userID = null;

		try {
			tx = session.beginTransaction();
			userID = (Integer) session.save(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return userID;

	}

	// @Override
	public DBUser findUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(DBUser.class).add(
				Restrictions.like("email", email));
		// TODO Sprawdz czy mozna to wyrzucic
		DBUser user = (DBUser) criteria.uniqueResult();
		session.close();
		return user;
	}

	public DBUser findUserById(Integer id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(DBUser.class).add(
				Restrictions.eq("id", id));
		criteria.setMaxResults(1);

		DBUser list = (DBUser) criteria.uniqueResult();
		session.close();
		return list;
	}

	// @Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			DBUser user = (DBUser) session.get(DBUser.class, id);
			session.delete(user);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();

		} finally {
			session.close();
		}

	}

	public List<DBUser> getAllUsers(Integer maxResult, Integer firstResult) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		List<DBUser> users = null;
		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(DBUser.class);
			if (maxResult != null) {
				criteria.setMaxResults(maxResult);
			}
			if (firstResult != null) {
				criteria.setFirstResult(firstResult);
			}
			users = (List<DBUser>) criteria.list();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return users;
	}

	public Integer findIdbyUserEmail(String email) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(DBUser.class).add(
				Restrictions.like("email", email));
		DBUser user = (DBUser) criteria.uniqueResult();
		session.close();
		return user.getIdUser();

	}

}
