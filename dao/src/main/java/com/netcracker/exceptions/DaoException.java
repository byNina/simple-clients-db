/**
 * 
 */
package com.netcracker.exceptions;

/**
 * @author Shevchenko,2016
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public DaoException() {
		super();
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

}
