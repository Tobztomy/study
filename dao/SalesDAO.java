
package com.telious.dao;

import com.telious.beans.SalesBean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesDAO {
    static Connection con=null;
    static PreparedStatement pst=null,pst2=null,pst3=null,ps1=null,ps=null;
    static ResultSet rs=null;
    
     //------------------------START----------------------------------- 
    /**
    *
    * @author Bini
    * @Date 02.23.2023
    * @version 1.0
    * 
    */
        
   public static Connection dbConnection()throws SQLException{
     
		try{
                        DBDAO.connect();
                        con=DBDAO.getDbCon();
		   
                }
		catch(ClassNotFoundException  e){
			 System.out.println("class not found e:"+e.getMessage()) ; 
		   }
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return con;
	}
	

//------------------END-------------------------------------- 
    
 //------------------------START-----------------------------------   
   /**
   *
   * @author Bini
   * @Date 02.23.2023
   * @version 1.0
   * 
   */
    public static ArrayList<SalesBean> retrieveCustomer(SalesBean order)throws SQLException
    {
         ArrayList<SalesBean> orders=new ArrayList<SalesBean>();
         
         con=dbConnection();
         
         try{
            pst=con.prepareStatement("select cust_id,cust_name from customer");
            
            System.out.println("select cust_id,cust_name from customer");
                     
       
            rs=pst.executeQuery();                
            while(rs.next()){                
                 SalesBean customer=new SalesBean();
                 
                 customer.setCustId(rs.getInt(1));
                 customer.setCustName(rs.getString(2));
                 orders.add(customer);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
           finally{
    	  con.close();
      }
        System.out.println("hello-------------------------------------------");
        return orders;
         
    }
    //---------------------------END-------------------------------------
    
    
  //------------------------START-----------------------------------   
    /**
    *
    * @author Bini
    * @Date 02.23.2023
    * @version 1.0
    * 
    */
    public static ArrayList<SalesBean> retrieveItem(SalesBean order)throws SQLException
    {
         ArrayList<SalesBean> orders=new ArrayList<SalesBean>();
         
         con=dbConnection();
         
         try{
            pst=con.prepareStatement("select item_id,item_name,item_price from item");
            
            System.out.println("select item_id,item_name,item_price from item");
                     
       
            rs=pst.executeQuery();                
            while(rs.next()){                
                 SalesBean item=new SalesBean();
                 
                 item.setItemId(rs.getInt(1));
                 item.setItemName(rs.getString(2));
                 item.setItemPrice(rs.getFloat(3));
                 orders.add(item);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
           finally{
    	  con.close();
      }
        System.out.println("hello-------------------------------------------");
        return orders;
         
    }
    //---------------------------END-------------------------------------
    
    
    
    
    //--------------------------------START---------------------------------
    
    /**
    *
    * @author Bini
    * @Date 02.23.2023
    * @version 1.0
    * 
    */
    public static float getPrice(SalesBean order)throws SQLException{
         con=dbConnection(); 
          float price=0.0f;
          try{
                  pst=con.prepareStatement( "select item_price from item where item_id=?");
                  System.out.println("select item_price from item where item_id="+order.getItemId()+" ");
                  pst.setInt(1,order.getItemId());
                  rs=pst.executeQuery();
                  while(rs.next()){
                      price=rs.getFloat(1);
                  }
               }
	 catch(SQLException sqlexception){
	            sqlexception.printStackTrace();
	 }  
	 
	  
	return price; 
              
          }
 
  
   //-----------------------------END----------------------------------
    
  //---------------------------START-------------------------------------
    /**
    *
    * @author Bini
    * @Date 02.23.2023
    * @version 1.0
    * 
    */
     public static boolean insertOrder(SalesBean order)throws SQLException
     {
         boolean flag=false; 
         con=dbConnection(); 
        
         try
         {
              pst=con.prepareStatement("insert into sales(cust_id,item_id,sa_date,quantity,total)values(?,?,?,?,?)");
              
              System.out.println("insert into sales(cust_id,item_id,sa_date,quantity,total)values(?,?,?,?,?)");
              
              pst.setInt(1,order.getCustId());              
              pst.setInt(2,order.getItemId());              
              pst.setString(3,order.getSalesDate());
              pst.setInt(4,order.getQuantity());              
              pst.setFloat(5,order.getTotal());
              
              pst.executeUpdate();             
                
              flag=true;
              
         }
         catch(Exception e){
             e.printStackTrace();
         }
         finally
         {
             con.close();
         }
         return flag;
     }
   // --------------------------------END-----------------------------------------------------
     
   
       
       
      
      //--------------------------------START---------------------------------
     /**
     *
     * @author Bini
     * @Date 02.23.2023
     * @version 1.0
     * 
     */     
       public static ArrayList<SalesBean> getAllOrderDetails(SalesBean orders)throws SQLException{
		ArrayList<SalesBean> order=new ArrayList<SalesBean>();
              
		con=dbConnection();
			    	            
		try{
			
         pst=con.prepareStatement("SELECT s.sa_id,s.cust_id,(SELECT cust_name FROM customer s where s.cust_id=c.cust_id) as cust_name,"
         		+ "s.item_id,(SELECT item_name FROM item i where s.item_id=i.item_id) as item_name,"
         		+ "(SELECT item_price FROM item i where s.item_id=i.item_id) as item_price,"
         		+ "s.sa_date,s.quantity,s.total from customer c,sales s, Item i WHERE s.cust_id =c.cust_id and "
         		+ "s.item_id=i.item_id order by s.sa_id desc");
			  	                        
		System.out.println("SELECT s.sa_id,s.cust_id,(SELECT cust_name FROM customer s where s.cust_id=c.cust_id) as cust_name,"
         		+ "s.item_id,(SELECT item_name FROM item i where s.item_id=i.item_id) as item_name,"
         		+ "(SELECT item_price FROM item i where s.item_id=i.item_id) as item_price,"
         		+ "s.sa_date,s.quantity,s.total from customer c,sales s, Item i WHERE s.cust_id =c.cust_id and "
         		+ "s.item_id=i.item_id order by s.sa_id desc");
               
			    rs=pst.executeQuery();                
			    while(rs.next()){                
			    	   SalesBean invoice=new SalesBean();
			    	   
			    	   invoice.setSalesId(rs.getInt(1));
			    	   invoice.setCustId(rs.getInt(2));
			    	   invoice.setCustName(rs.getString(3));
			    	   invoice.setItemId(rs.getInt(4));
			    	   invoice.setItemName(rs.getString(5));
			    	   invoice.setItemPrice(rs.getFloat(6));
			    	   invoice.setSalesDate(rs.getString(7));
			    	   invoice.setQuantity(rs.getInt(8));
			    	   invoice.setTotal(rs.getFloat(9));
			    	  
			    	   order.add(invoice);
			   }
			}catch(SQLException e){
			    	e.printStackTrace();
			 }finally{
			    	con.close();
			 }
			    	       
			  return order;
			    	            
 }
             //--------------------------------END---------------------------------
         
     
           
     }  