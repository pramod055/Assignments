package com.nagarro.billCalculator.exceptions;

public class InputException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public InputException(String msg)
	{
		super(msg);
	}
}
