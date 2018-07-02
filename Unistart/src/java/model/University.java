/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "University")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u")
    , @NamedQuery(name = "University.findByUniversityId", query = "SELECT u FROM University u WHERE u.universityId = :universityId")
    , @NamedQuery(name = "University.findByUniversityName", query = "SELECT u FROM University u WHERE u.universityName = :universityName")
    , @NamedQuery(name = "University.findByUniversityCode", query = "SELECT u FROM University u WHERE u.universityCode = :universityCode")
    , @NamedQuery(name = "University.findByWebsite", query = "SELECT u FROM University u WHERE u.website = :website")
    , @NamedQuery(name = "University.findByAvatar", query = "SELECT u FROM University u WHERE u.avatar = :avatar")})
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UniversityId")
    private Integer universityId;
    @Basic(optional = false)
    @Column(name = "UniversityName")
    private String universityName;
    @Basic(optional = false)
    @Column(name = "UniversityCode")
    private String universityCode;
    @Column(name = "Website")
    private String website;
    @Column(name = "Avatar")
    private String avatar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId")
    private Collection<Introduce> introduceCollection;
    @JoinColumn(name = "LevelId", referencedColumnName = "LevelId")
    @ManyToOne(optional = false)
    private Level levelId;
    @JoinColumn(name = "TypeId", referencedColumnName = "TypeId")
    @ManyToOne(optional = false)
    private Type typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId")
    private Collection<Branch> branchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId")
    private Collection<Rate> rateCollection;

    public University() {
    }

    public University(Integer universityId) {
        this.universityId = universityId;
    }

    public University(Integer universityId, String universityName, String universityCode) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.universityCode = universityCode;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<Introduce> getIntroduceCollection() {
        return introduceCollection;
    }

    public void setIntroduceCollection(Collection<Introduce> introduceCollection) {
        this.introduceCollection = introduceCollection;
    }

    public Level getLevelId() {
        return levelId;
    }

    public void setLevelId(Level levelId) {
        this.levelId = levelId;
    }

    public Type getTypeId() {
        return typeId;
    }

    public void setTypeId(Type typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    @XmlTransient
    public Collection<Rate> getRateCollection() {
        return rateCollection;
    }

    public void setRateCollection(Collection<Rate> rateCollection) {
        this.rateCollection = rateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universityId != null ? universityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.universityId == null && other.universityId != null) || (this.universityId != null && !this.universityId.equals(other.universityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.University[ universityId=" + universityId + " ]";
    }
    
    //=======TRANSIENT HANDLER=========
    
}
