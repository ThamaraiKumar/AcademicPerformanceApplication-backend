package com.example.attendance.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.attendance.entity.Attendance;

@Repository
public interface AttendanceRepo extends JpaRepository<Attendance, String> {
	
	   public Iterable<Attendance> findByDate(LocalDate date);

}
