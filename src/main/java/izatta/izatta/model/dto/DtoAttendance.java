package izatta.izatta.model.dto;

import com.sun.istack.NotNull;
import izatta.izatta.model.entities.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoAttendance {

    @NotNull
    private String name;

    @NotNull
    private Integer crm;

    @NotNull
    private String cpf;

    @NotNull
    private String nameDoctor;

    @NotNull
    private LocalDate dateAttendance;

    @NotNull
    private Integer room;

    @NotNull
    @Enumerated
    private Status status;

    @NotNull
    @Column(nullable = false)
    private Time hourAttendance;
}