package com.besterCapitalMedia.javaentryexam.Controller;


import com.besterCapitalMedia.javaentryexam.model.Employee;
import com.besterCapitalMedia.javaentryexam.service.EmployeeService;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity deliveryManagements(HttpServletRequest request) throws Exception{
        HashMap response = new HashMap();
        boolean success = false;
        List errors = new ArrayList();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "";
        Map data = new HashMap();
        try {

            List<Employee> employees=employeeService.getall();
            Collections.reverse(employees);
            data.put("Employees", employees);
            success = true;
            message = "Employees List";
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            errors.add(new ErrorMessages() {
            });
        }
        response.put("success", success);
        response.put("errors", errors);
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity(response, httpStatus);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deliveryManagements(@RequestBody Employee employee) throws Exception{
        HashMap response = new HashMap();
        boolean success = false;
        List errors = new ArrayList();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "";
        Map data = new HashMap();
        try {

            employeeService.create_update(employee);

            success = true;
            message = "Employees List";
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            errors.add(new ErrorMessages() {
            });
        }
        response.put("success", success);
        response.put("errors", errors);
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity(response, httpStatus);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getEmployeeDetail(@PathVariable("id") int id) throws Exception{
        HashMap response = new HashMap();
        boolean success = false;
        List errors = new ArrayList();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "";
        Map data = new HashMap();
        try {

           Optional<Employee> employee= employeeService.findById(id);
            data.put("Employee",employee);
            success = true;
            message = "Employee detail";
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            errors.add(new ErrorMessages() {
            });
        }
        response.put("success", success);
        response.put("errors", errors);
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity(response, httpStatus);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployee(@PathVariable("id") int id) throws Exception{
        HashMap response = new HashMap();
        boolean success = false;
        List errors = new ArrayList();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        String message = "";
        Map data = new HashMap();
        try {

             employeeService.deleteEmployee(id);

            success = true;
            message = "Employee deleted";
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            errors.add(new ErrorMessages() {
            });
        }
        response.put("success", success);
        response.put("errors", errors);
        response.put("message", message);
        response.put("data", data);
        return new ResponseEntity(response, httpStatus);
    }
}
