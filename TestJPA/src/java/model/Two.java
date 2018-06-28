/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Two", catalog = "test", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Two.findAll", query = "SELECT t FROM Two t")
    , @NamedQuery(name = "Two.findByTwoId", query = "SELECT t FROM Two t WHERE t.twoId = :twoId")
    , @NamedQuery(name = "Two.findByTwoName", query = "SELECT t FROM Two t WHERE t.twoName = :twoName")})
public class Two implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TwoId", nullable = false)
    private Integer twoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TwoName", nullable = false, length = 50)
    private String twoName;
    @JoinColumn(name = "OneId", referencedColumnName = "OneId", nullable = false)
    
    @ManyToOne(optional = false)
    @JsonIgnore
    private One oneId;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "two")
    private Three three;

    public Two() {
    }

    public Two(Integer twoId) {
        this.twoId = twoId;
    }

    public Two(Integer twoId, String twoName) {
        this.twoId = twoId;
        this.twoName = twoName;
    }

    public Integer getTwoId() {
        return twoId;
    }

    public void setTwoId(Integer twoId) {
        this.twoId = twoId;
    }

    public String getTwoName() {
        return twoName;
    }

    public void setTwoName(String twoName) {
        this.twoName = twoName;
    }

    public One getOneId() {
        return oneId;
    }

    public void setOneId(One oneId) {
        this.oneId = oneId;
    }

    public Three getThree() {
        return three;
    }

    public void setThree(Three three) {
        this.three = three;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (twoId != null ? twoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Two)) {
            return false;
        }
        Two other = (Two) object;
        if ((this.twoId == null && other.twoId != null) || (this.twoId != null && !this.twoId.equals(other.twoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Two[ twoId=" + twoId + " ]";
    }
    
}
