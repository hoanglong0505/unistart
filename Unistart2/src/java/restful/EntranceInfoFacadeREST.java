/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import java.util.List;
import javax.ejb.Stateless;
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
import javax.ws.rs.core.PathSegment;
import model.EntranceInfo;
import model.EntranceInfoPK;

/**
 *
 * @author TNT
 */
@Stateless
@Path("model.entranceinfo")
public class EntranceInfoFacadeREST extends AbstractFacade<EntranceInfo> {

    @PersistenceContext(unitName = "Unistart2PU")
    private EntityManager em;

    private EntranceInfoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;schoolId=schoolIdValue;fieldId=fieldIdValue;year=yearValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        model.EntranceInfoPK key = new model.EntranceInfoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> schoolId = map.get("schoolId");
        if (schoolId != null && !schoolId.isEmpty()) {
            key.setSchoolId(new java.lang.Integer(schoolId.get(0)));
        }
        java.util.List<String> fieldId = map.get("fieldId");
        if (fieldId != null && !fieldId.isEmpty()) {
            key.setFieldId(new java.lang.Integer(fieldId.get(0)));
        }
        java.util.List<String> year = map.get("year");
        if (year != null && !year.isEmpty()) {
            key.setYear(new java.lang.Integer(year.get(0)));
        }
        return key;
    }

    public EntranceInfoFacadeREST() {
        super(EntranceInfo.class);
        em= Persistence.createEntityManagerFactory("Unistart2PU").createEntityManager();
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(EntranceInfo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, EntranceInfo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        model.EntranceInfoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public EntranceInfo find(@PathParam("id") PathSegment id) {
        model.EntranceInfoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EntranceInfo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<EntranceInfo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
