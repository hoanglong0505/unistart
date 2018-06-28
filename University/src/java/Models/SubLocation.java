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
public class SubLocation {
    private int subLocationId;
    private String subLocationName;
    List<Location> listLocation;

    public SubLocation() {
    }

    public SubLocation(int subLocationId, String subLocationName) {
        this.subLocationId = subLocationId;
        this.subLocationName = subLocationName;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }

    public int getSubLocationId() {
        return subLocationId;
    }

    public void setSubLocationId(int subLocationId) {
        this.subLocationId = subLocationId;
    }

    public String getSubLocationName() {
        return subLocationName;
    }

    public void setSubLocationName(String subLocationName) {
        this.subLocationName = subLocationName;
    }

    public SubLocation(int subLocationId, String subLocationName, List<Location> listLocation) {
        this.subLocationId = subLocationId;
        this.subLocationName = subLocationName;
        this.listLocation = listLocation;
    }
    
    
}
