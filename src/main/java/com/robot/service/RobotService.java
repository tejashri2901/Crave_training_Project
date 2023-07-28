package com.robot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.robot.RobotDAO;
import com.robot.model.Robot;

@Service
public class RobotService {
	  @Autowired
      RobotDAO robotrepository;
      
      public List<Robot> getall(){
    	  return robotrepository.findAll();
      }
       public Robot getbyid(int id) {
    	   return robotrepository.findById(id).get();
       }
        public Robot createsave(Robot rob) {
        	return robotrepository.save(rob);
        }
        public void deleteCar(int id) {

            // TODO Auto-generated method stub

             robotrepository.deleteById(id);

        }

        

         public Robot updateCar(int id, Robot updatedCar) {

                Robot existingCar = robotrepository.findById(id).orElse(null);

                if (existingCar != null) {

                    existingCar.setModel(updatedCar.getModel());

                    existingCar.setPrice(updatedCar.getPrice());

                    existingCar.setColor(updatedCar.getColor());

                    return robotrepository.save(existingCar);

                }

                return null; // Car with the specified ID not found

            }
}
