package com.petex.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petex.entity.DrAppointmentEntity;
import com.petex.service.DrAppointmentService;

@RestController
@RequestMapping("/petex")
public class DrAppointmentRestController {

	@Autowired
	private DrAppointmentService servies;

	@PostMapping("/save")
	public ResponseEntity<String> saveAppointment(@RequestBody DrAppointmentEntity entity) {
		Boolean status = servies.save(entity);
		if (status) {
			return new ResponseEntity<String>("Appointment booked success", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Appointment not success", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/get/{customerId}")
	public ResponseEntity<DrAppointmentEntity> getAppointment(@PathVariable Integer customerId) {
		DrAppointmentEntity entity = servies.getAppintmentById(customerId);
		return new ResponseEntity<DrAppointmentEntity>(entity, HttpStatus.OK);

	}

	@GetMapping("/getAll")
	public ResponseEntity<List<DrAppointmentEntity>> getAllAppintment() {
		List<DrAppointmentEntity> entity = servies.getAllAppointmentData();
		return new ResponseEntity<List<DrAppointmentEntity>>(entity, HttpStatus.OK);

	}

	 @PutMapping("/update/{customerId}")
	    public ResponseEntity<String> updateAppointment(@PathVariable Integer customerId,
	                                                   @RequestBody DrAppointmentEntity entity) {
	        Boolean updatedStatus = servies.updateAppointmentData(customerId, entity);

	        if (updatedStatus) {
	            return new ResponseEntity<>("Appointment data updated successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Appointment data not updated successfully", HttpStatus.BAD_REQUEST);
	        }
	    }
	 
	 @DeleteMapping("/delete/{customerId}")
	 public ResponseEntity<String> deleteAppointment(@PathVariable Integer customerId) {
	     String deleteStatus = servies.deleteAppointmentById(customerId);

	     if (deleteStatus.equals("deleted")) {
	         return new ResponseEntity<>("Appointment deleted successfully", HttpStatus.OK);
	     } else {
	         return new ResponseEntity<>("Appointment not found or not deleted successfully", HttpStatus.NOT_FOUND);
	     }
	 }


}
