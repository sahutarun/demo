package com.exceptions;

public class PageHeadingException extends AssertionError {

	public PageHeadingException() {
	}

	private PageHeadingException(String var1) {
		super(var1);
	}

	public PageHeadingException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public PageHeadingException(boolean var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(char var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(int var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(long var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(float var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(double var1) {
		this(String.valueOf(var1));
	}

	public PageHeadingException(String var1, Throwable var2) {
		super(var1, var2);
	}


}
