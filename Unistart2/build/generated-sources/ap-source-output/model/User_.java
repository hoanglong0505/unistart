package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Rate;
import model.Report;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-04T09:05:39")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile CollectionAttribute<User, Report> reportCollection;
    public static volatile CollectionAttribute<User, Rate> rateCollection;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> email;

}