package gr.hua.dit.ds.ergasia.entities;

public class pet {
    private Long id;
    private String name;
    private String type;
    private int age;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public pet(Long id, String name, String type,int age) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.age = age;
    }

    @Override
    public String toString() {
        return "pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                '}';
    }
}
