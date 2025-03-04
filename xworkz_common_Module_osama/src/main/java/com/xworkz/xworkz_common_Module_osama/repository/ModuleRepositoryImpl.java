package com.xworkz.xworkz_common_Module_osama.repository;

import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("xworkz_commonModule");

    public ModuleRepositoryImpl(){
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
}
