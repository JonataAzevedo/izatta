package izatta.izatta.service;

import izatta.izatta.exception.ResourceBadRequestException;
import izatta.izatta.exception.ResourceNotFoundException;
import izatta.izatta.model.dto.DtoAttendance;
import izatta.izatta.model.dto.DtoChanger;
import izatta.izatta.model.entities.Attendance;
import izatta.izatta.model.entities.enuns.Status;
import izatta.izatta.repository.RepositoryAttendance;
import izatta.izatta.repository.RepositoryDoctor;
import izatta.izatta.repository.RepositoryPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAttendance {

    @Autowired
    private RepositoryAttendance repositoryAttendance;

    @Autowired
    private RepositoryDoctor repositoryDoctor;

    @Autowired
    private RepositoryPerson repositoryPerson;

    public Attendance create (DtoAttendance dtoAttendance){

        Attendance attendance = new Attendance();
        attendance.setName(dtoAttendance.getName());
        attendance.setCpf(dtoAttendance.getCpf());
        attendance.setCrm(dtoAttendance.getCrm());
        attendance.setNameDoctor(dtoAttendance.getNameDoctor());
        attendance.setDateTimeAttendance(dtoAttendance.getDateTimeAttendance());
        attendance.setRoom(dtoAttendance.getRoom());
        attendance.setStatus(Status.valueOf("PENDENTE"));

        if (dtoAttendance.getDateTimeAttendance().isBefore(LocalDateTime.now())){

            throw new ResourceBadRequestException("The date entered cannot be earlier than the current date: " + dtoAttendance.getDateTimeAttendance());
        }

        return repositoryAttendance.save(attendance);
    }

    public Attendance change (Integer id, DtoChanger dtoChanger){

        Optional<Attendance> attendance = repositoryAttendance.findById(id);

        if (attendance.isEmpty()){

            throw new ResourceNotFoundException("Attendance not found for ID: " + id);
        }

        Attendance changeAttendance = attendance.get();
        changeAttendance.setStatus(dtoChanger.getStatus());
        changeAttendance.setDateTimeClose(dtoChanger.getDateTimeClose());

        return repositoryAttendance.save(changeAttendance);
    }

    public Attendance findById (Integer id){

        Optional<Attendance> attendance = repositoryAttendance.findById(id);

        if (attendance.isEmpty()) {

            throw new ResourceNotFoundException("Attendance not found for ID: " + id);
        }

        return attendance.get();
    }

    public List<Attendance> listAll(){

        return repositoryAttendance.findAll();
    }
}
