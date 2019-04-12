// This class is used as an entity in our database.

// Package and import statements.
package medical.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class doctorProfile {
	
// Instance variables.
	@Id
	@Column(name = "doctor_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
	// Default constructor.
	public doctorProfile()
	{
		super();
	}
	
	// Constructors.
	public doctorProfile(String firstName, String lastName)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public doctorProfile(String firstName, String lastName, String email, String phone)
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
	// Setters and Getters.
	public long getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(long doctorID) {
		this.doctorID = doctorID;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	// Helper methods.
	@Override
	public String toString() 
	{
		return "Doctor Profile: Doctor ID- " + doctorID + " | First Name- " + firstName + " | Last Name- " + lastName
				+ " | Email- " + email + " | Phone Number- " + phone;
	}
}
