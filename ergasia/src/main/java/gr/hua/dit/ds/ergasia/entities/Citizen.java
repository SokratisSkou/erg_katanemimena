package gr.hua.dit.ds.ergasia.entities;
import jakarta.persistence.*;

import java.sql.Date;


@Entity

public class Citizen extends user{


    public Citizen() {

    }



    public Citizen(long id, String UserName, String name, String password, int age) {
        super(id,UserName,name,password,age);
    }


}
