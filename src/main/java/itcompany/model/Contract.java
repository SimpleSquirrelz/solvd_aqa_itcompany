package itcompany.model;

public class Contract {
    private Long id;
    private Customer customer;
    private Project project;
    private Employee employee;

    public Contract(Customer customer, Project project, Employee employee) {
        this.customer = customer;
        this.project = project;
        this.employee = employee;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + this.getId() +
                ", customer=" + this.getCustomer() +
                ", project=" + this.getProject() +
                ", employee=" + this.getProject() +
                '}';
    }
}
