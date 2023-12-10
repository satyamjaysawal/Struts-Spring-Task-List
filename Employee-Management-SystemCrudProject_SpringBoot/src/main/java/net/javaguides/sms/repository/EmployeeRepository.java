package net.javaguides.sms.repository;

import net.javaguides.sms.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  


	@Query("SELECT e FROM Employee e " +
		       "WHERE LOWER(e.firstname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
		       "OR LOWER(e.lastname) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
		       "OR CAST(e.id AS STRING) LIKE :searchTerm")
		List<Employee> searchEmployeesByGenericTerm(@Param("searchTerm") String searchTerm);


  
    List<Employee> findAllByOrderByFirstnameAsc();
  
    List<Employee> findAllByOrderByLastnameAsc();

    List<Employee> findAllByOrderByEmailAsc(); 
}
