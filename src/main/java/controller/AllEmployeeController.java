package controller;

import Entity.Employee;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AllEmployeeController extends AbstractController {

    private EmployeeService employeeService ;

    public AllEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<Employee> employees = employeeService.getAllEmployee();
        ModelAndView modelAndView = new ModelAndView("allEmployees");
        modelAndView.addObject("employee",employees);
        return modelAndView ;
    }
}
