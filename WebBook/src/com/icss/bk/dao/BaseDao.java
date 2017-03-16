package com.icss.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	
	protected Connection conn;                  //成员变量
	
	public void openConnection() throws Exception{
		
		if(this.conn == null || this.conn.isClosed()){
			Class.forName("oracle.jdbc.driver.OracleDriver");            //用反射技术，动态加载数据库的驱动（不需要new）	
	    	conn = DriverManager.getConnection("jdbc:oracle:thin:@10.0.17.252:1521:orcl","nmz8","123456");
		}		
	}
	
	
	public void closeConnection(){		
		if(this.conn != null){
			try {
				this.conn.close();	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}

}
