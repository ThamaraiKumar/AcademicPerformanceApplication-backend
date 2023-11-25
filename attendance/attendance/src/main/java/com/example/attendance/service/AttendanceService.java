package com.example.attendance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.attendance.entity.Attendance;
import com.example.attendance.repository.AttendanceRepo;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceRepo attendanceRepo;
	
	
	public void saveAttendance(Attendance att)
	{
		attendanceRepo.save(att);
	}
	
//	public void updateAttendance(LocalDate date) {
//        Iterable<StudentEntity> students = getStudentsFromStudentService();
//
//        for (StudentEntity student : students) {
//        	Attendance attendance = new Attendance();
//            attendance.setEmailid(student.getEmailid());
//            attendance.setRollno(student.getRollno());
//            attendance.setName(student.getName());
//            attendance.setDepartment(student.getDepartment());
//            attendance.setGender(student.getGender());
//            attendance.setAtt(attendance.getAtt()); 
//            attendance.setDate(date);
//            attendanceRepo.save(attendance);
//
//        }
//    }
//	private List<StudentEntity> getStudentsFromStudentService() {
//		String studentsUrl = "http://localhost:1001/student/getAllstudent";
//		StudentEntity[] students = restTemplate.getForObject(studentsUrl, StudentEntity[].class);
//		return List.of(students);
//		
//	}
}

