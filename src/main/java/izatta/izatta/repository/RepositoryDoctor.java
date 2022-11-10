package izatta.izatta.repository;

import izatta.izatta.model.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryDoctor extends JpaRepository <Doctor, Integer> {
}
