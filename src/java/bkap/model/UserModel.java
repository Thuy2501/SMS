/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

import bkap.entity.User;
import bkap.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import org.springframework.jdbc.core.CallableStatementCreator;

/**
 *
 * @author ngocthuy
 */
public class UserModel {

    public boolean checkUser(User user) {
        Connection conn = null;
        CallableStatement callSt = null;
        Boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call CheckAd(?,?,?)}");
            callSt.setString(1, user.getUserName());
            callSt.setString(2, user.getPass());
            callSt.registerOutParameter(3, Types.BIT);
            callSt.execute();
            int svt = callSt.getInt(3);
            if (svt > 0) {
                check = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
}
