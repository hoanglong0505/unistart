/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author Admin
 */
public class University {
    private int universityId;
    private String universityName;
    private String universityCode;
    private String website;
    private int typeId;
    private int levelId;
    private List<Branch>  listBrach;
    public University() {
    }

    public University(int universityId, String universityName, String universityCode, String website, int typeId, int levelId) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.universityCode = universityCode;
        this.website = website;
        this.typeId = typeId;
        this.levelId = levelId;
    }

    public University(int universityId, String universityName, String universityCode, String website, int typeId, int levelId, List<Branch> listBrach) {
        this.universityId = universityId;
        this.universityName = universityName;
        this.universityCode = universityCode;
        this.website = website;
        this.typeId = typeId;
        this.levelId = levelId;
        this.listBrach = listBrach;
    }

    public List<Branch> getListBrach() {
        return listBrach;
    }

    public void setListBrach(List<Branch> listBrach) {
        this.listBrach = listBrach;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Override
    public String toString() {
        return "University{" + "universityId=" + universityId + ", universityName=" + universityName + ", universityCode=" + universityCode + ", website=" + website + ", typeId=" + typeId + ", levelId=" + levelId + '}';
    }
    
}
