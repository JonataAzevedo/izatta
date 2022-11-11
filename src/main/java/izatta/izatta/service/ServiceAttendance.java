package izatta.izatta.service;

import izatta.izatta.exception.ResourceBadRequestException;
import izatta.izatta.exception.ResourceNotFoundException;
import izatta.izatta.model.dto.DtoAttendance;
import izatta.izatta.model.dto.DtoChangeAttendance;
import izatta.izatta.model.dto.DtoChanger;
import izatta.izatta.model.entities.Attendance;
import izatta.izatta.model.entities.enuns.Status;
import izatta.izatta.repository.RepositoryAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceAttendance {

    @Autowired
    private RepositoryAttendance repositoryAttendance;

    public Attendance create (DtoAttendance dtoAttendance){

        Attendance attendance = new Attendance();
        attendance.setName(dtoAttendance.getName());
        attendance.setCpf(dtoAttendance.getCpf());
        attendance.setCrm(dtoAttendance.getCrm());
        attendance.setNameDoctor(dtoAttendance.getNameDoctor());
        attendance.setDateAttendance(dtoAttendance.getDateAttendance());
        attendance.setHourAttendance(dtoAttendance.getHourAttendance());
        attendance.setRoom(dtoAttendance.getRoom());
        attendance.setStatus(Status.valueOf("PENDENTE"));


        if (dtoAttendance.getDateAttendance().isBefore(LocalDate.now())){
            throw new ResourceBadRequestException("The date entered cannot be earlier than the current date: " + dtoAttendance.getDateAttendance());
        }

        if (repositoryAttendance.existsByDateAttendanceAndCpf(dtoAttendance.getDateAttendance(), dtoAttendance.getCpf())){
            throw new RuntimeException("This person already has an appointment for this day: " + dtoAttendance.getDateAttendance());
        }

        return repositoryAttendance.save(attendance);
    }

    public Attendance changeDateAttendance(Integer id, DtoChangeAttendance dtoChangeAttendance){

        Optional<Attendance> attendance = repositoryAttendance.findById(id);

        if (attendance.isEmpty()){
            throw new ResourceNotFoundException("Attendance not found for ID: " + id);
        }

        Attendance changeAttendance = attendance.get();
        changeAttendance.setDateAttendance(dtoChangeAttendance.getDateAttendance());
        changeAttendance.setHourAttendance(dtoChangeAttendance.getHourAttendance());

        return repositoryAttendance.save(changeAttendance);
    }

    public Attendance chanceCancel (Integer id, DtoChanger dtoChanger){

        Optional<Attendance> attendance = repositoryAttendance.findById(id);

        if (attendance.isEmpty()){
            throw new ResourceNotFoundException("Attendance not found for ID: " + id);
        }

        Attendance changeAttendance = attendance.get();
        changeAttendance.setStatus(dtoChanger.getStatus());
        changeAttendance.setDateClosed(dtoChanger.getDateClosed());
        changeAttendance.setHourClosed(dtoChanger.getHourClosed());

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