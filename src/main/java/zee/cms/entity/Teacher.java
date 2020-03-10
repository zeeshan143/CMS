package zee.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstName;
	 
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email; 

	@OneToOne(targetEntity=TeacherDetail.class, cascade=CascadeType.ALL)
	@JoinColumn(name="teacher_detail_id")
	private TeacherDetail teacherDetailId;
	
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="teacher_course", joinColumns=@JoinColumn(name="teacher_id"),
							   inverseJoinColumns=@JoinColumn(name="course_id"))
	private List<Course> courses;

	
	@ManyToMany(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="teacher_student", joinColumns=@JoinColumn(name="teacher_id"),
							   inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;

	
	//=====================================================================================

	public Teacher() { }
	public Teacher(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//=====================================================================================

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) { this.firstName = firstName; }
	public String getLastName() { return lastName; }
	public void setLastName(String lastName) { this.lastName = lastName; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public TeacherDetail getTeacherDetailId() { return teacherDetailId; }
	public void setTeacherDetailId(TeacherDetail teacherDetailId) { this.teacherDetailId = teacherDetailId; }
	public List<Course> getCourses() { return courses; }
	public void setCourses(List<Course> courses) { this.courses = courses; }
	public List<Student> getStudents() { return students; }
	public void setStudents(List<Student> students) { this.students = students; }
	//=====================================================================================
	
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName 
				+ ", email=" + email + ", teacherDetailId=" + teacherDetailId + "]";
	}
	//=====================================================================================

	public void addCourse(Course theCourse) {
		if (courses==null) { courses = new ArrayList<>(); }
		courses.add(theCourse);
	}
	
	public void addStudent(Student theStudent) {
		if (students==null) { students = new ArrayList<>(); }
		students.add(theStudent);
	}
	
}
