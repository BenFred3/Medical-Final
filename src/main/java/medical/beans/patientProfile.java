// This class is used as an entity in our database.

// Package and import statements.
package medical.beans;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class patientProfile 
{
	// Instance variables.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientID;
	private String firstName;
	private String lastName;
	private Date birthday;
	private String email;
	private int phoneNumber;
	
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
	
	public patientProfile(String firstName, String lastName, Date birthday, String email, int phoneNumber)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	// Getters and setters.
	public int getPatientID() 
	{
		return patientID;
	}
	public void setPatientID(int patientID) 
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

	public Date getBirthday() 
	{
		return birthday;
	}
	public void setBirthday(Date birthday) 
	{
		this.birthday = birthday;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public int getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	// Helper methods.
	@Override
	public String toString() 
	{
		return "Patient Profile: Patient ID- " + patientID + " | First Name- " + firstName + " | Last Name- " + lastName
				+ " | Birthday- " + birthday + " | Email- " + email + " | Phone Number- " + phoneNumber;
	}
}