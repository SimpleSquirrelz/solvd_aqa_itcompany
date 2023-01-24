package itcompany.model;

import java.util.HashSet;
import java.util.Set;

public class Employee extends User {
    private Long id;
    private float salary;
    private Set<Position> positions;

    public Employee() {
        super();
        positions = new HashSet<>();
        this.salary = 0.0f;
    }

    public Employee(String name, String surname, String username, String email, String password, float salary) {
        super(name, surname, username, email, password);
        this.salary = salary;
    }

    public Employee(HashSet<Position> positions, String name, String surname, String username, String email, String password, float salary) {
        super(name, surname, username, email, password);
        this.salary = salary;
        this.positions = positions;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + this.getId() + '\'' +
                "name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", phones=" + this.getPhones().toString() +
                ", addresses=" + this.getAddresses().toString() +
                ", username='" + this.getUsername() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                '}';
    }
}
