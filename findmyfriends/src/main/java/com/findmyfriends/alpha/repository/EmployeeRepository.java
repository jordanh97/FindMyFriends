package com.findmyfriends.alpha.repository;

import com.findmyfriends.alpha.domain.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository 
			extends CrudRepository<Employee, Long> {

}
