/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import static model.utils.TransientHandler.GENERATE;
import static model.utils.TransientHandler.RAW;
import static model.utils.TransientHandler.TRANSIENT;

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
public class Branch implements Serializable {

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

    //=============RELATIONSHIP HANDLER==============
   
    //HANDLE UNIVERSITY
    @JoinColumn(name = "UniversityId", referencedColumnName = "UniversityId")
    @ManyToOne(optional = false)
    private University university;
    @Transient
    @XmlTransient
    public int universityHandler = GENERATE;

    public University getUniversity() {
        if (universityHandler == GENERATE) {
            university.branchHandler = TRANSIENT;
            return university;
        }
        return null;
    }

    public void setUniversity(University university) {
        this.university = university;
    }
     // Handle UniversotyID
  @Column(name = "UniversityId", updatable = false, insertable = false)
    private Integer universityId;
    public Integer getUniversityId() {
        if ( universityHandler!= RAW) {
            universityId = null;
        }
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    //HANDLE LOCATION
    @JoinColumn(name = "LocationId", referencedColumnName = "LocationId")
    @ManyToOne(optional = false)
    private Location location;
    @Transient
    @XmlTransient
    public int locationHandler = GENERATE;

    public Location getLocation() {
        if (locationHandler == GENERATE) {
            location.branchHandler = TRANSIENT;
            return location;
        }
        return null;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // Handle LocationID
  @Column(name = "LocationId", updatable = false, insertable = false)
    private Integer locationId;
    public Integer getLocationId() {
        if ( locationHandler!= RAW) {
            locationId = null;
        }
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
