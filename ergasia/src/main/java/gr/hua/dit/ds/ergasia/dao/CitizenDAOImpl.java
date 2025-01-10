package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.Citizen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class CitizenDAOImpl implements CitizenDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public List<Citizen> getCitizens() {
        TypedQuery<Citizen> query = em.createQuery("select c from Citizen c", Citizen.class);
        return query.getResultList();

    }

    @Override
    public Citizen getCitizen(Integer CitizenId) {return em.find(Citizen.class, CitizenId);}

    @Override
    @Transactional
    public void saveCitizen(Citizen citizen) {
        System.out.println("citizen "+ citizen.getId());
        if (citizen.getId() == null) {
            em.persist(citizen);
        } else {
            em.merge(citizen);
        }
    }

    @Override
    @Transactional
    public void deleteCitizen(Integer citizenId) {
        System.out.println("Deleting citizen with id: " + citizenId);
        em.remove(em.find(Citizen.class, citizenId));
    }
}
