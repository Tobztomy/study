
<%@page import="java.util.ArrayList"%>
<%@page import="com.telious.beans.SalesBean"%>
<%@page import="com.telious.dao.SalesDAO"%>






<h1>SALES</h1>

  <table border="1">
<tr>
	<th>Sl.No</th>
	<th>Order No</th>
	<th>Order Date</th>
	<th>Customer ID</th>	
	<th>Customer Name</th>
    <th>Item ID</th>
    <th>Item Name</th>      
    <th>Quantity</th>
    <th>Item Price</th>  
    <th>Total Price</th>      
	
	
	
</tr>

  
	<%
			int i=1;
			SalesBean order=new SalesBean();
	  		
			ArrayList<SalesBean> sale=SalesDAO.getAllOrderDetails(order);
			for(SalesBean o : sale){
                    
						
	  
	  %>

   <tr>
	<td><%=i%></td>
	<td><%=o.getSalesId()%></td>
	<td><%=o.getSalesDate()%></td>
	<td><%=o.getCustId()%></td>
	<td><%=o.getCustName()%></td>
	<td><%=o.getItemId()%></td>
	<td><%=o.getItemName()%></td>	
	<td><%=o.getQuantity()%></td>	
	<td><%=o.getItemPrice()%></td>
    <td><%=o.getTotal()%></td>  
	</tr>
	
	
<%
i++;
}
%>

</table>




</body>
</html>