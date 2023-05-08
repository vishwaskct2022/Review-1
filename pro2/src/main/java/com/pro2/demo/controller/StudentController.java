package com.pro2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro2.demo.model.Student;
import com.pro2.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService StudentController;
	
	@GetMapping("fetchstudent")
	public List<Student> getAllStudents()
	{
		List<Student>studentList=StudentController.getAllStudents();
		return studentList;
	}
	
	@PostMapping("save-student")
	public Student saveStudent(@RequestBody Student s ) {
		return StudentController.saveStudent(s);
	}
	@PutMapping("/updateStudent/{regno}")
	public  Student updateStudent(@RequestBody Student s,@PathVariable("regno") int regno)
	{	
		return StudentController.updateStudent(s,regno);
	}	
	@DeleteMapping("delete-student/{id}")
	public void deleteStudent(@PathVariable("id") int id) {
		StudentController.deleteStudent(id);
	}
	@GetMapping("/sortStudents/{field}")
	public List<Student>sortStudents(@PathVariable String field){
		return StudentController.sortStudents(field);
	}
	@GetMapping("/pagingStudents/{offset}/{pageSize}")
	public List<Student>pagingStudents(@PathVariable int offset,@PathVariable int pageSize)
	{
		return StudentController.pagingStudents(offset,pageSize);
	}
	@GetMapping("/pagingAndSortingStudents/{offset}/{pageSize}/{field}")

	public List<Student> pagingAndSortingEmployees(@PathVariable int offset,
			@PathVariable int pageSize,
			@PathVariable String field) 
	{
		return StudentController.pagingAndSortingStudents(offset, pageSize, field);
	}
	@GetMapping("/fetchStudentsByNamePrefix")
	public List<Student>fetchStudentsByNamePrefix(@RequestParam String prefix)
	{
		return StudentController.fetchStudentsByNamePrefix(prefix);
	}
	@GetMapping("/fetchStudentsByDepartment/{dept}/{name}")
	public List<Student>fetchStudentsByDepartment(@PathVariable String dept,@PathVariable String name)
	{
		return StudentController.getStudentsByDepartment(dept,name);
	}
	@DeleteMapping("/deleteStudentsByName/{name}")
	public String deleteStudentByName(String name)
	{
		int result=StudentController.deleteStudentByName(name);
		if(result>0)
			return "Student record deleted";
		else
			return "Problem occured while deleting";
		
	}
	@PutMapping("/updateStudentsByName")
	public String update(@RequestParam String dept,@RequestParam String name)
	{
		int result=StudentController.updateStudentsByName(dept,name);
		if(result>0)
			return "Updated Successfully";
		else
			return "Problem occured while updating";
		
	}

}
