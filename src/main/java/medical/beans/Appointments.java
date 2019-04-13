// This class is used as an entity in our database.

// Package and import statements.
package medical.beans;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointments 
{
	// Instance variables.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Timestamp dateTime;
	private int appointmentKept;
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private doctorProfile doctorProfile;
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private patientProfile patientProfile;
	
	// Constructors.
	
	public Appointments() {
		super();
	}
	
	public Appointments(Timestamp date, int apptKept) {
		super();
		this.dateTime = date;
		this.appointmentKept = apptKept;
	}
	
	// Setters and Getters.
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public int getAppointmentKept() {
		return appointmentKept;
	}

	public void setAppointmentKept(int appointmentKept) {
		this.appointmentKept = appointmentKept;
	}
	
	public doctorProfile getDoctorProfile() {
		return doctorProfile;
	}

	public void setDoctorProfile(doctorProfile doctorProfile) {
		this.doctorProfile = doctorProfile;
	}

	public patientProfile getPatientProfile() {
		return patientProfile;
	}

	public void setPatientProfile(patientProfile patientProfile) {
		this.patientProfile = patientProfile;
	}

	// Helper methods.
	@Override
	public String toString() 
	{
		return "Appointment: " + dateTime;
	}
}
