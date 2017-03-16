package com.icss.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.bk.biz.IRole;
import com.icss.bk.entity.User;

public class UserDao extends BaseDao {
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public boolean regist(User user){	
		
		Connection conn = null;
	    try {
	    	//打开数据库
	    	this.openConnection();
	        	
	    	//创建PreparedStatement对象
	    	String sql = "insert into  tuser values(?,?,?,?)";
	    	PreparedStatement ps = conn.prepareStatement(sql);
	    	ps.setString(1, user.getUname());
	    	ps.setString(2, user.getPwd());
	    	ps.setInt(3,user.getRole());
	    	ps.setString(4, user.getAddress());
	    	ps.executeUpdate(); 	    	
	    	
	    	this.closeConnection();
	    	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	 
			
		return true;
	}
	
	
	/**
	 * 用户登录
	 * @param uname  用户名
	 * @param pwd    密码
	 * @return       返回登录成功的用户信息
	 */
	public User login(String uname,String pwd) throws Exception{
		User user = null;
		
		//打开数据库
		this.openConnection();
		
		String sql = "select * from tuser where uname=? and pwd=?";
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				user = new User();     //能够进入while循环，说明查询条件找到了满足的结果集
				user.setUname(uname);
				user.setPwd(pwd);
				user.setRole(rs.getInt("role"));     //按照字段名提取改行记录该字段的值
				user.setAddress(rs.getString("addr"));
			}			
		}
		
		//关闭数据库
		this.closeConnection();
		
		return user;
	}

}
