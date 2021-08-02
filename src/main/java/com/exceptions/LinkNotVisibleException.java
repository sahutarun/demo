package com.exceptions;

public class LinkNotVisibleException extends AssertionError {

	public LinkNotVisibleException() {
	}

	private LinkNotVisibleException(String var1) {
		super(var1);
	}

	public LinkNotVisibleException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public LinkNotVisibleException(boolean var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(char var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(int var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(long var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(float var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(double var1) {
		this(String.valueOf(var1));
	}

	public LinkNotVisibleException(String var1, Throwable var2) {
		super(var1, var2);
	}


}

