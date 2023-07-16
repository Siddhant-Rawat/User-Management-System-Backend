package com.siddhant.fullstackbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserNotFoundAdvice {

//	@ExceptionHandler(UserNotFoundException.class) -> if you find this
//	UserNotFoundException.class in controller,
//	then send a request to this handler

	@ResponseBody
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> exceptionHandler(UserNotFoundException exception) {

		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("error", exception.getMessage());

		return errorMap;
	}
}
