package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.EntranceInfoPK;
import model.Field;
import model.School;
import model.Subject;
import model.SubjectCombination;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-04T09:05:39")
@StaticMetamodel(EntranceInfo.class)
public class EntranceInfo_ { 

    public static volatile SingularAttribute<EntranceInfo, SubjectCombination> sjCombiCode4;
    public static volatile SingularAttribute<EntranceInfo, SubjectCombination> sjCombiCode3;
    public static volatile SingularAttribute<EntranceInfo, SubjectCombination> sjCombiCode2;
    public static volatile SingularAttribute<EntranceInfo, SubjectCombination> sjCombiCode1;
    public static volatile SingularAttribute<EntranceInfo, EntranceInfoPK> entranceInfoPK;
    public static volatile SingularAttribute<EntranceInfo, String> fieldSubCode;
    public static volatile SingularAttribute<EntranceInfo, Integer> normalEntranceAmount;
    public static volatile SingularAttribute<EntranceInfo, Subject> mainsjCode2;
    public static volatile SingularAttribute<EntranceInfo, Subject> mainsjCode1;
    public static volatile SingularAttribute<EntranceInfo, Subject> mainsjCode4;
    public static volatile SingularAttribute<EntranceInfo, Subject> mainsjCode3;
    public static volatile SingularAttribute<EntranceInfo, Integer> otherEntranceAmount;
    public static volatile SingularAttribute<EntranceInfo, Field> field;
    public static volatile SingularAttribute<EntranceInfo, School> school;

}