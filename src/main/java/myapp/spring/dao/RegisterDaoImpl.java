package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class RegisterDaoImpl implements RegisterDao{
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	@Override
	public Register getRegister(long id) {
		try(Session session = sessionFactory.openSession()){
			return (Register)session.get(Register.class.getName(), id);
		}
	}
	
	@Override
	public List<Register> getAllRegisters() {
		try(Session session = sessionFactory.openSession()){
			Query<Register> query = session.createQuery("FROM "+Register.class.getName());
			return query.getResultList();				
		}
	}

	public void saveRegister(Register v){
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			session.saveOrUpdate(v);
			session.getTransaction().commit();
			
		}
	}
	
	@Override
	public boolean checkUser(String login, String password) {
	
		
		if(login.equalsIgnoreCase("qwerty") && password.equalsIgnoreCase("qwerty"))
			return true;
		return false; }
	
	
	@Override
	public void deleteRegister(Register v) {
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			session.delete(v);
			session.getTransaction().commit();
		}
	}

}
