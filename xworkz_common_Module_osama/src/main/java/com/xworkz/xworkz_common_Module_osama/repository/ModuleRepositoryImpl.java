package com.xworkz.xworkz_common_Module_osama.repository;

import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("xworkz_commonModule");

    public ModuleRepositoryImpl() {
        System.out.println("ModuleRepositoryImpl is Created");
    }

    @Override
    public boolean save(ModuleEntity moduleEntity) {
        EntityManager eMang = emf.createEntityManager();
        eMang.getTransaction().begin();
        eMang.persist(moduleEntity);
        eMang.getTransaction().commit();
        eMang.close();

        return true;
    }

    @Override
    public ModuleEntity onSignin(String email) {
        EntityManager eManag = emf.createEntityManager();
        Query query = eManag.createNamedQuery("getEmailAndPassword").setParameter("email", email);
        try {
            ModuleEntity moduleEntity = (ModuleEntity) query.getSingleResult();
            System.out.println("REPOSITORY :" + moduleEntity);
            return moduleEntity;
        } catch (NoResultException e) {
            System.out.println("No entity found for the given email and password.");
            return null;
        }
    }

    @Override
    public ModuleEntity findByEmail(String email) {
        EntityManager eManag = emf.createEntityManager();
        Query query = eManag.createNamedQuery("findByEmail").setParameter("email", email);
        query.getSingleResult();
        System.out.println("REPOSITORY :" + query.getSingleResult());
        return (ModuleEntity) query.getSingleResult();
    }

    @Override
    public boolean updateByEmail(ModuleEntity moduleEntity) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction transaction = eManag.getTransaction();
        try {
            transaction.begin();
            Query query = eManag.createNamedQuery("updateByEmail");

            query.setParameter("userName", moduleEntity.getUserName());
            query.setParameter("age", moduleEntity.getAge());
            query.setParameter("dob", moduleEntity.getDob());
            query.setParameter("phoneNo", moduleEntity.getPhoneNo());
            query.setParameter("location", moduleEntity.getLocation());
            query.setParameter("password", moduleEntity.getPassword());
            query.setParameter("email", moduleEntity.getEmail());

            int updatedCount = query.executeUpdate();
            transaction.commit();
            return updatedCount > 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        } finally {
            eManag.close();
        }
    }
}
