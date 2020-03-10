package zee.cms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="course")
public class Course{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="degree_id")
	private Degree degree;
	
	
	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="teacher_course", joinColumns=@JoinColumn(name="course_id"),
							   inverseJoinColumns=@JoinColumn(name="teacher_id"))
	private List<Teacher> teachers;

	@ManyToMany(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="course_student", joinColumns=@JoinColumn(name="course_id"),
							   inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students;
	//=====================================================================================

	public Course() { }
	public Course(String title) { this.title = title; }
	//=====================================================================================

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public Degree getDegree() { return degree; }
	public void setDegree(Degree degree) { this.degree = degree; }
	public List<Teacher> getTeachers() { return teachers; }
	public void setTeachers(List<Teacher> teachers) { this.teachers = teachers; }
	public List<Student> getStudents() { return students; }
	public void setStudents(List<Student> students) { this.students = students; }
	//=====================================================================================

	@Override
	public String toString() { return "Course [id=" + id + ", title=" + title + "]"; }

	public void addStudent(Student theStudent) { 
		if (students==null) { students = new ArrayList<>(); }
		students.add(theStudent);
	}

	public void addTeacher(Teacher theTeacher) {
		if (teachers==null) { teachers = new ArrayList<>(); }
		teachers.add(theTeacher);
	}

}
