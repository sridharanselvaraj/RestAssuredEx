package io.sri.java;

public class Person {

    private String ename;
    private int  eno;
    private String salary;

    public Person(String ename, int eno, String salary) {
        this.ename = ename;
        this.eno = eno;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ename='" + ename + '\'' +
                ", eno=" + eno +
                ", salary='" + salary + '\'' +
                '}';
    }
}
