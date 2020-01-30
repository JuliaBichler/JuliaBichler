package tirol.htl.anichstrasse.Maven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Person {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	private int age;
	private String firstName;
	private String lastName;
	
	@Transient
	public long aliveSince;
	
	private Hobby hobby;
	
	public Person(long id,int age,String firstName, String lastName, long aliveSince) {
		this.id=id;
		this.age=age;
		this.firstName=firstName;
		this.lastName=lastName;
		this.aliveSince=aliveSince;
	}
	
	public Person() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", age=" + age + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", aliveSince=" + aliveSince + ", hobby=" + hobby + "]";
	}

	
	public long getAliveSince() {
		return aliveSince;
	}

	public void setAliveSince(long aliveSince) {
		this.aliveSince = aliveSince;
	}
	

	public Hobby getHobby() {
		return hobby;
	}

	public void setHobby(Hobby hobby) {
		this.hobby = hobby;
	}
	
	
}
