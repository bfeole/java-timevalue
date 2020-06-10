package local.bfeole.timevalue.controllers;

import local.bfeole.timevalue.Employee;
import local.bfeole.timevalue.TimeValueApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class EmployeeController
{
    // http://localhost:8080/data/allemployees
    @GetMapping(value = "/allemployees",
            produces = {"application/json"})
    public ResponseEntity<?> getAllEmployees()
    {
        TimeValueApplication.ourEmpList.empList.sort((e1, e2) -> ((int) (e1.getSalary() - e2.getSalary())));
        return new ResponseEntity<>(TimeValueApplication.ourEmpList.empList, HttpStatus.OK);
    }

    // http://localhost:8080/data/employee/2
    @GetMapping(value = "/employee/{empid}",
            produces = {"application/json"})
    public ResponseEntity<?> getEmployeeById(@PathVariable long empid)
    {
        Employee rtnEmp = TimeValueApplication.ourEmpList
                .findEmployee(e -> (e.getId() == empid));
        return new ResponseEntity<>(rtnEmp, HttpStatus.OK);
    }

    // http://localhost:8080/data/employees/s
    // find list of employees whose fname starts with s

    @GetMapping(value = "/employees/{letter}",
            produces = {"application/json"})
    public ResponseEntity<?> getEmployeesByLetter(@PathVariable char letter)
    {
        // Main class   ->    Object List ->  That method from OBJ
        List<Employee> rtnEmps = TimeValueApplication.ourEmpList
                .findEmployees(e -> e.getFname().toUpperCase().charAt(0) == Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnEmps, HttpStatus.OK);
    }


    // http://localhost:8080/data/employee/calc/2/0.05/.1/1/4
    // based on employee ID, determine % of salary to be contributed and determine future value of contribution over time
    @RequestMapping(value = "/employee/calc/{id}/{contribution}/{interest}/{years}/{period}",
            produces = {"application/json"})
    public ResponseEntity<?> getFutureValueById(@PathVariable long id,
                                                @PathVariable double contribution,
                                                @PathVariable double interest,
                                                @PathVariable double years,
                                                @PathVariable double period)
    {
        Employee rtnEmp = TimeValueApplication.ourEmpList.findEmployee(e -> (e.getId() == id));

        // determine % amount of salary to be contributed
        double pv = rtnEmp.getSalary() * (contribution);

        // determines future value of initial contribution
        double fv = pv * Math.pow((1 + (interest / period)),(period * years));

        double fvRnd = Math.round(fv * 100.0 ) / 100.0;

        rtnEmp.setFutureValue(fvRnd);

        return new ResponseEntity<>("When contributing " + contribution * 100 + " % of your total salary: " + pv + " with " + interest * 100 + " % interest for " + years + " years, your future value of contribution is: " + fvRnd, HttpStatus.OK);
    }

}

