package izatta.izatta.repository;

import izatta.izatta.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPerson extends JpaRepository <Person, Integer> {
}
