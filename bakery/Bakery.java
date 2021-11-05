package bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean remove(String name) {
        for (Employee empl : employees) {
            if (empl.getName().equals(name)) {
                employees.remove(empl);
                return true;
            }
        }
        return false;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max((empl1, empl2) -> Integer.compare(empl1.getAge(), empl2.getAge())).get();
    }

    public Employee getEmployee(String name) {
        for (Employee empl : employees) {
            if (empl.getName().equals(name)) {
                return empl;
            }
        }
        return null;
    }

    public int getCount() {
        return employees.size();
    }

    //    Employees working at Bakery {bakeryName}:
//{Employee1}
//{Employee2}
//(…)
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Employees working at Bakery %s:\n", name));
        for (Employee empl : employees) {
            stringBuilder.append(empl.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
