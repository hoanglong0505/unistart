package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.University;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-02T16:33:39")
@StaticMetamodel(Level.class)
public class Level_ { 

    public static volatile CollectionAttribute<Level, University> universities;
    public static volatile SingularAttribute<Level, Integer> levelId;
    public static volatile SingularAttribute<Level, String> levelName;

}