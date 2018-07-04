/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Three;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.One;
import model.Three;

/**
 * REST Web Service
 *
 * @author Admin
 */
@Path("test")
public class TestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of TestResource
     */
    public TestResource() {
    }

    /**
     * Retrieves representation of an instance of Three.TestResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String getText() {
        ThreeBLO blo = new ThreeBLO();
        JpaJsonConverter converter = new JpaJsonConverter();
        return converter.convertToDatabaseColumn(blo.getall());
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test")
    public String SetText(String one) throws IOException {
        System.out.println(one);
        ObjectMapper mapper = new ObjectMapper();
        One o = mapper.readValue(one, One.class);
        JpaJsonConverter converter = new JpaJsonConverter();
        String s = converter.convertToDatabaseColumn(o);

        return s;
    }

}

