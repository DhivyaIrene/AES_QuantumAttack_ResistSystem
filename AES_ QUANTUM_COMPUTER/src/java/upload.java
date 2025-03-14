/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Algorithm.AesEncryption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
public class upload extends HttpServlet {

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
         AesEncryption aes=new AesEncryption();
                    String url = "jdbc:mysql://localhost:3306/Audit";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, "root", "root");
            PreparedStatement ps;
            Statement st = con.createStatement();  
            Statement st1 = con.createStatement();
            String s1=request.getParameter("t1");
            String a1= request.getParameter("a1");
            String a2 ="C:\\Users\\de434\\Desktop\\AES_ QUANTUM_COMPUTER\\"+ request.getParameter("a2");
            String a3 = request.getParameter("a3");
                String a4 = request.getParameter("a4");
                String a5 = request.getParameter("a5");
            String a10=" ";
              int randomInt = 0;
              
          String a="",d="",d1="";
          int b11=0,b12=0,b13=0,h11=0,h12=0,h13=0,c=0,aa=0,aa1=0,aa3=0,aa4=0;
         HttpSession so = request.getSession(true);
              String v3=null,v1=null,v2=null,v4=null,v5=null;
                if((s1!=null) )
            {
            if((a1!=null)|| (a2!=null)|| (a3!=null) )
            {
                 java.util.Date st11 = new java.util.Date();
                // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10

                Random randomGenerator = new Random();
                for (int idx = 1; idx <= 10; ++idx) {
                    randomInt = randomGenerator.nextInt(100000);

                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String f = formatter.format(st11);
                System.out.println("Formatted date is ==>" + f);
                  
                   ResultSet rs = st1.executeQuery("select * from register where userid='"+aes.toEncrypt(so.getAttribute("un").toString().getBytes())+"'");

    if(rs.next())
		{
      v1=rs.getString(1);  
	   v2=rs.getString(2); 
	    v3=rs.getString(8); 
//         aa1=Integer.parseInt(rs.getString(9)); 
         
       		   } 
   
    
    
   
    
   
                                         
                                         
                                         
                        if(a5.equalsIgnoreCase("pdf")) {
                                   
                            File file = new File(a2);
                FileInputStream fis = new FileInputStream(file);
                long filesize = file.length();
		long filesizeInKB = filesize / 1024;
                
         		System.out.println("Size of File is: " + filesizeInKB + " KB");  
          
        int r=Integer.parseInt(a3);
                      a="(((b11*b12*b13)-b11)+((b11*b12*b13)-b12)+((b11*b12*b13)-b13))";
                                    d="import/v1.jar";
                                     d1="import/import/v1.jad";
                                      c = 9;
        b11 = (r / 1000) + c;
        h11 = r % 1000;
        b12 = (h11 / 10) + c;
        h12 = h11 % 10;
        b13 = h12 + c;
        aa = (((b11 * b12 * b13) - b11) + ((b11 * b12 * b13) - b12) + ((b11 * b12 * b13) - b13));
                                     System.out.println(r);
                                    System.out.println("b11"+ "   "+b11);
                                    System.out.println("c11"+"    "+h11);
                                    System.out.println("b12"+"   "+b12);
                                     System.out.println("c12"+"  "+h12);
                                     System.out.println("b13"+"    "+b13);
                                     System.out.println("c13"+"   "+h13);
					 System.out.println("Enter the number one=" + aa);
					 System.out.println("Enter the number one=" + aa);
                                         
                            PreparedStatement pstmt = con.prepareStatement("insert into upload values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, a1);
                pstmt.setString(2, v1);
                pstmt.setBinaryStream(3, fis, file.length());
                pstmt.setString(4, file.getName());
                pstmt.setInt(5, r);
                pstmt.setString(6, d);
                pstmt.setString(7, a);
                pstmt.setInt(8, aa);
                pstmt.setString(9, a10);
                pstmt.setString(10, a10);
                 pstmt.setString(11, v3);
                    pstmt.setString(12, filesizeInKB+"");
                 pstmt.setString(13, a4);
              pstmt.setString(14, a5);
                   ResultSet rs1 = (ResultSet) st.executeQuery("select * from upload where filename='"+file.getName()+"'");
        
                 
	       if(rs1.next())
	   	      {
	   		 request.setAttribute("ok", "1");
                    request.setAttribute("msg", "already exist");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                }else{
                        //    mail(rs12.getString(5), "Public Key:"+r+" Secret Key"+aa);
                   
                   int i=  pstmt.executeUpdate();
                   
              if(i==1){
                   request.setAttribute("ok1", "1");
                       request.setAttribute("a1", "File Size:"+filesizeInKB+"");
                             request.setAttribute("a2", "Balance File Size:"+aa4+"");
                    request.setAttribute("msg", "Sucessfully registered");
                  RequestDispatcher rs5=request.getRequestDispatcher("h3.jsp");
                  rs5.forward(request, response);
              }else{

                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Password didnot match");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                } 
            
               }}else if(a5.equalsIgnoreCase("mpeg")) {
                   File file = new File(a2);
                FileInputStream fis = new FileInputStream(file);
                long filesize = file.length();
		long filesizeInKB = filesize / 1024;
                
         		System.out.println("Size of File is: " + filesizeInKB + " KB");  
          
                if(aa3>=filesizeInKB){
                aa4=(int) (aa3-filesizeInKB);
        int r=Integer.parseInt(a3);
                      a="(((b11*b12*b13)-b11)+((b11*b12*b13)-b12)+((b11*b12*b13)-b13))";
                                    d="import/v1.jar";
                                     d1="import/import/v1.jad";
                                      c = 9;
        b11 = (r / 1000) + c;
        h11 = r % 1000;
        b12 = (h11 / 10) + c;
        h12 = h11 % 10;
        b13 = h12 + c;
        aa = (((b11 * b12 * b13) - b11) + ((b11 * b12 * b13) - b12) + ((b11 * b12 * b13) - b13));
                                     System.out.println(r);
                                    System.out.println("b11"+ "   "+b11);
                                    System.out.println("c11"+"    "+h11);
                                    System.out.println("b12"+"   "+b12);
                                     System.out.println("c12"+"  "+h12);
                                     System.out.println("b13"+"    "+b13);
                                     System.out.println("c13"+"   "+h13);
					 System.out.println("Enter the number one=" + aa);
					 System.out.println("Enter the number one=" + aa);
                    String newDir = "new_dir";
        boolean success = (new File(newDir)).mkdir();

        if (success) {
            System.out.println("Successfully created directory: " + newDir);
        } else {
            System.out.println("Failed to create directory: " + newDir);
        }

        // Create a directory; all non-existent ancestor directories are
        // automatically created.
        newDir = "C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\AUDITING\\web\\video";
        success = (new File(newDir)).mkdirs();

        if (success) {
            System.out.println("Successfully created directory: " + newDir);
        } else {
            System.out.println("Failed to create directory: " + newDir);
        }

                  InputStream inStream = null;
	OutputStream outStream = null;

 
    	    File afile =new File(a2);
            System.out.println(afile);
                   System.out.println(afile.getAbsolutePath());
       
    	    File bfile =new File("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\AUDITING\\web\\video\\"+a1+".mpeg");

    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("File is copied successful!");
                            PreparedStatement pstmt = con.prepareStatement("insert into upload values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, a1);
                pstmt.setString(2, v1);
                pstmt.setString(3, a1);
                pstmt.setString(4, a1);
                pstmt.setInt(5, r);
                pstmt.setString(6, d);
                pstmt.setString(7, a);
                pstmt.setInt(8, aa);
                pstmt.setString(9, a10);
                pstmt.setString(10, a10);
                 pstmt.setString(11, v3);
                    pstmt.setString(12, filesizeInKB+"");
                 pstmt.setString(13, a4);
              pstmt.setString(14, a5);
                   ResultSet rs1 = (ResultSet) st.executeQuery("select * from upload where filename='"+file.getName()+"'");
        
                 
	       if(rs1.next())
	   	      {
	   		 request.setAttribute("ok", "1");
                    request.setAttribute("msg", "already exist");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                }else{
                       
                   int i=  pstmt.executeUpdate();
              if(i==1){
                   request.setAttribute("ok1", "1");
                       request.setAttribute("a1", "File Size:"+filesizeInKB+"");
                             request.setAttribute("a2", "Balance File Size:"+aa4+"");
                    request.setAttribute("msg", "Sucessfully registered");
                  RequestDispatcher rs5=request.getRequestDispatcher("h3.jsp");
                  rs5.forward(request, response);
              }else{

                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Password didnot match");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                } 
            
               }     }else{
         request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Cross the Limit");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
    }
            }else  if(a5.equalsIgnoreCase("mp3")) {
                   
            File file = new File(a2);
                FileInputStream fis = new FileInputStream(file);
                long filesize = file.length();
		long filesizeInKB = filesize / 1024;
                
         		System.out.println("Size of File is: " + filesizeInKB + " KB");  
     
                System.out.println("balance" + aa4 + " KB");  
        int r=Integer.parseInt(a3);
                      a="(((b11*b12*b13)-b11)+((b11*b12*b13)-b12)+((b11*b12*b13)-b13))";
                                    d="import/v1.jar";
                                     d1="import/import/v1.jad";
                                      c = 9;
        b11 = (r / 1000) + c;
        h11 = r % 1000;
        b12 = (h11 / 10) + c;
        h12 = h11 % 10;
        b13 = h12 + c;
        aa = (((b11 * b12 * b13) - b11) + ((b11 * b12 * b13) - b12) + ((b11 * b12 * b13) - b13));
                                     System.out.println(r);
                                    System.out.println("b11"+ "   "+b11);
                                    System.out.println("c11"+"    "+h11);
                                    System.out.println("b12"+"   "+b12);
                                     System.out.println("c12"+"  "+h12);
                                     System.out.println("b13"+"    "+b13);
                                     System.out.println("c13"+"   "+h13);
					 System.out.println("Enter the number one=" + aa);
					 System.out.println("Enter the number one=" + aa);
                     String newDir = "new_dir";
        boolean success = (new File(newDir)).mkdir();

        if (success) {
            System.out.println("Successfully created directory: " + newDir);
        } else {
            System.out.println("Failed to create directory: " + newDir);
        }

        // Create a directory; all non-existent ancestor directories are
        // automatically created.
        newDir = "C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\AUDITING\\web\\video";
        success = (new File(newDir)).mkdirs();

        if (success) {
            System.out.println("Successfully created directory: " + newDir);
        } else {
            System.out.println("Failed to create directory: " + newDir);
        }

                  InputStream inStream = null;
	OutputStream outStream = null;

 
    	    File afile =new File(a2);
            System.out.println(afile);
                   System.out.println(afile.getAbsolutePath());
      
    	    File bfile =new File("C:\\Users\\ADMIN\\Documents\\NetBeansProjects\\AUDITING\\web\\video\\"+a1+".mp3");

    	    inStream = new FileInputStream(afile);
    	    outStream = new FileOutputStream(bfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){
 
    	    	outStream.write(buffer, 0, length);
 
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("File is copied successful!");
                            PreparedStatement pstmt = con.prepareStatement("insert into upload values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, a1);
                pstmt.setString(2, v1);
                 pstmt.setString(3, a1);
                pstmt.setString(4, a1);
                pstmt.setInt(5, r);
                pstmt.setString(6, d);
                pstmt.setString(7, a);
                pstmt.setInt(8, aa);
                pstmt.setString(9, a10);
                pstmt.setString(10, a10);
                 pstmt.setString(11, v3);
                    pstmt.setString(12, filesizeInKB+"");
                 pstmt.setString(13, a4);
              pstmt.setString(14, a5);
                   ResultSet rs1 = (ResultSet) st.executeQuery("select * from upload where filename='"+file.getName()+"'");
        
                 
	       if(rs1.next())
	   	      {
	   		 request.setAttribute("ok", "1");
                    request.setAttribute("msg", "already exist");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                }else{
                       
                   int i=  pstmt.executeUpdate();
              if(i==1){
                   request.setAttribute("ok1", "1");
                       request.setAttribute("a1", "File Size:"+filesizeInKB+"");
                             request.setAttribute("a2", "Balance File Size:"+aa4+"");
                    request.setAttribute("msg", "Sucessfully registered");
                  RequestDispatcher rs5=request.getRequestDispatcher("h3.jsp");
                  rs5.forward(request, response);
              }else{

                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Password didnot match");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                } 
            
               }
            
            }else if(a5.equalsIgnoreCase("doc")) {
                
                   File file = new File(a2);
                FileInputStream fis = new FileInputStream(file);
                long filesize = file.length();
		long filesizeInKB = filesize / 1024;
                
         		System.out.println("Size of File is: " + filesizeInKB + " KB");  
        
        int r=Integer.parseInt(a3);
                      a="(((b11*b12*b13)-b11)+((b11*b12*b13)-b12)+((b11*b12*b13)-b13))";
                                    d="import/v1.jar";
                                     d1="import/import/v1.jad";
                                      c = 9;
        b11 = (r / 1000) + c;
        h11 = r % 1000;
        b12 = (h11 / 10) + c;
        h12 = h11 % 10;
        b13 = h12 + c;
        aa = (((b11 * b12 * b13) - b11) + ((b11 * b12 * b13) - b12) + ((b11 * b12 * b13) - b13));
                                     System.out.println(r);
                                    System.out.println("b11"+ "   "+b11);
                                    System.out.println("c11"+"    "+h11);
                                    System.out.println("b12"+"   "+b12);
                                     System.out.println("c12"+"  "+h12);
                                     System.out.println("b13"+"    "+b13);
                                     System.out.println("c13"+"   "+h13);
					 System.out.println("Enter the number one=" + aa);
					 System.out.println("Enter the number one=" + aa);
           
                            PreparedStatement pstmt = con.prepareStatement("insert into upload values ( ?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, a1);
                pstmt.setString(2, v1);
               pstmt.setBinaryStream(3, fis, file.length());
                pstmt.setString(4, file.getName());
                pstmt.setInt(5, r);
                pstmt.setString(6, d);
                pstmt.setString(7, a);
                pstmt.setInt(8, aa);
                pstmt.setString(9, a10);
                pstmt.setString(10, a10);
                 pstmt.setString(11, v3);
                    pstmt.setString(12, filesizeInKB+"");
                 pstmt.setString(13, a4);
              pstmt.setString(14, a5);
                   ResultSet rs1 = (ResultSet) st.executeQuery("select * from upload where filename='"+file.getName()+"'");
        
                 
	       if(rs1.next())
	   	      {
	   		 request.setAttribute("ok", "1");
                    request.setAttribute("msg", "already exist");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                }else{
                      //   mail(rs12.getString(5), "Public Key:"+r+" Secret Key"+aa);
                   int i=  pstmt.executeUpdate();
              if(i==1){
                   request.setAttribute("ok1", "1");
                       request.setAttribute("a1", "File Size:"+filesizeInKB+"");
                             request.setAttribute("a2", "Balance File Size:"+aa4+"");
                    request.setAttribute("msg", "Sucessfully registered");
                  RequestDispatcher rs5=request.getRequestDispatcher("h3.jsp");
                  rs5.forward(request, response);
              }else{

                    request.setAttribute("ok", "1");
                    request.setAttribute("msg", "Password didnot match");
                    RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
                    requestdispatcher.forward(request, response);
                } 
            
               }
            
            
            }else{
                            
                        }
    
   
    
 
        
                     
            
                
               
               
              
            }else {
           request.setAttribute("ok", "1");
               request.setAttribute("msg", "Please Enter all the Values");
	       RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
	       requestdispatcher.forward(request, response); 
            }
                                    
            
            }else {
                 request.setAttribute("ok", "1");
			request.setAttribute("msg", "Please Enter all the Values");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("h3.jsp");
			requestdispatcher.forward(request, response);
            }
            
            
            
            
            
            
        }catch(Exception e) {
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