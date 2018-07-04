/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "Subject")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
    , @NamedQuery(name = "Subject.findBySubjectCode", query = "SELECT s FROM Subject s WHERE s.subjectCode = :subjectCode")
    , @NamedQuery(name = "Subject.findBySubjectName", query = "SELECT s FROM Subject s WHERE s.subjectName = :subjectName")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SubjectCode")
    private String subjectCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SubjectName")
    private String subjectName;
    @OneToMany(mappedBy = "sjCode1")
    private Collection<SubjectCombination> subjectCombinationCollection;
    @OneToMany(mappedBy = "sjCode2")
    private Collection<SubjectCombination> subjectCombinationCollection1;
    @OneToMany(mappedBy = "sjCode3")
    private Collection<SubjectCombination> subjectCombinationCollection2;
    @OneToMany(mappedBy = "mainsjCode1")
    private Collection<EntranceInfo> entranceInfoCollection;
    @OneToMany(mappedBy = "mainsjCode2")
    private Collection<EntranceInfo> entranceInfoCollection1;
    @OneToMany(mappedBy = "mainsjCode3")
    private Collection<EntranceInfo> entranceInfoCollection2;
    @OneToMany(mappedBy = "mainsjCode4")
    private Collection<EntranceInfo> entranceInfoCollection3;

    public Subject() {
    }

    public Subject(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @XmlTransient
    public Collection<SubjectCombination> getSubjectCombinationCollection() {
        return subjectCombinationCollection;
    }

    public void setSubjectCombinationCollection(Collection<SubjectCombination> subjectCombinationCollection) {
        this.subjectCombinationCollection = subjectCombinationCollection;
    }

    @XmlTransient
    public Collection<SubjectCombination> getSubjectCombinationCollection1() {
        return subjectCombinationCollection1;
    }

    public void setSubjectCombinationCollection1(Collection<SubjectCombination> subjectCombinationCollection1) {
        this.subjectCombinationCollection1 = subjectCombinationCollection1;
    }

    @XmlTransient
    public Collection<SubjectCombination> getSubjectCombinationCollection2() {
        return subjectCombinationCollection2;
    }

    public void setSubjectCombinationCollection2(Collection<SubjectCombination> subjectCombinationCollection2) {
        this.subjectCombinationCollection2 = subjectCombinationCollection2;
    }

    @XmlTransient
    public Collection<EntranceInfo> getEntranceInfoCollection() {
        return entranceInfoCollection;
    }

    public void setEntranceInfoCollection(Collection<EntranceInfo> entranceInfoCollection) {
        this.entranceInfoCollection = entranceInfoCollection;
    }

    @XmlTransient
    public Collection<EntranceInfo> getEntranceInfoCollection1() {
        return entranceInfoCollection1;
    }

    public void setEntranceInfoCollection1(Collection<EntranceInfo> entranceInfoCollection1) {
        this.entranceInfoCollection1 = entranceInfoCollection1;
    }

    @XmlTransient
    public Collection<EntranceInfo> getEntranceInfoCollection2() {
        return entranceInfoCollection2;
    }

    public void setEntranceInfoCollection2(Collection<EntranceInfo> entranceInfoCollection2) {
        this.entranceInfoCollection2 = entranceInfoCollection2;
    }

    @XmlTransient
    public Collection<EntranceInfo> getEntranceInfoCollection3() {
        return entranceInfoCollection3;
    }

    public void setEntranceInfoCollection3(Collection<EntranceInfo> entranceInfoCollection3) {
        this.entranceInfoCollection3 = entranceInfoCollection3;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectCode != null ? subjectCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectCode == null && other.subjectCode != null) || (this.subjectCode != null && !this.subjectCode.equals(other.subjectCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Subject[ subjectCode=" + subjectCode + " ]";
    }
    
}
