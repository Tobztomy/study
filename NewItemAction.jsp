
<%--     
Document   : CATEGORY ACTION    
Created on : 03.14.2023
Author     : Bini
--%>


<%@page language="java" import="java.sql.*,java.util.*" %>
<%@page import="com.telious.beans.ItemBean" %>
<%@page import="com.telious.dao.ItemDAO" %>

<% 
	
	String itemName=request.getParameter("itemName"); // Step 1: getting values from UI page(NewItem.html)
	float itemPrice=Float.parseFloat(request.getParameter("itemPrice"));
	
	
	ItemBean itemBean=new ItemBean();// Step 2: Create a Item object (itemBean object)
	
	itemBean.setItemName(itemName); // Step 3:store values to item object
	itemBean.setItemPrice(itemPrice);
	
	Boolean flag=ItemDAO.insertItem(itemBean);//Step 4: insert object into table row(database)
	
	if(flag){
		response.sendRedirect("index.html");
	}else{
		response.sendRedirect("Error.jsp");
	}
%>