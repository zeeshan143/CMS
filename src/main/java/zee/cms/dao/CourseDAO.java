package zee.cms.dao;

import java.util.List;

import zee.cms.entity.Course;

public interface CourseDAO {

	public List<Course> findAll();
	public Course findById(int id);
	public void save(Course student);
	public void deleteById(int id);

}
