package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Branch;
import model.Level;
import model.Type;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-01T18:02:14")
@StaticMetamodel(University.class)
public class University_ { 

    public static volatile SingularAttribute<University, String> universityName;
    public static volatile SingularAttribute<University, Integer> universityId;
    public static volatile SingularAttribute<University, String> website;
    public static volatile CollectionAttribute<University, Branch> branchs;
    public static volatile SingularAttribute<University, Level> level;
    public static volatile SingularAttribute<University, Integer> levelId;
    public static volatile SingularAttribute<University, Integer> typeId;
    public static volatile SingularAttribute<University, String> avatar;
    public static volatile SingularAttribute<University, Type> type;
    public static volatile SingularAttribute<University, String> universityCode;

}