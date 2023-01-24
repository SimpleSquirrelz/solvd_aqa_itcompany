package itcompany.model;

import java.util.List;

public class Project {
    private Long id;
    private Customer customer;
    private List<Employee> employees;
    private List<Task> tasks;
    private String name;

    public Project(Customer customer, List<Employee> employees, List<Task> tasks, String name) {
        this.customer = customer;
        this.employees = employees;
        this.tasks = tasks;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
