package izatta.izatta.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @ApiOperation(value = "This endpoint creates a medical appointment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create a medical appointment"),
            @ApiResponse(code = 500, message = "An exception was thrown")
    })
    @PostMapping(produces="application/json", consumes = "application/json")
    public ResponseEntity<Attendance> create(@RequestBody DtoAttendance dtoAttendance){

        Attendance attendance = serviceAttendance.create(dtoAttendance);

        return new ResponseEntity<>(attendance, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Cancel an appointment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Put date/time of canceled service" ),
            @ApiResponse(code = 404, message = "ID not found"),
            @ApiResponse(code = 500, message = "An exception was thrown")
    })
    @PutMapping(value= "/cancel/{id}", produces="application/json", consumes = "application/json")
    public ResponseEntity<Attendance> changeCancel(@PathVariable Integer id, @RequestBody DtoChanger dtoChanger){

        return new ResponseEntity<>(serviceAttendance.chanceCancel(id, dtoChanger), HttpStatus.OK);
    }

    @ApiOperation(value = "Change data and time")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Change the date/time of an appointment"),
            @ApiResponse(code = 404, message = "ID not found"),
            @ApiResponse(code = 500, message = "An exception was thrown")
    })
    @PutMapping(value = "/change/{id}", produces="application/json", consumes = "application/json")
    public ResponseEntity<Attendance> changeDateAttendance(@PathVariable Integer id, @RequestBody DtoChangeAttendance changeAttendance){

        return new ResponseEntity<>(serviceAttendance.changeDateAttendance(id, changeAttendance), HttpStatus.OK);
    }

    @ApiOperation(value = "Return attendance for ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a attendance for ID"),
            @ApiResponse(code = 404, message = "ID not found"),
            @ApiResponse(code = 500, message = "An exception was thrown")
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<Attendance> findById (@PathVariable Integer id){

        return new ResponseEntity<>(serviceAttendance.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Returns a list of appointment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of appointment"),
            @ApiResponse(code = 500, message = "An exception was thrown")
    })
    @GetMapping(produces="application/json")
    public List<Attendance> findAll(){

        return serviceAttendance.listAll();
    }
}