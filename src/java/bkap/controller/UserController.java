/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.controller;

import bkap.entity.User;
import bkap.model.UserModel;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ngocthuy
 */
@Controller
@RequestMapping(value = "/userController")
public class UserController {

    private UserModel userModel;

    public UserController() {
        userModel = new UserModel();
    }

    @RequestMapping(value = "/initLogin")
    public ModelAndView initLogin() {
        //chuyen sang trang login.jsp
        ModelAndView model = new ModelAndView("login");
        User userLogin = new User();
        model.addObject("userLogin", userLogin);
        return model;
    }

    @RequestMapping(value = "/login")
    public String checkUser(HttpSession session, User userLogin) {
        //kiem tra user co ton tai hay khong 
        boolean check = userModel.checkUser(userLogin);
        if (check) {
            //add thong tin uer vao session
            session.setAttribute("userName", userLogin.getUserName());
            session.setAttribute("pass", userLogin.getPass());
            return "index";
        } else {
            return "error";
        }
    }

}
