package com.example.demo.repository;

import com.example.demo.models.EmployeeJPA;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends CrudRepository<EmployeeJPA, Long> {

    EmployeeJPA findEmployeeJPAByEmailIsNullOrderById();

}
