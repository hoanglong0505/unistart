/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restful;

import DAO.LevelDAO;
import Models.Level;
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
@Path("level")
public class LevelResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LevelResource
     */
    public LevelResource() {
    }

    /**
     * Retrieves representation of an instance of Restful.LevelResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get-all")
    public List<Level> getAllLevels() throws SQLException, ClassNotFoundException {
        LevelDAO lDAO=new LevelDAO();
        return lDAO.getListLevel();
    }
}
