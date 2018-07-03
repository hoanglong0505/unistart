/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Admin
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
        resources.add(model.service.ArticleFacadeREST.class);
        resources.add(model.service.BranchFacadeREST.class);
        resources.add(model.service.EntranceInfoFacadeREST.class);
        resources.add(model.service.FieldFacadeREST.class);
        resources.add(model.service.FieldTypeFacadeREST.class);
        resources.add(model.service.LevelFacadeREST.class);
        resources.add(model.service.LocationFacadeREST.class);
        resources.add(model.service.RateCriteriaFacadeREST.class);
        resources.add(model.service.RateDetailFacadeREST.class);
        resources.add(model.service.RateFacadeREST.class);
        resources.add(model.service.RegionFacadeREST.class);
        resources.add(model.service.ReportFacadeREST.class);
        resources.add(model.service.SchoolFacadeREST.class);
        resources.add(model.service.SubjectCombinationFacadeREST.class);
        resources.add(model.service.SubjectFacadeREST.class);
        resources.add(model.service.TypeFacadeREST.class);
        resources.add(model.service.UserFacadeREST.class);
    }
    
}
