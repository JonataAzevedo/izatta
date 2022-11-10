package izatta.izatta.repository;

import izatta.izatta.model.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface RepositoryAttendance extends JpaRepository <Attendance, Integer> {
}
