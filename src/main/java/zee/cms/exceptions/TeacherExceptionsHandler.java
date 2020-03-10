package zee.cms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeacherExceptionsHandler {

	// For global exception handling, we create this class and write the exception handler methods in it.
	// Otherwise we write the exception handler methods in the RestControllerClass. 

	@ExceptionHandler // For TeacherNotFoundException
	public ResponseEntity<TeacherErrorResponse> handleException(TeacherNotFoundException exc) {
		TeacherErrorResponse error = new TeacherErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value()); // We are setting the response class fields. 
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	@ExceptionHandler // For any other exception in Teacher
	public ResponseEntity<TeacherErrorResponse> handleExceptionTeacher(Exception exc) {
		TeacherErrorResponse error = new TeacherErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
