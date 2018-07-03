/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.University;
import model.utils.TransientHandler;

/**
 *
 * @author TNT
 */
public class UniversityDAO implements TransientHandler {

    public List<University> findAllWithBranchs(EntityManager em) {
        Query q = em.createNamedQuery("University.findAll", University.class);
        List<University> uList = q.getResultList();
        for (University u : uList) {
            u.branchHandler = GENERATE;
        }
        return uList;
    }
}
