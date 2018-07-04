/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author TNT
 */
@Embeddable
public class EntranceInfoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SchoolId")
    private int schoolId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FieldId")
    private int fieldId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Year")
    private int year;

    public EntranceInfoPK() {
    }

    public EntranceInfoPK(int schoolId, int fieldId, int year) {
        this.schoolId = schoolId;
        this.fieldId = fieldId;
        this.year = year;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) schoolId;
        hash += (int) fieldId;
        hash += (int) year;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntranceInfoPK)) {
            return false;
        }
        EntranceInfoPK other = (EntranceInfoPK) object;
        if (this.schoolId != other.schoolId) {
            return false;
        }
        if (this.fieldId != other.fieldId) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EntranceInfoPK[ schoolId=" + schoolId + ", fieldId=" + fieldId + ", year=" + year + " ]";
    }
    
}
