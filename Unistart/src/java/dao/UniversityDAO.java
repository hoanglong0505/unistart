/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Branch;
import model.University;

/**
 *
 * @author TNT
 */
public class UniversityDAO extends DataAccessObject {

    public UniversityDAO(EntityManager em) {
        this.em = em;
    }

    public List<University> findByRelativeName(String name) {
//        Query q=em.createNamedQuery("findByRelativeName");
        Query q = em.createNativeQuery("SELECT * FROM University "
                + "WHERE UniversityName LIKE ? COLLATE Latin1_General_CI_AI", University.class);
        q.setParameter(1, "%" + name + "%");
        return q.getResultList();
    }

}
