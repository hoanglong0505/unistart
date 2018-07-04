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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "SubjectCombination")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubjectCombination.findAll", query = "SELECT s FROM SubjectCombination s")
    , @NamedQuery(name = "SubjectCombination.findBySjCombiCode", query = "SELECT s FROM SubjectCombination s WHERE s.sjCombiCode = :sjCombiCode")})
public class SubjectCombination implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "SjCombiCode")
    private String sjCombiCode;
    @JoinColumn(name = "SjCode1", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject sjCode1;
    @JoinColumn(name = "SjCode2", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject sjCode2;
    @JoinColumn(name = "SjCode3", referencedColumnName = "SubjectCode")
    @ManyToOne
    private Subject sjCode3;
    @OneToMany(mappedBy = "sjCombiCode1")
    private Collection<EntranceInfo> entranceInfoCollection;
    @OneToMany(mappedBy = "sjCombiCode2")
    private Collection<EntranceInfo> entranceInfoCollection1;
    @OneToMany(mappedBy = "sjCombiCode3")
    private Collection<EntranceInfo> entranceInfoCollection2;
    @OneToMany(mappedBy = "sjCombiCode4")
    private Collection<EntranceInfo> entranceInfoCollection3;

    public SubjectCombination() {
    }

    public SubjectCombination(String sjCombiCode) {
        this.sjCombiCode = sjCombiCode;
    }

    public String getSjCombiCode() {
        return sjCombiCode;
    }

    public void setSjCombiCode(String sjCombiCode) {
        this.sjCombiCode = sjCombiCode;
    }

    public Subject getSjCode1() {
        return sjCode1;
    }

    public void setSjCode1(Subject sjCode1) {
        this.sjCode1 = sjCode1;
    }

    public Subject getSjCode2() {
        return sjCode2;
    }

    public void setSjCode2(Subject sjCode2) {
        this.sjCode2 = sjCode2;
    }

    public Subject getSjCode3() {
        return sjCode3;
    }

    public void setSjCode3(Subject sjCode3) {
        this.sjCode3 = sjCode3;
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
        hash += (sjCombiCode != null ? sjCombiCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubjectCombination)) {
            return false;
        }
        SubjectCombination other = (SubjectCombination) object;
        if ((this.sjCombiCode == null && other.sjCombiCode != null) || (this.sjCombiCode != null && !this.sjCombiCode.equals(other.sjCombiCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SubjectCombination[ sjCombiCode=" + sjCombiCode + " ]";
    }
    
}
