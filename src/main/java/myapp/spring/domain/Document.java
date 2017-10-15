package myapp.spring.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name="documents")
public class Document implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private long id;	

	@NotBlank
	@Size(min=2, max=40)
	private String name;
	
	@NotBlank
	private String about;
	
	@Past
	@Column(name="release_date")
	private Date releaseDate;
	

	private int caseNumber;
	
	@ManyToOne
	private DocumentType type;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Valid
	List<Accessory> accessories;

	public Document(){
		type = new DocumentType();
		accessories = new ArrayList<Accessory>();
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String ab) {
		this.about = ab;
	}
	public int getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(int cas) {
		this.caseNumber = cas;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date rdata) {
		this.releaseDate = rdata;
	}
	
	public void setType(DocumentType gtype) {
		this.type = gtype;
	}
	
	public DocumentType getType() {
		return type;
	}

	public List<Accessory> getAccessories() {
		return accessories;
	}

	public void setAccessories(List<Accessory> accessories) {
		this.accessories = accessories;
	}

}
