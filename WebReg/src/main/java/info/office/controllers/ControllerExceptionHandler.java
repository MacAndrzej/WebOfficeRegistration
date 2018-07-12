package info.office.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import info.office.exception.IdNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	final static Logger logger = Logger.getLogger(ControllerExceptionHandler.class);
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public ModelAndView handleNotFound(Exception exception) {
		logger.error("Handling not found exception");
		logger.error(exception.getMessage());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("404error");
		modelAndView.addObject("exception",exception);
		return modelAndView;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(NumberFormatException.class)
	public ModelAndView handleNumberFormat(Exception exception) {
		logger.error("Handling not found exception");
		logger.error(exception.getMessage());
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("400error");
		modelAndView.addObject("exception",exception);
		return modelAndView;
	}
	
}
