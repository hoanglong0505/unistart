package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.RateDetail;
import model.University;
import model.Users;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T16:33:39")
@StaticMetamodel(Rate.class)
public class Rate_ { 

    public static volatile SingularAttribute<Rate, University> university;
    public static volatile SingularAttribute<Rate, String> title;
    public static volatile SingularAttribute<Rate, String> experience;
    public static volatile SingularAttribute<Rate, Integer> userId;
    public static volatile SingularAttribute<Rate, Integer> rateId;
    public static volatile SingularAttribute<Rate, Integer> universityId;
    public static volatile SingularAttribute<Rate, String> pros;
    public static volatile SingularAttribute<Rate, Boolean> encourage;
    public static volatile CollectionAttribute<Rate, RateDetail> rateDetails;
    public static volatile SingularAttribute<Rate, Boolean> anonymous;
    public static volatile SingularAttribute<Rate, Users> user;
    public static volatile SingularAttribute<Rate, String> cons;
    public static volatile SingularAttribute<Rate, Integer> status;

}