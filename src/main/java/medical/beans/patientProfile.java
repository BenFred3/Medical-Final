// This class is used as an entity in our database.

// Package and import statements.
package medical.beans;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class patientProfile 
{
	// Instance variables.
	@Id
	@Column(name = "patient_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientID;
	private String firstName;
	private String lastName;
	private Date birthdate;
	private String email;
	private String phone;
	
	// Default constructor.
	public patientProfile()
	{
		super();
	}
	
	public patientProfile(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public patientProfile(String firstName, String lastName, Date birthdate, String email, String phone)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
	}
	
	// Getters and setters.
	public long getPatientID() 
	{
		return patientID;
	}
	public void setPatientID(long patientID) 
	{
		this.patientID = patientID;
	}

	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	public Date getBirthdate() 
	{
		return birthdate;
	}
	public void setBirthdate(Date birthdate) 
	{
		this.birthdate = birthdate;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhone() 
	{
		return phone;
	}
	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	// Helper methods.
	@Override
	public String toString() 
	{
		return "Patient Profile: Patient ID- " + patientID + " | First Name- " + firstName + " | Last Name- " + lastName
				+ " | birthdate- " + birthdate + " | Email- " + email + " | Phone Number- " + phone;
	}
}