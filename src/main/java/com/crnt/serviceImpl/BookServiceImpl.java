package com.crnt.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.stereotype.Service;

import com.crnt.beans.Book;
import com.crnt.entity.BookEntity;
import com.crnt.exception.BookException;
import com.crnt.repository.BookRepository;
import com.crnt.service.BookService;

import ch.qos.logback.classic.Logger;


@Service
public class BookServiceImpl implements BookService{
	public static org.slf4j.Logger log= org.slf4j.LoggerFactory.getLogger(BookServiceImpl.class.getSimpleName());
	
	private BookRepository bookRepository;

	@Override
	public void save(Book book) {
		
		BookEntity entity = new BookEntity();
		entity.setAuthor(book.getAuthor());
		entity.setBookName(book.getBookName());
		bookRepository.save(entity);
		log.info("book saved : "+book);
		
		
		
	}

	@Override
	public List<Book> getAll() throws BookException {
		List<Book> book = new ArrayList<>();
		try {
			List<BookEntity> bookEntities = bookRepository.getAll();
			convert(bookEntities, book);
		}
		catch (Exception e) {
			throw new BookException("Not able to fetch records");
		}
		return book;
	}

	private void convert(List<BookEntity> bookEntities, List<Book> book) {
		// TODO Auto-generated method stub
		
	}

}
