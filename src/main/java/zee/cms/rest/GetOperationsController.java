package zee.cms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zee.cms.entity.*;
import zee.cms.exceptions.*;
import zee.cms.service.*;

@RestController
//@RequestMapping("/t")
public class GetOperationsController {

	// Dependencies
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private TeacherDetailService teacherDetailService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private CourseService courseService;

	private ReviewService reviewService;

	@Autowired // For multiple dependencies use @Qualifier annotation in this constructor. 
	public GetOperationsController(ReviewService reviewService) { this.reviewService = reviewService; }
	//==========================================================================

	// Teacher
	@GetMapping("/teachers")
	public List<Teacher> findAllTeachers(){ return teacherService.findAll(); }

	@GetMapping("/teachers/{teacherId}")
	public Teacher getTeacher(@PathVariable int teacherId){
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		return theTeacher; 
	}
	//==========================================================================
	
	
	// TeacherDetail
	@GetMapping("/teacherDetails")
	public List<TeacherDetail> findAllTeacherDetails(){ return teacherDetailService.findAll(); }

	@GetMapping("/teacherDetails/{teacherDetailId}")
	public TeacherDetail getTeacherDetail(@PathVariable int teacherDetailId){
		TeacherDetail theTeacherDetail = teacherDetailService.findById(teacherDetailId);
		if( theTeacherDetail == null) { throw new TeacherDetailNotFoundException("TeacherDetail ID not found - " + teacherDetailId); }
		return theTeacherDetail; 
	}
	//==========================================================================

	// Student
	@GetMapping("/students")
	public List<Student> findAllStudents(){ return studentService.findAll(); }

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable Integer studentId){
		System.out.println(studentId);
		Student theStudent = studentService.findById(studentId);
		if(theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		return theStudent; 
	}
	//==========================================================================

	// Degree
	@GetMapping("/degrees")
	public List<Degree> findAllDegrees(){ return degreeService.findAll(); }

	@GetMapping("/degrees/{degreeId}")
	public Degree getDegree(@PathVariable int degreeId){
		Degree theDegree = degreeService.findById(degreeId);
		if( theDegree == null) { throw new DegreeNotFoundException("Degree ID not found - " + degreeId); }
		return theDegree; 
	}
	//==========================================================================

	// Course
	@GetMapping("/courses")
	public List<Course> findAllCourses(){ return courseService.findAll(); } 

	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId){ 
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		return theCourse; 
	}
	//==========================================================================

	// Review
	@GetMapping("/reviews")
	public List<Review> findAllReviews(){ return reviewService.findAll(); }

	@GetMapping("/reviews/{reviewId}")
	public Review getReview(@PathVariable int reviewId){ 
		Review theReview = reviewService.findById(reviewId);
		if( theReview == null) { throw new ReviewNotFoundException("Review ID not found - " + reviewId); }
		return theReview; 
	}
	//==========================================================================

}
