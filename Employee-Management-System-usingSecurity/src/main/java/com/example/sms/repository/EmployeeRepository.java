package com.example.sms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.sms.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  


	@Query("SELECT e FROM Employee e " +
		       "WHERE LOWER(e.firstname) LIKE LOWER(CONCAT(:searchTerm, '%')) " +
		       "OR LOWER(e.lastname) LIKE LOWER(CONCAT(:searchTerm, '%')) " +
		       "OR CAST(e.id AS STRING) LIKE CONCAT(:searchTerm, '%')")
		List<Employee> searchEmployeesByGenericTerm(@Param("searchTerm") String searchTerm);


  
    List<Employee> findAllByOrderByFirstnameAsc();
  
    List<Employee> findAllByOrderByLastnameAsc();

    List<Employee> findAllByOrderByEmailAsc(); 
}
