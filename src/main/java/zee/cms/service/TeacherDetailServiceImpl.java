package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.TeacherDetailDAO;
import zee.cms.entity.TeacherDetail;

@Service
public class TeacherDetailServiceImpl implements TeacherDetailService {

	private TeacherDetailDAO teacherDetailDAO;

	@Autowired
	public TeacherDetailServiceImpl(TeacherDetailDAO teacherDetailDAO) { this.teacherDetailDAO = teacherDetailDAO; }

	@Override
	@Transactional
	public List<TeacherDetail> findAll() { return teacherDetailDAO.findAll(); }

	@Override
	@Transactional
	public TeacherDetail findById(int id) { return teacherDetailDAO.findById(id); }

	@Override
	@Transactional
	public void save(TeacherDetail teacherDetail) { teacherDetailDAO.save(teacherDetail); }

	@Override
	@Transactional
	public void deleteById(int id) { teacherDetailDAO.deleteById(id); }

}
