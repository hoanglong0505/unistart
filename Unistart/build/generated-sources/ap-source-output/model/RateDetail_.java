package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Rate;
import model.RateCriteria;
import model.RateDetailPK;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T16:33:39")
@StaticMetamodel(RateDetail.class)
public class RateDetail_ { 

    public static volatile SingularAttribute<RateDetail, RateCriteria> rateCriteria;
    public static volatile SingularAttribute<RateDetail, Rate> rate;
    public static volatile SingularAttribute<RateDetail, Integer> criteriaId;
    public static volatile SingularAttribute<RateDetail, RateDetailPK> rateDetailPK;
    public static volatile SingularAttribute<RateDetail, Integer> value;
    public static volatile SingularAttribute<RateDetail, Integer> rateId;

}