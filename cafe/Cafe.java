package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                employees.remove(employee);
                return true;
            }
        }
        return false;
    }
    public Employee getOldestEmployee(){
       return employees.stream().max((e1,e2)-> Integer.compare(e1.getAge(), e2.getAge())).get();
    }
    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if (employee.getName().equals(name)) {
                return employee;
            }
        }
        return null;
    }
    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder stringBuilder = new StringBuilder(String.format("Employees working at Cafe %s:\n", name));
        for (Employee employee : employees) {
            stringBuilder.append(employee.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
