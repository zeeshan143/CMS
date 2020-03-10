package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.TeacherDAO;
import zee.cms.entity.Teacher;

@Service
public class TeacherServiceImpl implements TeacherService {

	private TeacherDAO teacherDAO;

	@Autowired
	public TeacherServiceImpl(TeacherDAO teacherDAO) { this.teacherDAO = teacherDAO; }

	@Override
	@Transactional
	public List<Teacher> findAll() { return teacherDAO.findAll(); }

	@Override
	@Transactional
	public Teacher findById(int id) { return teacherDAO.findById(id); }

	@Override
	@Transactional
	public void save(Teacher teacher) { teacherDAO.save(teacher); }

	@Override
	@Transactional
	public void deleteById(int id) { teacherDAO.deleteById(id); }

}
