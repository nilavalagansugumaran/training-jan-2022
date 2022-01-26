package com.example.demo.repository;

import com.example.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeJdbcRepository {

    @Autowired private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void setup() {

         /* h2 create table
                */
        jdbcTemplate.execute("create table EMPLOYEES(" +
                "id int auto_increment, " +
                "name varchar(50), " +
                "email varchar(50), " +
                "salary double, " +
                "dept varchar(50), " +
                "primary key (id) )");
       /*
        sql server
        */
       // jdbcTemplate.execute("create table EMPLOYEES(id INT IDENTITY(1,1) PRIMARY KEY, name varchar(50), salary decimal(15,2), dept varchar(50))");
        jdbcTemplate.update("insert into EMPLOYEES (name, email, salary, dept) values(?,?,?,?)",
                new Object[]{"nila", "nila@nila.com", 1000.0, "eng"});
    }

    public Employee getEmployee(Long id) {
        String sql = "select * from EMPLOYEES where id =?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), id);
    }

    public Employee addEmployee(Employee emp) {
        String sql = "insert into EMPLOYEES (name, email, salary, dept) values(?,?,?,?)";
        jdbcTemplate.update(sql,
                new Object[]{emp.getName(), emp.getEmail(), emp.getSalary(), emp.getDept()});

        sql = "select * from EMPLOYEES where name =?";
        return jdbcTemplate.queryForObject(sql, new EmployeeRowMapper(), emp.getName());
    }

    public void updateEmployee(Employee emp) {
        String sql = "update EMPLOYEES set salary = ? where id=?";

        jdbcTemplate.update(sql,
                new Object[]{emp.getSalary(), emp.getId()});
    }

    public void deleteEmployee(Long id) {
        String sql = "delete from EMPLOYEES where id=?";
        jdbcTemplate.update(sql, id);
    }

    public List<Employee> getAllEmployees() {
        String sql = "select * from EMPLOYEES";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setEmail(rs.getString("email"));
            employee.setSalary(rs.getDouble("salary"));
            employee.setDept(rs.getString("dept"));
            return employee;
        }
    }
}
