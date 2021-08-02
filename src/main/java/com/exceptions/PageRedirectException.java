package com.exceptions;

public class PageRedirectException extends AssertionError {

	public PageRedirectException() {
	}

	private PageRedirectException(String var1) {
		super(var1);
	}

	public PageRedirectException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public PageRedirectException(boolean var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(char var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(int var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(long var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(float var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(double var1) {
		this(String.valueOf(var1));
	}

	public PageRedirectException(String var1, Throwable var2) {
		super(var1, var2);
	}


}

