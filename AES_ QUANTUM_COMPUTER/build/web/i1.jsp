<%-- 
    Document   : i1
    Created on : Feb 13, 2023, 1:32:13 PM
    Author     : ADMIN
--%>

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
-->
        </style>
</head>
    <body bgcolor="#003366"><form action="i1" method="post">
         	<%
                    
   String ok=(String)request.getAttribute("ok");
   String msg="";
   String a="";
   String b="";
    if(ok!=null)
   {
   msg=(String)request.getAttribute("msg");
   
     }
    %>
	<table width="1098" border="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td width="1092" height="59" align="center"><div align="center"><span class="style1">AES – QUANTUM COMPUTER BRUTE FORCE ATTACK RESIST SYSTEM</span></div></td>
  </tr>
  <tr>
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="291"/></td>
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
    <td height="450"><table width="479" border="0" align="center">
          <tr>
            <td width="473" height="43" align="center" bgcolor="#003366"><span class="style4"><strong>LOGIN FORM </strong></span></td>
          </tr>
          <tr>
            <td height="147"><table width="417" border="0" align="center">
              <tr>
                <td width="144"><strong>User Name <span class="style4">* </span></strong></td>
                <td width="10">&nbsp;</td>
                <td width="249"><input type="text" id="a1" name="a1"  style="width:180px" maxlength="25"class="displayValue" onKeyPress="return nospecialcharacters();" onChange="return val_zero('a1','err_a1');" 
                     onBlur="return txt_empty('a1','err_a1','Should Not Be Blank');" value="" /></td>
              </tr>
              <tr>
                <td><strong>Password <span class="style4">* </span></strong></td>
                <td>&nbsp;</td>
                <td><input type="password" id="a2" name="a2"  style="width:180px" maxlength="20" class="displayValue" 
onchange="return val_zero('a2','err_a2');"
											onblur="return val_password('a2','err_a2','Should Not Be Blank');" /></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
                <td>&nbsp;</td>
              </tr>
              <tr>
                <td>&nbsp;</td>
                <td></td>
                <td><label>
                  <input  type="submit" name="s1" value="Sign In" class="buttons" onClick="return validatePage('a1|a2'	 ,'err_a1|err_a2'
			 ,'Should Not Be Blank|Should Not Be Blank');"   />&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" name="s2" value="Cancel">
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
