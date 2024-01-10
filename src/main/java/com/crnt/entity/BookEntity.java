package com.crnt.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BookEntity")
public class BookEntity {
	private String bookName;
	private String author;
	public String getBookName() {
		return bookName;
	}
	public BookEntity(String bookName, String author) {
		super();
		this.bookName = bookName;
		this.author = author;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
