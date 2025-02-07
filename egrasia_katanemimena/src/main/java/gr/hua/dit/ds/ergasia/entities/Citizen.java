package gr.hua.dit.ds.ergasia.entities;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private int age;
    @Column
    private String contactInfo;

    public Citizen() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Citizen(Integer id, String name, String surname, int age, String contactInfo) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
