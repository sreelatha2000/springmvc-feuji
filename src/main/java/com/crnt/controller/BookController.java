package com.crnt.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crnt.beans.Book;
import com.crnt.controller.*;
@Controller
public class BookController {

	private static Logger log = (Logger) LoggerFactory
			.getLogger(BookController.class.getSimpleName());

	@RequestMapping(path = "/pages", method = RequestMethod.GET)
	public ModelAndView book() {
		Map map = new HashMap();
		map.put("headerName", "Book");

		return new ModelAndView("pages", "page", new Book()).addAllObjects(map);
	}
	@RequestMapping(path = "/pages", method = RequestMethod.POST)
	public ModelAndView createBook(@ModelAttribute Book book) {
		
		
		log.info(book.toString());
		System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		return new ModelAndView("pages", "page", book);
		
	}
}
