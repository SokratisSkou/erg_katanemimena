package gr.hua.dit.ds.ergasia.entities;
import gr.hua.dit.ds.ergasia.entities.user;
import jakarta.persistence.*;

@Entity
public class Admin extends user {


    public Admin() {}


    public Admin(long id, String UserName, String name, String password, int age) {
        super(id,UserName,name,password,age);
    }



}
