package zee.cms.dao;

import java.util.List;

import zee.cms.entity.TeacherDetail;


public interface TeacherDetailDAO {

	public List<TeacherDetail> findAll();
	public TeacherDetail findById(int id);
	public void save(TeacherDetail teacherDetail);
	public void deleteById(int id);
 
}
