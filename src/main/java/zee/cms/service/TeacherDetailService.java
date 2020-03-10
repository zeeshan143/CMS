package zee.cms.service;

import java.util.List;

import zee.cms.entity.TeacherDetail;


public interface TeacherDetailService {

	public List<TeacherDetail> findAll();
	public TeacherDetail findById(int id);
	public void save(TeacherDetail teacherDetail);
	public void deleteById(int id);

}
