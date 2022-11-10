package izatta.izatta.model.entities;

import izatta.izatta.model.entities.enuns.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false)
    private Integer crm;

    @Column(nullable = false, length = 255)
    private String nameDoctor;

    @Column(nullable = false)
    private Integer room;

    @Column(nullable = false)
    private LocalDateTime dateTimeAttendance;

    @Enumerated
    @Column(nullable = false, length = 9)
    private Status status;

    @Column
    private LocalDateTime dateTimeClose;
}
