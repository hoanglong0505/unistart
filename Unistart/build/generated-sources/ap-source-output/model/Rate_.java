package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Branch;
import model.RateDetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-01T18:02:14")
@StaticMetamodel(Rate.class)
public class Rate_ { 

    public static volatile SingularAttribute<Rate, String> pros;
    public static volatile SingularAttribute<Rate, Short> encourage;
    public static volatile CollectionAttribute<Rate, RateDetail> rateDetails;
    public static volatile SingularAttribute<Rate, String> title;
    public static volatile SingularAttribute<Rate, String> experience;
    public static volatile SingularAttribute<Rate, Integer> userId;
    public static volatile SingularAttribute<Rate, Branch> branch;
    public static volatile SingularAttribute<Rate, Integer> rateId;
    public static volatile SingularAttribute<Rate, String> cons;

}