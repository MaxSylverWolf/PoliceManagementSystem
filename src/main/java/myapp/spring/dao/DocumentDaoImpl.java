package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Document;
import myapp.spring.domain.DocumentType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

public class DocumentDaoImpl implements DocumentDao{
	
	protected final Logger log = LoggerFactory.getLogger(getClass());

	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	

	
	@Override
	public List<DocumentType> getDocumentTypes() {
		try(Session session = sessionFactory.openSession()){
			Query<DocumentType> query = session.createQuery("FROM "+DocumentType.class.getName());
			return query.getResultList();		
		}
	}
	@Override
	public List<Accessory> getAccessories() {
		try(Session session = sessionFactory.openSession()){
			Query<Accessory> query = session.createQuery("FROM "+Accessory.class.getName());
			return query.getResultList();		
		}
	}
	@Override
	public Document getDocument(long id) {
		try(Session session = sessionFactory.openSession()){
			return (Document)session.get(Document.class.getName(), id);
		}
	}
	
	@Override
	public List<Document> getAllDocuments() {
		try(Session session = sessionFactory.openSession()){
			Query<Document> query = session.createQuery("FROM "+Document.class.getName());
			return query.getResultList();				
		}
	}

	public void saveOrUpdateDocument(Document v){
		try(Session session = sessionFactory.openSession()){
			session.beginTransaction();
			session.saveOrUpdate(v);
			session.getTransaction().commit();
			
		}
	}

	@Override
	public void deleteDocument(Document v) {
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
	
	
	


