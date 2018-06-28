/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Three;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Three;

/**
 *
 * @author Admin
 */
public class ThreeBLO  implements Serializable{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestJPAPU");

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public List getall(){
        EntityManager em=emf.createEntityManager();
        String jpql="One.findAll";
        Query query=em.createNamedQuery(jpql);     
        List result= query.getResultList();  
        return result;
    }
    
}
