package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.School;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-04T09:05:39")
@StaticMetamodel(Type.class)
public class Type_ { 

    public static volatile CollectionAttribute<Type, School> schoolCollection;
    public static volatile SingularAttribute<Type, String> typeName;
    public static volatile SingularAttribute<Type, Integer> typeId;

}