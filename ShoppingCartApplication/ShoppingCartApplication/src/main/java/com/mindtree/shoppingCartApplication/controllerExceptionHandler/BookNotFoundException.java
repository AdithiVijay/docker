package com.mindtree.shoppingCartApplication.controllerExceptionHandler;

import com.mindtree.shoppingCartApplication.exception.ApplicationException;

public class BookNotFoundException extends ApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
