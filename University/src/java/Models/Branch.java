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
public class Branch {

    private int branchId;
    private String branchName;
    private int universityId;
    private int locationId;
    private String locationName;
    private String address;
    private String phone;
    private String website;
    private List<Location> listLocation;
    

    public Branch() {
    }

    public Branch(int branchId, String branchName, int universityId, int locationId, String address, String phone, String website) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.universityId = universityId;
        this.locationId = locationId;
        this.address = address;
        this.phone = phone;
        this.website = website;
    }

    public Branch(int branchId, String branchName, int universityId, int locationId, String locationName, String address, String phone, String website) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.universityId = universityId;
        this.locationId = locationId;
        this.locationName = locationName;
        this.address = address;
        this.phone = phone;
        this.website = website;
    }
    
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}
