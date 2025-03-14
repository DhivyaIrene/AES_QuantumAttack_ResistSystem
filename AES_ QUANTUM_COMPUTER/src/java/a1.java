/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithm.AESDecryption;
import Algorithm.AesEncryption;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class a1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Connection con = null;
            String url = "jdbc:mysql://localhost:3306/Audit";
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, "root", "root");
            Statement smt = con.createStatement();
            Statement smt1 = con.createStatement();
            Statement smt2 = con.createStatement();
            String a1 = request.getParameter("a1");
            String a2 = request.getParameter("a2");
            String a3 = request.getParameter("a3");
            String a4 = request.getParameter("a4");
            String a5 = request.getParameter("a5");
            String a6 = request.getParameter("a6");
            String a7 = request.getParameter("a7");
            String a8 = request.getParameter("a8");
            String a9 = request.getParameter("a9");
//              String a11=request.getParameter("a10");
//                 String a12=request.getParameter("a11");
            String a11 = "Department";

            AesEncryption asc = new AesEncryption();

            if (request.getParameter("s1") != null) {
                if ((a1.equals("")) || (a2.equals("")) || (a3.equals("")) || (a4.equals("")) || (a5.equals("")) || (a6.equals("")) || (a7.equals("")) || (a8.equals(""))) {
                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Please press enter");
                    RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                    rs.forward(request, response);
                } else {

                    ResultSet rst = smt.executeQuery("Select * from register where  userid='" + a1 + "'");
                    if (rst.next()) {
                        request.setAttribute("ok", "1");
                        request.setAttribute("msg", "UserName Already Exist");
                        RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                        rs.forward(request, response);
                    } else {
                        if (a3.equalsIgnoreCase(a4)) {
                            int a111 = 0, a112 = 0;

                        

                          

                            PreparedStatement pstmt = con.prepareStatement("insert into register values ( ?,?,?,?,?,?,?,?,?)");
                            pstmt.setString(1, asc.toEncrypt(a1.getBytes()));
                            pstmt.setString(2, asc.toEncrypt(a2.getBytes()));
                            pstmt.setString(3, asc.toEncrypt(a3.getBytes()));
                            pstmt.setString(4, asc.toEncrypt(a5.getBytes()));
                            pstmt.setString(5, asc.toEncrypt(a6.getBytes()));
                            pstmt.setString(6, asc.toEncrypt(a7.getBytes()));
                            pstmt.setString(7, asc.toEncrypt(a11.getBytes()));
                            pstmt.setString(8, asc.toEncrypt(a8.getBytes()));
                            pstmt.setString(9, "Accept");
                   

                            int v = pstmt.executeUpdate();

                         if ((v == 1)) {
                                request.setAttribute("ok", "1");
                                request.setAttribute("msg", "Registered Successfully");
                                RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                                rs.forward(request, response);
                            } else {
                                request.setAttribute("ok", "1");
                                request.setAttribute("msg", "Please enter the value");
                                RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                                rs.forward(request, response);
                            }
                        } else {
                            request.setAttribute("ok", "1");
                            request.setAttribute("msg", "Password didnt match");
                            RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                            rs.forward(request, response);
                        }

                    }
                }
            } else {

                request.setAttribute("ok", "1");
                request.setAttribute("msg", "Please enter all the value");
                RequestDispatcher rs = request.getRequestDispatcher("a1.jsp");
                rs.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
