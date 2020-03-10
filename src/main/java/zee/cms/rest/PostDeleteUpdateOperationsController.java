package zee.cms.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zee.cms.entity.*;
import zee.cms.exceptions.*;
import zee.cms.service.*;

@RestController
//@RequestMapping("/adm")
public class PostDeleteUpdateOperationsController {

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
	public PostDeleteUpdateOperationsController(ReviewService reviewService) { this.reviewService = reviewService; }
	//==========================================================================

	// Teacher
	@PostMapping("/teachers")
	public Teacher addTeacher(@RequestBody Teacher theTeacher){
		theTeacher.setId(0);
		teacherService.save(theTeacher);
		return theTeacher;
	}
	@PutMapping("/teachers/{teacherId}")
	public Teacher updateTeacher(@PathVariable int teacherId, @RequestBody Teacher theNewTeacher){
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		theTeacher.setFirstName(theNewTeacher.getFirstName());
		theTeacher.setLastName(theNewTeacher.getLastName());
		theTeacher.setEmail(theNewTeacher.getEmail());
		teacherService.save(theTeacher);
		return theTeacher;
	}
	@DeleteMapping("/teachers/{teacherId}")
	public String deleteTeacher(@PathVariable int teacherId){ 
		Teacher theTeacher = teacherService.findById(teacherId);
		System.out.println("Teacher object: " + theTeacher);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		teacherService.deleteById(teacherId);
		try {
			int teacherDetailId = theTeacher.getTeacherDetailId().getId();
			teacherDetailService.deleteById(teacherDetailId);			
		}
		catch(NullPointerException e){ }
		return "Deleted Teacher Id: " + teacherId;
	}
	//==================================================================
	
	//TeacherDetail
	@PostMapping("/teacherDetails")
	public TeacherDetail addTeacherDetail(@RequestBody TeacherDetail theTeacherDetail){
		theTeacherDetail.setId(0);
		teacherDetailService.save(theTeacherDetail);
		return theTeacherDetail;
	}
	@PutMapping("/teacherDetails/{teacherDetailId}")
	public TeacherDetail updateTeacherDetail(@PathVariable int teacherDetailId, @RequestBody TeacherDetail theNewTeacherDetail){
		TeacherDetail theTeacherDetail = teacherDetailService.findById(teacherDetailId);
		if( theTeacherDetail == null) { throw new TeacherDetailNotFoundException("TeacherDetail ID not found - " + teacherDetailId); }
		theTeacherDetail.setChannel(theNewTeacherDetail.getChannel());
		theTeacherDetail.setHobby(theNewTeacherDetail.getHobby());
		teacherDetailService.save(theTeacherDetail);
		return theTeacherDetail;
	}
	@DeleteMapping("/teacherDetails/{teacherDetailId}")
	public String deleteTeacherDetail(@PathVariable int teacherDetailId){
		TeacherDetail theTeacherDetail = teacherDetailService.findById(teacherDetailId);
		if( theTeacherDetail == null) { throw new TeacherDetailNotFoundException("TeacherDetail ID not found - " + teacherDetailId); }
		Teacher theTeacher = teacherService.findById(teacherDetailId);
		theTeacher.setTeacherDetailId(null);
		teacherDetailService.deleteById(teacherDetailId);
		return "Deleted TeacherDetail Id: " + teacherDetailId;
	}
	//==================================================================

