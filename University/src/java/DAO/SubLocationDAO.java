/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Models.Level;
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
public class SubLocationDAO {
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

    public List<SubLocation> getListSubLocation() throws SQLException, ClassNotFoundException {
        List<SubLocation> listSubLocation = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT SubLocationId,SubLocationName FROM SubLocation";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    SubLocation l = new SubLocation();
                    l.setSubLocationId(rs.getInt("SubLocationId"));
                    l.setSubLocationName(rs.getString("SubLocationName"));
                    LocationDAO dao= new LocationDAO();
                    l.setListLocation(dao.getLocationBySubId(rs.getInt("SubLocationId")));
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
