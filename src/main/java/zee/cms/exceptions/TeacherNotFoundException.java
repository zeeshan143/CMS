package zee.cms.exceptions;

public class TeacherNotFoundException extends RuntimeException {
	public TeacherNotFoundException(String message, Throwable cause) { super(message, cause); }
	public TeacherNotFoundException(String message) { super(message); }
	public TeacherNotFoundException(Throwable cause) { super(cause); }
}
