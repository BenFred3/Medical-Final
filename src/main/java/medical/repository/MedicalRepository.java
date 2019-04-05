// Package and import statements.
package medical.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medical.beans.patientProfile;

@Repository
public interface MedicalRepository extends JpaRepository<patientProfile, Long> { }