<%-- 
    Document   : add sales/order
    Created on : 2.28.2023
    Author     : BINI
--%>


<%@page language="java" import="java.sql.*,java.util.*" %>
<%@page import="com.telious.beans.SalesBean"%> <%-- Step 1: import package getter/setter class--%>
<%@page import="com.telious.dao.SalesDAO"%>  <%-- Step 1: import package  business() class--%>

<%

SalesBean sale=new SalesBean();// Step 2 : Create object of the class

String odate=request.getParameter("odate");

String cid=request.getParameter("custname");
System.out.println("cid with name----------------------"+cid);

// StringTokenizer st=new StringTokenizer(id);

//cid=Integer.parseInt(st.nextToken("-"));
// System.out.println("tokenizer----------------------"+st.nextToken("-"));
String[] custIdName=cid.split("-");
int cuid=Integer.parseInt(custIdName[0]);
System.out.println("tokenizer---------customer id-------------"+cuid); 



String iid=request.getParameter("itemname");
System.out.println("iid with name----------------------"+iid);


String[] itemIdName=iid.split("-");
int itemid=Integer.parseInt(itemIdName[0]);
System.out.println("tokenizer-----------item id-----------"+itemid); 


int qty=Integer.parseInt(request.getParameter("qty").trim());





System.out.println("======action page===odate====="+odate);
System.out.println("======action page===qty====="+qty);



sale.setCustId(cuid);
sale.setItemId(itemid);
sale.setSalesDate(odate);
sale.setQuantity(qty);

float total=0.0f;
float itemPrice=SalesDAO.getPrice(sale);

	System.out.println("======action page==itemPrice======"+itemPrice);	
	
	total=qty*itemPrice;
	
	System.out.println("======action page==total======"+total);	             


sale.setTotal(total);

//Step 3: setting values from jsp to setter/getter class
//Step 3: setting values from jsp to setter/getter class


	boolean inFlag=SalesDAO.insertOrder(sale);
    if(inFlag){
        
         response.sendRedirect("index.html");  
    }
    else{
         response.sendRedirect("Error.jsp");  
    }




%>

