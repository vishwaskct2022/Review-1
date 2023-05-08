package com.pro2.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pro2.demo.model.Student;
import com.pro2.demo.repository.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentservice;
	
	public List<Student> getAllStudents()
	{
		List<Student>studentList=studentservice.findAll();
		return studentList;
	}
	
	public Student saveStudent(Student s) {
		return studentservice.save(s);
	}
	
	public void deleteStudent(int s) {
		studentservice.deleteById(s);
	}
	public List<Student>sortStudents(String field){
		return studentservice.findAll(Sort.by(Direction.DESC,field));
	}
	public  Student updateStudent(Student s,int regno) {
		Optional<Student> optional=studentservice.findById(regno);
		Student obj=null;
		if(optional.isPresent())
		{
			obj=optional.get();
			obj.setRegno(s.getRegno());
			obj.setName(s.getName());
			obj.setDepartment(s.getDepartment());
			obj.setEmail(s.getEmail());
		studentservice.saveAndFlush(s);
		}
		return obj;
	}
	
	public List<Student>pagingStudents(int offset,int pageSize){
		Pageable paging=PageRequest.of(offset,pageSize);
		Page<Student>studentData=studentservice.findAll(paging);
		List<Student>studentList=studentData.getContent();
		return studentList;
	}
	public List<Student> pagingAndSortingStudents(int offset,
			int pageSize,String field) {
		Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
			Page<Student> student=studentservice.findAll(paging);
			return student.getContent();
		}
	public List<Student> fetchStudentsByNamePrefix(String prefix)
	  {
		  return studentservice.findByNameStartingWith(prefix);
	  }
	public List<Student>getStudentsByDepartment(String dept,String name)
	{
		return studentservice.getStudentsByDepartment(dept,name);
	}
	@Transactional
	public int deleteStudentByName(String name)
	{
		return studentservice.deleteStudentsByName(name);
	}
	@Transactional
	public int updateStudentsByName(String dept,String name)
	{
		return studentservice.updateStudentsByName(dept,name);
	}

	
}
