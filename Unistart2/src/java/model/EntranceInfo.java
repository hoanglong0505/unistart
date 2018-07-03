/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "EntranceInfo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntranceInfo.findAll", query = "SELECT e FROM EntranceInfo e")
    , @NamedQuery(name = "EntranceInfo.findBySchoolId", query = "SELECT e FROM EntranceInfo e WHERE e.entranceInfoPK.schoolId = :schoolId")
    , @NamedQuery(name = "EntranceInfo.findByFieldId", query = "SELECT e FROM EntranceInfo e WHERE e.entranceInfoPK.fieldId = :fieldId")
    , @NamedQuery(name = "EntranceInfo.findByLevelId", query = "SELECT e FROM EntranceInfo e WHERE e.entranceInfoPK.levelId = :levelId")
    , @NamedQuery(name = "EntranceInfo.findByYear", query = "SELECT e FROM EntranceInfo e WHERE e.entranceInfoPK.year = :year")
    , @NamedQuery(name = "EntranceInfo.findByNormalEntranceAmount", query = "SELECT e FROM EntranceInfo e WHERE e.normalEntranceAmount = :normalEntranceAmount")
    , @NamedQuery(name = "EntranceInfo.findByOtherEntranceAmount", query = "SELECT e FROM EntranceInfo e WHERE e.otherEntranceAmount = :otherEntranceAmount")})
public class EntranceInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntranceInfoPK entranceInfoPK;
    @Column(name = "NormalEntranceAmount")
    private Integer normalEntranceAmount;
    @Column(name = "OtherEntranceAmount")
    private Integer otherEntranceAmount;
    @JoinColumn(name = "SchoolId", referencedColumnName = "SchoolId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private School school;
    @JoinColumn(name = "FieldId", referencedColumnName = "FieldId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Field field;
    @JoinColumn(name = "LevelId", referencedColumnName = "LevelId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Level level;
    @JoinColumn(name = "Main_sjCode1", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject mainsjCode1;
    @JoinColumn(name = "Main_sjCode2", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject mainsjCode2;
    @JoinColumn(name = "Main_sjCode3", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject mainsjCode3;
    @JoinColumn(name = "Main_sjCode4", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject mainsjCode4;
    @JoinColumn(name = "SjCombiCode1", referencedColumnName = "SjCombiCode")
    @ManyToOne
    private SubjectCombination sjCombiCode1;
    @JoinColumn(name = "SjCombiCode2", referencedColumnName = "SjCombiCode")
    @ManyToOne
    private SubjectCombination sjCombiCode2;
    @JoinColumn(name = "SjCombiCode3", referencedColumnName = "SjCombiCode")
    @ManyToOne
    private SubjectCombination sjCombiCode3;
    @JoinColumn(name = "SjCombiCode4", referencedColumnName = "SjCombiCode")
    @ManyToOne
    private SubjectCombination sjCombiCode4;

    public EntranceInfo() {
    }

    public EntranceInfo(EntranceInfoPK entranceInfoPK) {
        this.entranceInfoPK = entranceInfoPK;
    }

    public EntranceInfo(int schoolId, int fieldId, int levelId, int year) {
        this.entranceInfoPK = new EntranceInfoPK(schoolId, fieldId, levelId, year);
    }

    public EntranceInfoPK getEntranceInfoPK() {
        return entranceInfoPK;
    }

    public void setEntranceInfoPK(EntranceInfoPK entranceInfoPK) {
        this.entranceInfoPK = entranceInfoPK;
    }

    public Integer getNormalEntranceAmount() {
        return normalEntranceAmount;
    }

    public void setNormalEntranceAmount(Integer normalEntranceAmount) {
        this.normalEntranceAmount = normalEntranceAmount;
    }

    public Integer getOtherEntranceAmount() {
        return otherEntranceAmount;
    }

    public void setOtherEntranceAmount(Integer otherEntranceAmount) {
        this.otherEntranceAmount = otherEntranceAmount;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Subject getMainsjCode1() {
        return mainsjCode1;
    }

    public void setMainsjCode1(Subject mainsjCode1) {
        this.mainsjCode1 = mainsjCode1;
    }

    public Subject getMainsjCode2() {
        return mainsjCode2;
    }

    public void setMainsjCode2(Subject mainsjCode2) {
        this.mainsjCode2 = mainsjCode2;
    }

    public Subject getMainsjCode3() {
        return mainsjCode3;
    }

    public void setMainsjCode3(Subject mainsjCode3) {
        this.mainsjCode3 = mainsjCode3;
    }

    public Subject getMainsjCode4() {
        return mainsjCode4;
    }

    public void setMainsjCode4(Subject mainsjCode4) {
        this.mainsjCode4 = mainsjCode4;
    }

    public SubjectCombination getSjCombiCode1() {
        return sjCombiCode1;
    }

    public void setSjCombiCode1(SubjectCombination sjCombiCode1) {
        this.sjCombiCode1 = sjCombiCode1;
    }

    public SubjectCombination getSjCombiCode2() {
        return sjCombiCode2;
    }

    public void setSjCombiCode2(SubjectCombination sjCombiCode2) {
        this.sjCombiCode2 = sjCombiCode2;
    }

    public SubjectCombination getSjCombiCode3() {
        return sjCombiCode3;
    }

    public void setSjCombiCode3(SubjectCombination sjCombiCode3) {
        this.sjCombiCode3 = sjCombiCode3;
    }

    public SubjectCombination getSjCombiCode4() {
        return sjCombiCode4;
    }

    public void setSjCombiCode4(SubjectCombination sjCombiCode4) {
        this.sjCombiCode4 = sjCombiCode4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entranceInfoPK != null ? entranceInfoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntranceInfo)) {
            return false;
        }
        EntranceInfo other = (EntranceInfo) object;
        if ((this.entranceInfoPK == null && other.entranceInfoPK != null) || (this.entranceInfoPK != null && !this.entranceInfoPK.equals(other.entranceInfoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EntranceInfo[ entranceInfoPK=" + entranceInfoPK + " ]";
    }
    
}
