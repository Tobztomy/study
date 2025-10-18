<%@page language="java" import="java.sql.*,java.util.*" %>
<%@page import="com.telious.beans.CustomerBean" %>
<%@page import="com.telious.dao.CustomerDAO" %>
<%@page import="com.telious.beans.ItemBean" %>
<%@page import="com.telious.dao.ItemDAO" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>:: Sales Form ::</title>
</head>
<body>
<form id="salesform" name="salesform" method="post" action="SaleEntryAction.jsp">

<table border="1">
  
 <tr>
    <td>Date</td>
    <td>
       <input name="odate" type="text" />  
    </td>
  </tr>
 
 
<tr>
   <td>Customer </td>   
      <td><select name="custname" id="custname">
       <option>--SELECT ONE--</option>
             <%
             
           ArrayList<CustomerBean> customer = CustomerDAO.listCustomer();
         
                        
   			for(CustomerBean cust : customer){
				
				String custIdName=cust.getCustId()+"-"+cust.getCustName();
                              
                               
             %>   
             
          
             <option><%=custIdName%></option>
             <%}%>
             </select>
            </td>
  </tr>
  
  
  
  
   <tr>
   <td>Item </td>
    
      <td><select name="itemname" id="itemname">
       <option>--SELECT ONE--</option>
             <%
             
           ArrayList<ItemBean> item = ItemDAO.listItems();
         
                        
   			for(ItemBean items : item){
				
				String itemIdName=items.getItemId()+"-"+items.getItemName();
                              
                               
             %>   
             
          
             <option><%=itemIdName%></option>
             <%}%>
             </select>
            </td>
  </tr>
  
 <tr>
    <td>Quantity</td>
    <td>     
      <input name="qty" type="text"/>
    </td>
  </tr>
  
 
   <tr>
    <td>&nbsp;</td>
    <td>
      <input type="submit" value="Submit"/>
    </td>
  </tr>
 
  
  
  </table>

</form>
</body>
</html>