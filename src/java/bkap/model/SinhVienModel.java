/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;


import bkap.entity.SinhVien;
import bkap.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ngocthuy
 */
public class SinhVienModel {
    public List<SinhVien> getAllSinhVien() {
        //Khoi tao doi tuong Connection va CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        List<SinhVien> listSinhVien = null;
        try {
            conn = ConnectionDB.openConnection();
            //Khoi tao doi tuong callSt de goi procedure
            callSt = conn.prepareCall("{call GetAllSinhVien()}");
            //Set gia tri cho cac tham so vao, dang ky cac tham so gia
            //Thu thi goi procedure
            ResultSet rs = callSt.executeQuery();
            listSinhVien = new ArrayList<>();
            while (rs.next()) {
                SinhVien sv = new SinhVien();
                sv.setMaSV(rs.getString("MaSV"));
                sv.setTenSV(rs.getString("TenSV"));
                sv.setNoiSinh(rs.getString("NoiSinh"));
                sv.setGhichu(rs.getString("GhiChu"));
                sv.setDanToc(rs.getString("DanToc"));
                sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                sv.setQuocTich(rs.getString("GioiTinh"));
                sv.setNgaySinh(rs.getString("GioiTinh"));
                sv.setTonGiao(rs.getString("TonGiao"));
                sv.setDiaChiHT(rs.getString("DiaChiHT"));
                sv.setDiaChiTC(rs.getString("DiaChiTC"));
                sv.setsDT(rs.getString("SDT"));
                sv.setEmail(rs.getString("Email"));
                sv.setMaLop(rs.getString("MaLop"));
                listSinhVien.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listSinhVien;
    }
    
    public boolean insertCatalog(SinhVien sv) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call UpdateSinhVien(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //set gia tri cac tham so vao
            callSt.setString(1, sv.getMaSV());
            callSt.setString(2, sv.getTenSV());
            callSt.setString(3, sv.getNoiSinh());
            callSt.setString(4, sv.getGhichu());
            callSt.setString(5, sv.getDanToc());
            callSt.setBoolean(6, sv.isGioiTinh());
            callSt.setString(7, sv.getQuocTich());
            callSt.setString(8, sv.getNgaySinh());
            callSt.setString(9, sv.getTonGiao());
            callSt.setString(10, sv.getDiaChiHT());
            callSt.setString(11, sv.getDiaChiTC());
            callSt.setString(12, sv.getsDT());
            callSt.setString(13, sv.getEmail());
            callSt.setString(14, sv.getMaLop());
            //dang ki kieu du lieu cho cac tham so tra ra
            callSt.registerOutParameter(15, Types.BIT);
            //thuc hien procedure
            callSt.execute();
            //lay gia tri tham so tra ra
            check = callSt.getBoolean(15);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(null, callSt);
        }
        return check;
    }
    
    public boolean updateSinhVien(SinhVien sv) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call UpdateSinhVien(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //set gia tri cac tham so vao
            callSt.setString(1, sv.getMaSV());
            callSt.setString(2, sv.getTenSV());
            callSt.setString(3, sv.getNoiSinh());
            callSt.setString(4, sv.getGhichu());
            callSt.setString(5, sv.getDanToc());
            callSt.setBoolean(6, sv.isGioiTinh());
            callSt.setString(7, sv.getQuocTich());
            callSt.setString(8, sv.getNgaySinh());
            callSt.setString(9, sv.getTonGiao());
            callSt.setString(10, sv.getDiaChiHT());
            callSt.setString(11, sv.getDiaChiTC());
            callSt.setString(12, sv.getsDT());
            callSt.setString(13, sv.getEmail());
            callSt.setString(14, sv.getMaLop());
            
            //dang ki kieu du lieu cho cac tham so tra ra
            callSt.registerOutParameter(15, Types.BIT);
            //thuc hien procedure
            callSt.execute();
            //lay gia tri tham so tra ra
            check = callSt.getBoolean(15);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(null, callSt);
        }
        return check;
    }
    
    public boolean deleteSinhVien(String maSV) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call DeleteSinhVien(?)}");
            callSt.setString(1, maSV);
            callSt.executeUpdate();
            check = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public SinhVien getSinhVienById(String maSV) {
        //khoi tao doi tuong Connection va CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        SinhVien sv = null;
        try {
            conn = ConnectionDB.openConnection();
            //khoi tao doi tuong callSt de goi procedure
            callSt = conn.prepareCall("{call getCatalogById(?)}");
            //set gia tri cho cac tham so vao, dang ki cac tham so gia
            callSt.setString(1, maSV);
            //thuc thi goi procedure 
            ResultSet rs = callSt.executeQuery();
            sv = new SinhVien();
            if (rs.next()) {
                sv.setMaSV(rs.getString("MaSV"));
                sv.setTenSV(rs.getString("TenSV"));
                sv.setNoiSinh(rs.getString("NoiSinh"));
                sv.setGhichu(rs.getString("GhiChu"));
                sv.setDanToc(rs.getString("DanToc"));
                sv.setGioiTinh(rs.getBoolean("GioiTinh"));
                sv.setQuocTich(rs.getString("GioiTinh"));
                sv.setNgaySinh(rs.getString("GioiTinh"));
                sv.setTonGiao(rs.getString("TonGiao"));
                sv.setDiaChiHT(rs.getString("DiaChiHT"));
                sv.setDiaChiTC(rs.getString("DiaChiTC"));
                sv.setsDT(rs.getString("SDT"));
                sv.setEmail(rs.getString("Email"));
                sv.setMaLop(rs.getString("MaLop"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(null, callSt);
        }
        return sv;
    }
}
