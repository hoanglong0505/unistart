/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Admin
 */
public class Location {
    private int LocationId;
    private int SubLocationId;
    private String LocationName;

    public Location() {
    }

    public int getSubLocationId() {
        return SubLocationId;
    }

    public void setSubLocationId(int SubLocationId) {
        this.SubLocationId = SubLocationId;
    }

    public Location(int LocationId, int SubLocationId, String LocationName) {
        this.LocationId = LocationId;
        this.SubLocationId = SubLocationId;
        this.LocationName = LocationName;
    }

    public Location(int LocationId, String LocationName) {
        this.LocationId = LocationId;
        this.LocationName = LocationName;
    }

    public int getLocationId() {
        return LocationId;
    }

    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }
    
}
