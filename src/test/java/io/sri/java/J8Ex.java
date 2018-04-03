package io.sri.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class J8Ex {

    public static void main(String[] args) {

        List<Person> employee = Arrays.asList(
                new Person("Sridharan", 32, "23000.00"),
                new Person("Selvaraj", 55, "73,000.00"),
                new Person("Srinithi", 4, "20000.00"),
                new Person("Ramya", 30, "43,000.00"),
                new Person("Indirani", 44, "63,000.00"),
                new Person("Nitin", 2, "43,000.00")
        );

        Collections.sort(employee, (p1, p2) -> p1.getSalary().compareTo(p2.getSalary()));
        printConditionally(employee,p->true);

        System.out.println("============================================");
        printConditionally(employee,p->
            p.getSalary().contentEquals("20000.00")
        );
        System.out.println("============================================");
        printConditionally(employee,p->p.getEname().contentEquals("Ramya"));
        printConditionally(employee,p -> p.getEname().startsWith("N"));


    }

        private static void printConditionally(List<Person> people,Condition condition)
        {
            for(Person p:people)
            {
                if(condition.test(p) )
                {
                    System.out.println(p);
                }
            }

        }

        }

interface Condition
{
    boolean test(Person p);
}
