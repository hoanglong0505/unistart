package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.RateDetail;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T16:33:39")
@StaticMetamodel(RateCriteria.class)
public class RateCriteria_ { 

    public static volatile CollectionAttribute<RateCriteria, RateDetail> rateDetails;
    public static volatile SingularAttribute<RateCriteria, Integer> criteriaId;
    public static volatile SingularAttribute<RateCriteria, String> criteriaName;
    public static volatile SingularAttribute<RateCriteria, Boolean> status;

}