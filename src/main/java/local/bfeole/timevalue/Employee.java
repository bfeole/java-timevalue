package local.bfeole.timevalue;

import java.util.concurrent.atomic.AtomicLong;

public class Employee
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String fname;
    private String lname;
    private double salary;
    private boolean has401K;
    private long companyId;
    private long healthplanId;
    private double futureValue;

    public Employee(String fname, String lname, double salary, boolean has401K, long companyId, long healthplanId, double futureValue)
    {
        this.id = counter.incrementAndGet(); // maxId++ if multiple IDs are created at same time this queues up which to create first
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.has401K = has401K;
        this.companyId = companyId;
        this.healthplanId = healthplanId;
        this.futureValue = futureValue;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getFname()
    {
        return fname;
    }

    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public String getLname()
    {
        return lname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public boolean isHas401K()
    {
        return has401K;
    }

    public void setHas401K(boolean has401K)
    {
        this.has401K = has401K;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(long companyId)
    {
        this.companyId = companyId;
    }

    public long getHealthplanId()
    {
        return healthplanId;
    }

    public void setHealthplanId(long healthplanId)
    {
        this.healthplanId = healthplanId;
    }

    public double getFutureValue()
    {
        return futureValue;
    }

    public void setFutureValue(double futureValue)
    {
        this.futureValue = futureValue;
    }

    public String getFullName() { return fname + " " + lname; }

    @Override
    public String toString()
    {
        return "Employee{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", salary=" + salary +
                ", has401K=" + has401K +
                ", companyId=" + companyId +
                ", healthplanId=" + healthplanId +
                '}';
    }
}
