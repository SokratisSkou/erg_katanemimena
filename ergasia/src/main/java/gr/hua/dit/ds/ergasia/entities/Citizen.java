package gr.hua.dit.ds.ergasia.entities;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table
public class Citizen extends user{


    public Citizen() {

    }



    public Citizen(int id, String UserName, String name, String password, int age, String email) {
        super(id,UserName,name,password,age,email);
    }


}
