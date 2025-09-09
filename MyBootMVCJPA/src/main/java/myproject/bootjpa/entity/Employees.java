package myproject.bootjpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Employee_no")
	Long Empno;
	
	@Column(name="Employee_name")
	String name;
	
	@Column(name="Employee_code")
	String code;
	
	@Column(name="Employee_salary")
	int salary;
	
	   // Default constructor
    public Employees() {}

    // Constructor without id
    public Employees(String name, String code, int salary) {
        this.name = name;
        this.code = code;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
