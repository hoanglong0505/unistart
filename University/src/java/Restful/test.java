/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restful;

import DAO.UniversityDao;
import Models.University;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("test")
public class test {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of test
     */
    public test() {
    }

    /**
     * Retrieves representation of an instance of Restful.test
     * @return an instance of java.lang.String
     */
    @GET
    @Produces()
        @Path("/test")
    public List<University> getText() throws SQLException, ClassNotFoundException {
        UniversityDao dao= new UniversityDao();
        List<University> list= dao.getListUniversity();
        return list ;
    }


}
