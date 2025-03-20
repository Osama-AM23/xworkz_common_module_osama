package com.xworkz.xworkz_common_Module_osama.repository;

import com.xworkz.xworkz_common_Module_osama.entity.ModuleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Slf4j
@Repository
public class ModuleRepositoryImpl implements ModuleRepository {
    @Autowired
    private EntityManagerFactory emf;


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
    public long getCountOfName(String userName) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction transaction = eManag.getTransaction();
        Query query = eManag.createNamedQuery("getNameCount");
        query.setParameter("userName", userName);
        Long count = (long) query.getSingleResult();
        try {
            transaction.begin();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            eManag.close();
        }
        return count;
    }

    @Override
    public long getCountOfLoginId(String loginId) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        Query query = eManag.createNamedQuery("getLoginIdCount");
        query.setParameter("loginId", loginId);
        Long count = (Long) query.getSingleResult();
        try {
            eTrans.begin();
            eTrans.commit();
        } catch (Exception e) {
            if (eTrans.isActive()) {
                eTrans.rollback();
            }
            e.printStackTrace();
        } finally {
            eManag.close();
        }
        return count;
    }

    @Override
    public long getCountOfEmail(String email) {

        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        Query query = eManag.createNamedQuery("getEmailCount");
        query.setParameter("email", email);
        Long count = (long) query.getSingleResult();
        try {
            eTrans.begin();
            eTrans.commit();
        } catch (Exception e) {
            if (eTrans.isActive()) {
                eTrans.rollback();
            }
            e.printStackTrace();
        } finally {
            eManag.close();
        }

        return count;
    }

    @Override
    public long getCountOfPhoneNo(String phoneNo) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        Query query = eManag.createNamedQuery("getPhoneNoCount");
        query.setParameter("phoneNo", phoneNo);
        Long count = (long) query.getSingleResult();
        try {
            eTrans.begin();
            eTrans.commit();
        } catch (Exception e) {
            if (eTrans.isActive()) {
                eTrans.rollback();
            }
            e.printStackTrace();
        } finally {
            eManag.close();
        }
        return count;
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
            log.info("No entity found for the given email and password.");
            return null;
        }
    }

    @Override
    public ModuleEntity findByEmail(String email) {
        EntityManager eManag = emf.createEntityManager();
        Query query = eManag.createNamedQuery("findByEmail").setParameter("email", email);
        query.getSingleResult();
        log.info("REPOSITORY :" + query.getSingleResult());
        return (ModuleEntity) query.getSingleResult();
    }

    @Override
    public boolean onUpdateCount(ModuleEntity moduleEntity) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        try {
            eTrans.begin();
            eManag.merge(moduleEntity);
            eTrans.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            eManag.close();
        }
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
            query.setParameter("updatedBy", moduleEntity.getUpdatedBy());
            query.setParameter("updatedDate", moduleEntity.getUpdatedDate());

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

    @Override
    public boolean setLockTime(String email, ModuleEntity moduleEntity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction eTrans = entityManager.getTransaction();
        try {
            eTrans.begin();
            entityManager.merge(moduleEntity);
            eTrans.commit();
            return true;
        } catch (Exception e) {
            if (eTrans.isActive())
                eTrans.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteUserByEmail(String email) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        eTrans.begin();
        eManag.createNamedQuery("deleteUser").setParameter("email", email).executeUpdate();
        eTrans.commit();
    }

    @Override
    public ModuleEntity getDataForUpdate(String email) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        try {
            Query query = eManag.createNamedQuery("getDataForUpdate");
            query.setParameter("email", email);
            return (ModuleEntity) query.getSingleResult();
        } catch (Exception e) {
            if (eTrans.isActive()) {
                eTrans.rollback();
                e.printStackTrace();
            }
            return null;
        } finally {
            eManag.close();
        }
    }

    @Override
    public boolean forgetPasswordUpdate(ModuleEntity moduleEntity) {
        EntityManager eManag = emf.createEntityManager();
        EntityTransaction eTrans = eManag.getTransaction();
        try {
            eTrans.begin();
            Query query = eManag.createNamedQuery("forgetPasswordUpdate");
            query.setParameter("password", moduleEntity.getPassword());
            query.setParameter("email", moduleEntity.getEmail());

            int updateRow = query.executeUpdate();
            eTrans.commit();
            return updateRow > 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (eTrans.isActive()) {
                eTrans.rollback();
            }
            return false;
        } finally {
            eManag.close();
        }
    }

}
