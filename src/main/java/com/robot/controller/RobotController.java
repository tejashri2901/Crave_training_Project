package com.robot.controller;

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

import com.robot.model.Robot;
import com.robot.service.RobotService;

@RestController
@RequestMapping("/api")
public class RobotController {
	    @Autowired
        RobotService robservice;
	    
	    @GetMapping("/robot")
	    public List<Robot> getall(){
	    	return robservice.getall();
	    	
	    }
	    @GetMapping("/robot/{id}")
	    public Robot getbyid(@PathVariable int id){
	    	return robservice.getbyid(id);
	    	
	    }
	    @PostMapping("/robot")
	    public Robot createsave(@RequestBody Robot robot){
	    	return robservice.createsave(robot);
	    	
	    }
	    
	    @DeleteMapping("/robot/{id}")
	    public ResponseEntity<String> deleteCar(@PathVariable int id) {

	        try {

	            robservice.deleteCar(id);

	            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);

	        } catch (Exception e) {

	            return new ResponseEntity<>("Failed to delete the book", HttpStatus.INTERNAL_SERVER_ERROR);

	        }

	    }

	    

	    

	    @PutMapping("/robot/{id}")

	    public ResponseEntity<String> updateCar(@PathVariable int id, @RequestBody Robot updatedCar) {

	        try {

	            Robot updatedCarResult = robservice.updateCar(id, updatedCar);

	            if (updatedCarResult != null) {

	                return new ResponseEntity<>("Car updated successfully", HttpStatus.OK);

	            } else {

	                return new ResponseEntity<>("Car with the given ID not found", HttpStatus.NOT_FOUND);

	            }

	        } catch (Exception e) {

	            return new ResponseEntity<>("Failed to update the car", HttpStatus.INTERNAL_SERVER_ERROR);

	        }

	    }
}
