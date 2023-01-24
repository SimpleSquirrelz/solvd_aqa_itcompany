package itcompany.model;

public class User extends Contact {
    private String username;
    private String email;
    private String password;

    public User() {
        super();
        this.username = "Username is missing";
        this.email = "Email is missing";
        this.password = "Password is missing";
    }

    public User(String name, String surname, String username, String email, String password) {
        super(name, surname);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + this.getName() + '\'' +
                ", surname='" + this.getSurname() + '\'' +
                ", phones=" + this.getPhones().toString() +
                ", addresses=" + this.getAddresses().toString() +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
