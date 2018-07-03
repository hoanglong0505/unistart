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
 * @author Admin
 */
@Entity
@Table(name = "School")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "School.findAll", query = "SELECT s FROM School s")
    , @NamedQuery(name = "School.findBySchoolId", query = "SELECT s FROM School s WHERE s.schoolId = :schoolId")
    , @NamedQuery(name = "School.findBySchoolName", query = "SELECT s FROM School s WHERE s.schoolName = :schoolName")
    , @NamedQuery(name = "School.findBySchoolCode", query = "SELECT s FROM School s WHERE s.schoolCode = :schoolCode")
    , @NamedQuery(name = "School.findByWebsite", query = "SELECT s FROM School s WHERE s.website = :website")
    , @NamedQuery(name = "School.findByPhone", query = "SELECT s FROM School s WHERE s.phone = :phone")
    , @NamedQuery(name = "School.findByEmail", query = "SELECT s FROM School s WHERE s.email = :email")
    , @NamedQuery(name = "School.findByAvatar", query = "SELECT s FROM School s WHERE s.avatar = :avatar")})
public class School implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SchoolId")
    private Integer schoolId;
    @Basic(optional = false)
    @Column(name = "SchoolName")
    private String schoolName;
    @Column(name = "SchoolCode")
    private String schoolCode;
    @Column(name = "Website")
    private String website;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Avatar")
    private String avatar;
    @OneToMany(mappedBy = "schoolId")
    private Collection<Rate> rateCollection;
    @OneToMany(mappedBy = "schoolId")
    private Collection<Article> articleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Collection<EntranceInfo> entranceInfoCollection;
    @JoinColumn(name = "TypeId", referencedColumnName = "TypeId")
    @ManyToOne
    private Type typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Collection<Branch> branchCollection;

    public School() {
    }

    public School(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public School(Integer schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @XmlTransient
    public Collection<Rate> getRateCollection() {
        return rateCollection;
    }

    public void setRateCollection(Collection<Rate> rateCollection) {
        this.rateCollection = rateCollection;
    }

    @XmlTransient
    public Collection<Article> getArticleCollection() {
        return articleCollection;
    }

    public void setArticleCollection(Collection<Article> articleCollection) {
        this.articleCollection = articleCollection;
    }

    @XmlTransient
    public Collection<EntranceInfo> getEntranceInfoCollection() {
        return entranceInfoCollection;
    }

    public void setEntranceInfoCollection(Collection<EntranceInfo> entranceInfoCollection) {
        this.entranceInfoCollection = entranceInfoCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolId != null ? schoolId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof School)) {
            return false;
        }
        School other = (School) object;
        if ((this.schoolId == null && other.schoolId != null) || (this.schoolId != null && !this.schoolId.equals(other.schoolId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.School[ schoolId=" + schoolId + " ]";
    }
    
}
