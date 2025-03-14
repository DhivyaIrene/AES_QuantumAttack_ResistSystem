<%-- 
    Document   : h3
    Created on : Feb 13, 2023, 1:34:39 PM
    Author     : ADMIN
--%>

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
    <body bgcolor="#003366"><form action="upload" method="post">
                				<%   int a111=0;
         String a13="",a1="",a2="",a3="",msg="",a12="",a11="";
         int a112=0;
   String ok=(String)request.getAttribute("ok");

    if(ok!=null)
   {
   msg=(String)request.getAttribute("msg");

     }
     String ok1=(String)request.getAttribute("ok1");


    if(ok1!=null)
   {
          a12=(String)request.getAttribute("a2");
        a11=(String)request.getAttribute("a1");
   msg=(String)request.getAttribute("msg");

     }
    %>
	<table width="1098" border="0" align="center" bgcolor="#FFFFFF">
  <tr>
    <td width="1092" height="59" align="center"><div align="center"><span class="style1">AES – QUANTUM COMPUTER BRUTE FORCE ATTACK RESIST SYSTEM</span></div></td>
  </tr>
  <tr>
    <td><img  src="images/cloud-computing-banner1.jpg" width="1092" height="283"/></td>
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
    <td height="450" align="center"><table width="455" border="0" align="center">
  
      <tr>
        <td height="45"  bgcolor="#003366">  <div align="center" class="style4"><strong>FILE UPLOAD</strong></div></td>  
      </tr>
		  <tr>
        <td height="145"> <table width="404" border="0" align="center">  <% int index=0;
	try
	{
            

 System.out.println(a11);
		
		String url="jdbc:mysql://localhost:3306/Audit";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();
		ResultSet rs = st.executeQuery("select max(fid) from upload ");

    			
	 %>   <%
          if (rs.next()) {
				
				a111=Integer.parseInt(rs.getString(1));
                                a112=a111+1;
                                      a13=a112+"";
           %>   <%}else{
                  a112=1000;  
                  a13=a112+"";
           }
           %>
  <tr>
    <td width="129"><div align="left"><strong>File ID </strong></div></td>
    <td width="10">&nbsp;</td>
    <td width="251"><label>
            <div align="left">
     <input type="text" id="a1" name="a1"  style="width:180px" maxlength="25"class="displayValue" onKeyPress="return nospecialcharacters();" onChange="return val_zero('a1','err_a1');" 
                     onBlur="return txt_empty('a1','err_a1','Should Not Be Blank');" value="<%=a13%>" />
                    </div>
    </label></td>
  </tr><%
 
											
													}
	catch (Exception e) {
		out.println(e);
	}
	%>
  <tr>
    <td><div align="left"><strong>File Name </strong></div></td>
    <td>&nbsp;</td>
    <td><label>
            <div align="left">
              <input type="file" name="a2" value="">
                    </div>
    </label></td>
  </tr>
  <tr>
    <td><div align="left"><strong>File Key </strong></div></td>
    <td>&nbsp;</td>
    <td><label>
            <div align="left">
              <input type="text" id="a3" name="a3" style="width:180px"  maxlength="10" class="displayValue"  onKeyPress="return numbersonly();return nospecialcharacters();" onChange="return val_zero('a3','err_a3');" onBlur="return txt_empty('a3','err_a3','Should Not Be Blank');"/>
                    </div>
    </label></td>
  </tr>
    <tr>
    <td><div align="left"><strong>Type</strong></div></td>
    <td>&nbsp;</td>
    <td><label>
    <div align="left">
      <select name="a4">
        <option value="Select Type">Select Type</option>
        <option value="Private">Private</option>
        <option value="Public">Public</option>
        
      </select>
    </div>
    </label></td>
  </tr>
   <tr>
            <td><div align="left"><strong>Format</strong></div></td>
            <td>&nbsp;</td>
            <td><label>
            <div align="left">
              <select name="a5">
                <option value="Select">Select </option>
                <option value="pdf">pdf</option>
                <option value="doc">doc</option>
                 <option value="mpeg">mpeg</option>
                <option value="mp3">mp3</option>
              </select>
            </div>
            </label></td>
          </tr>
  <tr>
    <td><div align="left"></div></td>
    <td>&nbsp;</td>
    <td><div align="left"></div></td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td><label>
      <input type="submit" name="t1" value="Add">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="t2" value="Cancel">
    </label></td>
  </tr>
</table>  </td>   </tr>
    </table></td>
  </tr>
  <tr>
    <td height="54" bgcolor="#003366">&nbsp;</td>
  </tr>
</table>
</form>
      
    </body>
</html>


