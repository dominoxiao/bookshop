package com.icss.bk.biz;

import java.sql.SQLIntegrityConstraintViolationException;

import com.icss.bk.dao.BookDao;
import com.icss.bk.entity.TBook;

public class BookBiz {
	
	/**
	 * ÃÌº”Õº È
	 * @param book
	 * @return
	 */
	public void addBook(TBook book) throws SQLIntegrityConstraintViolationException,Exception{		
		if(book != null){
			BookDao dao = new BookDao();
			dao.addBook(book);		
		}			
	}
	
	

}
