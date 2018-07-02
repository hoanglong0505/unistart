package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.One;
import model.Three;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-29T16:35:26")
@StaticMetamodel(Two.class)
public class Two_ { 

    public static volatile SingularAttribute<Two, String> twoName;
    public static volatile SingularAttribute<Two, Integer> twoId;
    public static volatile SingularAttribute<Two, Three> three;
    public static volatile SingularAttribute<Two, One> oneId;

}