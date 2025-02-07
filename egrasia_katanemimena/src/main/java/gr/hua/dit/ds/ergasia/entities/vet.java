package gr.hua.dit.ds.ergasia.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer Id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String ContactInfo;



    public vet() {

    }

    @OneToMany(mappedBy = "vet", cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    private  List<pet> pets;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        name = Name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        surname = Surname;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    public List<pet> getPets() {
        return pets;
    }

    public void setPets(List<pet> pets) {
        this.pets = pets;
    }

    public vet(Integer id, String Name, String Surname, String contactInfo, List<pet> pets) {
        Id = id;
        name = name;
        surname = Surname;
        ContactInfo = contactInfo;
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "vet{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", ContactInfo='" + ContactInfo + '\'' +
                ", pets=" + pets +
                '}';
    }
}
