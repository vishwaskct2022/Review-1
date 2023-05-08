package com.pro2.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.pro2.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	//positional parameter
	@Query("select s from Student s where s.department=?1 and s.name=?2")
	public List<Student>getStudentsByDepartment(String dept,String name);
	
	//named parameter
	@Query("select s from Student s where s.department=:dept")
	public List<Student>getStudentsByDepartment(String dept);
	
	//DML
	@Modifying
	@Query("delete from Student s where s.name=?1")
	public int deleteStudentsByName(String name);
	
	@Modifying
	@Query("update Student s set s.department=?1 where s.name=?2")
	public int updateStudentsByName(String dept,String name);
	
	@Query(value="select * from Student  s where  s.email= ?1", nativeQuery=true)
	public List<Student> fetchStudenstByMail(String  mail);
	
	List<Student> findByNameStartingWith(String prefix);
	List<Student> findByNameEndingWith(String suffix);
	List<Student> findByDepartment(String dept);

}
