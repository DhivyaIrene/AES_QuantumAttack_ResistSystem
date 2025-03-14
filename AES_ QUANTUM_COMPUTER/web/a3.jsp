<%-- 
    Document   : a3
    Created on : Feb 13, 2023, 1:33:22 PM
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
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="266"/></td>
  </tr>
  <tr>
    <td><table width="1089" border="0" bgcolor="#003366">
      <tr>
        <td width="104" height="37" align="center"><a href="admin.jsp" class="style3 style4">HOME</a></td>
        <td width="202" align="center"><a href="a1.jsp" class="style5">ADMIN REGISTER </a></td>
      
        <td width="240" align="center"><a href="a3.jsp" class="style5">EMPLOYEE DETAILS</a></td>
        <td width="215" align="center"><a href="a4.jsp" class="style5">DOWNLOAD DETAILS</a></td>
		<td width="113" align="center"><a href="i1.jsp" class="style5">LOGOUT </a></td>
      </tr>
    </table></td>
  </tr>
 <tr>
    <td height="450"><table align="center" width="849" height="156" border="0">
<tr>
            <td width="843" height="52" align="center" bgcolor="#003366"><span class="style4"><strong>EMPLOYEE DETAIL </strong></span></td>
          </tr><tr><td><table align="center" width="840" border="0">
        <tr>
        <td width="834" height="41" align="center"><div align="center"><table width="100%" height="27" border="1" >
        <tr>
            <td width="102"><div align="center" class="style19 style6 style9"><strong>USER ID </strong></div></td>
            <td width="103"><div align="center" class="style19 style6 style9"><strong>NAME</strong></div></td>
            <td width="178"><div align="center" class="style22 style6 style9"><strong>MOBILE</strong></div></td>
            <td width="177" height="23" ><div align="center" class="style19 style6 style9"><strong>EMAIL</strong></div></td>
            <td width="126"><div align="center" class="style19 style6 style9"><strong>DOB</strong></div></td>   
            <td width="108"><div align="center" class="style19 style6 style9"><strong>DEPT</strong></div></td>
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
                                                                             
                                                ResultSet rs = st.executeQuery("select * from register ");
                                                if (rs != null) {%>
                                                                <% while (rs.next()) {
                                                                %>
                                                                <tr>
                                                                    <td width="105" ><div align="center"><%=dsc.toDeycrypt(rs.getString("userid"))%></div></td>
                                                                  <td width="105" ><div align="center"><%=dsc.toDeycrypt(rs.getString("name"))%></div></td>
                                                                  <td width="170"><div align="center"><%=dsc.toDeycrypt(rs.getString("mobile"))%></div></td>
                                                                  <td width="197"><div align="center"><%=dsc.toDeycrypt(rs.getString("email"))%></div></td>
                                                                  <td width="107"><div align="center"><%=dsc.toDeycrypt(rs.getString("date"))%></div></td>
                                                                 <td width="110"><div align="center"><%=dsc.toDeycrypt(rs.getString("department"))%></div></td>
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



