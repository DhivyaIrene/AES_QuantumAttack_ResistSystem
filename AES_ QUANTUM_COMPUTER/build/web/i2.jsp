<%-- 
    Document   : i2
    Created on : Feb 13, 2023, 1:32:21 PM
    Author     : ADMIN
--%>

<%@page import="Algorithm.AESDecryption"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title><script type="text/javascript" src="js/datetimepicker_css.js"></script>
		<script type="text/javascript" src="js/general.js"></script>
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
-->
        </style>
</head>
    <body bgcolor="#003366">  <form action="i2" method="post" >
         <%
   String ok=(String)request.getAttribute("ok");
   String msg="";
 String a11="";
 String a12="";
 String b1="",b2="",b3="",b4="",b5="",b6="",b7="",b8="",b9="",b10="";
String amt="",dis="";
    if(ok!=null)
   {
       msg = (String) request.getAttribute("msg");
 

     }
    %>
	<table width="1098" border="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td width="1092" height="59" align="center"><div align="center"><span class="style1">AES – QUANTUM COMPUTER BRUTE FORCE ATTACK RESIST SYSTEM</span></div></td>
  </tr>
  <tr>
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="285"/></td>
  </tr>
  <tr>
    <td><table width="1089" border="0" bgcolor="#003366">
      <tr>
        <td width="164" height="41" align="center"><a href="index.jsp" class="style3">HOME</a></td>
        <td width="209" align="center"><a href="i1.jsp" class="style3">LOGIN</a></td>
        <td width="227" align="center"><a href="i2.jsp" class="style3">REGISTER</a></td>
        <td width="256" align="center"><a href="i3.jsp" class="style3">ABOUTUS</a></td>
        <td width="211" align="center"><a href="i4.jsp" class="style3">CONTACT US </a></td>
      </tr>
    </table></td>
  </tr>
 <tr>
    <td height="450"><table width="500" border="0" align="center">
      <tr>
        <td width="494" height="43" align="center"><strong>REGISTRATION FORM </strong></td>
      </tr>
      <tr>
        <td><table  border="0" align="center">
          <tr>
            <td width="168"><strong>UserName </strong></td>
            <td width="10">&nbsp;</td>
            <td width="241"><label>
              <input type="text" id="a1" name="a1"  style="width:180px" maxlength="25"class="displayValue" onKeyPress="return nospecialcharacters();" onChange="return val_zero('a1','err_a1');" 
                     onBlur="return txt_empty('a1','err_a1','Should Not Be Blank');" value="" />
            </label></td>
          </tr>
          <tr>
            <td><strong>Name</strong></td>
            <td>&nbsp;</td>
            <td>
              <label><input name="a2" type="text"  id="a2" style="width:180px" maxlength="25"class="displayValue" onKeyPress="return nospecialcharacters();" onChange="return val_zero('a2','err_a2');" 
											onBlur="return txt_empty('a2','err_a2','User Name Should Not Be Blank');" value=""/>&nbsp;&nbsp;&nbsp;<span id="err_a2"></span></label>         </td>
          </tr>
          <tr>
            <td><strong>Password </strong></td>
            <td>&nbsp;</td>
            <td><label>
                    <input type="password" id="a3" name="a3"  style="width:180px" maxlength="20" class="displayValue" 
onchange="return val_zero('a3','err_a3');"
											onblur="return val_password('a3','err_a3','Should Not Be Blank');" value="" />
            </label></td>
          </tr>
          <tr>
            <td><strong>Retype Password </strong></td>
            <td>&nbsp;</td>
            <td><label>
                    <input type="password" id="a4" name="a4"  style="width:180px" maxlength="20" class="displayValue" 
onchange="return val_zero('a4','err_a4');"
											onblur="return val_password('a4','err_a4','Should Not Be Blank');" value=""/>
            </label></td>
          </tr>
          <tr>
            <td><strong>Mobile</strong></td>
            <td>&nbsp;</td>
            <td><label>
              <input type="text" id="a5" name="a5" style="width:180px"  maxlength="10" class="displayValue"  onKeyPress="return numbersonly();return nospecialcharacters();" onChange="return val_zero('a5','err_a5');" onBlur="return txt_empty('a5','err_a5','Should Not Be Blank');" value=""/>
            </label></td>
          </tr>
          <tr>
            <td><strong>Email-Id</strong></td>
            <td>&nbsp;</td>
            <td><label>
              <input type="text" id="a6" name="a6" style="width:180px" class="displayValue" onChange="return val_zero('a6','err_a6');" onBlur="return txt_empty('a6','err_a6','Should Not Be Blank');"value=""/>
            </label></td>
          </tr>
          <tr>
            <td><strong>Date</strong></td>
            <td>&nbsp;</td>
            <td><label>
                  <input type="text" style="width:180px" id="a7" name="a7" class="displayValue" onChange="return val_zero('a7','err_a7');" 
 onBlur="return txt_empty('a7','err_a7','Should Not Be Blank');" value=""/>
                      <a href="javascript:NewCssCal('a7','yyyymmdd')"><img src="images/cal.jpg" alt="" width="16" height="16" /></a><span id="err_a7"></span></label></td>
          </tr>
          <tr>
            <td><strong>Department</strong></td>
            <td>&nbsp;</td>
           
               <%

  String pro1=null;
 		try {
			int flag = 0;
 AESDecryption dsc=new AESDecryption();
			 Connection con=null;
      	      String url="jdbc:mysql://localhost:3306/Audit";
	      String driver="com.mysql.jdbc.Driver";
	      Class.forName(driver);
	       con=(Connection)DriverManager.getConnection(url, "root","root");  
               Statement stmt = con.createStatement();
			Statement st1 = con.createStatement();
		
			ResultSet rs1 = st1.executeQuery("select distinct department from register ");
  %> 
                        <td width="248"><label>
            <select name="a8"  >
                <option>Select Department</option>
			 <%
          while (rs1.next()) {
				pro1=dsc.toDeycrypt(rs1.getString(1));
           %>
              <option><%=pro1%></option><%} %>
            </select>
            </label></td>
                       
          <%
        }
        catch(Exception e)
        {
        out.println(e);
        } %>        
            </label>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td><label>
              <input  type="submit" name="s1" value="Submit" class="buttons" onClick="return validatePage('a1|a2|a3|a4|a5|a6|a7|a8|a9'	 ,'err_a1|err_a2|err_a3|err_a4|err_a5|err_a6|err_a7|err_a8|err_a9'
			 ,'Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank|Should Not Be Blank');"  />&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="s2" value="Cancel">
            </label></td>
          </tr>

        </table>
          <p align="center"><%=msg%></p></td>
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