	// Student
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student theStudent){
		theStudent.setId(0);
		studentService.save(theStudent);
		return theStudent;
	}
	@PutMapping("/students/{studentId}")
	public Student updateStudent(@PathVariable int studentId, @RequestBody Student theNewStudent){
		Student theStudent = studentService.findById(studentId);
		if(theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		theStudent.setFirstName(theNewStudent.getFirstName());
		theStudent.setLastName(theNewStudent.getLastName());
		theStudent.setEmail(theNewStudent.getEmail());
		studentService.save(theStudent);
		return theStudent;
	}
	@DeleteMapping("/students/{studentId}")
	public String deleteStudent(@PathVariable int studentId){
		Student theStudent = studentService.findById(studentId);
		if(theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		studentService.deleteById(studentId);
		return "Deleted Student Id: " + studentId;
	}
	//==================================================================
	
	// Degree
	@PostMapping("/degrees")
	public Degree addDegree(@RequestBody Degree theDegree){
		theDegree.setId(0);
		degreeService.save(theDegree);
		return theDegree;		
	}
    //--------------------------------------------------------------------
//	@PutMapping("/degrees/{degreeId}")
//	public Degree updateDegree(@RequestBody Degree theDegree){ 
//		degreeService.save(theDegree);
//		return theDegree;
//	}
//	// This causes to write mention the id field in the JSON object, as:
//	// {
//			"id":2,
//			"name":"new_data_for_degree_name"
//	// }
	//--------------------------------------------------------------------	

	@PutMapping("/degrees/{degreeId}")
	public Degree updateDegree(@PathVariable int degreeId, @RequestBody Degree theNewDegree){
		Degree theDegree = degreeService.findById(degreeId);
		if( theDegree == null) { throw new DegreeNotFoundException("Degree ID not found - " + degreeId); }
		theDegree.setName(theNewDegree.getName());
		degreeService.save(theDegree);
		return theDegree;
	}
	@DeleteMapping("/degrees/{degreeId}")
	public String deleteDegree(@PathVariable int degreeId){
		Degree theDegree = degreeService.findById(degreeId);
		if( theDegree == null) { throw new DegreeNotFoundException("Degree ID not found - " + degreeId); }
		List<Course> courses = courseService.findAll();
		for(Course course: courses){
			try {
				if(course.getDegree().getId()==theDegree.getId()) {
					course.setDegree(null);
					courseService.save(course);
				} // We can delete the course related to degree here. 				
			}
			catch(NullPointerException e) {}
		}
		degreeService.deleteById(degreeId);
		return "Deleted Degree Id: " + degreeId;
	}
	//==================================================================
	
	
	// Course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course theCourse){
		theCourse.setId(0);
		courseService.save(theCourse);
		return theCourse;
	}
	@PutMapping("/courses/{courseId}")
	public Course updateCourse(@PathVariable int courseId, @RequestBody Course theNewCourse){
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		theCourse.setTitle(theNewCourse.getTitle());
		courseService.save(theCourse);
		return theCourse;
	}
	@DeleteMapping("/courses/{courseId}")
	public String deleteCourse(@PathVariable int courseId){
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		List<Review> reviews = reviewService.findAll();
		for(Review review: reviews) {
			try {
				if(review.getCourse().getId()==theCourse.getId()) {
					reviewService.deleteById(review.getId());
				}
			}
			catch(NullPointerException e) {}
		}
		courseService.deleteById(courseId);
		return "Deleted Course Id: " + courseId;
	}
	//==================================================================

	// Review
//	@PostMapping("/reviews")
//	public Review addReview(@RequestBody Review theReview){
//		theReview.setId(0);
//		reviewService.save(theReview);
//		return theReview;
//	}
	@PutMapping("/reviews/{reviewId}")
	public Review updateReview(@PathVariable int reviewId, @RequestBody Review theNewReview){
		Review theReview = reviewService.findById(reviewId);
		if( theReview == null) { throw new ReviewNotFoundException("Review ID not found - " + reviewId); }
		theReview.setComment(theNewReview.getComment());
		reviewService.save(theReview);
		return theReview;
	}
	@DeleteMapping("/reviews/{reviewId}")
	public String deleteReview(@PathVariable int reviewId){
		Review theReview = reviewService.findById(reviewId);
		if( theReview == null) { throw new ReviewNotFoundException("Review ID not found - " + reviewId); }
		reviewService.deleteById(reviewId);
		return "Deleted Review Id: " + reviewId;
	}
	//==================================================================
	
	// Extra Endpoints
	//OneToOne: Create teacher and then create teacherDetail
	@PostMapping("/teachers/{teacherId}/teacherDetails")
	public Teacher addDetailInTeacher(@PathVariable int teacherId, @RequestBody TeacherDetail theTeacherDetail){
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		theTeacher.setTeacherDetailId(theTeacherDetail);
		teacherService.save(theTeacher);
		return theTeacher;
	}

	@PostMapping("/degrees/{degreeId}/courses")
	public Course addCourseInDegree(@PathVariable int degreeId, @RequestBody Course theCourse){
		Degree theDegree = degreeService.findById(degreeId);
		if( theDegree == null) { throw new DegreeNotFoundException("Degree ID not found - " + degreeId); }
		theCourse.setDegree(theDegree);
		courseService.save(theCourse);
		return theCourse;
	}

	@PostMapping("/courses/{courseId}/reviews")
	public Review addReviewInCourse(@PathVariable int courseId, @RequestBody Review theReview){
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		theReview.setCourse(theCourse);
		reviewService.save(theReview);
		return theReview;
	}

	@PostMapping("/teachers/{teacherId}/courses")
	public Course addCourseInTeacher(@PathVariable int teacherId, @RequestBody Course theCourse){ 
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		theTeacher.addCourse(theCourse);
		teacherService.save(theTeacher);
		return theCourse;
	}
	@PostMapping("/courses/{courseId}/teachers")
	public Teacher addTeacherInCourse(@PathVariable int courseId, @RequestBody Teacher theTeacher){ 
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		theCourse.addTeacher(theTeacher);
		courseService.save(theCourse);
		return theTeacher;
	}
	@PostMapping("/teachers/{teacherId}/students")
	public Student addStudentInTeacher(@PathVariable int teacherId, @RequestBody Student theStudent){
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		theTeacher.addStudent(theStudent);
		teacherService.save(theTeacher);
		return theStudent;
	}
	@PostMapping("/students/{studentId}/teachers")
	public Teacher addTeacherInStudent(@PathVariable int studentId, @RequestBody Teacher theTeacher){
		Student theStudent = studentService.findById(studentId);
		if( theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		theStudent.addTeacher(theTeacher);
		studentService.save(theStudent);
		return theTeacher;
	}
	@PostMapping("/teachers/{teacherId}/students/{studentId}")
	public Student mergeStudentInTeacher(@PathVariable int teacherId, @PathVariable int studentId){
		Teacher theTeacher = teacherService.findById(teacherId);
		if( theTeacher == null) { throw new TeacherNotFoundException("Teacher ID not found - " + teacherId); }
		Student theStudent = studentService.findById(studentId);
		if( theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		theTeacher.addStudent(theStudent);
		teacherService.save(theTeacher);
		return theStudent;
	} 
	@PostMapping("/courses/{courseId}/students")
	public Student addStudentInCourse(@PathVariable int courseId, @RequestBody Student theStudent){
		Course theCourse = courseService.findById(courseId);
		if( theCourse == null) { throw new CourseNotFoundException("Course ID not found - " + courseId); }
		theCourse.addStudent(theStudent);
		courseService.save(theCourse);
		return theStudent;
	}
	@PostMapping("/students/{studentId}/courses")
	public Course addCourseInStudent(@PathVariable int studentId, @RequestBody Course theCourse){
		Student theStudent = studentService.findById(studentId);
		if( theStudent == null) { throw new StudentNotFoundException("Student ID not found - " + studentId); }
		theStudent.addCourse(theCourse);
		studentService.save(theStudent);
		return theCourse;
	}

	//==================================================================
	
	
	
	
	
	
}
