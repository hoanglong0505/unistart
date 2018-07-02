package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Two;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-29T16:35:26")
@StaticMetamodel(One.class)
public class One_ { 

    public static volatile ListAttribute<One, Two> twoList;
    public static volatile SingularAttribute<One, String> oneName;
    public static volatile SingularAttribute<One, Integer> oneId;

}