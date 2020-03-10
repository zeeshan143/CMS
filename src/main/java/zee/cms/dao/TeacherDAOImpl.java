package zee.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.Teacher;


@Repository
public class TeacherDAOImpl implements TeacherDAO{

	private EntityManager entityManager;

	@Autowired
	public TeacherDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<Teacher> findAll() {
		Query theQuery=entityManager.createQuery("FROM Teacher");
		List<Teacher> teachers=theQuery.getResultList();
		return teachers;
	}

	@Override
	public Teacher findById(int id) {
		Teacher teacher=entityManager.find(Teacher.class, id);
		return teacher;
	}

	@Override
	public void save(Teacher teacher) {
		Teacher theTeacher=entityManager.merge(teacher);
		teacher.setId(theTeacher.getId());
	}

	@Override
	public void deleteById(int id) {
		Query theQuery=entityManager.createQuery("DELETE FROM Teacher where id=:teacherId");
		theQuery.setParameter("teacherId", id);
		theQuery.executeUpdate();
	}

}
