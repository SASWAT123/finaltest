package com.verizon.tls.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verizon.tls.model.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
