// This class is used as an entity in our database.

// Package and import statements.
package medical.beans;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Appointments {

	// Instance variables.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date dateTime;
	private int appointmentKept;
	private long doctorId;
	private long patientId;
	
	
	
	public Appointments() {
		super();
	}
	
	public Appointments(Date date, int apptKept) {
		super();
		this.dateTime = date;
		this.appointmentKept = apptKept;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getAppointmentKept() {
		return appointmentKept;
	}

	public void setAppointmentKept(int appointmentKept) {
		this.appointmentKept = appointmentKept;
	}
	
	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	// Helper methods.
	@Override
	public String toString() 
	{
		return "Appointment: " + dateTime;
	}
}
