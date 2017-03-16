package com.icss.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.icss.bk.entity.TBook;

public class BookDao extends BaseDao{
	
	
	
	/**
	 * 添加图书
	 * @param book
	 * @return
	 */
public void addBook222(TBook book) throws SQLIntegrityConstraintViolationException,Exception{
		
		Connection conn = null;		
		
	  
    	//打开数据库
    	this.openConnection();
    	
    	//添加图书
    	String sql = "insert into tbook(isbn,bname) values('" + book.getIsbn() + "','" + book.getBname() + "')";  	
    	Statement st = conn.createStatement();
    	st.executeUpdate(sql);
    	
    	this.closeConnection();	
		
	}


	public void addBook(TBook book) throws SQLIntegrityConstraintViolationException,Exception{		
	  
    	//打开数据库
    	this.openConnection();
    	
    	//添加图书
    	String sql = "insert into tbook values(?,?,?,?,?,?,?,?)";
    	PreparedStatement ps = conn.prepareStatement(sql);
    	ps.setString(1, book.getIsbn());
    	ps.setString(2, book.getBname());
    	ps.setString(3, book.getAuthor());
    	ps.setString(4, book.getPress());
    	long now = book.getPdate().getTime();
    	ps.setDate(5, new java.sql.Date(now) );    //此处需要从java.util.Data转换成java.sql.Date
    	ps.setDouble(6, book.getPrice());
    	ps.setInt(7, book.getKcount());
    	ps.setString(8, book.getPicurl());
    	ps.executeUpdate();	   
    	
    	this.closeConnection();	
		
	}

}
