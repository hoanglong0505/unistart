/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author TNT
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(restful.BranchFacadeREST.class);
        resources.add(restful.IntroduceFacadeREST.class);
        resources.add(restful.LevelFacadeREST.class);
        resources.add(restful.LocationFacadeREST.class);
        resources.add(restful.RateCriteriaFacadeREST.class);
        resources.add(restful.RateDetailFacadeREST.class);
        resources.add(restful.RateFacadeREST.class);
        resources.add(restful.SubLocationFacadeREST.class);
        resources.add(restful.TypeFacadeREST.class);
        resources.add(restful.UniversityFacadeREST.class);
        resources.add(restful.UsersFacadeREST.class);
    }
    
}
