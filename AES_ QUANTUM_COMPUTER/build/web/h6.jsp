<%-- 
    Document   : h6
    Created on : Feb 13, 2023, 6:08:06 PM
    Author     : ADMIN
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Algorithm.AESDecryption"%>
<%@page import="Algorithm.AesEncryption"%>
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
.style6 {font-size: 14px}
.style7 {color: #FFFFFF; font-weight: bold; font-size: 14px; }
-->
        </style>
</head>
    <body bgcolor="#003366"> <form action="verify" method="post">
	   <%
   String ok="";
      String ok1="";  String ok2="";
   String msg="",msg1="";
      String a1="";
	  String a2="";
	  String a3="";        
   	  String a4=""; 
	  		  String a5="";  
			   String a6=""; 
			   ok=(String)request.getAttribute("ok");
			   ok1=(String)request.getAttribute("ok1");
                              ok2=(String)request.getAttribute("ok2");
     String un="";
       if(ok2!=null)
   {
 
	 msg=(String)request.getAttribute("msg");
   }
   if(ok!=null)
   {
  a1=(String)request.getAttribute("a1");
  a2=(String)request.getAttribute("a2");
    a3=(String)request.getAttribute("a3");
	 a4=(String)request.getAttribute("a4");
	 msg=(String)request.getAttribute("msg");
   }
    if(ok1!=null)
   {
  msg1=(String)request.getAttribute("msg1");
	 a5=(String)request.getAttribute("aa");
	  a6=(String)request.getAttribute("aa1");
   }
    %>
	<table width="1098" border="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td width="1092" height="59" align="center"><div align="center"><span class="style1">AES – QUANTUM COMPUTER BRUTE FORCE ATTACK RESIST SYSTEM</span></div></td>
  </tr>
  <tr>
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="279"/></td>
  </tr>
  <tr>
    <td><table width="1089" border="0" bgcolor="#003366">
      <tr>
        <td width="80" height="37" align="center"><a href="h1.jsp" class="style3 style4 style6">HOME</a></td>
        <td width="168" align="center"><a href="h2.jsp" class="style7">EMPLOYEE_ACK </a></td>
		 <td width="128" align="center"><a href="h8.jsp" class="style7">FILE ACK </a></td>
        <td width="158" align="center"><a href="h3.jsp" class="style7">UPLOAD FILE</a></td>
        <td width="135" align="center"><a href="h4.jsp" class="style7">MY FILE </a></td>
        <td width="191" align="center"><a href="h5.jsp" class="style7">FILE LIST</a></td>
		 <td width="191" align="center"><a href="h6.jsp" class="style7">FILE REQUESTER </a></td>
		 <td width="234" align="center"><a href="h7.jsp" class="style7">DOWNLOADER </a></td>
			<td width="93" align="center"><a href="i1.jsp" class="style7">LOGOUT </a></td>
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
        <td width="973"><table width="845" height="33" border="0">
          <tr>
		    
            <td width="163"><div align="center"><strong>SELECT </strong></div></td>
            <td width="160"><div align="center"><strong>FILE ID </strong></div></td>
            <td width="159"><div align="center"><strong>FILE NAME </strong></div></td>
            <td width="171"><div align="center"><strong>REQUESTER NAME </strong></div></td>
             <td width="170"><div align="center"><strong>DATE</strong></div></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="843" height="33" border="0">
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
		ResultSet rs = st.executeQuery("select * from verify where ack=''and department='"+so.getAttribute("un3")+"'");

    while(rs.next())
		{						
	 %><tr>
		
            <td width="203"><div align="center">
              <input name="b" type="radio" value="<%=rs.getString(1)%>">
            </div></td>
            <td width="206"><div align="center"><%=rs.getString(2)%></div></td>
            <td width="203"><div align="center"><%=rs.getString(4)%></div></td>
            <td width="203"><div align="center"><%=rs.getString(5)%></div></td>
              <td width="203"><div align="center"><%=rs.getString(9)%></div></td>
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
  <tr>
    <td height="115" align="center"><table width="240" border="0" align="center">

       <tr>
        <td width="234">&nbsp;</td>
      </tr>
      <tr align="center">
        <td><label>
          <input type="submit" name="t1" value="Accept">&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" name="t2" value="Denied">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
      <p><%=msg%></p></td>
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

