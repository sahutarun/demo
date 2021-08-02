package com.exceptions;

public class SearchException extends AssertionError {

	public SearchException() {
	}

	private SearchException(String var1) {
		super(var1);
	}

	public SearchException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public SearchException(boolean var1) {
		this(String.valueOf(var1));
	}

	public SearchException(char var1) {
		this(String.valueOf(var1));
	}

	public SearchException(int var1) {
		this(String.valueOf(var1));
	}

	public SearchException(long var1) {
		this(String.valueOf(var1));
	}

	public SearchException(float var1) {
		this(String.valueOf(var1));
	}

	public SearchException(double var1) {
		this(String.valueOf(var1));
	}

	public SearchException(String var1, Throwable var2) {
		super(var1, var2);
	}


}
