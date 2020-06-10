package local.bfeole.timevalue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimeValueApplication
{
    public static EmpList ourEmpList;
    // main method
    public static void main(String[] args)
    {
        ourEmpList = new EmpList();
        SpringApplication.run(TimeValueApplication.class, args);
    }

}
