package controller;

import Entity.Employee;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateEmployeeController extends AbstractController {

    private EmployeeService employeeService ;

    public CreateEmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String name = httpServletRequest.getParameter("name");
        Employee employee = new Employee();
        employee.setName(name);
        employeeService.createEmployee(employee);
        ModelAndView modelAndView = new ModelAndView("createEmployee");
        return modelAndView ;
    }
}
