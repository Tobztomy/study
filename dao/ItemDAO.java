
package com.telious.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.telious.beans.ItemBean;
import com.telious.dao.ItemDAO;



public class ItemDAO {
    
   static Connection con=null;
   static PreparedStatement pst=null;
   static ResultSet rs;
   static ArrayList<ItemBean> al;
 
      
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
    
    
   public static boolean getItem( ItemBean item)throws SQLException{//Step 6:  function here
       boolean flag=false; 
       con=dbConnection(); 
     
        try{
            pst=con.prepareStatement("select * from item" 
                    + " where item_name=? and item_price=?");
            
            System.out.println("select * from item" 
                    + " where item_name=? and item_price=?");
                     
            pst.setString(1,item.getItemName());//Step 7: calling getter() from getter/setter class
		//Step 10: setting getter values to corresponding query
            pst.setFloat(2,item.getItemPrice());//Step 7: calling getter() from getter/setter class
                //Step 10: setting getter values to corresponding   
            System.out.println("am here --------get  value---------"+item.getItemName());
            System.out.println("am here --------get  value---------"+item.getItemPrice()); 
            rs=pst.executeQuery();                
            while(rs.next()){
                
                flag=true;
            }
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
    
    
   
  //------------------------START-----------------------------------   
   /**
   *
   * @author Bini
   * @Date 02.23.2023
   * @version 1.0
   * 
   */
    
    
   public static boolean insertItem( ItemBean item)throws SQLException{//Step 6:  function here
       boolean flag=false; 
       con=dbConnection(); 
     
        try{
            pst=con.prepareStatement("insert into item(item_name,item_price)values(?,?)");
            
            System.out.println("insert into item(item_name,item_price)values(?,?)");
                     
            pst.setString(1,item.getItemName());//Step 7: calling getter() from getter/setter class
		//Step 10: setting getter values to corresponding query
            pst.setFloat(2,item.getItemPrice());//Step 7: calling getter() from getter/setter class
                //Step 10: setting getter values to corresponding   
            System.out.println("am here --------get  value---------"+item.getItemName());
            System.out.println("am here --------get  value---------"+item.getItemPrice()); 
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
     
   
   //-----------------------------------START--------------------------------------
   /**
   *
   * @author Bini
   * @Date 02.23.2023
   * @version 1.0
   * 
   */
    
   public static ArrayList<ItemBean> listItems()throws SQLException{//Step 6:  function here
        ArrayList<ItemBean> items=new ArrayList<ItemBean>();
       
       con=dbConnection(); 
        
     
        try{
            pst=con.prepareStatement("select * from item");
            
            System.out.println("select * from item");
                     
       
            rs=pst.executeQuery();                
            while(rs.next()){                
                 ItemBean it=new ItemBean();
                 it.setItemId(rs.getInt(1));
                 it.setItemName(rs.getString(2));
                 it.setItemPrice(rs.getFloat(3));
                 items.add(it);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
         finally{
    	  con.close();
      }
    
        return items;
 } 
 //------------------------------------------END---------------------------------------- 
    
   //-----------------------------------START--------------------------------------
   /**
   *
   * @author Bini
   * @Date 02.23.2023
   * @version 1.0
   * 
   */
    
   public static ArrayList<ItemBean>  getItemDetails(ItemBean ite)throws SQLException{//Step 6:  function here
        ArrayList<ItemBean> items=new ArrayList<ItemBean>();
       
       con=dbConnection(); 
        
     
        try{
            pst=con.prepareStatement("select * from item where item_id=?");
            pst.setInt(1,ite.getItemId());
            rs=pst.executeQuery();                
            while(rs.next()){                
                 ItemBean it=new ItemBean();
                 it.setItemId(rs.getInt(1));
                 it.setItemName(rs.getString(2));
                 it.setItemPrice(rs.getFloat(3));
                 items.add(it);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
         finally{
    	  con.close();
      }
    
        return items;
 } 
 //------------------------------------------END---------------------------------------- 
    
    
     
   
   
}
