package local.bfeole.timevalue;

import java.util.ArrayList;
import java.util.List;

public class EmpList
{
    public List<Employee> empList = new ArrayList<Employee>();

    public EmpList()
    {
        empList.add(new Employee("Steve", "Green", 45000, true, 1, 1, 0));
        empList.add(new Employee("Sam", "Ford", 80000, true, 1, 1, 0));
        empList.add(new Employee("John", "Jones ", 75000, true, 1, 1, 0));
    }
    // takes a lambda expression and find employeeID
    // want to be able to send employee an expression
    // create an interface
    public Employee findEmployee(CheckEmployee tester)
    {
        for (Employee e : empList)
        {
            if (tester.test(e))
            {
                return e;
            }
        }
        return null;
    }
    // return List of Employees
    public List<Employee> findEmployees(CheckEmployee tester)
    {
        // create temporary List to work with, Similar to filtered list
        List<Employee> tempEmpList = new ArrayList<>();

        for (Employee e : empList)
        {
            if (tester.test(e))
            {
                tempEmpList.add(e);
            }
        }
        return tempEmpList;
    }
}