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
public class i1 extends HttpServlet {

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
            String url = "jdbc:mysql://localhost:3306/Audit";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement ps;
            Statement st = con.createStatement();       
            Statement st1 = con.createStatement();       
            Statement st2 = con.createStatement();
            String vname = request.getParameter("a1");
            String vpass = request.getParameter("a2");
                 HttpSession so = request.getSession(true);
                
                 System.out.println(vname);
                System.out.println(vpass);
                	String b2=null;
                	String b3=null;
                        String b4=null;   String b5=null;
                        AesEncryption asc=new AesEncryption();
                        AESDecryption dsc=new AESDecryption();
            if ((request.getParameter("s1"))!= null) {
               
                String rno = null;
                String pw = null;
                String roll = null;
                int flag = 0;
                        
	    
          
            
                ResultSet rs1 = (ResultSet) st.executeQuery("select * from register where userid='"+asc.toEncrypt(vname.getBytes())+"' and ack='Accept'");
        
                 
	        if(rs1.next())
	   	      {
	   		b2=rs1.getString(1);
                        b3=rs1.getString(3);
                                System.out.println(dsc.toDeycrypt(b2));
                System.out.println(dsc.toDeycrypt(b2));	   
                       System.out.println(vname);
                System.out.println(vpass);
	        if((vname.equalsIgnoreCase(dsc.toDeycrypt(b2)))&&(vpass.equalsIgnoreCase(dsc.toDeycrypt(b3)))) {
                     b4=dsc.toDeycrypt(rs1.getString(7));
                       b5=dsc.toDeycrypt(rs1.getString(8));
                            System.out.println(b4);
          
	   	 flag=1;
                 
                }
                      }
                      ResultSet rs3 = (ResultSet) st2.executeQuery("select * from login ");
        
                 
	        if(rs3.next())
	   	      {
	   		b2=rs3.getString(1);
                        b3=rs3.getString(2);
                          System.out.println(b2);
                System.out.println(b3);	   
                       System.out.println(vname);
                System.out.println(vpass);	   
	        if((vname.equalsIgnoreCase(b2))&&(vpass.equalsIgnoreCase(b3))) {
                     b4=rs3.getString(3);
                       System.out.println(b4);
	   	 flag=1;
                }
                      }so.setAttribute("un", vname);
                    System.out.println("user :"+b4);
                    so.setAttribute("un", vname);
                so.setAttribute("un1", vpass);
                 so.setAttribute("un2", b4);
                  so.setAttribute("un3", b5);
                if((flag==1)&&(b4.equals("Department"))){
                     request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Welcome to User Login");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h1.jsp");
		 requestdispatcher.forward(request, response);
                }
                else if((flag==1)&&(b4.equals("Admin"))){
                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Welcome to Admin Login");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("a1.jsp");
		 requestdispatcher.forward(request, response);
                }else if((flag==1)&&(b4.equals("Employee"))){
                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Welcome to Employee Login");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("st1.jsp");
		 requestdispatcher.forward(request, response);
                }
                else{
                      request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Invalid Username && Password");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("i1.jsp");
		 requestdispatcher.forward(request, response);
                }
        

            } else{
                      request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Invalid Username && Password");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("i1.jsp");
		 requestdispatcher.forward(request, response);
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
