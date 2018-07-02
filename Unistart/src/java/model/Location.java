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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.utils.TransientHandler;
import static model.utils.TransientHandler.GENERATE;
import static model.utils.TransientHandler.TRANSIENT;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "Location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId")
    , @NamedQuery(name = "Location.findByLocationName", query = "SELECT l FROM Location l WHERE l.locationName = :locationName")})
public class Location implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LocationId")
    private Integer locationId;
    @Basic(optional = false)
    @Column(name = "LocationName")
    private String locationName;

    public Location() {
    }

    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    public Location(Integer locationId, String locationName) {
        this.locationId = locationId;
        this.locationName = locationName;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Location[ locationId=" + locationId + " ]";
    }

    //=============RELATIONSHIP HANDLER============
    //HANDLE BRANCHS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private Collection<Branch> branchs;
    @Transient
    @XmlTransient
    public int branchHandler = GENERATE;

    public Collection<Branch> getBranchs() {
        if (branchHandler == GENERATE) {
            for (Branch b : branchs) {
                b.locationHandler = TRANSIENT;
            }
            return branchs;
        }
        return null;
    }

    public void setBranchs(Collection<Branch> branchs) {
        this.branchs = branchs;
    }

    //HANDLE SUBLOCATION
    @JoinColumn(name = "SubLocationId", referencedColumnName = "SubLocationId")
    @ManyToOne(optional = false)
    private SubLocation subLocation;
    @Transient
    @XmlTransient
    public int subLocationHandler = GENERATE;

    public SubLocation getSubLocation() {
        if (subLocationHandler == GENERATE) {
            subLocation.locationHandler = TRANSIENT;
            return subLocation;
        }
        return null;
    }

    public void setSubLocation(SubLocation subLocation) {
        this.subLocation = subLocation;
    }
    // Handle UniversityId
  @Column(name = "SubLocationId", updatable = false, insertable = false)
    private Integer subLocationId;
    public Integer getSubLocationId() {
        if ( subLocationHandler!= RAW) {
            subLocationId = null;
        }
        return subLocationId;
    }

    public void setSubLocationId(Integer subLocationId) {
        this.subLocationId = this.subLocationId;
    }

}
