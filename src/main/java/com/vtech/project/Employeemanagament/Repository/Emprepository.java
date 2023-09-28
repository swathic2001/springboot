package com.vtech.project.Employeemanagament.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vtech.project.Employeemanagament.entity.Employee;
@Repository
public interface Emprepository extends JpaRepository<Employee, Integer>{

}
