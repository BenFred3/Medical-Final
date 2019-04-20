// This is the web controller which will help us direct our users where they need to go.
// Package and import statements.
package medical.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import medical.beans.Appointments;
import medical.beans.doctorProfile;
import medical.beans.patientProfile;
import medical.repository.MedicalRepository;
import medical.repository.AppointmentRepository;
import medical.repository.DoctorRepository;

@Controller
public class WebController {
	// Autowired Repo's.
	@Autowired
	MedicalRepository repo;
	
	@Autowired
	AppointmentRepository apptrepo;

	@Autowired
	DoctorRepository docrepo;

	// Patient Web Controller.  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	@GetMapping("/addPatientProfile")
	public String addNewPatientProfile(Model patientModel) {
		patientProfile pP = new patientProfile();
		patientModel.addAttribute("newPatientProfile", pP);
		return "add";
	}
	@PostMapping("/addPatientProfile")
	public String addNewPatientProfile(@ModelAttribute patientProfile pP, Model patientModel) {
		repo.save(pP);
		patientModel.addAttribute("patientProfiles", repo.findAll());
		return "results";
	}
	@GetMapping("/viewAllPatientProfiles")
	public String viewAllPatientProfiles(Model model) {
		model.addAttribute("patientProfiles", repo.findAll());
		return "results";
	}
	@GetMapping("/editPatientProfile/{patientID}")
	public String showUpdateForm(@PathVariable("patientID") long patientID, Model patientModel) {
		patientProfile pP = repo.findById(patientID)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient ID:" + patientID));
		patientModel.addAttribute("patientProfile", pP);
		return "update";
	}
	@PostMapping("/update/{patientID}")
	public String updatePatient(@PathVariable("patientID") long patientID, @Valid patientProfile pP,
			BindingResult result, Model patientModel) {
		if (result.hasErrors()) {
			pP.setPatientID(patientID);
			return "update";
		}

		repo.save(pP);
		patientModel.addAttribute("patientProfiles", repo.findAll());
		return "results";
	}
	@GetMapping("/deletePatientProfile/{patientID}")
	public String deleteUser(@PathVariable("patientID") long patientID, Model patientModel) {
		patientProfile pP = repo.findById(patientID).orElseThrow(() -> new IllegalArgumentException("Invalid patient ID:" + patientID));
		repo.delete(pP);
		patientModel.addAttribute("patientProfiles", repo.findAll());
		return "results";

	}
	
	// Appointment Web Controller.  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	@GetMapping("/addAppointment")
	public String addNewAppointment(Model appointmentModel) {
		Appointments appt = new Appointments();
		appointmentModel.addAttribute("newAppointment", appt);
		appointmentModel.addAttribute("docDrop", docrepo.findAll());
		return "makeappt";
	}
	@PostMapping("/addAppointment")
	public String addNewAppointment(@ModelAttribute Appointments appt, Model appointmentModel) {
		apptrepo.save(appt);
		appointmentModel.addAttribute("Appointments", apptrepo.findAll());
		return "resultsappts";
	}
	@GetMapping("/viewAppointments/{patientProfile}")
	public String viewAllAppointments(@PathVariable("patientProfile") patientProfile id, Model apptModel) {
		// Added a find appointment method in the AppointmentRepo file.
		apptModel.addAttribute("appointments", apptrepo.findByPatientProfile(id));
		return "resultsappts";
	}
	@GetMapping("/viewAppointments")
	public String whatIsPatientID() {
		return "whatIsPatientNumber";
	}
	@GetMapping("/viewPatientAppointments")
	public String whatIsPatientID(@RequestParam("patientProfile") patientProfile patientId, Model apptModel) {
		apptModel.addAttribute("appointments", apptrepo.findByPatientProfile(patientId));
		return "resultsappts";
	}
	@GetMapping("/editAppointments/{id}")
	public String showApptUpdateForm(@PathVariable("id") long id, Model apptModel) {
		Appointments a = apptrepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid patient ID:" + id));
		apptModel.addAttribute("appointments", a);
		apptModel.addAttribute("docDrop", docrepo.findAll());
		return "updateappts";
	}
	@PostMapping("/updateappts/{id}")
	public String editAppointment(@ModelAttribute Appointments a, Model appointmentModel) {
		apptrepo.save(a);
		appointmentModel.addAttribute("Appointments", apptrepo.findAll());
		return "resultsappts";
	}
	@GetMapping("/deleteAppointment/{id}")
	public String deleteAppointment(@PathVariable("id") long id, Model appointmentModel) {
		Appointments appt = apptrepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID:" + id));
		patientProfile pid = appt.getPatientProfile();
		apptrepo.delete(appt);
		appointmentModel.addAttribute("appointments", apptrepo.findByPatientProfile(pid));
		return "resultsappts";
	}
	
	//Doctor Web Controller. - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
	@GetMapping("/addDoctorProfile")
	public String addDoctor(Model doctorModel) {
		doctorProfile dP = new doctorProfile();
		doctorModel.addAttribute("newDoctorProfile", dP);
		return "addDoctor";	
	}
		
	@PostMapping("/addDoctorProfile")
	public String addNewDoctorProfile(@ModelAttribute doctorProfile pP, Model doctorModel) {
		docrepo.save(pP);
		doctorModel.addAttribute("doctorProfiles", docrepo.findAll());
		return "resultsdoc";
	}
		
	@GetMapping("/viewAllDoctorProfiles")
	public String viewAllDoctorProfiles(Model model) {
		model.addAttribute("doctorProfiles", docrepo.findAll());
		return "resultsdoc";
	}
}