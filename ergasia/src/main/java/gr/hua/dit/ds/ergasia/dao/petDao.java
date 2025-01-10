package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.pet;
import java.util.List;
public interface petDao {
    public List<pet> getpets();
    public pet getpet(Long pet_id);
    public pet savepet(pet pet);
    public void deletepet(Long pet_id);
}
