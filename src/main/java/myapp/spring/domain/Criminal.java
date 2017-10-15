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
@Table(name="criminals")
public class Criminal implements Serializable{
	
	
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
	private String surname;
	
	@Past
	@Column(name="birthDate")
	private Date birthDate;
	
	@Min(value=5)
	@Max(value=110)
	private int age;
	
	private int PESEL;	
	
	@NotBlank
	private String streetAddr;
	
	@NotBlank
	private String zipcode;
	
	@NotBlank
	private String cityName;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String skinColor;
	
	@NotBlank
	private String eyesColor;
	
	@NotBlank
	private String hairColor;
	
	@NotBlank
	private String hair;
	

	private int height;
	

	private int weight;
	
	@NotBlank
	private String profile;
	
	@NotBlank
	private String profession;
	
	@NotBlank
	private String job;
	
	@NotBlank
	private String lastSchool;
	
	
	@ManyToOne
	private CriminalType type;

	public Criminal(){
		type = new CriminalType();
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String ab) {
		this.surname = ab;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int ag) {
		this.age = ag;
	}

	public int getPESEL() {
		return PESEL;
	}
	public void setPESEL(int pes) {
		this.PESEL = pes;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date rdata) {
		this.birthDate = rdata;
	}
	
	public String getStreetAddr() {
		return streetAddr;
	}
	public void setStreetAddr(String stre) {
		this.streetAddr = stre;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zip) {
		this.zipcode = zip;
	}
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String city) {
		this.cityName =city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String ca) {
		this.country = ca;
	}
	
	public String getSkinColor() {
		return skinColor;
	}
	public void setSkinColor(String sco) {
		this.skinColor = sco;
	}
	
	
	public String getEyesColor() {
		return eyesColor;
	}
	public void setEyesColor(String eco) {
		this.eyesColor = eco;
	}
	
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hco) {
		this.hairColor = hco;
	}
	
	public String getHair() {
		return hair;
	}
	public void setHair(String hta) {
		this.hair = hta;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int hai) {
		this.height = hai;
	}
	
	public int getWeight() {
		return weight;
	}
	public void setWeight(int wei) {
		this.weight = wei;
	}
	
	public String getProfile() {
		return profile;
	}
	public void setProfile(String prof) {
		this.profile = prof;
	}

	public String getProfession() {
		return profession;
	}
	public void setProfession(String profe) {
		this.profession = profe;
	}
	
	public String getJob() {
		return job;
	}
	public void setJob(String sd) {
		this.job = sd;
	}

	public String getLastSchool() {
		return lastSchool;
	}
	public void setLastSchool(String sq) {
		this.lastSchool = sq;
	}
	
	public void setType(CriminalType gtype) {
		this.type = gtype;
	}
	
	public CriminalType getType() {
		return type;
	}

}
