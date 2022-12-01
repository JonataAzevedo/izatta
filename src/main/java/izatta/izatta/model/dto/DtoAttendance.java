package izatta.izatta.model.dto;

import com.sun.istack.NotNull;
import izatta.izatta.model.entities.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DtoAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String crm;

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