package academy.sirisha.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Student {
    @Id
    @Column(columnDefinition = "varchar(36)")
    public String id;
    public String name;
    public String branch;

    @Column(unique = true)
    public String email;

    public Student() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
