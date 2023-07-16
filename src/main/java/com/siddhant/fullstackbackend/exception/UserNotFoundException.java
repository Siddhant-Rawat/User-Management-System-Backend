package com.siddhant.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Long id) {
		super("Cannot find user with id " + id);
	}
}
