package com.icss.bk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icss.bk.biz.IRole;
import com.icss.bk.entity.User;

public class UserDao extends BaseDao {
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public boolean regist(User user){	
		
		Connection conn = null;
	    try {
	    	//�����ݿ�
	    	this.openConnection();
	        	
	    	//����PreparedStatement����
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
	 * �û���¼
	 * @param uname  �û���
	 * @param pwd    ����
	 * @return       ���ص�¼�ɹ����û���Ϣ
	 */
	public User login(String uname,String pwd) throws Exception{
		User user = null;
		
		//�����ݿ�
		this.openConnection();
		
		String sql = "select * from tuser where uname=? and pwd=?";
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		if(rs != null){
			while(rs.next()){
				user = new User();     //�ܹ�����whileѭ����˵����ѯ�����ҵ�������Ľ����
				user.setUname(uname);
				user.setPwd(pwd);
				user.setRole(rs.getInt("role"));     //�����ֶ�����ȡ���м�¼���ֶε�ֵ
				user.setAddress(rs.getString("addr"));
			}			
		}
		
		//�ر����ݿ�
		this.closeConnection();
		
		return user;
	}

}
