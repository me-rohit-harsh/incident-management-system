package in.rapifuzz.incident.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import in.rapifuzz.incident.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, String> {
	Optional<Incident> findByIdAndUserId(String id, Long userId);

	List<Incident> findByUserId(Long userId);

    List<Incident> findByDetails(String details);
    List<Incident> findByStatus(String status);
    
    boolean existsById(String id);
}