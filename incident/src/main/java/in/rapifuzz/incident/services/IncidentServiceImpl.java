package in.rapifuzz.incident.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.rapifuzz.incident.model.Incident;
import in.rapifuzz.incident.repository.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService{

	@Autowired
	private IncidentRepository incidentRepository;
	
	@Override
	public Incident save(Incident incident) {
		return incidentRepository.save(incident);
	}
	/*
	 * public Incident createIncident(Incident incident) { if (incident.getId() ==
	 * null || incident.getId().isEmpty()) {
	 * incident.setId(IncidentUtils.generateUniqueId()); } return
	 * incidentRepository.save(incident); }
	 */
	
//	@Override
//	public List<Incident> findByUserId(Long userId) {
//	return	incidentRepository.findByUserId(userId);
//	}

}
