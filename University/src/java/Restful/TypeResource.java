/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restful;

import DAO.TypeDAO;
import Models.Type;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author TNT
 */
@Path("type")
public class TypeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TypeResource
     */
    public TypeResource() {
    }

    /**
     * Retrieves representation of an instance of Restful.TypeResource
     * @return an instance of java.lang.String
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get-all")
    public List<Type> getAllTypes() throws SQLException, ClassNotFoundException {
        TypeDAO tDAO=new TypeDAO();
        return tDAO.getListType();
    }

}
