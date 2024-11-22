/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import entity.category;
import entity.products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tran Hieu
 */
public class DAO {
    Connection conn = null; // kết nối MySQL
    PreparedStatement ps = null; // sử dụng câu lệnh query
    ResultSet rs = null; // kết quả
   

    public List<products> getAllProduct() {
        List<products> list = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try {
            conn = DBContext.getMySQLConnection(); // Kết nối với MySQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); // Chạy câu lệnh query
            while (rs.next()) {
                list.add(new products(
                        rs.getInt("id"),   
                        rs.getString("catalogue"), 
                        rs.getString("msp"),
                        rs.getString("type"),
                        rs.getString("product_name"),
                        rs.getString("product_img"), 
                        rs.getDouble("product_price"),
                        rs.getString("product_description") 
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi nếu có
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace(); // Đảm bảo đóng kết nối
            }
        }
        return list;
    }
    public List<products> getAllProducts() {
        List<products> list = new ArrayList<>();
        String query = "SELECT * FROM Products";
        try {
            conn = DBContext.getMySQLConnection(); // Kết nối với MySQL
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); // Chạy câu lệnh query
            while (rs.next()) {
                list.add(new products(
                        rs.getInt("id"),   
                        rs.getString("catalogue"), 
                        rs.getString("msp"),
                        rs.getString("type"),
                        rs.getString("product_name"),
                        rs.getString("product_img"), 
                        rs.getDouble("product_price"),
                        rs.getString("product_description") 
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi nếu có
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace(); // Đảm bảo đóng kết nối
            }
        }
        return list;
    }
    public List<products> getAllProductByCategory(String category) {
        List<products> listCate = new ArrayList<>();
        String query = "SELECT * FROM Products WHERE catalogue = ?;";
        try {
            conn = DBContext.getMySQLConnection(); // Kết nối với MySQL
            ps = conn.prepareStatement(query);
            ps.setString(1, category);
            rs = ps.executeQuery(); // Chạy câu lệnh query
            
            while (rs.next()) {
                listCate.add(new products(
                           
                        rs.getInt("id"),   
                        rs.getString("catalogue"), 
                        rs.getString("msp"),
                        rs.getString("type"),
                        rs.getString("product_name"),
                        rs.getString("product_img"), 
                        rs.getDouble("product_price"),
                        rs.getString("product_description") 
                  
                ));
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi nếu có
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace(); // Đảm bảo đóng kết nối
            }
        }
        return listCate;
    }
    public products getLast() {
        String query = "SELECT * FROM Products\n" +
                        "ORDER BY id DESC\n" +
                        "LIMIT 1;";
        try {
            conn = DBContext.getMySQLConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                return new products(rs.getInt("id"),   
                        rs.getString("catalogue"), 
                        rs.getString("msp"),
                        rs.getString("type"),
                        rs.getString("product_name"),
                        rs.getString("product_img"), 
                        rs.getDouble("product_price"),
                        rs.getString("product_description")
                );
            }
        } catch (Exception e) {
        }
        return null;
    }
     public products getProductByID(String id) {
        String query = "select * from Products where id = ?";
        try {
            conn = new DBContext().getMySQLConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            if (rs.next()) { // Nếu tìm thấy sản phẩm
            return new products(
                    rs.getInt("id"),   
                    rs.getString("catalogue"), 
                    rs.getString("msp"),
                    rs.getString("type"),
                    rs.getString("product_name"),
                    rs.getString("product_img"), 
                    rs.getDouble("product_price"),
                    rs.getString("product_description")
            );
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<category> getAllCategory() {
        List<category> listC = new ArrayList<>();
        String query = "SELECT DISTINCT catalogue FROM products;";
        try {
            conn = new DBContext().getMySQLConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listC.add(new category(
                     rs.getString("catalogue")
                ));
            }
        } catch (Exception e) {
        }
        return listC;
    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<products> list = dao.getAllProduct();
        for (products x : list) {
         System.out.println(x); // In đối tượng sản phẩm
       }
        List<category> listC = dao.getAllCategory();
        for (category c : listC) {
            System.out.println(c); // In đối tượng sản phẩm
        }
        String productId = "1"; 

        // Khởi tạo đối tượng DAO và gọi hàm getProductByID
        
        products p = dao.getProductByID(productId);

        // Kiểm tra nếu sản phẩm được tìm thấy
        if (p != null) {
            // In ra thông tin sản phẩm để kiểm tra
            System.out.println("Sản phẩm tìm thấy: ");
            System.out.println("ID: " + p.getId());
            System.out.println("Tên sản phẩm: " + p.getProduct_name());
            System.out.println("Giá: " + p.getProduct_price());
            System.out.println("Mô tả: " + p.getProduct_description());
            // In thêm các thông tin khác nếu cần
        } else {
            System.out.println("Không tìm thấy sản phẩm với ID: " + productId);
        }
    }
        
    }
