package controller;

import Entity.Employee;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import service.EmployeeService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeByIdController extends AbstractController {
    private EmployeeService employeeService;

    public GetEmployeeByIdController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Integer id = Integer.valueOf(httpServletRequest.getParameter("id"));
        Employee employee = employeeService.getEmployeeById(id);
        ModelAndView modelAndView = new ModelAndView("getEmpByID");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
}
