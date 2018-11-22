package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends Model {
    private String firstName;
    private String lastName;
    private int age;
    @ManyToMany
    @JoinTable(name = "role_Empl",
            joinColumns = {@JoinColumn(name = "empl_id")},
            inverseJoinColumns = {@JoinColumn(name = "roli_id")})
    private Set<Role> roles = new HashSet<Role>();

    public Employee() {
    }

    public Employee(Long id) {
        super(id);
    }

    public Employee(String firstName, String lastName, int age, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
