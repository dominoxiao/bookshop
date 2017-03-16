package com.icss.bk.control;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bk.biz.BookBiz;
import com.icss.bk.entity.TBook;

public class BookAddSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookAddSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String isbn = request.getParameter("isbn");
		String bname = request.getParameter("bname");
		String author = request.getParameter("author");
		String press = request.getParameter("press");
		String price = request.getParameter("price");
		String pdate = request.getParameter("pdate");
		String picurl = request.getParameter("picurl");
		if(isbn != null && !isbn.trim().equals("")){
			if(bname !=null && !bname.trim().equals("")){
				BookBiz biz = new BookBiz();
				TBook book = new TBook();
				book.setIsbn(isbn);
				book.setAuthor(author);
				book.setBname(bname);
				book.setKcount(0);				
				book.setPicurl(picurl);
				book.setPress(press);
				try {
					double dprice = Double.parseDouble(price);   //把字符型的价格转换成double类型
					book.setPrice(dprice);	
				} catch (Exception e) {
					book.setPrice(0);
				}	
				try {
					SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
					Date ddate = sd.parse(pdate);				
					book.setPdate(ddate);                           //把字符型的日期，转换成Date类型	
				} catch (Exception e) {
					book.setPdate(null);
				}
				try {
					biz.addBook(book);	
					request.setAttribute("msg",bname + "--录入成功");
					request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
				} catch(SQLIntegrityConstraintViolationException e){
					request.setAttribute("msg","ISBN已经存在，请重新输入");
					request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("msg","网络异常，请和管理员联系");
					request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
				}				
			}else{
				request.setAttribute("msg","书名不能为空");
				request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
			}
			
		}else{
			request.setAttribute("msg","isbn不能为空");
			request.getRequestDispatcher("/back/BookAdd.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
