/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.controller;


import bkap.entity.SinhVien;
import bkap.model.SinhVienModel;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;


/**
 *
 * @author Lab06
 */
@Controller
@RequestMapping(value = "/catalogSinhVien")
public class SinhVienController {

    private SinhVienModel catModel;

    public SinhVienController() {
        catModel = new SinhVienModel();
    }

    @RequestMapping(value = "/getAll")
    public String getAllSinhVien(Model model) {
        //Khai bao trang jsp se tra ve sau khi thuc hien xong getAll.htm --> Chuyen ve trang Catalogs.jsp
//        ModelAndView model = new ModelAndView("danhsachSV");
        //Thuc hien goi sang model lay tat ca danh muc de hien thi
        List<SinhVien> listSinhVien = catModel.getAllSinhVien();
        //add listCatalog vao doi tuong model
//        model.addObject("listSinhVien", listSinhVien);
//        return model;
        model.addAttribute("listSinhVien", listSinhVien);
        return "danhsachSV";
    }

    @RequestMapping(value = "/initInsert")
    public ModelAndView initInsetCatalog() {
        //Khai bao trang jsp se tra ve sau khi thuc hien initInsert.htm
        ModelAndView model = new ModelAndView("CreateCatalog");
        //Khoi tao doi tuong Catalog chua du lieu ma nguoi dung muon them moi
        SinhVien newSinhVien = new SinhVien();
        //Add newCatalog vao model
        model.addObject("newSinhVien", newSinhVien);
        return model;
    }

    @RequestMapping(value = "/insert")
    public String insertCatalog(SinhVien newSinhVien) {
        //Thuc hien insert newCatalog vao database
        boolean check = catModel.insertCatalog(newSinhVien);
        if (check) {
            //goi lai getAll.htm de lay du lieu tu db ra hien thi
            return "redirect:getAll.htm";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/initUpdate")
    public ModelAndView initUpdateCatalog(int catalogId) {
        ModelAndView model = new ModelAndView("updateSinhVien");
        //Lay doi tuong Catalog trong database ra de hien thi
        SinhVien catalogUpdate = catModel.getSinhVienById(null);
        //add catalogUpdate vao model
        model.addObject("catalogUpdate", catalogUpdate);
        return model;
    }

    @RequestMapping(value = "/update")
    public String updateCatalog(SinhVien catalogUpdate) {
        //Thuc hien update
        boolean check = catModel.updateSinhVien(catalogUpdate);
        if (check) {
            return "redirect:getAll.htm";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/delete")
    public String deleteCatalog(int catalogId) {
        //Thuc hien xoa
        boolean check = catModel.deleteSinhVien(null);
        if (check) {
            return "redirect:getAll.htm";
        } else {
            return "error";
        }
    }
}
