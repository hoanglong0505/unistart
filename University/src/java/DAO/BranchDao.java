/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBUtils.DBUtils;
import Models.Branch;
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
public class BranchDao {
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
    
    public List<Branch> getListBranchByUnversity(int universityId) throws SQLException, ClassNotFoundException {
        List<Branch> listBranch = new ArrayList<>();
        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String sql = "select b.BranchId,b.Address,b.BranchName,b.LocationId,b.Phone,b.UniversityId,\n" +
"b.Website,l.LocationName  from Branch b,Location l where b.LocationId=l.LocationId and b.UniversityId="+universityId;
                //select * from Article order by id desc limit 5;
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                 Branch branch= new Branch();
                 branch.setBranchId(rs.getInt("BranchId"));
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
