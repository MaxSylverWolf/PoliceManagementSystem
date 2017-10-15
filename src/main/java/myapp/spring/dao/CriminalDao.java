package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;

public interface CriminalDao {

	Criminal getCriminal(long id);
	
	public void saveOrUpdateCriminal(Criminal v);
	
	public void deleteCriminal(Criminal v);
	
	List<Criminal> getAllCriminals();
	
	List<CriminalType> getCriminalTypes();
	
	boolean checkUser(String login, String password);

}
