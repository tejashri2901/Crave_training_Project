package com.robot;

import org.springframework.data.jpa.repository.JpaRepository;

import com.robot.model.Robot;

public interface RobotDAO extends JpaRepository<Robot,Integer> {

}
