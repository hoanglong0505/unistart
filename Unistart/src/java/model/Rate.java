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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.utils.TransientHandler;

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
    , @NamedQuery(name = "Rate.findByTitle", query = "SELECT r FROM Rate r WHERE r.title = :title")
    , @NamedQuery(name = "Rate.findByEncourage", query = "SELECT r FROM Rate r WHERE r.encourage = :encourage")
    , @NamedQuery(name = "Rate.findByStatus", query = "SELECT r FROM Rate r WHERE r.status = :status")
    , @NamedQuery(name = "Rate.findByAnonymous", query = "SELECT r FROM Rate r WHERE r.anonymous = :anonymous")})
public class Rate implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RateId")
    private Integer rateId;
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
    private Boolean encourage;
    @Basic(optional = false)
    @Column(name = "Status")
    private int status;
    @Basic(optional = false)
    @Column(name = "Anonymous")
    private boolean anonymous;

    public Rate() {
    }

    public Rate(Integer rateId) {
        this.rateId = rateId;
    }

    public Rate(Integer rateId, String title, int status, boolean anonymous) {
        this.rateId = rateId;
        this.title = title;
        this.status = status;
        this.anonymous = anonymous;
    }

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
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

    public Boolean getEncourage() {
        return encourage;
    }

    public void setEncourage(Boolean encourage) {
        this.encourage = encourage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
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

    //======================================
    //HANDLE UNIVERSITY
    @JoinColumn(name = "UniversityId", referencedColumnName = "UniversityId")
    @ManyToOne(optional = false)
    private University university;
    @Transient
    @XmlTransient
    public int universityHandler = GENERATE;

    public University getUniversity() {
        if (universityHandler == GENERATE) {
            university.rateHandler = TRANSIENT;
            return university;
        }
        return null;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
    // Handle UniversityId
  @Column(name = "UniversityId", updatable = false, insertable = false)
    private Integer universityId;
    public Integer getUniversityId() {
        if ( universityHandler!= RAW) {
            universityId = null;
        }
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = this.universityId;
    }

    //HANDLE RATE DETAILS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rate")
    private Collection<RateDetail> rateDetails;
    @Transient
    @XmlTransient
    public int rateDetailHandler = GENERATE;

    public Collection<RateDetail> getRateDetails() {
        if (rateDetailHandler == GENERATE) {
            for (RateDetail rd : rateDetails) {
                rd.rateHandler = TRANSIENT;
            }
            return rateDetails;
        }
        return null;
    }

    public void setRateDetails(Collection<RateDetail> rateDetails) {
        this.rateDetails = rateDetails;
    }
    

    //HANDLE USER
    @JoinColumn(name = "UserId", referencedColumnName = "UserId")
    @ManyToOne
    private Users user;
    @Transient
    @XmlTransient
    public int userHandler = GENERATE;

    public Users getUser() {
        if (userHandler == GENERATE) {
            user.rateHandler = TRANSIENT;
            return user;
        }
        return null;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    // Handle UniversityId
  @Column(name = "UserId", updatable = false, insertable = false)
    private Integer userId;
    public Integer getUserId() {
        if ( userHandler!= RAW) {
            userId = null;
        }
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = this.userId;
    }
}
