package com.project.common.exception;

public class NotEnoughCoinException extends Exception {
  
	private static final long serialversionUID = 1L;
	
	public NotEnoughCoinException(String msg) {
		super(msg);
	}
}
