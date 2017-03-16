package com.icss.bk.entity;

import java.util.Date;

public class TBook {
	private String isbn;
	private String bname;
	private String author;
	private String press;
	private Date pdate;                   //此处必须为java.util.Date
	private double price;
	private int kcount;
	private String picurl;
	
	
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getKcount() {
		return kcount;
	}
	public void setKcount(int kcount) {
		this.kcount = kcount;
	}	

}
