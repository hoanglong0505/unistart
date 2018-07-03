package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.University;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T16:33:39")
@StaticMetamodel(Introduce.class)
public class Introduce_ { 

    public static volatile SingularAttribute<Introduce, Integer> introduceId;
    public static volatile SingularAttribute<Introduce, Integer> universityId;
    public static volatile SingularAttribute<Introduce, University> university;
    public static volatile SingularAttribute<Introduce, String> link;
    public static volatile SingularAttribute<Introduce, Boolean> status;

}