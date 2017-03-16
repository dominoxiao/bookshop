package com.icss.bk.biz;

import com.icss.bk.dao.UserDao;
import com.icss.bk.entity.User;

public class UserBiz {
	
	/**
	 * �û�ע��
	 * @param user
	 * @return
	 */
	public boolean regist(User user){
		boolean bRet = false;
		
		if(user != null){
			UserDao dao = new UserDao();
			bRet = dao.regist(user);
		}
		
		return bRet;
	}
	
	
	/**
	 * �û���¼
	 * @param uname  �û���
	 * @param pwd    ����
	 * @return       ���ص�¼�ɹ����û���Ϣ
	 */
	public User login(String uname,String pwd) throws Exception{
		User user = null;
		
		if(uname != null && pwd != null && !uname.equals("") && !pwd.equals("") ){
			UserDao dao = new UserDao();
			user = dao.login(uname, pwd);			
		}
		
		return user;
	}


}
