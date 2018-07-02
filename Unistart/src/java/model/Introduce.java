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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import static model.utils.TransientHandler.GENERATE;
import static model.utils.TransientHandler.TRANSIENT;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "Introduce")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Introduce.findAll", query = "SELECT i FROM Introduce i")
    , @NamedQuery(name = "Introduce.findByIntroduceId", query = "SELECT i FROM Introduce i WHERE i.introduceId = :introduceId")
    , @NamedQuery(name = "Introduce.findByLink", query = "SELECT i FROM Introduce i WHERE i.link = :link")
    , @NamedQuery(name = "Introduce.findByStatus", query = "SELECT i FROM Introduce i WHERE i.status = :status")})
public class Introduce implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IntroduceId")
    private Integer introduceId;
    @Column(name = "Link")
    private String link;
    @Basic(optional = false)
    @Column(name = "Status")
    private boolean status;
    

    public Introduce() {
    }

    public Introduce(Integer introduceId) {
        this.introduceId = introduceId;
    }

    public Introduce(Integer introduceId, boolean status) {
        this.introduceId = introduceId;
        this.status = status;
    }

    public Integer getIntroduceId() {
        return introduceId;
    }

    public void setIntroduceId(Integer introduceId) {
        this.introduceId = introduceId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (introduceId != null ? introduceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Introduce)) {
            return false;
        }
        Introduce other = (Introduce) object;
        if ((this.introduceId == null && other.introduceId != null) || (this.introduceId != null && !this.introduceId.equals(other.introduceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Introduce[ introduceId=" + introduceId + " ]";
    }
    
    //============RELATIONSHIP HANDLER==============
    
    //HANDLE UNIVERSITY
    @JoinColumn(name = "UniversityId", referencedColumnName = "UniversityId")
    @ManyToOne(optional = false)
    private University university;
    @Transient
    @XmlTransient
    public int universityHandler = GENERATE;

    public University getUniversity() {
        if (universityHandler == GENERATE) {
            university.typeHandler = TRANSIENT;
            return university;
        }
        return null;
    }

   
    public void setUniversity(University university) {
        this.university = university;
    }
    
}
