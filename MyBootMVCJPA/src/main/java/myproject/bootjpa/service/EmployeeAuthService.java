package myproject.bootjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myproject.bootjpa.entity.Employees;
import myproject.bootjpa.repository.EmployeeRepo;

@Service
public class EmployeeAuthService {

	@Autowired
	EmployeeRepo employeerepo;
	
	public boolean LoginAction(String name,String code) {
		
		Optional<Employees> obj = employeerepo.findByNameAndCode(name, code);

		return obj.isPresent();
	}
}
