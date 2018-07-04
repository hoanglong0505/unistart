package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.RateDetail;
import model.Report;
import model.School;
import model.User;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-04T09:05:39")
@StaticMetamodel(Rate.class)
public class Rate_ { 

    public static volatile SingularAttribute<Rate, String> title;
    public static volatile SingularAttribute<Rate, String> experience;
    public static volatile SingularAttribute<Rate, User> userId;
    public static volatile SingularAttribute<Rate, Integer> rateId;
    public static volatile SingularAttribute<Rate, String> pros;
    public static volatile CollectionAttribute<Rate, Report> reportCollection;
    public static volatile SingularAttribute<Rate, Boolean> encourage;
    public static volatile SingularAttribute<Rate, School> schoolId;
    public static volatile SingularAttribute<Rate, Integer> userLike;
    public static volatile SingularAttribute<Rate, Boolean> anonymous;
    public static volatile CollectionAttribute<Rate, RateDetail> rateDetailCollection;
    public static volatile SingularAttribute<Rate, String> cons;
    public static volatile SingularAttribute<Rate, Integer> userDislike;

}