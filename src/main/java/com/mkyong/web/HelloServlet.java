package com.mkyong.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");

            Statement st1 = conn.createStatement();
            String sql1 = "select * from model";
            ResultSet rs = st1.executeQuery(sql1);
            List<Model> mod = new ArrayList<>();
            while (rs.next()) {
                Model m = new Model();
                m.setId(rs.getInt(1));
                m.setModelName(rs.getString(2));
                m.setYear(rs.getInt(3));
                m.setPrice(rs.getInt(4));
                m.setCompany(rs.getString(5));
                mod.add(m);
            }

            req.setAttribute("modelList", mod);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, res);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Model model = new Model();
        model.setId(Integer.parseInt(req.getParameter("id")));
        model.setModelName(req.getParameter("modelName"));
        model.setYear(Integer.parseInt(req.getParameter("year")));
        model.setPrice(Integer.parseInt(req.getParameter("price")));
        model.setCompany(req.getParameter("company"));
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "");
            String sql = "insert into model values(?,?,?,?,?)";
            PreparedStatement pt = con.prepareStatement(sql);

            pt.setInt(1, model.getId());
            pt.setString(2, model.getModelName());
            pt.setInt(3, model.getYear());
            pt.setInt(4, model.getPrice());
            pt.setString(5, model.getCompany());

            pt.execute();

        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

}
