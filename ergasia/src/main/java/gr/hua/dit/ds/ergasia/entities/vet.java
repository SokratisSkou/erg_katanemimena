package gr.hua.dit.ds.ergasia.entities;

public class vet {
    private int id;
    private String name;
    private int age;
    private String surname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public vet(int id, String name, int age, String surname) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "vet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", surname='" + surname + '\'' +
                '}';
    }
}
