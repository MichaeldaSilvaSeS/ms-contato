package br.com.teste.application.contato.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.teste.application.contato.dto.saida.CampoErroDto;
import br.com.teste.application.contato.dto.saida.ErroSaidaDto;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler{

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<?> excecao(){
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<CampoErroDto> campos = new ArrayList<CampoErroDto>();
		
		BindingResult bindingResult = ex.getBindingResult();
		
	    for (FieldError erros : bindingResult.getFieldErrors()) {
	    	campos.add(CampoErroDto
	    				.builder()
	    					.campo(erros.getField())
	    				.build()
	    			);
	    }
	    
		ErroSaidaDto erro = ErroSaidaDto
				.builder()
					.codigoDoErro(1)
					.mensagem("campos invalidos")
					.campoErroDto(campos)
				.build();
		
		return new ResponseEntity<Object>(erro,HttpStatus.BAD_REQUEST);
	}
	/*
	@ResponseStatus(value=HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ConstraintViolationException.class,ConstraintViolationException.class,DataIntegrityViolationException.class})
	public ResponseEntity<ErroSaidaDto> excecaoValidadao(ConstraintViolationException e){
		List<CampoErroDto> campos = new ArrayList<CampoErroDto>();
		
	    for (ConstraintViolation<?> violation : e.getConstraintViolations()) 
	    	campos.add(CampoErroDto
	    				.builder()
	    					.campo(violation.getPropertyPath().toString())
	    				.build()
	    			);
	    	    
		ErroSaidaDto erro = ErroSaidaDto
				.builder()
					.codigoDoErro(1)
					.mensagem("campos invalidos")
					.campoErroDto(campos)
				.build();
		
		return new ResponseEntity<ErroSaidaDto>(erro,HttpStatus.BAD_REQUEST);
	}
	*/
}
