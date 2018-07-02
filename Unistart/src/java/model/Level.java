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

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "Level")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Level.findAll", query = "SELECT l FROM Level l")
    , @NamedQuery(name = "Level.findByLevelId", query = "SELECT l FROM Level l WHERE l.levelId = :levelId")
    , @NamedQuery(name = "Level.findByLevelName", query = "SELECT l FROM Level l WHERE l.levelName = :levelName")})
public class Level implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LevelId")
    private Integer levelId;
    @Basic(optional = false)
    @Column(name = "LevelName")
    private String levelName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
    private Collection<University> universities;

    public Level() {
    }

    public Level(Integer levelId) {
        this.levelId = levelId;
    }

    public Level(Integer levelId, String levelName) {
        this.levelId = levelId;
        this.levelName = levelName;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (levelId != null ? levelId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Level)) {
            return false;
        }
        Level other = (Level) object;
        if ((this.levelId == null && other.levelId != null) || (this.levelId != null && !this.levelId.equals(other.levelId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Level[ levelId=" + levelId + " ]";
    }

    //===========TRANSIENT HANDLER===============
    //HANDLE BRANCHS
    @Transient
    @XmlTransient
    public int universityHandler = GENERATE;

    public Collection<University> getUniversities() {
        if (universityHandler == GENERATE) {
            for (University u : universities) {
                u.levelHandler = TRANSIENT;
            }
            return universities;
        }
        return null;
    }

    public void setUniversities(Collection<University> universities) {
        this.universities = universities;
    }
}
