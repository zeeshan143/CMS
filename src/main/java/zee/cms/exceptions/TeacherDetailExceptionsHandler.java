package zee.cms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TeacherDetailExceptionsHandler {

	@ExceptionHandler // For TeacherDetailNotFoundException
	public ResponseEntity<TeacherDetailErrorResponse> handleException(TeacherDetailNotFoundException exc) {
		TeacherDetailErrorResponse error = new TeacherDetailErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value()); // We are setting the response class fields. 
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }
	@ExceptionHandler // For any other exception in TeacherDetail
	public ResponseEntity<TeacherDetailErrorResponse> handleExceptionTeacherDetail(Exception exc) {
		TeacherDetailErrorResponse error = new TeacherDetailErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
