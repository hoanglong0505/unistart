/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import dao.UniversityDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.University;

/**
 *
 * @author TNT
 */
@javax.ejb.Stateless
@Path("model.university")
public class UniversityFacadeREST extends AbstractFacade<University> {

    @PersistenceContext(unitName = "UnistartPU")
    private EntityManager em;

    public UniversityFacadeREST() {
        super(University.class);
        em = Persistence.createEntityManagerFactory("UnistartPU").createEntityManager();
    }

    @POST
    @Override
    @Path("create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(University entity) {
        entity.setUpdateInfo();
        super.create(entity);
    }

    @POST
    @Path("edit:{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, University entity) {
        entity.setUpdateInfo();
        super.edit(entity);
    }

    @POST
    @Path("delete:{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public University find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<University> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<University> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    //==== USER DEFINED=====
    @GET
    @Path("findByRelativeName:{name}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<University> findByRelativeName(@PathParam("name") String name) {
        return new UniversityDAO(em).findByRelativeName(name);
    }

    @GET
    @Path("findAllRAW")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<University> findRAWUniversity() {
        List<University> uList = super.findAll();
        for (University u : uList) {
            u.branchHandler = TRANSIENT;
//            u.levelHandler = RAW;
//            u.typeHandler = RAW;
        }
        return uList;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
