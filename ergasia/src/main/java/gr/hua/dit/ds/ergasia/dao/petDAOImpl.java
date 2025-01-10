package gr.hua.dit.ds.ergasia.dao;
import gr.hua.dit.ds.ergasia.entities.pet;
import gr.hua.dit.ds.ergasia.entities.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

public class petDAOImpl implements petDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public List<pet> getpets() {
        TypedQuery<pet> query = entityManager.createQuery("SELECT u FROM pet u JOIN u.role r WHERE r.name = 'ROLE_PET'", pet.class);
        return query.getResultList();
    }


    @Override
    public pet getpet(Long pet_id) {
        return entityManager.find(pet.class, pet_id);
    }

    @Override
    @Transactional
    public pet savepet(pet pet) {
        System.out.println("pet "+ pet.getId());
        if (pet.getId() == null) {
            entityManager.persist(pet);
        } else {
            entityManager.merge(pet);
        }
        return pet;
    }

    @Override
    @Transactional
    public void deletepet(Long pet_id) {
        System.out.println("Deleting admin with id: " + pet_id);
        entityManager.remove(entityManager.find(pet.class, pet_id));
    }
}
