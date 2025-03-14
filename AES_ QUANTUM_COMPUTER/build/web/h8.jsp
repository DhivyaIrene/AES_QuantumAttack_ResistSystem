<%-- 
    Document   : h8
    Created on : Feb 13, 2023, 7:03:16 PM
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
.style6 {font-size: 14px}
.style7 {color: #FFFFFF; font-weight: bold; font-size: 14px; }
-->
        </style>
</head>
    <body bgcolor="#003366"><form action="v2" method="post">
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
    <td height="256"><img  src="images/cloud-computing-banner1.jpg" width="1092" height="258"/></td>
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
    <td height="450" align="center"><table width="996" border="0">
      <tr>
        <td width="986" height="47" align="center" bgcolor="#003366"><span class="style4"><strong>EMPLOYEE ACKNOWLEDMENT </strong></span></td>
      </tr>
      <tr>
        <td><table width="966" border="0" align="center">
	<tr><td></td></tr>
  <tr>
    <td width="960" height="114"><table width="931" border="0" align="center">
      <tr>
        <td width="925"><table width="944" height="33" border="0">
          <tr>
		    
            <td width="137"><div align="center"><strong>SELECT </strong></div></td>
			<td width="150"><div align="center"><strong>FILE ID </strong></div></td>
            <td width="194"><div align="center"><strong>USER ID </strong></div></td>
            <td width="216"><div align="center"><strong>FILE NAME </strong></div></td>
            <td width="221"><div align="center"><strong>DEPARTMENT</strong></div></td>
             </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="940" height="33" border="0">
          <% 
	try
	{  AESDecryption dsc=new AESDecryption(); AesEncryption asc=new AesEncryption();
            String a11=null;
             	   HttpSession so = request.getSession(true);
 System.out.println(a11);
		int flag=0;
		String url="jdbc:mysql://localhost:3306/Audit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select * from upload where ack1='' and department='"+asc.toEncrypt(so.getAttribute("un3").toString().getBytes())+"' ");

    while(rs.next())
		{						
	 %><tr>
		
            <td width="115"><div align="center">
                    <input name="b" type="radio" value="<%=rs.getString(1)%>">
            </div></td>
            <td width="122"><div align="center"><%=rs.getString(1)%></div></td>
            <td width="159"><div align="center"><%=dsc.toDeycrypt(rs.getString(2))%></div></td>
            <td width="180"><div align="center"><%=rs.getString(4)%></div></td>
              <td width="179"><div align="center"><%=dsc.toDeycrypt(rs.getString(11))%></div></td>
			      
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
    <td align="center"><table width="683" border="0" align="center">

       <tr>
        <td width="499">&nbsp;</td>
      </tr>
      <tr align="center">
        <td><label>
          <input type="submit" name="t1" value="Accept">&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" name="t2" value="Denied">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" name="t3" value="Download">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
      <p><%=msg%></p>
      <p>&nbsp;</p></td>
  </tr>
</table></td>
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



