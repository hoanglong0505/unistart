package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.EntranceInfo;
import model.SubjectCombination;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-04T09:05:39")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile CollectionAttribute<Subject, SubjectCombination> subjectCombinationCollection2;
    public static volatile CollectionAttribute<Subject, EntranceInfo> entranceInfoCollection;
    public static volatile CollectionAttribute<Subject, SubjectCombination> subjectCombinationCollection1;
    public static volatile CollectionAttribute<Subject, EntranceInfo> entranceInfoCollection2;
    public static volatile CollectionAttribute<Subject, EntranceInfo> entranceInfoCollection3;
    public static volatile CollectionAttribute<Subject, EntranceInfo> entranceInfoCollection1;
    public static volatile CollectionAttribute<Subject, SubjectCombination> subjectCombinationCollection;
    public static volatile SingularAttribute<Subject, String> subjectCode;
    public static volatile SingularAttribute<Subject, String> subjectName;

}