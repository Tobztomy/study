
package com.telious.dao;

import java.sql.*;
import java.io.*; // for Serializable interface


/**
*
* @author Bini
* @Date 02.23.2023
* @version 1.0
* 
*/

public class DBDAO implements Serializable{ //Serialization, in broad terms, is the way Java provides developers to persist the state of any object to a persistent store.
                                                
	private static final long serialVersionUID = 1L;
		//If a developer wants that for some reason instance of his coded class should be persisted to a backing store, then the class needs to be declared as implementing Serializable.
    private  static Connection dbCon;  
	private  static String dbURL;
	private  static  String dbDriver; 
	private  static String userName;
	private  static  String passWord;
    
    //-------------------------------------------------------------------------	
	public DBDAO(){  	    
		 super();   	       
        }
 //-----------------------------------------------------------------------
        private static  void  dbInit(){
		   
	    try{
                    dbDriver="com.mysql.cj.jdbc.Driver";	  
                    dbURL="jdbc:mysql://localhost:3306/telious";
                    userName="root";	
                   //userName="bini";
                    passWord="mysql"; 
                 // passWord="bini";
	    }
	     catch (Exception e){	    	
	    	e.printStackTrace();
	    }
	  
	}
//-----------------------------------------------------------------------
	public  static void connect() throws ClassNotFoundException,SQLException { 
	          dbInit();
	          Class.forName(dbDriver); 
	          dbCon = DriverManager.getConnection(dbURL,userName,passWord); 
	          setDbCon(dbCon);	    
        }
//------------------------------------------------------------

	public static Connection getDbCon(){
		return dbCon;
	}
	
	public static void setDbCon(Connection con){
		dbCon=con;
	}
	public static void close() throws SQLException{ 
	        dbCon.close(); 
	}
	
	//-------------------------------------------------------------------
    
}
