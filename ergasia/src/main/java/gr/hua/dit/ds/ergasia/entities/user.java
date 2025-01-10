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
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "name")
        })
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 120)
    private String password;


    @NotBlank
    private int Age;






    public user() {
    }

    public user(long Id,String username, String name, String password, int age) {
        this.Id =Id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.Age = age;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {this.Id = id;}

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







    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + username + '\'' +
                ", Name='" + name + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }
}