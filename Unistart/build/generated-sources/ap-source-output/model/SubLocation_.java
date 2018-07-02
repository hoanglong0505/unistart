package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Location;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-01T18:02:14")
@StaticMetamodel(SubLocation.class)
public class SubLocation_ { 

    public static volatile SingularAttribute<SubLocation, Integer> subLocationId;
    public static volatile SingularAttribute<SubLocation, String> subLocationName;
    public static volatile CollectionAttribute<SubLocation, Location> locations;

}