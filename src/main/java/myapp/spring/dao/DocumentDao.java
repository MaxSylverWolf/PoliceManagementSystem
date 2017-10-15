package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Document;
import myapp.spring.domain.DocumentType;

public interface DocumentDao {

	Document getDocument(long id);
	
	public void saveOrUpdateDocument(Document v);
	
	public void deleteDocument(Document v);
	
	List<Document> getAllDocuments();
	
	List<DocumentType> getDocumentTypes();
	
	boolean checkUser(String login, String password);

	List<Accessory> getAccessories();

}
