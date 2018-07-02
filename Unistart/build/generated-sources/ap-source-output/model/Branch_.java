package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Location;
import model.Rate;
import model.University;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-01T18:02:14")
@StaticMetamodel(Branch.class)
public class Branch_ { 

    public static volatile SingularAttribute<Branch, Integer> branchId;
    public static volatile SingularAttribute<Branch, String> website;
    public static volatile SingularAttribute<Branch, String> address;
    public static volatile SingularAttribute<Branch, String> phone;
    public static volatile SingularAttribute<Branch, University> university;
    public static volatile CollectionAttribute<Branch, Rate> rates;
    public static volatile SingularAttribute<Branch, String> branchName;
    public static volatile SingularAttribute<Branch, Location> location;

}