package myapp.spring.dao;

import java.util.List;

import myapp.spring.domain.Accessory;
import myapp.spring.domain.Criminal;
import myapp.spring.domain.CriminalType;
import myapp.spring.domain.Register;

public interface RegisterDao {

	Register getRegister(long id);
	
	public void saveRegister(Register v);
	
	List<Register> getAllRegisters();
		
	boolean checkUser(String login, String password);
	
	public void deleteRegister(Register v);


}
