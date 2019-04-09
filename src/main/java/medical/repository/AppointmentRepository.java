// Package and import statements.
package medical.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medical.beans.Appointments;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointments, Long> { 
	
	List<Appointments> findByPatientId(long patientId);
}

