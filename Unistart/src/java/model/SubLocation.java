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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import static model.utils.TransientHandler.GENERATE;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "SubLocation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubLocation.findAll", query = "SELECT s FROM SubLocation s")
    , @NamedQuery(name = "SubLocation.findBySubLocationId", query = "SELECT s FROM SubLocation s WHERE s.subLocationId = :subLocationId")
    , @NamedQuery(name = "SubLocation.findBySubLocationName", query = "SELECT s FROM SubLocation s WHERE s.subLocationName = :subLocationName")})
public class SubLocation implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SubLocationId")
    private Integer subLocationId;
    @Basic(optional = false)
    @Column(name = "SubLocationName")
    private String subLocationName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subLocation")
    private Collection<Location> locations;

    public SubLocation() {
    }

    public SubLocation(Integer subLocationId) {
        this.subLocationId = subLocationId;
    }

    public SubLocation(Integer subLocationId, String subLocationName) {
        this.subLocationId = subLocationId;
        this.subLocationName = subLocationName;
    }

    public Integer getSubLocationId() {
        return subLocationId;
    }

    public void setSubLocationId(Integer subLocationId) {
        this.subLocationId = subLocationId;
    }

    public String getSubLocationName() {
        return subLocationName;
    }

    public void setSubLocationName(String subLocationName) {
        this.subLocationName = subLocationName;
    }



    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subLocationId != null ? subLocationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubLocation)) {
            return false;
        }
        SubLocation other = (SubLocation) object;
        if ((this.subLocationId == null && other.subLocationId != null) || (this.subLocationId != null && !this.subLocationId.equals(other.subLocationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.SubLocation[ subLocationId=" + subLocationId + " ]";
    }
    
    //=============TRANSIENT HANDLER==============
    //HANDLE LOCATIONS
    @Transient
    @XmlTransient
    public int locationHandler = GENERATE;

    public Collection<Location> getLocations() {
        if (locationHandler == GENERATE) {
            for (Location l : locations) {
                l.subLocationHandler = TRANSIENT;
            }
            return locations;
        }
        return null;
    }
    
    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
    
}
