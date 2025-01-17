package gr.hua.dit.ds.ergasia.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;



import java.util.HashSet;
import java.util.Set;

@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;

    @NotBlank
    @Size(max = 20)
    @Column
    private String username;

    @NotBlank
    @Size(max = 50)
    @Column
    private String name;

    @NotBlank
    @Size(max = 120)
    @Column
    private String password;


    @NotBlank
    @Column
    private int Age;

    @NotBlank
    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role ;





    public user(int Id,String username, String name, String password, int age, String email) {
        this.Id =Id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.Age = age;
        this.email = email;
    }

    public user() {

    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {this.Id = id;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getage() {
        return Age;
    }

    public void setBirthDate(int age) {
        this.Age = age;
    }

    public String getEmail() {
        return email;
   }
    public void setEmail(String email) {
        this.email = email;
   }
    public String getRole() {return role.getName();}
    public void setRole(String role) {this.role.setName(role);}

    @Override
    public String toString() {
        return "user{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", Age=" + Age +
                ", email='" + email + '\'' +
                '}';
    }
}