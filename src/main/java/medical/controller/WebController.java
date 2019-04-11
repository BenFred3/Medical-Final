// This is the web controller which will help us direct our users where they need to go.
// Package and import statements.
package medical.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import medical.beans.Appointments;
import medical.beans.patientProfile;
import medical.beans.doctorProfile;
import medical.repository.MedicalRepository;
import medical.repository.AppointmentRepository;
import medical.repository.DoctorRepository;

@Controller
public class WebController 
{
	@Autowired
	MedicalRepository repo;
	
	@GetMapping("/addPatientProfile")
	public String addNewPatientProfile(Model patientModel)
	{
		patientProfile pP = new patientProfile();
		patientModel.addAttribute("newPatientProfile", pP);
		return "add";
	}
	
	@PostMapping("/addPatientProfile")
	public String addNewPatientProfile(@ModelAttribute patientProfile pP, Model patientModel)
	{
		repo.save(pP);
		patientModel.addAttribute("patientProfiles", repo.findAll());
		return "results";
	}
	
	@GetMapping("/viewAllPatientProfiles")
	public String viewAllPatientProfiles(Model model) {
		model.addAttribute("patientProfiles", repo.findAll());
		return "results";
	}
  
	@Autowired
	AppointmentRepository apptrepo;
	
	@Autowired
	DoctorRepository docrepo;
	
	@GetMapping("/addAppointment")
	public String addNewAppointment(Model appointmentModel)
	{
		Appointments appt = new Appointments();
		appointmentModel.addAttribute("newAppointment", appt);
		appointmentModel.addAttribute("docDrop", docrepo.findAll());
		return "makeappt";
	}
	
	@PostMapping("/addAppointment")
	public String addNewAppointment(@ModelAttribute Appointments appt, Model appointmentModel)
	{
		apptrepo.save(appt);
		appointmentModel.addAttribute("Appointments", apptrepo.findAll());
		return "resultsappts";
	}
	
	@GetMapping("/viewAppointments/{patientProfile}")
	public String viewAllAppointments(@PathVariable("patientProfile") patientProfile id, Model apptModel) {
		//Added a find appointment method in the AppointmentRepo file.
		apptModel.addAttribute("appointments", apptrepo.findByPatientProfile(id));
		return "resultsappts";
	}
	@GetMapping("/viewAppointments")
	public String whatIsPatientID(){
		return "whatIsPatientNumber";
	}
	@GetMapping("/viewPatientAppointments")
	public String whatIsPatientID(@RequestParam("patientProfile") patientProfile patientId, Model apptModel) {
		apptModel.addAttribute("appointments", apptrepo.findByPatientProfile(patientId));
		return "resultsappts";
	}
	
}
