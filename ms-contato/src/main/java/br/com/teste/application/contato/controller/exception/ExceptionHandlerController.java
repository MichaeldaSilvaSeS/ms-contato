package br.com.teste.application.contato.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> excecao(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
