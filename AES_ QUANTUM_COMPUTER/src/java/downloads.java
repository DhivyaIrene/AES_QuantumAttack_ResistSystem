/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Algorithm.AESDecryption;
import Algorithm.AesEncryption;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
public class downloads extends HttpServlet {

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

            String url1;
        String mail="";
            HttpSession so = request.getSession(true);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Audit", "root", "root");
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            Statement st2 = con.createStatement();
            Statement st3 = con.createStatement();
            Statement st4 = con.createStatement();
            Statement st5 = con.createStatement();
            Statement st6 = con.createStatement();
            int size; 
            int flag=0;
            String a11=request.getParameter("a1");
                        String a12=request.getParameter("a2");
            long mob = 0;
            String b = request.getParameter("b");
            String b1 = request.getParameter("b1");
            String a1="",a2="",bt1="",phone=""; 
           
            if (request.getParameter("t1") != null) {
                String v = null;
                java.util.Date st11 = new java.util.Date();
                // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10
     
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String f = formatter.format(st11);
                System.out.println("Formatted date is ==>" + f);
        

                System.out.println("select * from upload where fid='" + b + "' ");
                ResultSet rs = st1.executeQuery("select * from upload where fid='" + b + "'");
                if (rs != null) {
                    if (rs.next()) {
                        a1=rs.getString(4);
                                 a2=rs.getString(5);
                                         String a3=rs.getString(6);
                                         bt1=rs.getString(8);
                    
                               ResultSet r1=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r1.next())
			{
                           phone=r1.getString(4);
                        }     
                                              
                        //ss.SendSMS(phone,"generate code "+ bt1);
                         request.setAttribute("ok", "1");
                          request.setAttribute("a3", a3);
                                  request.setAttribute("a4", b);
                        request.setAttribute("a1", a1);
                           request.setAttribute("a2", a2);
                       RequestDispatcher rs2 = request.getRequestDispatcher("h5.jsp");
                rs2.forward(request, response);
                     
                    } else {
                         RequestDispatcher rs2 = request.getRequestDispatcher("h5.jsp");
                rs2.forward(request, response);
                    }

                }

            } else
                
                
                
                if (request.getParameter("t3") != null) {
          
                String v = null;
                java.util.Date st11 = new java.util.Date();
                // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String f = formatter.format(st11);
                System.out.println("Formatted date is ==>" + f);

                System.out.println("select * from upload where fid='" + b + "' ");
                 System.out.println("select * from upload where fid='" + a11 + "' ");
                    ResultSet rs2 = st1.executeQuery("select * from upload where fid='" + a11 + "'");
                if (rs2 != null) {
                    if (rs2.next()) {
                        a1=rs2.getString(4);
                                 a2=rs2.getString(5);
                        
                     
                    } 
                }
      
                 ResultSet rs1=st2.executeQuery("select * from upload where fid='"+a11+"'");
			if(rs1.next())
			{
                            if(rs1.getString(8).equalsIgnoreCase(a12)){
                          
                                            ResultSet rs=st1.executeQuery("select * from upload where fid='"+a11+"' and ( userid='"+so.getAttribute("un")+"' || type='Public')");
			if(rs.next())
			{
                                           System.out.println("Same ");
                                                          System.out.println("select * from upload where fid='" + a11 + "' ");
//			      int q=st.executeUpdate("insert into download value('"+so.getAttribute("un") +"','"+b+"','"+a1+"','"+f+"','Yes')");
//                                if(q==1){	
//                    
//                        byte[] byteArray = new byte[1048576];
//				InputStream Asset = rs.getBinaryStream(3);
//				//request.setAttribute("Asset", Asset);
//				response.reset();
//				//response.setContentType("image/jpeg");
//				response.setContentType("text/doc");
//				while((size=Asset.read(byteArray))!=-1)
//				{
//					response.getOutputStream().write(byteArray, 0, size);	
//                                }
//				
//                   
                           
//                         
//                                }
                                                         
                                                        
                                                            if(rs.getString(14).equalsIgnoreCase("doc")){
				
                                                                        ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(4);
                           phone=r.getString(4);
                        }     
                                   
                      //  mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                      //  ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                                
                                                                int i=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/doc");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
				}
                        }
                           
                            }else  if(rs.getString(14).equalsIgnoreCase("pdf")){
                                   ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                           mail=r.getString(5);
                            phone=r.getString(4);
                        }     
                                              
                       // ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                      //  mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
				  int i1=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs.getString(2) +"','"+a1+"','"+f+"','yes')");  
              if(i1==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/pdf");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
			
                        }}
                           
                            }else  if(rs.getString(14).equalsIgnoreCase("ppt")){
				     ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                              mail=r.getString(5);
                           phone=r.getString(4);
                        }     
                                              
                     //   ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                        //     mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                                int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i2==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/ppt");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
				}
                        }
                            }else{
                                   
                                 request.setAttribute("ok", "1");
                
                        request.setAttribute("msg", "Failed");
                  
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response); 
                        }
			}else{
                            
                                     ResultSet rs11=st1.executeQuery("select * from upload where fid='"+a11+"' and ( ack2='"+so.getAttribute("un")+"'|| userid='"+so.getAttribute("un")+"' || type='Private')");
			if(rs11.next())
			{
                                           System.out.println("Same ");
                                                          System.out.println("select * from upload where fid='" + a11 + "' ");
//			      int q=st.executeUpdate("insert into download value('"+so.getAttribute("un") +"','"+b+"','"+a1+"','"+f+"','Yes')");
//                                if(q==1){	
//                    
//                        byte[] byteArray = new byte[1048576];
//				InputStream Asset = rs.getBinaryStream(3);
//				//request.setAttribute("Asset", Asset);
//				response.reset();
//				//response.setContentType("image/jpeg");
//				response.setContentType("text/doc");
//				while((size=Asset.read(byteArray))!=-1)
//				{
//					response.getOutputStream().write(byteArray, 0, size);	
//                                }
//				
//                   
                           
//                         
//                                }
                                                         
                                                        
                                                            if(rs11.getString(14).equalsIgnoreCase("doc")){
				
                                                                        ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(4);
                           phone=r.getString(4);
                        }     
                                   
                      //  mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                      //  ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                                
                                                                int i=st4.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs11.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs11.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/doc");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
				}
                        }
                           
                            }else  if(rs11.getString(14).equalsIgnoreCase("pdf")){
                                   ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                           mail=r.getString(5);
                            phone=r.getString(4);
                        }     
                                              
                       // ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                      //  mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
				  int i1=st5.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs11.getString(2) +"','"+a1+"','"+f+"','yes')");  
              if(i1==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs11.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/pdf");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
			
                        }}
                           
                            }else  if(rs11.getString(14).equalsIgnoreCase("ppt")){
				     ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                              mail=r.getString(5);
                           phone=r.getString(4);
                        }     
                                              
                     //   ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                        //     mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                                int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs11.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i2==1){
				byte[] byteArray = new byte[1048576];
				InputStream Asset = rs11.getBinaryStream(3);
				//request.setAttribute("Asset", Asset);
				response.reset();
				//response.setContentType("image/jpeg");
				response.setContentType("application/ppt");
				while((size=Asset.read(byteArray))!=-1)
				{
					response.getOutputStream().write(byteArray, 0, size);	
				}
                        }
                            }else  if(rs11.getString(14).equalsIgnoreCase("mpeg")){
				     ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(5);
                           phone=r.getString(4);
                        }     
