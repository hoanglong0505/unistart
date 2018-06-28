/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
 * @author Admin
 */
@Entity
@Table(name = "One", catalog = "test", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "One.findAll", query = "SELECT o FROM One o")
    , @NamedQuery(name = "One.findByOneId", query = "SELECT o FROM One o WHERE o.oneId = :oneId")
    , @NamedQuery(name = "One.findByOneName", query = "SELECT o FROM One o WHERE o.oneName = :oneName")})
public class One implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "OneId", nullable = false)
    private Integer oneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "OneName", nullable = false, length = 50)
    private String oneName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "oneId") 
    private List<Two> twoList;

    public One() {
    }

    public One(Integer oneId) {
        this.oneId = oneId;
    }

    public One(Integer oneId, String oneName) {
        this.oneId = oneId;
        this.oneName = oneName;
    }

    public Integer getOneId() {
        return oneId;
    }

    public void setOneId(Integer oneId) {
        this.oneId = oneId;
    }

    public String getOneName() {
        return oneName;
    }

    public void setOneName(String oneName) {
        this.oneName = oneName;
    }

    @XmlTransient
    public List<Two> getTwoList() {
        return twoList;
    }

    public void setTwoList(List<Two> twoList) {
        this.twoList = twoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (oneId != null ? oneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof One)) {
            return false;
        }
        One other = (One) object;
        if ((this.oneId == null && other.oneId != null) || (this.oneId != null && !this.oneId.equals(other.oneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.One[ oneId=" + oneId + " ]";
    }
    
}
