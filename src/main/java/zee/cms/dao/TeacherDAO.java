package zee.cms.dao;

import java.util.List;

import zee.cms.entity.Teacher;

public interface TeacherDAO {

	public List<Teacher> findAll();
	public Teacher findById(int id);
	public void save(Teacher teacher);
	public void deleteById(int id);

}
