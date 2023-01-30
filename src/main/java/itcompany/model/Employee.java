package itcompany.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonTypeName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
@JsonTypeName("employee")
public class Employee extends User {
    private Long id;
    private float salary;
    private Set<Position> positions;

    public Employee() {
        super();
        positions = new LinkedHashSet<>();
        this.salary = 0.0f;
    }

    public Employee(String name, String surname, String username, String email, String password, float salary) {
        super(name, surname, username, email, password);
        this.salary = salary;
    }

    public Employee(LinkedHashSet<Position> positions, String name, String surname, String username, String email, String password, float salary) {
        super(name, surname, username, email, password);
        this.salary = salary;
        this.positions = positions;
    }

    public Employee(List<Address> addressList, List<Phone> phoneList, LinkedHashSet<Position> positions, String name, String surname, String username, String email, String password, float salary) {
        super(name, surname, username, email, password);
        this.salary = salary;
        this.positions = positions;
        this.setPhones(phoneList);
        this.setAddresses(addressList);
    }

    @XmlElement
    @JsonGetter("salary")
    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @XmlElement
    @JsonGetter("positions")
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    @XmlElement
    @Override
    @JsonGetter("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + this.getId() + '\'' +
                "name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", salary='" + this.getSalary() + '\'' +
                ", \npositions=\n" + this.getPositions().toString() +
                ", \nphones=\n" + this.getPhones().toString() +
                ", \naddresses=\n" + this.getAddresses().toString() +
                '}';
    }
}
