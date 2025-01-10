package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.Citizen;

import java.util.List;

public interface CitizenDao {
    public List<Citizen> getCitizens();
    public Citizen getCitizen(Integer citizen_id);
    public void saveCitizen(Citizen citizen);
    public void deleteCitizen(Integer citizen_id);
}
