package com.wolken.mobile.dao;

import java.util.List;

import javax.persistence.RollbackException;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wolken.mobile.entity.UserEntity;

@Component
public class RegistrationDAOImpl implements RegistrationDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	SessionFactory factory;

	public String save(UserEntity entity) {
		
		Session session = null;
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	log.info(entity);
	    	session.save(entity);
	    	tx.commit();
		}
		catch(RollbackException e) {
			return "Save Failed";
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return "Saved Successfully";
	}

	public UserEntity updatePriceByModelNo(UserEntity entity, float price) {
		Session session = null;
		entity.setPrice(price);
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	session.saveOrUpdate(entity);
	    	tx.commit();
		}
		catch(RollbackException e) {
			log.error(e.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return entity;
	}
	
	public UserEntity updateAvailabilityByModelNo(UserEntity entity, boolean availability) {
		Session session = null;
		entity.setAvailability(availability);
		try {
	    	session = factory.openSession();
	    	Transaction tx = session.beginTransaction();
	    	session.saveOrUpdate(entity);
	    	tx.commit();
		}
		catch(RollbackException e) {
			log.error(e.getMessage());
		}
		finally {
			if(session!=null)
				session.close();
		}
		
		return entity;
	}
	
	public List<UserEntity> getByPrice(float price) {
		Session session = null;
		List<UserEntity> entity= null;
		try{
	    	session = factory.openSession();
	    	Query query = session.getNamedQuery("getByPrice");
	    	query.setParameter("price", price);
	    	entity = query.list();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}
	
	public List<UserEntity> getByBrandName(String brandName) {
		Session session = null;
		List<UserEntity> entity= null;
		try{
	    	session = factory.openSession();
	    	Query query = session.getNamedQuery("getByBrandName");
	    	query.setParameter("brandName", brandName);
	    	entity = query.list();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}

	public UserEntity getByModelNo(int modelNo) {
		Session session = null;
		UserEntity entity= null;
		try{
	    	session = factory.openSession();
	    	Query query = session.getNamedQuery("getByModelNo");
	    	query.setParameter("modelNo", modelNo);
	    	entity = (UserEntity) query.uniqueResult();
		}
		finally {
			if(session!=null)
				session.close();
		}
		return entity;
	}

//	public String delete(UserEntity entity) {
//		Session session = null;
//        try {
//            session = factory.openSession();
//            Transaction tx= session.beginTransaction();
//            session.delete(entity);
//            tx.commit();
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//        return "Data Successfully deleted";
//    }
}
