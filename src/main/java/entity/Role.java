package entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class Role extends Model {

    private String title;
    @ManyToMany (mappedBy = "roles")
    private Set<Employee> employees=new HashSet<Employee>();


    public Role(String title, Set<Employee> employees) {
        this.title = title;
        this.employees = employees;
    }

    public Role() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
