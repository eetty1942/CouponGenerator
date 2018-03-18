package com.coupon.exception;


import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class ControllerExceptionHandler {
/*	private static final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	@ExceptionHandler(value = UnAuthorizedException.class)
	public ModelAndView handleUnAutorizedException(UnAuthorizedException e) {
		return new ModelAndView("UnAutorrizedPage.jsp");
	}*/
}