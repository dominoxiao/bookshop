package com.icss.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {
	
	protected Connection conn;                  //��Ա����
	
	public void openConnection() throws Exception{
		
		if(this.conn == null || this.conn.isClosed()){
			Class.forName("oracle.jdbc.driver.OracleDriver");            //�÷��似������̬�������ݿ������������Ҫnew��	
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
