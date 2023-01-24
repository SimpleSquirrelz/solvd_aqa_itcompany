package itcompany.model;

public class ProjectEmployee {
    private Long id;
    private Project project;
    private Employee employee;

    public ProjectEmployee(Project project, Employee employee) {
        this.project = project;
        this.employee = employee;
    }

    public Long getId() {
        return id;
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
        return "ProjectEmployee{" +
                "id=" + id +
                ", project=" + project +
                ", employee=" + employee +
                '}';
    }
}
