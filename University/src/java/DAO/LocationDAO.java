/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Models.Location;
import Models.SubLocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LocationDAO {
      private PreparedStatement stm;
    private Connection con;
    private ResultSet rs;

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Location> getLocationBySubId(int subId) throws SQLException, ClassNotFoundException {
        List<Location> listSubLocation = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT LocationId,LocationName,SubLocationId FROM Location where SubLocationId="+subId;
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    Location l = new Location();
                    l.setLocationId(rs.getInt("LocationId"));
                    l.setSubLocationId(rs.getInt("SubLocationId"));
                    l.setLocationName(rs.getString("LocationName"));

                    listSubLocation.add(l);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listSubLocation;
    }

}
