package zee.cms.exceptions;

public class TeacherDetailNotFoundException extends RuntimeException {
	public TeacherDetailNotFoundException(String message, Throwable cause) { super(message, cause); }
	public TeacherDetailNotFoundException(String message) { super(message); }
	public TeacherDetailNotFoundException(Throwable cause) { super(cause); }
}
