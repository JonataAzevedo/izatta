package izatta.izatta.model.entities;

import izatta.izatta.model.entities.enuns.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated
    @Column(nullable = false, length = 9)
    private Gender gender;

    @Column(nullable = false)
    private Integer crm;

    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer room;
}
