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

import medical.beans.Appointments;
import medical.beans.patientProfile;
import medical.repository.MedicalRepository;
import medical.repository.AppointmentRepository;

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
	
	@GetMapping("/addAppointment")
	public String addNewAppointment(Model appointmentModel)
	{
		Appointments appt = new Appointments();
		appointmentModel.addAttribute("newAppointment", appt);
		return "makeappt";
	}
	
	@PostMapping("/addAppointment")
	public String addNewAppointment(@ModelAttribute Appointments appt, Model appointmentModel)
	{
		apptrepo.save(appt);
		appointmentModel.addAttribute("Appointments", apptrepo.findAll());
		return "results";
	}
	
	@GetMapping("/viewAppointments/{patientId}")
	public String viewAllAppointments(@PathVariable("patientId") long id, Model apptModel) {
		//Added a find appointment method in the AppointmentRepo file.
		apptModel.addAttribute("appointments", apptrepo.findByPatientId(id));
		return "resultsappts";
	}
	
}
