package com.example.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.attendance.entity.Attendance;
import com.example.attendance.service.AttendanceService;

@RestController
@RequestMapping("/staffAttendance")
@CrossOrigin
public class AttendanceController {
	
	@Autowired
	AttendanceService attendanceService;
	
	
	@PostMapping("/postAttendance")
	public void SaveAttendance(@RequestBody Attendance att)
	{
		attendanceService.saveAttendance(att);
	}
//	@PostMapping("/update")
//    public ResponseEntity<String> updateAttendance(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        attendanceService.updateAttendance(date);
//        return ResponseEntity.ok("Attendance updated for " + date);
//    }

}
