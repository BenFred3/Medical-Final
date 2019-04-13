// Package and import statements.
package medical.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import medical.beans.doctorProfile;


@Repository
public interface DoctorRepository extends JpaRepository<doctorProfile, Long> { }