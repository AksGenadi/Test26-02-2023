package com.company.repo;

import com.company.beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	List<Employee> findEmployeeByName(String name);
}
