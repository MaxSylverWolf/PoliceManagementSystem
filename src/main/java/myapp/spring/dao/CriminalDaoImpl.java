package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class CriminalDaoImpl implements CriminalDao{
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	

	
	@Override
	public List<CriminalType> getCriminalTypes() {
		try(Session session = sessionFactory.openSession()){
			Query<CriminalType> query = session.createQuery("FROM "+CriminalType.class.getName());
			return query.getResultList();		
		}
	}

	@Override
	public Criminal getCriminal(long id) {
		try(Session session = sessionFactory.openSession()){
			return (Criminal)session.get(Criminal.class.getName(), id);
		}
	}
	
	@Override
	public List<Criminal> getAllCriminals() {
		try(Session session = sessionFactory.openSession()){
			Query<Criminal> query = session.createQuery("FROM "+Criminal.class.getName());
			return query.getResultList();				
		}
	}

	public void saveOrUpdateCriminal(Criminal v){
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			session.saveOrUpdate(v);
			session.getTransaction().commit();
			
		}
	}

	@Override
	public void deleteCriminal(Criminal v) {
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			session.delete(v);
			session.getTransaction().commit();
		}
	}
	

	
	@Override
	public boolean checkUser(String login, String password) {
		
		
		if(login.equalsIgnoreCase("SYLVERWOLF") && password.equalsIgnoreCase("ARCANINE"))
			return true;
		return false;
	}

	

			
	}
	
	
	


