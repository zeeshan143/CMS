package zee.cms.dao;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;

	@Autowired
	public StudentDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<Student> findAll() {
		Query theQuery=entityManager.createQuery("FROM Student");
		List<Student> students=theQuery.getResultList();
		return students;
	}

	@Override
	public Student findById(int id) {
		Student student=entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public void save(Student student) {
		Student theStudent=entityManager.merge(student);
		student.setId(theStudent.getId());
	}

	@Override
	public void deleteById(int id) {
		Query theQuery=entityManager.createQuery("DELETE FROM Student where id=:studentId");
		theQuery.setParameter("studentId", id);
		theQuery.executeUpdate();
	}

}