//                            mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);                      
//                        ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
//                        
                                int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs11.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i2==1){
				 request.setAttribute("ok1", "1");
                
                        request.setAttribute("msg1", "Download the Video");
                         request.setAttribute("aa", a11);
                    request.setAttribute("aa1", "mpeg");
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response); 
                        }
                            }else  if(rs11.getString(14).equalsIgnoreCase("mp3")){
				     ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(5);
                           phone=r.getString(4);
                        }     
                      //     mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);                       
                      //  ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);
                        
                                int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs11.getString(2) +"','"+a1+"','"+f+"','yes')");  
              
                        if(i2==1){
				  request.setAttribute("ok1", "1");
                
                        request.setAttribute("msg1", "Download the MP3");
                         request.setAttribute("aa", a11);
                   request.setAttribute("aa1", "mp3");
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response); 
                        }
                            }else{
                                   
                                 request.setAttribute("ok", "1");
                
                        request.setAttribute("msg", "Failed");
                  
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response); 
                        }
			}else{
                             ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(5);
                           phone=r.getString(4);
                        }     
                     //           mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);                  
                     //   ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" trying to downloaded the file id"+a11);
                        
                            System.out.print(b1);
                             int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs1.getString(2) +"','"+a1+"','"+f+"','Sent request to public')");  
                                if(i2==1){
                            request.setAttribute("ok", "1");
                
                        request.setAttribute("msg", "Your have no Right to download it");
                  
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response); 
                        }
                          
                                }
                        
                        
                        }
                     
                            } else {
                                 ResultSet r=st3.executeQuery("select * from register where userid=(select userid from upload where fid='"+a11+"') ");
			if(r.next())
			{
                             mail=r.getString(5);
                           phone=r.getString(4);
                        }     
                      //           mail(mail,"User "+ so.getAttribute("un").toString()+" downloaded the file id"+a11);                 
                     //   ss.SendSMS(phone,"User "+ so.getAttribute("un").toString()+" trying to downloaded the file id"+a11);
                    
                                  int i2=st6.executeUpdate("insert into download values ('"+so.getAttribute("un") +"','"+a11+"','"+rs1.getString(2) +"','"+a1+"','"+f+"','Sent request to public')");  
              
                                   if(i2==1){
                                       request.setAttribute("ok", "1");
                
                        request.setAttribute("msg", "Wrong Option");
                  
                       RequestDispatcher rs12 = request.getRequestDispatcher("h5.jsp");
                rs12.forward(request, response);
                                   }else{
                                       request.setAttribute("ok1", "1");
                
                        request.setAttribute("msg", "You are not authorised to Download");
                  
                       RequestDispatcher rs112 = request.getRequestDispatcher("h5.jsp");
                rs112.forward(request, response);
                                   }
                                  
                            }
                        }else{
                               request.setAttribute("ok", "1");
                
                        request.setAttribute("msg", "You are not authorised to Download");
                  
                       RequestDispatcher rs112 = request.getRequestDispatcher("h5.jsp");
                rs112.forward(request, response);
                        }
                        
            

            }else if(request.getParameter("t2")!=null) {
                int s1=0,s2=0,s3=0;
                    java.util.Date st11 = new java.util.Date();
                // Formatting date into  yyyy-MM-dd HH:mm:ss e.g 2008-10-10 11:21:10
     
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String f = formatter.format(st11);
                System.out.println("Formatted date is ==>" + f);
                 AesEncryption asc=new AesEncryption();
                         AESDecryption dsc=new AESDecryption();
                        String as="";
                  ResultSet rs = st1.executeQuery("select * from upload where fid='" + b + "'" );
                if (rs != null) {
                    if (rs.next()) {
                        a1=rs.getString(2);
                                 a2=rs.getString(4);
                                   as=dsc.toDeycrypt(rs.getString(11));  
                    }
                }
                        ResultSet r2=st2.executeQuery("select max(fid) from verify  ");
			if(r2!=null)
			{
                        if(r2.next())
			{
                          s1=Integer.parseInt(r2.getString(1));
                          s2=s1+1;
                        }  
                        }else{
                            s2=1000;
                        }   
                             
                               ResultSet r1=st3.executeQuery("select * from register where userid='"+asc.toEncrypt(so.getAttribute("un").toString().getBytes())+"'  ");
			if(r1.next())
			{
                           phone=r1.getString(4);
                           mail=r1.getString(5);
                          
                        }  
                          //and department!='"+asc.toEncrypt(so.getAttribute("un3").toString().getBytes())+"'
                                             
               int v=st.executeUpdate("insert into verify values('"+s2+"','"+b+"','"+a1+"','"+a2+"','"+so.getAttribute("un")+"','','"+phone+"','"+mail+"','"+f+"','','"+as+"')");
                        
if(v==1){
     request.setAttribute("ok2", "1");
                
                      request.setAttribute("msg", "your request is updated and its in process");
        RequestDispatcher rs2 = request.getRequestDispatcher("h5.jsp");
                rs2.forward(request, response);
}else{
     request.setAttribute("ok2", "1");
                
                        request.setAttribute("msg", "your request is not updated");
        RequestDispatcher rs2 = request.getRequestDispatcher("h5.jsp");
                rs2.forward(request, response);
}
                   
                     
                   
                
                
                RequestDispatcher rs21 = request.getRequestDispatcher("h5.jsp");
                rs21.forward(request, response);
            }else {
                RequestDispatcher rs21 = request.getRequestDispatcher("h5.jsp");
                rs21.forward(request, response);
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
