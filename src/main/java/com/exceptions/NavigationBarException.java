package com.exceptions;

public class NavigationBarException extends AssertionError {

	public NavigationBarException() {
	}

	private NavigationBarException(String var1) {
		super(var1);
	}

	public NavigationBarException(Object var1) {
		this(String.valueOf(var1));
		if (var1 instanceof Throwable) {
			this.initCause((Throwable)var1);
		}

	}

	public NavigationBarException(boolean var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(char var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(int var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(long var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(float var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(double var1) {
		this(String.valueOf(var1));
	}

	public NavigationBarException(String var1, Throwable var2) {
		super(var1, var2);
	}


}
