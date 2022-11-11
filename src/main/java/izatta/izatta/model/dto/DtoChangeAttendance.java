package izatta.izatta.model.dto;

import com.sun.istack.NotNull;
import izatta.izatta.model.entities.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoChangeAttendance {

    @NotNull
    @Column(nullable = false)
    private LocalDate dateAttendance;

    @NotNull
    @Column(nullable = false)
    private Time hourAttendance;

    @NotNull
    @Column(nullable = false)
    private Status status;
}
