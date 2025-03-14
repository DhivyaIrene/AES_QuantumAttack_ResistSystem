<%-- 
    Document   : st5
    Created on : Feb 13, 2023, 1:35:50 PM
    Author     : ADMIN
--%>
<%@page import="Algorithm.AESDecryption"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            a {
                color: white;
                text-decoration: none;
            }
        </style>
        <style type="text/css">
<!--
.style1 {
	color: #003366;
	font-weight: bold;
	font-size: 24px;
	font-style: italic;
}
.style3 {color: #CCCCCC; font-weight: bold; }
.style4 {color: #FFFFFF}
.style5 {color: #FFFFFF; font-weight: bold; }
-->
        </style>
</head>
    <body bgcolor="#003366"><form action="" method="post">
	<table width="1098" border="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td width="1092" height="59" align="center"><div align="center"><span class="style1">AES – QUANTUM COMPUTER BRUTE FORCE ATTACK RESIST SYSTEM</span></div></td>
  </tr>
  <tr>
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="284"/></td>
  </tr>
  <tr>
    <td><table width="1089" border="0" bgcolor="#003366">
      <tr>
        <td width="123" height="37" align="center"><a href="st1.jsp" class="style3 style4">HOME</a></td>
        <td width="209" align="center"><a href="st2.jsp" class="style5">UPLOAD DETAILS </a></td>
        <td width="163" align="center"><a href="st3.jsp" class="style5"> MY FILE</a></td>
        <td width="203" align="center"><a href="st4.jsp" class="style5">FILE LIST </a></td>
		 <td width="252" align="center"><a href="st6.jsp" class="style5">REQUEST DETAILS</a></td>
        <td width="252" align="center"><a href="st5.jsp" class="style5">DOWNLOAD DETAILS</a></td>
		<td width="113" align="center"><a href="i1.jsp" class="style5">LOGOUT </a></td>
      </tr>
    </table></td>
  </tr>
 <tr>
    <td height="450" align="center"><table align="center" width="757" height="156" border="0">
<tr>
            <td width="751" height="52" align="center" bgcolor="#003366"><span class="style4"><strong>DOWNLOADER DETAIL </strong></span></td>
          </tr><tr><td><table align="center" width="751" border="0">
                                  <tr>
                                                    <td width="745" height="41" align="center"><div align="center"><table width="100%" height="27" border="1" >
                                                            <tr>
															<td width="127"><div align="center" class="style19 style6 style9"><strong>File Id</strong></div></td>
                                                              <td width="127"><div align="center" class="style19 style6 style9"><strong>User Id</strong></div></td>
                                                             
                                                              <td width="296"><div align="center" class="style22 style6 style9"><strong>File Name</strong></div></td>
                                                              <td width="162" height="23" ><div align="center" class="style19 style6 style9"><strong>Date</strong></div></td>
                                                              <td width="132"><div align="center" class="style19 style6 style9"><strong>Status</strong></div></td>
                                                           
                                                            
                                                      </tr>
                                                        </table>
                                                    </div></td>
                </tr>
                                                <tr><td height="49">
												<div class="text"  id="navvylist"   border-color:#FFFF00;">
                                                                         <table width=100%  align="center" border="1">
                                                                <%!int index = 1;%>
                                                                <%
                                                                    AESDecryption dsc=new AESDecryption();
																      HttpSession so = request.getSession(true);
                                                                            try {
                                                                                int flag = 0;
                                                                                String url = "jdbc:mysql://localhost:3306/Audit";
                                                                                Class.forName("com.mysql.jdbc.Driver");
                                                                                Connection con = DriverManager.getConnection(url, "root", "root");
                                                                                Statement st = con.createStatement();
                                                                             
                                                ResultSet rs = st.executeQuery("select * from download where userid= '"+so.getAttribute("un")+"'");
                                                if (rs != null) {%>
                                                                <% while (rs.next()) {
                                                                %>
                                                                <tr>
																<td width="129" ><div align="center"><%=rs.getString(2)%></div></td>
                                                                  <td width="129" ><div align="center"><%=rs.getString(1)%></div></td>
                                                                  <td width="295"><div align="center"><%=rs.getString(4)%></div></td>
                                                                  <td width="162"><div align="center"><%=rs.getString(5)%></div></td>
                                                                  <td width="131"><div align="center"><%=rs.getString(6)%></div></td>
                                                                
                                                            <%

                                                                                                                                        index++;
                                                                                                                                    }
                                                                                                                                } else {
                                                                    %>
                                                                    No items found....!
                                                                    <%                    }
                                                                                } catch (Exception e) {
                                                                                    out.println(e);
                                                                                }
                                                                    %>
                                                            </table>
							     </div>
                                                    </td>
                                                </tr>
                                            </table></td></tr>
              </table></td>
  </tr>
  <tr>
    <td height="54" bgcolor="#003366">&nbsp;</td>
  </tr>
</table>
</form>
      
    </body>
</html>


