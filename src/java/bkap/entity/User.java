/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.entity;

/**
 *
 * @author ngocthuy
 */
public class User {
    private int userId;
    private String userName;
    private String pass;
    private boolean uStatus;

    public User() {
    }

    public User(int userId, String userName, String pass, boolean uStatus) {
        this.userId = userId;
        this.userName = userName;
        this.pass = pass;
        this.uStatus = uStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public boolean isuStatus() {
        return uStatus;
    }

    public void setuStatus(boolean uStatus) {
        this.uStatus = uStatus;
    }
    
    
}
