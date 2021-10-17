package cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees = new ArrayList<>();

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    public void addEmployee(Employee employee){
        if(this.employees.size()<capacity){
            employees.add(employee);
        }
    }
    public boolean removeEmployee(String name){
        for (Employee employee : this.employees) {
            if (employee.getName().equals(name)) {
                this.employees.remove(employee);
                return true;
            }
        }
        return false;

    }
    public Employee getOldestEmployee(){
        Employee oldestEmployee = this.employees.get(0);
        int oldestAge = oldestEmployee.getAge();
        for (Employee employee : this.employees) {
            if(employee.getAge()>oldestAge){
                oldestEmployee = employee;
                oldestAge = oldestEmployee.getAge();
            }
        }
        return oldestEmployee;
    }
    public Employee getEmployee(String name){
        for (Employee employee : this.employees) {
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }
    public Integer getCount(){
        return this.employees.size();
    }
    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employees working at Cafe ").append(this.name).append(":\n");
        for (Employee employee : this.employees){
            sb.append(employee).append("\n");
        }
return sb.toString();
    }

}
