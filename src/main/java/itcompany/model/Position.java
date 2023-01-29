package itcompany.model;

public class Position {
    private Long id;
    private Long employeeId;
    private String name;

    public Position(Long employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Position(){}


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + this.getId() +
                ", employeeId=" + this.getEmployeeId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
