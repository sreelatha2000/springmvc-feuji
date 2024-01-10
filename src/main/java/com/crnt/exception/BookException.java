package com.crnt.exception;


public class BookException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public BookException(String message) {
		 
		 super(message);
		
	}
	 
	 public BookException(String message, Exception exception) {
			super(message, exception);
		}
	
	

}
