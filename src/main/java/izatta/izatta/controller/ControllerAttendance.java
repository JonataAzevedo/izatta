package izatta.izatta.controller;

import izatta.izatta.model.dto.DtoAttendance;
import izatta.izatta.model.dto.DtoChangeAttendance;
import izatta.izatta.model.dto.DtoChanger;
import izatta.izatta.model.entities.Attendance;
import izatta.izatta.service.ServiceAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
public class ControllerAttendance {

    @Autowired
    private ServiceAttendance serviceAttendance;

    @PostMapping
    public ResponseEntity<Attendance> create(@RequestBody DtoAttendance dtoAttendance){

        Attendance attendance = serviceAttendance.create(dtoAttendance);

        return new ResponseEntity<>(attendance, HttpStatus.CREATED);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<Attendance> changeCancel(@PathVariable Integer id, @RequestBody DtoChanger dtoChanger){

        return new ResponseEntity<>(serviceAttendance.chanceCancel(id, dtoChanger), HttpStatus.OK);
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<Attendance> changeDateAttendance(@PathVariable Integer id, @RequestBody DtoChangeAttendance changeAttendance){

        return new ResponseEntity<>(serviceAttendance.changeDateAttendance(id, changeAttendance), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> findById (@PathVariable Integer id){

        return new ResponseEntity<>(serviceAttendance.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Attendance> findAll(){

        return serviceAttendance.listAll();
    }
}