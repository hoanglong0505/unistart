/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Three", catalog = "test", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Three.findAll", query = "SELECT t FROM Three t")
    , @NamedQuery(name = "Three.findByThreeId", query = "SELECT t FROM Three t WHERE t.threeId = :threeId")
    , @NamedQuery(name = "Three.findByThreeName", query = "SELECT t FROM Three t WHERE t.threeName = :threeName")
    , @NamedQuery(name = "Three.findByTwoId", query = "SELECT t FROM Three t WHERE t.twoId = :twoId")})
public class Three implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ThreeId", nullable = false)
    private Integer threeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ThreeName", nullable = false, length = 50)
    private String threeName;
    @Basic(optional = false)
    @NotNull
    
    @Column(name = "TwoId", nullable = false)
    private int twoId;
    @JoinColumn(name = "ThreeId", referencedColumnName = "TwoId", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
     @JsonIgnore
    private Two two;

    public Three() {
    }

    public Three(Integer threeId) {
        this.threeId = threeId;
    }

    public Three(Integer threeId, String threeName, int twoId) {
        this.threeId = threeId;
        this.threeName = threeName;
        this.twoId = twoId;
    }

    public Integer getThreeId() {
        return threeId;
    }

    public void setThreeId(Integer threeId) {
        this.threeId = threeId;
    }

    public String getThreeName() {
        return threeName;
    }

    public void setThreeName(String threeName) {
        this.threeName = threeName;
    }

    public int getTwoId() {
        return twoId;
    }

    public void setTwoId(int twoId) {
        this.twoId = twoId;
    }

    public Two getTwo() {
        return two;
    }

    public void setTwo(Two two) {
        this.two = two;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (threeId != null ? threeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Three)) {
            return false;
        }
        Three other = (Three) object;
        if ((this.threeId == null && other.threeId != null) || (this.threeId != null && !this.threeId.equals(other.threeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Three[ threeId=" + threeId + " ]";
    }
    
}
