package com.exceptions;

public class BrowseBySectorException extends AssertionError {

	public BrowseBySectorException() {
	}

	private BrowseBySectorException(String var1) {
		super(var1);
	}

	public BrowseBySectorException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public BrowseBySectorException(boolean var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(char var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(int var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(long var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(float var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(double var1) {
		this(String.valueOf(var1));
	}

	public BrowseBySectorException(String var1, Throwable var2) {
		super(var1, var2);
	}


}
