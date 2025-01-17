package gr.hua.dit.ds.ergasia.entities;
import gr.hua.dit.ds.ergasia.entities.user;
import jakarta.persistence.*;

@Entity
@Table
public class Admin extends user {
    @Column
    private int secret_id;

    public Admin() {}



    public Admin(int id, String UserName, String name, String password, int age,String email,int secret_id) {
        super(id,UserName,name,password,age,email);
        this.secret_id = secret_id;
    }




}
