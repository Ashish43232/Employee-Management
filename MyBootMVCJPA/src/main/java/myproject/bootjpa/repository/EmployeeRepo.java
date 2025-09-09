package myproject.bootjpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myproject.bootjpa.entity.Employees;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Long>{
	
	//Select * from employees where name  = ? and code = ?;
	
	Optional<Employees> findByNameAndCode(String name,String code);

}
