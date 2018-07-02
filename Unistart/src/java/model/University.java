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
import static model.utils.TransientHandler.RAW;
import static model.utils.TransientHandler.TRANSIENT;
import restful.LevelFacadeREST;
import restful.TypeFacadeREST;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "University")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "University.findAll", query = "SELECT u FROM University u")
    , @NamedQuery(name = "University.findByUniversityId", query = "SELECT u FROM University u WHERE u.universityId = :universityId")
    , @NamedQuery(name = "University.findByUniversityName", query = "SELECT u FROM University u WHERE u.universityName = :universityName")
    , @NamedQuery(name = "University.findByUniversityCode", query = "SELECT u FROM University u WHERE u.universityCode = :universityCode")
    , @NamedQuery(name = "University.findByWebsite", query = "SELECT u FROM University u WHERE u.website = :website")
    , @NamedQuery(name = "University.findByAvatar", query = "SELECT u FROM University u WHERE u.avatar = :avatar")})
public class University implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UniversityId")
    private Integer universityId;
    @Basic(optional = false)
    @Column(name = "UniversityName")
    private String universityName;
    @Basic(optional = false)
    @Column(name = "UniversityCode")
    private String universityCode;
    @Column(name = "Website")
    private String website;
    @Column(name = "Avatar")
    private String avatar;

    public University() {
    }

    public University(Integer universityId) {
        this.universityId = universityId;
    }

    public University(Integer universityId, String universityName, String universityCode) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.universityCode = universityCode;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityCode() {
        return universityCode;
    }

    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (universityId != null ? universityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof University)) {
            return false;
        }
        University other = (University) object;
        if ((this.universityId == null && other.universityId != null) || (this.universityId != null && !this.universityId.equals(other.universityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.University[ universityId=" + universityId + " ]";
    }

    //=======RELATIONSHIP HANDLER=========
    //HANDLE INTRODUCES
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private Collection<Introduce> introduces;
    @Transient
    @XmlTransient
    public int introduceHandler = GENERATE;

    public Collection<Introduce> getIntroduces() {
        if (introduceHandler == GENERATE) {
            for (Introduce i : introduces) {
                i.universityHandler = TRANSIENT;
            }
            return introduces;
        }
        return null;
    }

    public void setIntroduces(Collection<Introduce> introduces) {
        this.introduces = introduces;
    }

    //HANDLE TYPE
    @JoinColumn(name = "TypeId", referencedColumnName = "TypeId")
    @ManyToOne(optional = false)
    private Type type;
    @Transient
    @XmlTransient
    public int typeHandler = GENERATE;

    public Type getType() {
        if (typeHandler == GENERATE) {
            type.universityHandler = TRANSIENT;
            return type;
        }
        return null;
    }

    public void setType(Type type) {
        this.type = type;
    }

    //HANDLE BRANCHS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private Collection<Branch> branchs;
    @Transient
    @XmlTransient
    public int branchHandler = GENERATE;

    public Collection<Branch> getBranchs() {
        if (branchHandler == GENERATE) {
            for (Branch b : branchs) {
                b.universityHandler = TRANSIENT;
            }
            return branchs;
        }
        return null;
    }

    public void setBranchs(Collection<Branch> branchs) {
        this.branchs = branchs;
    }

    //Handle Level
    @JoinColumn(name = "LevelId", referencedColumnName = "LevelId")
    @ManyToOne(optional = false)
    private Level level;
    @Transient
    @XmlTransient
    public int levelHandler = GENERATE;

    public Level getLevel() {
        if (levelHandler == GENERATE) {
            level.universityHandler = TRANSIENT;
            return level;
        }
        return null;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    //Handle Rate
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "university")
    private Collection<Rate> rates;

    @Transient
    @XmlTransient
    public int rateHandler = GENERATE;

    public Collection<Rate> getRates() {
        if (rateHandler == GENERATE) {
            for (Rate r : rates) {
                r.universityHandler = TRANSIENT;
            }
            return rates;
        }
        return null;
    }

    public void setRates(Collection<Rate> rates) {
        this.rates = rates;
    }

}
