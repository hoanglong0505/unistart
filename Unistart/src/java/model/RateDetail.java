/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import model.utils.TransientHandler;

/**
 *
 * @author TNT
 */
@Entity
@Table(name = "RateDetail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RateDetail.findAll", query = "SELECT r FROM RateDetail r")
    , @NamedQuery(name = "RateDetail.findByRateId", query = "SELECT r FROM RateDetail r WHERE r.rateDetailPK.rateId = :rateId")
    , @NamedQuery(name = "RateDetail.findByCriteriaId", query = "SELECT r FROM RateDetail r WHERE r.rateDetailPK.criteriaId = :criteriaId")
    , @NamedQuery(name = "RateDetail.findByValue", query = "SELECT r FROM RateDetail r WHERE r.value = :value")})
public class RateDetail implements Serializable, TransientHandler {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RateDetailPK rateDetailPK;
    @Basic(optional = false)
    @Column(name = "Value")
    private int value;

    public RateDetail() {
    }

    public RateDetail(RateDetailPK rateDetailPK) {
        this.rateDetailPK = rateDetailPK;
    }

    public RateDetail(RateDetailPK rateDetailPK, int value) {
        this.rateDetailPK = rateDetailPK;
        this.value = value;
    }

    public RateDetail(int rateId, int criteriaId) {
        this.rateDetailPK = new RateDetailPK(rateId, criteriaId);
    }

    public RateDetailPK getRateDetailPK() {
        return rateDetailPK;
    }

    public void setRateDetailPK(RateDetailPK rateDetailPK) {
        this.rateDetailPK = rateDetailPK;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateDetailPK != null ? rateDetailPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RateDetail)) {
            return false;
        }
        RateDetail other = (RateDetail) object;
        if ((this.rateDetailPK == null && other.rateDetailPK != null) || (this.rateDetailPK != null && !this.rateDetailPK.equals(other.rateDetailPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RateDetail[ rateDetailPK=" + rateDetailPK + " ]";
    }

    //=============RELATIONSHIP HANDLER====================
    //HANDLE RATE
    @JoinColumn(name = "RateId", referencedColumnName = "RateId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rate rate;

    @Transient
    @XmlTransient
    public int rateHandler = GENERATE;

    public Rate getRate() {
        if (rateHandler == GENERATE) {
            rate.rateDetailHandler = TRANSIENT;
            return rate;
        }
        return null;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    //HANDLE RATE CRITERIA
    @JoinColumn(name = "CriteriaId", referencedColumnName = "CriteriaId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private RateCriteria rateCriteria;

    @Transient
    @XmlTransient
    public int rateCriteriaHandler = GENERATE;

    public RateCriteria getRateCriteria() {
        if (rateCriteriaHandler == GENERATE) {
            rateCriteria.rateDetailHandler = TRANSIENT;
            return rateCriteria;
        }
        return null;
    }

    public void setRateCriteria(RateCriteria rateCriteria) {
        this.rateCriteria = rateCriteria;
    }

}
