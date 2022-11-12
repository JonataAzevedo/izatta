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
public class DtoChanger {

    @NotNull
    @Enumerated
    private Status status;

    @Column
    private LocalDate dateClosed;

    @Column
    private Time hourClosed;
}