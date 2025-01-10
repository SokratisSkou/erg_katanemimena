package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.Admin;
import gr.hua.dit.ds.ergasia.entities.user;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;
public class AdminDAOImpl implements AdminDao{
    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Admin getAdmin(Long admin_id) {
        return entityManager.find(Admin.class, admin_id);
    }

    @Override
    @Transactional
    public Admin saveAdmin(Admin admin) {
        System.out.println("admin "+ admin.getId());
        if (admin.getId() == null) {
            entityManager.persist(admin);
        } else {
            entityManager.merge(admin);
        }
        return admin;
    }

    @Override
    @Transactional
    public void deleteAdmin(Long admin_id) {
        System.out.println("Deleting admin with id: " + admin_id);
        entityManager.remove(entityManager.find(Admin.class, admin_id));
    }
}
