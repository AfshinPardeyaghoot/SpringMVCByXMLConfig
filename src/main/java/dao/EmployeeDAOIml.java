package dao;

import Entity.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class EmployeeDAOIml implements AbstractEmployeeDAO{

    private JdbcTemplate jdbcTemplate ;

    private final String SQL_FIND_EMPLOYEE_BY_ID = "select * from employee where id=?";
    private final String SQL_FIND_ALL_EMPLOYEE = "select * from employee ";
    private final String SQL_DELETE_EMPLOYEE_BY_ID = "delete from employee where id=?";
    private final String SQL_INSERT_EMPLOYEE = "insert into employee(name) values(?)";
    private final String SQL_UPDATE_EMPLOYEE = "update employee(name) set values(?)";

    public EmployeeDAOIml(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee employee = this.jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE_BY_ID,new Object[]{id},new EmployeeMapper());
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.jdbcTemplate.query(SQL_FIND_ALL_EMPLOYEE,new EmployeeMapper());
    }

    @Override
    public boolean deleteEmployee(Employee employee) {
        return this.jdbcTemplate.update(SQL_DELETE_EMPLOYEE_BY_ID,employee.getId())>0;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return this.jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,employee.getId(),employee.getName())>0;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        return this.jdbcTemplate.update(SQL_INSERT_EMPLOYEE,employee.getName())>0;
    }
}
