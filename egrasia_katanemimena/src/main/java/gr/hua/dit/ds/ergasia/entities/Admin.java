package gr.hua.dit.ds.ergasia.entities;
import gr.hua.dit.ds.ergasia.entities.user;
import jakarta.persistence.*;

@Entity
@Table
public class Admin  {
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



    public Admin() {}


    public Admin(Integer id, String Name, String Surname, int age) {
        Id = id;
        name = Name;
        surname = Surname;
        this.age = age;
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

    public void setName(String Name) {
        name = Name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String Surname) {
        surname = Surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
