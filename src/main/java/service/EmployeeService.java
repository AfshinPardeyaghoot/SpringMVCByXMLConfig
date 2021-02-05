package service;

import Entity.Employee;
import dao.AbstractEmployeeDAO;
import dao.EmployeeDAOIml;

import java.util.List;

public class EmployeeService {
    private AbstractEmployeeDAO abstractEmployeeDAO;

    public EmployeeService(AbstractEmployeeDAO abstractEmployeeDAO) {
        this.abstractEmployeeDAO = abstractEmployeeDAO;
    }

    public List<Employee> getAllEmployee(){
        List<Employee> employees = abstractEmployeeDAO.getAllEmployee();
        return employees;
    }

    public Employee getEmployeeById(Integer id){
        Employee employee = abstractEmployeeDAO.getEmployeeById(id);
        return employee;
    }

    public void createEmployee(Employee employee){
        abstractEmployeeDAO.createEmployee(employee);
    }

    public void deleteEmployee(Integer id){
        Employee employee = abstractEmployeeDAO.getEmployeeById(id);
        abstractEmployeeDAO.deleteEmployee(employee);
    }

}
