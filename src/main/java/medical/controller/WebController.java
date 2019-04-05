// This is the web controller which will help us direct our users where they need to go.
// Package and import statements.
package medical.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import medical.beans.patientProfile;
import medical.repository.MedicalRepository;

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
}
