package zee.cms.service;

import java.util.List;

import zee.cms.entity.Teacher;

public interface TeacherService {

	public List<Teacher> findAll();
	public Teacher findById(int id);
	public void save(Teacher teacher);
	public void deleteById(int id);

}
