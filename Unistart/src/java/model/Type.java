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
@Table(name = "Type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Type.findAll", query = "SELECT t FROM Type t")
    , @NamedQuery(name = "Type.findByTypeId", query = "SELECT t FROM Type t WHERE t.typeId = :typeId")
    , @NamedQuery(name = "Type.findByTypeName", query = "SELECT t FROM Type t WHERE t.typeName = :typeName")})
public class Type implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TypeId")
    private Integer typeId;
    @Basic(optional = false)
    @Column(name = "TypeName")
    private String typeName;

    public Type() {
    }

    public Type(Integer typeId) {
        this.typeId = typeId;
    }

    public Type(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Type[ typeId=" + typeId + " ]";
    }
    
    //=============RELATIONSHIP HANDLER====================
    //HANDLE UNIVERSITIES
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Collection<University> universities;
    @Transient
    @XmlTransient
    public int universityHandler = RAW;

    public Collection<University> getUniversities() {
        if (universityHandler == GENERATE) {
            for (University u : universities) {
                u.typeHandler = TRANSIENT;
            }
            return universities;
        }
        return null;
    }

    public void setUniversities(Collection<University> universities) {
        this.universities = universities;
    }
    
}
