/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restful;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("Unversity")
public class UnversityResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UnversityResource
     */
    public UnversityResource() {
    }

    /**
     * Retrieves representation of an instance of Restful.UnversityResource
     * @return an instance of java.lang.String
     */
    @GET
     @Path("/t")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
       return "asd";
    }

    /**
     * PUT method for updating or creating an instance of UnversityResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content) {
    }
}
