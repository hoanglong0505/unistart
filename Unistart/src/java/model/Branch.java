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
@Table(name = "Branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.branchId = :branchId")
    , @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName")
    , @NamedQuery(name = "Branch.findByAddress", query = "SELECT b FROM Branch b WHERE b.address = :address")
    , @NamedQuery(name = "Branch.findByPhone", query = "SELECT b FROM Branch b WHERE b.phone = :phone")
    , @NamedQuery(name = "Branch.findByWebsite", query = "SELECT b FROM Branch b WHERE b.website = :website")})
public class Branch implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "BranchId")
    private Integer branchId;
    @Basic(optional = false)
    @Column(name = "BranchName")
    private String branchName;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Website")
    private String website;
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId")
    @ManyToOne(optional = false)
    private Location location;
    @JoinColumn(name = "UniversityId", referencedColumnName = "UniversityId")
    @ManyToOne(optional = false)
    private University university;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
    private Collection<Rate> rates;

    public Branch() {
    }

    public Branch(Integer branchId) {
        this.branchId = branchId;
    }

    public Branch(Integer branchId, String branchName, String address) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.address = address;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Branch[ branchId=" + branchId + " ]";
    }

    //TRANSIENT HANDLER
    //-------------HANDLE LOCATION----------------
    @Transient
    private Integer locationId;
    @Transient @XmlTransient
    public int locationHandler = GENERATE;

    public Location getLocation() {
        if (locationHandler == GENERATE) {
            return location;
        }
        return null;
    }

    @XmlElement(name = "locationId")
    public Integer getLocationId() {
        if (locationHandler == RAW) {
            locationId = location.getLocationId();
        }
        return locationId;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    //-------------HANDLE UNIVERSITY----------------
    @Transient
    private Integer universityId;
    @Transient @XmlTransient
    public int universityHandler = GENERATE;

    public University getUniversity() {
        if (universityHandler == GENERATE) {
            university.branchHandler = TRANSIENT;
            return university;
        }
        return null;
    }

    @XmlElement(name = "universityId")
    public Integer getUniversityId() {
        if (universityHandler == RAW) {
            universityId = university.getUniversityId();
        }
        return universityId;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
    
    //HANDLE RATES
    @Transient @XmlTransient
    public int rateHandler = GENERATE;

    public Collection<Rate> getRates() {
        if (rateHandler == GENERATE) {
            for (Rate r : rates) {
                r.branchHandler = TRANSIENT;
            }
            return rates;
        }
        return null;
    }

    public void setRates(Collection<Rate> rates) {
        this.rates = rates;
    }
}
