package izatta.izatta.model.entities;

import io.swagger.annotations.ApiModelProperty;
import izatta.izatta.model.entities.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Attendance code")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @ApiModelProperty(value = "Patient name")
    @Column(nullable = false, length = 255)
    private String name;

    @ApiModelProperty(value = "Patient CPF")
    @Column(nullable = false, length = 11)
    private String cpf;

    @ApiModelProperty(value = "Doctor CRM")
    @Column(nullable = false)
    private String crm;

    @ApiModelProperty(value = "Doctor name")
    @Column(nullable = false, length = 255)
    private String nameDoctor;

    @ApiModelProperty(value = "Medical room")
    @Column(nullable = false)
    private Integer room;

    @ApiModelProperty(value = "Data for attendance")
    @Column(nullable = false)
    private LocalDate dateAttendance;

    @ApiModelProperty(value = "Hour for attendance")
    @Column(nullable = false)
    private Time hourAttendance;

    @ApiModelProperty(value = "Status for attendance")
    @Enumerated
    @Column(nullable = false, length = 9)
    private Status status;

    @ApiModelProperty(value = "Date for closed attendance")
    @Column
    private LocalDate dateClosed;

    @ApiModelProperty(value = "Hour for closed attendance")
    @Column
    private Time hourClosed;
}