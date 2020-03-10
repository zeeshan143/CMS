package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.StudentDAO;
import zee.cms.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDAO studentDAO;

	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO) { this.studentDAO = studentDAO; }

	@Override
	@Transactional
	public List<Student> findAll() { return studentDAO.findAll(); }

	@Override
	@Transactional
	public Student findById(int id) {
		return studentDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentDAO.save(student);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentDAO.deleteById(id);
	}

}
