package com.crnt.service;

import java.util.List;

import com.crnt.beans.Book;
import com.crnt.exception.BookException;

public interface BookService {
	void save(Book book);
	List<Book> getAll() throws BookException;

}
