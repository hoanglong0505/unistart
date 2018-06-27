/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Models.University;
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
public class UniversityDao {

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

    public List<University> getListUniversity() throws SQLException, ClassNotFoundException {
        List<University> listUniversity = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "SELECT u.*,t.TypeName,l.LevelName FROM University u "
                        + "INNER JOIN Type t ON t.TypeId=u.TypeId "
                        + "INNER JOIN Level l ON l.LevelId=u.LevelId";
                //select * from Article order by id desc limit 5;
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    University u = new University();
                    u.setUniversityId(rs.getInt("UniversityId"));
                    u.setUniversityName(rs.getString("UniversityName"));
                    u.setUniversityCode(rs.getString("UniversityCode"));
                    u.setWebsite(rs.getString("Website"));
                    u.setTypeId(rs.getInt("TypeId"));
                    u.setLevelId(rs.getInt("LevelId"));
                    u.setAvatar(rs.getString("Avatar"));
                    u.setTypeName(rs.getString("TypeName"));
                    u.setLevelName(rs.getString("LevelName"));

                    listUniversity.add(u);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return listUniversity;
    }

}
