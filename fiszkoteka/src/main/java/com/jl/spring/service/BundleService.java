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

import com.jl.spring.data.DBBundle;
import com.jl.spring.data.DBUser;
import com.jl.spring.util.HibernateUtil;

/**
 * @author oem1
 * Klasa obs�uguj�ca operacje na bazie danych zwi�zane z wi�zkami
 */

@Service
public class BundleService {

	@Autowired
	private UserService userService;

/**
 * metoda usuwaj�ca wi�zk�
 * @param id- numer id wi�zki
 */
public void deleted(Integer id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			DBBundle bundle =findBundleById(id);
			bundle.setDeleted(true);
			session.update(bundle);
			tx.commit();
		} catch (HibernateException e) {
			if(tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/**
	 * metoda dodaj�ca wi�zk�
	 * @param idUser- id u�ytkownika
	 * @param nameBundle- nazwa wi�zki
	 * @param visible- widoczno�� prywatna (false)/ publiczna (true)
	 * @return id wi�zki
	 */
	public Integer add(Integer idUser, String nameBundle,Boolean visible){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx= null;
		Integer bundleID = null;
		
		try {
			tx = session.beginTransaction();
			DBBundle bundle = new DBBundle();
			bundle.setNameBundle(nameBundle);
			DBUser user = userService.findUserById(idUser);
			bundle.setUsers(user);
			bundle.setVisible(visible);
			bundle.setDeleted(false);
			bundleID = (Integer)session.save(bundle);
			tx.commit();
		} catch (HibernateException e) {
			 if (tx!=null) tx.rollback();
	         e.printStackTrace();
		} finally {
			session.close();
		}
		
		return bundleID;
		
	}
	
/**
 * aktualizacja wi�zki
 * @param bundle- wi�zka
 */
public void update(DBBundle bundle) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(bundle);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}
	}
	
/**
 * metoda wyszukuje publiczne wi�zki o okre�lonej nazwie i nieusuni�te
 * @param bundleName- nazwa wi�zki
 * @return lista wi�zek spe�niaj�cych warunki
 */
	@SuppressWarnings("unchecked")
	public List<DBBundle> findBundle(String bundleName){
		Session session =HibernateUtil.getSessionFactory().openSession();
		
		List bundles = null;
		try {
			 bundles =  session.createCriteria(DBBundle.class)
					.add(Restrictions.like("nameBundle", bundleName))
					.add(Restrictions.eq("visible", true))
					.add(Restrictions.eq("deleted", false)).list();
		
		} catch (HibernateException e){
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bundles;
	}
	
	/**
	 * Metoda znajduje pojedyncz� wi�zk� po nazwie
	 * @param name- nazwa wi�zki
	 * @return wi�zka
	 */
	public DBBundle findBundleByName(String name){
		Session session =HibernateUtil.getSessionFactory().openSession();
		DBBundle bundle = null;
		try {
		
			Criteria criteria = session.createCriteria(DBBundle.class)
				   .add(Restrictions.like("nameBundle", name));
			
			bundle = (DBBundle)criteria.uniqueResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bundle;
		
	}
	
	/**
	 * Metoda zwraca wi�zk� w opraciu o jej numer id
	 * @param id- id wi�zki
	 * @return wi�zka
	 */
	public DBBundle findBundleById(Integer id){
		Session session =HibernateUtil.getSessionFactory().openSession();
		DBBundle bundle = null;
		try {
			
			Criteria criteria = session.createCriteria(DBBundle.class)
				   .add(Restrictions.eq("idBundle", id));
			bundle = (DBBundle)criteria.uniqueResult();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bundle;
	}
	
/**
 * Metoda zwraca list� publicznych, nieusuni�tych wi�zek
 * @return lista publicznych, nieusuni�tych wi�zek
 */
	public List<DBBundle> getAllPublicBundles(){
			Session session =HibernateUtil.getSessionFactory().openSession();
		
		List bundles = null;
		try {
			 bundles = session.createCriteria(DBBundle.class)
					.add(Restrictions.eq("visible", true))
					.add(Restrictions.eq("deleted", false)).list();
		
		} catch (HibernateException e){
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		return (List<DBBundle>)bundles;
		
	}
	/**
	 * 
	 * @param id- id u�ytkownika
	 * @param maxResult- liczba wi�zek
	 * @param firstResult- numer pierwszej wi�zki
	 * @return lista wi�zek u�ytkownika
	 */
	public List<DBBundle> findByUserId(Integer id, Integer maxResult, Integer firstResult){
		Session session =HibernateUtil.getSessionFactory().openSession();
		List<DBBundle> list = null;
		try {
			Query query  = session.createQuery("from DBBundle b where b.users.idUser=:id and b.deleted=false");
			query.setParameter("id", id);
				   
			if(maxResult != null) {
				query.setMaxResults(maxResult);
			}
			if(maxResult != null) {
				query.setFirstResult(firstResult);
			}
			list = (List<DBBundle>)query.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	/**
	 * 
	 * @param id- id u�ytkownika
	 * @param nameBundle- nazwa wi�zki
	 * @param maxResult- liczba wi�zek
	 * @param firstResult- numer pierwszej wi�zki
	 * @return lista wi�zek u�ytkownika
	 */
	public List<DBBundle> findByUserIdBundleName(Integer id, String nameBundle, Integer maxResult, Integer firstResult){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<DBBundle> list = null;
		try {
			Query query  = session.createQuery("from DBBundle b where b.users.idUser=:id and b.nameBundle=:nameBundle");
			query.setParameter("id", id);
			query.setParameter("nameBundle", nameBundle);
				   
			if(maxResult != null) {
				query.setMaxResults(maxResult);
			}
			if(maxResult != null) {
				query.setFirstResult(firstResult);
			}
			list = (List<DBBundle>)query.list();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}
	
	
	
}
