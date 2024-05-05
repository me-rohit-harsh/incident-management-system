/*
 * package in.rapifuzz.incident;
 * 
 * import java.time.LocalDate; import java.util.Random;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody;
 * 
 * import in.rapifuzz.incident.model.Incident; import
 * in.rapifuzz.incident.repository.IncidentRepository;
 * 
 * public class IncidentUtils {
 * 
 * private static final Random RANDOM = new Random(); private static final int
 * CURRENT_YEAR = 2024; // Consider making this dynamic
 * 
 * @Autowired private IncidentRepository incidentRepository;
 * 
 * public static String generateUniqueId(IncidentRepository incidentRepository)
 * { String id; do { id = "RMG" + (10000 + RANDOM.nextInt(90000)) +
 * CURRENT_YEAR; } while (incidentRepository.existsById(id)); return id; }
 * 
 * public Incident createOrUpdateIncident(Incident incident) { if
 * (incident.getId() == null) { incident.setId(generateUniqueId()); // Method to
 * generate your custom ID }
 * 
 * return incidentRepository.save(incident); }
 * 
 * private String generateUniqueId() { String uniqueId; do { uniqueId = "RMG" +
 * (10000 + new Random().nextInt(90000)) + LocalDate.now().getYear(); } while
 * (incidentRepository.existsById(uniqueId)); return uniqueId; }
 * 
 * @PostMapping("/incidents") public ResponseEntity<Incident>
 * addIncident(@RequestBody Incident incident) { Incident savedIncident =
 * createOrUpdateIncident(incident); return ResponseEntity.ok(savedIncident); }
 * 
 * }
 */