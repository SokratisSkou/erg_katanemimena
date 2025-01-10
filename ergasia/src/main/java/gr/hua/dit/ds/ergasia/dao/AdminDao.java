package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.Admin;
import java.util.List;
public interface AdminDao {

    public Admin getAdmin(Long admin_id);
    public Admin saveAdmin(Admin admin);
    public void deleteAdmin(Long admin_id);
}
