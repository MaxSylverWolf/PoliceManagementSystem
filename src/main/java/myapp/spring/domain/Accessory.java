package myapp.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="accessories")
public class Accessory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	Long id;
	
	String name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Accessory){
		Accessory a = (Accessory)obj;
		return a.getId().equals(id);
		}
		return false;
	}


}
