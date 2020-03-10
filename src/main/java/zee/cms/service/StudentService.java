package zee.cms.service;

import java.util.List;

import zee.cms.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	public Student findById(int id);
	public void save(Student student);
	public void deleteById(int id);
}
