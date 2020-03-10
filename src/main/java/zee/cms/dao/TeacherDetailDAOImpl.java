package zee.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.TeacherDetail;

@Repository
public class TeacherDetailDAOImpl implements TeacherDetailDAO{

	private EntityManager entityManager;

	@Autowired
	public TeacherDetailDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<TeacherDetail> findAll() {
		Query theQuery=entityManager.createQuery("FROM TeacherDetail");
		List<TeacherDetail> teacherDetails=theQuery.getResultList();
		return teacherDetails;
	}

	@Override
	public TeacherDetail findById(int id) {
		TeacherDetail teacherDetail=entityManager.find(TeacherDetail.class, id);
		return teacherDetail;
	}

	@Override
	public void save(TeacherDetail teacherDetail) {
		TeacherDetail theTeacherDetail=entityManager.merge(teacherDetail);
		teacherDetail.setId(theTeacherDetail.getId());
	}

	@Override
	public void deleteById(int id) {
		Query theQuery=entityManager.createQuery("DELETE FROM TeacherDetail where id=:teacherDetailId");
		theQuery.setParameter("teacherDetailId", id);
		theQuery.executeUpdate();
	}

}
