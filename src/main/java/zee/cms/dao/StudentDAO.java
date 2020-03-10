package zee.cms.dao;

import java.util.List;

import zee.cms.entity.Student;

public interface StudentDAO {

	public List<Student> findAll();
	public Student findById(int id);
	public void save(Student student);
	public void deleteById(int id);

}
