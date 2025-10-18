
<%--     
Document   : CATEGORY ACTION    
Created on : 03.14.2023
Author     : Bini
--%>


<%@page language="java" import="java.sql.*,java.util.*" %>
<%@page import="com.telious.beans.CustomerBean" %>
<%@page import="com.telious.dao.CustomerDAO" %>

<% 
	
	String custName=request.getParameter("custName"); // Step 1: getting values from UI page(NewCustomer.html)
	String custAddress=request.getParameter("custAddress");
	
	
	CustomerBean customerBean=new CustomerBean();// Step 2: Create a Customer object (customerBean object)
	
	customerBean.setCustName(custName); // Step 3:store values to customer object
	customerBean.setCustAddress(custAddress);
	
	Boolean flag=CustomerDAO.insertCustomer(customerBean);//Step 4: insert object into table row(database)
	
	if(flag){
		response.sendRedirect("index.html");
	}else{
		response.sendRedirect("Error.jsp");
	}
%>