/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.utils.TransientHandler;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "Rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rate.findAll", query = "SELECT r FROM Rate r")
    , @NamedQuery(name = "Rate.findByRateId", query = "SELECT r FROM Rate r WHERE r.rateId = :rateId")
    , @NamedQuery(name = "Rate.findByUserId", query = "SELECT r FROM Rate r WHERE r.userId = :userId")
    , @NamedQuery(name = "Rate.findByTitle", query = "SELECT r FROM Rate r WHERE r.title = :title")
    , @NamedQuery(name = "Rate.findByEncourage", query = "SELECT r FROM Rate r WHERE r.encourage = :encourage")})
public class Rate implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RateId")
    private Integer rateId;
    @Column(name = "UserId")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "Title")
    private String title;
    @Lob
    @Column(name = "Pros")
    private String pros;
    @Lob
    @Column(name = "Cons")
    private String cons;
    @Lob
    @Column(name = "Experience")
    private String experience;
    @Column(name = "Encourage")
    private Short encourage;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rate")
    private Collection<RateDetail> rateDetails;
    @JoinColumn(name = "BranchId", referencedColumnName = "BranchId")
    @ManyToOne(optional = false)
    private Branch branch;

    public Rate() {
    }

    public Rate(Integer rateId) {
        this.rateId = rateId;
    }

    public Rate(Integer rateId, String title) {
        this.rateId = rateId;
        this.title = title;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Short getEncourage() {
        return encourage;
    }

    public void setEncourage(Short encourage) {
        this.encourage = encourage;
    }

    @XmlTransient
    public Collection<RateDetail> getRateDetails() {
        return rateDetails;
    }

    public void setRateDetails(Collection<RateDetail> rateDetails) {
        this.rateDetails = rateDetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateId != null ? rateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rate)) {
            return false;
        }
        Rate other = (Rate) object;
        if ((this.rateId == null && other.rateId != null) || (this.rateId != null && !this.rateId.equals(other.rateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Rate[ rateId=" + rateId + " ]";
    }

    //===============TRANSIENT HANDLER==================
    //HANDLE BRANCH
    @Transient
    private Integer branchId;
    @Transient @XmlTransient
    public int branchHandler = GENERATE;

    public Branch getBranch() {
        if (branchHandler == GENERATE) {
            branch.rateHandler = TRANSIENT;
            return branch;
        }
        return null;
    }

    @XmlElement(name = "branchId")
    public Integer getBranchId() {
        if (branchHandler == RAW) {
            branchId = branch.getBranchId();
        }
        return branchId;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}
