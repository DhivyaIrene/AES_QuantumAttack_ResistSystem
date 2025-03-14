<%-- 
    Document   : st4
    Created on : Feb 13, 2023, 1:35:41 PM
    Author     : ADMIN
--%>
<%@page import="Algorithm.AESDecryption"%>
<%@page import="Algorithm.AesEncryption"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
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
    <body bgcolor="#003366"><form action="sdownloads" method="post">
	   <%
   String ok="";
      String ok1="";
   String msg="",msg1="";
      String a1="";
	  String a2="";
	  String a3="";        
   	  String a4=""; 
	  		  String a5="";  
			   String a6=""; 
			   ok=(String)request.getAttribute("ok");
			   ok1=(String)request.getAttribute("ok1");
     String un="";
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
    <td height="450" align="center"><table width="956" border="0">
      <tr>
        <td width="950" height="49" align="center" bgcolor="#003366"><span class="style4"><strong>OTHER DEPARTMENT FILE DOWNLOAD </strong></span></td>
      </tr>
      <tr>
        <td><table width="943" border="0" align="center">
  <tr>
    <td width="937" height="114"><table width="920" border="0" align="center">
      <tr>
        <td width="914"><table width="925" height="33" border="0">
            <tr>
              <td width="163"><div align="center"><strong>SELECT </strong></div></td>
              <td width="160"><div align="center"><strong>FILE ID </strong></div></td>
              <td width="209"><div align="center"><strong>FILE NAME </strong></div></td>
              <td width="201"><div align="center"><strong>USER NAME </strong></div></td>
              <td width="159"><div align="center"><strong>TYPE </strong></div></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="916" height="33" border="0">
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
		ResultSet rs = st.executeQuery("select * from upload where ack1='ok' and department!='"+asc.toEncrypt(so.getAttribute("un3").toString().getBytes())+"'");

    while(rs.next())
		{						
	 %>
          <tr>
              <td width="164"><div align="center">
                  <input name="b" type="radio" value="<%=rs.getString(1)%>">
              </div></td>
            <td width="165"><div align="center"><%=rs.getString(1)%></div></td>
            <td width="206"><div align="center"><%=rs.getString(4)%></div></td>
            <td width="201"><div align="center"><%=dsc.toDeycrypt(rs.getString(2))%></div></td>
            <td width="158"><div align="center"><%=rs.getString(13)%></div></td>
          </tr>
            <%
 
													
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
    <td align="center"><table width="240" border="0" align="center">

       
      <tr>
        <td><label>
          <input type="submit" name="t1" value="Download">&nbsp;&nbsp;&nbsp;&nbsp;
          <input type="submit" name="t2" value="Send Reguest">
        </label></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>
      <%if(request.getParameter("t1")!=null){%>
      <table width="486" border="0" align="center">
	   <tr>
    <td width="198">File Id</td>
    <td width="8">&nbsp;</td>
    <td width="258"><label>
      <input type="text" name="a1"  value="<%=a4%>" >
    </label></td>
  </tr>
  <tr>
    <td>Generated Code </td>
    <td>&nbsp;</td>
    <td><label>
      <input type="text" name="a2" >
    </label></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><input type="submit" name="t3" value="Download">
      &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="submit" name="t4" value="Submit"></td>
  </tr>
</table>
      <%}%><%=msg%><%if(request.getParameter("t3")!=null){%><table width="318" border="0">
  <tr>
    <td width="20">&nbsp;</td>
    <td width="255">&nbsp;</td>
    <td width="29">&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center"><%=msg1%></td>
     <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td align="center"><a href="video/<%=a5%>.<%=a6%>">Download the File</a></td>
    <td>&nbsp;</td>
  </tr>
</table>
<%}%></td>
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


