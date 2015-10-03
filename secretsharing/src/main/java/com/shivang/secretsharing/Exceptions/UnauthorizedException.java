package com.shivang.secretsharing.Exceptions;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		// TODO Auto-generated constructor stub
	}

	public UnauthorizedException(String arg0) {
		//super(arg0);
		System.out.println(arg0+" is unauthorized to access this Secret");
	}

}
