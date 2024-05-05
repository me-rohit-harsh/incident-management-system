package in.rapifuzz.incident.controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.rapifuzz.incident.model.Incident;
import in.rapifuzz.incident.repository.IncidentRepository;
import in.rapifuzz.incident.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private IncidentRepository incidentRepository;

	@Autowired
	private UserRepository userRepository;

	 @GetMapping("/user/{userId}")
	    public String viewUserDetails(@PathVariable Long userId, Model model, RedirectAttributes redirectAttributes) {
	        return userRepository.findById(userId).map(user -> {
	            model.addAttribute("user", user);
	            model.addAttribute("incidents", incidentRepository.findByUserId(userId));
	            return "userDetails"; // Thymeleaf template
	        }).orElseGet(() -> {
	            redirectAttributes.addFlashAttribute("errorMessage", "User not found.");
	            return "redirect:/admindashboard";
	        });
	    }



	
	



	@GetMapping("/admindashboard")
	    public String adminDashboard(@RequestParam Optional<String> incidentId, Model model) {
	        if (incidentId.isPresent()) {
	            incidentRepository.findById(incidentId.get())
	                .ifPresent(incident -> model.addAttribute("incidents", List.of(incident)));
	        } else {
	            List<Incident> incidents = incidentRepository.findAll();
	            model.addAttribute("incidents", incidents);
	        }
	        return "adminDashboard";  // Name of the Thymeleaf template
	    }

	@PostMapping("/updateStatus/{id}")
	public ResponseEntity<?> updateIncidentStatus(@PathVariable String id, @RequestBody Map<String, String> request) {
		System.out.println("Attempting to update the status for ID " + id + " to " + request.get("status"));

		return incidentRepository.findById(id).map(incident -> {
			incident.setStatus(request.get("status"));
			incidentRepository.save(incident);
			System.out.println("ok ok");
			return ResponseEntity.ok("Status updated successfully");
			
		}).orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	

}
