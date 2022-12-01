package izatta.izatta.service;

import izatta.izatta.model.dto.DtoAttendance;
import izatta.izatta.model.entities.Attendance;
import izatta.izatta.model.entities.enuns.Status;
import izatta.izatta.repository.RepositoryAttendance;
import org.assertj.core.api.Assertions;;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ServiceAttendanceTest {

    @Autowired
    ServiceAttendance serviceAttendance;

    @MockBean
    RepositoryAttendance repositoryAttendance;

    @BeforeEach
    public void init(){

         Attendance attendanceMock = Attendance.builder()
                 .id(15)
                 .name("nome paciente")
                 .cpf("47522770858")
                 .crm("1234521")
                 .nameDoctor("nome doctor")
                 .room(12)
                 .dateAttendance(LocalDate.now())
                 .hourAttendance(Time.valueOf(LocalTime.now()))
                 .status(Status.valueOf("PENDENTE"))
                 .dateClosed(LocalDate.of(2022,12,12))
                 .hourClosed(Time.valueOf(LocalTime.now()))
                 .build();

         Mockito.when(repositoryAttendance.save(attendanceMock)).thenReturn(attendanceMock);
         Mockito.when(repositoryAttendance.findById(1)).thenReturn(Optional.of(attendanceMock));
    }

    @Test
    void create() {

        DtoAttendance dtoAttendance = new DtoAttendance(25
                , "nome paciente"
                , "1234521"
                , "47522770858"
                , "nome doctor"
                , LocalDate.of(2022,12,12)
                , 12
                , Status.PENDENTE
                , Time.valueOf(LocalTime.now()));

        Attendance attendance = serviceAttendance.create(dtoAttendance);

        Assertions.assertThat(dtoAttendance).isNotNull();
        Assertions.assertThat(dtoAttendance.getId()).isEqualTo(25);
        Assertions.assertThat(dtoAttendance.getId()).isNotNull();
    }
}