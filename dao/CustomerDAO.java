
package com.telious.dao;

import com.telious.beans.CustomerBean;




import java.sql.*;
import java.util.ArrayList;



public class CustomerDAO {
    
    static Connection con=null;
    static PreparedStatement pst=null;
    static ResultSet rs;
    
  //------------------------START----------------------------------- 
 /**
 *
 * @author bini
 * @date : 02.23.2023
 * @version : 1.0
 * @purpose :Establish a new Database connection
 * @param :

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
    
    
   public static boolean insertCustomer( CustomerBean customerBean)throws SQLException{//Step 6:  function here
       boolean flag=false; 
       con=dbConnection(); 
     
        try{
            pst=con.prepareStatement("insert into Customer(cust_name,cust_address)values(?,?)");
            
            System.out.println("insert into Customer(cust_name,cust_address)values(?,?)");
                     
        
		//Step 10: setting getter values to corresponding query
            pst.setString(1,customerBean.getCustName());//Step 7: calling getter() from getter/setter class
                //Step 10: setting getter values to corresponding 
            
            pst.setString(2,customerBean.getCustAddress());
          
            
            
            System.out.println("am here --------get  value---------"+customerBean.getCustName());
         
           pst.executeUpdate();
                flag=true;
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{ 
                    con.close();
                }
    
        return flag;
 } 
 //------------------------------------------END----------------------------------------
   
 //----------------------------------------------------------------------------------------
   
   /**
   *
   * @author Bini
   * @Date 02.23.2023
   * @version 1.0
   * 
   */
   
    public static ArrayList<CustomerBean> listCustomer()throws SQLException{
         ArrayList<CustomerBean> customers=new ArrayList<CustomerBean>();
          
         con=dbConnection();
         
          try{
            pst=con.prepareStatement("select * from Customer");
            
            System.out.println("select * from Customer");
                     
       
            rs=pst.executeQuery();                
            while(rs.next()){                
                 CustomerBean customer=new CustomerBean();
                 customer.setCustId(rs.getInt(1));                
                 customer.setCustName(rs.getString(2));
                 customer.setCustAddress(rs.getString(3));
                
                 customers.add(customer);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
           finally{
    	  con.close();
      }
    
        return customers;
         
    }
    //---------------------------------------------------------------------------------------------
    
    /**
    *
    * @author Bini
    * @Date 02.23.2023
    * @version 1.0
    * 
    */
    
    public static ArrayList<CustomerBean> getCustomerDetails(CustomerBean customerBean)throws SQLException {
    	//Step 6:  function here
        ArrayList<CustomerBean> customers=new ArrayList<CustomerBean>();
       
       con=dbConnection(); 
        
     
        try{
            pst=con.prepareStatement("select * from Customer where cust_id=?");
            pst.setInt(1,customerBean.getCustId());
            rs=pst.executeQuery();                
            while(rs.next()){                
                 CustomerBean cu=new CustomerBean();
                 cu.setCustId(rs.getInt(1));               
                 cu.setCustName(rs.getString(2));
                 cu.setCustAddress(rs.getString(3));		
                 customers.add(cu);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
         finally{
    	  con.close();
      }
    
        return customers;
 }
  
}
