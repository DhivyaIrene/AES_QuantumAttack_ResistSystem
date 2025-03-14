<%-- 
    Document   : st6
    Created on : Feb 13, 2023, 1:36:10 PM
    Author     : ADMIN
--%>

<%@page import="Algorithm.AesEncryption"%>
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
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="287"/></td>
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
    <td height="450" align="center"><table width="972" border="0">
      <tr>
        <td width="962" height="42" align="center" bgcolor="#003366"><span class="style4"><strong>ACKNOWLEDGE REQUEST </strong></span></td>
      </tr>
      <tr>
        <td><table width="890" border="0" align="center">
  <tr>
    <td width="884" height="114"><table width="848" border="0" align="center">
      <tr>
        <td width="973"><table width="845" height="98" border="0">
          <tr>
		    
            <td width="163" height="46"><div align="center"><strong>VERIFY ID</strong></div></td>
            <td width="160"><div align="center"><strong>FILE ID </strong></div></td>
            <td width="170"><div align="center"><strong>FILE NAME </strong></div></td>
            <td width="160"><div align="center"><strong>REQUESTER NAME </strong></div></td>
             <td width="170"><div align="center"><strong>ACCESS CODE </strong></div></td>
            </tr>

          <% 
	try
	{AesEncryption asc=new AesEncryption(); AESDecryption dsc=new AESDecryption();
            String a11=null;
             	   HttpSession so = request.getSession(true);
 System.out.println(a11);
		int flag=0;
		String url="jdbc:mysql://localhost:3306/Audit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select * from verify where uname='"+so.getAttribute("un1")+"' and ack='Accepted'");

    while(rs.next())
		{						
	 %><tr>
		
            <td width="203" height="46"><div align="center">
             <%=rs.getString(1)%>
            </div></td>
            <td width="206"><div align="center"><%=rs.getString(2)%></div></td>
            <td width="203"><div align="center"><%=rs.getString(3)%></div></td>
            <td width="203"><div align="center"><%=rs.getString(5)%></div></td>
              <td width="203"><div align="center"><%=rs.getString(12)%></div></td>
            </tr>  <%
 
													
													} 
													}
	catch (Exception e) {
		out.println(e);
	}
	%>
        </table></td>
      </tr>
    </table></td>
  </tr>

</table></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="54" bgcolor="#003366">&nbsp;</td>
  </tr>
</table>
</form>
      
    </body>
</html>


