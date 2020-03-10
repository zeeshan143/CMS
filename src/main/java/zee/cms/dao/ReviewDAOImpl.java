package zee.cms.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zee.cms.entity.Review;

@Repository
public class ReviewDAOImpl implements ReviewDAO{

	private EntityManager entityManager;

	@Autowired
	public ReviewDAOImpl(EntityManager entityManager) { this.entityManager = entityManager; }

	@Override
	public List<Review> findAll() {
		Query theQuery=entityManager.createQuery("FROM Review");
		List<Review> reviews=theQuery.getResultList();
		return reviews;
	}

	@Override
	public Review findById(int id) {
		Review review=entityManager.find(Review.class, id);
		return review;
	}

	@Override
	public void save(Review review) {
		Review theReview=entityManager.merge(review);
		review.setId(theReview.getId());
	}

	@Override
	public void deleteById(int id) {
		Query theQuery=entityManager.createQuery("DELETE FROM Review where id=:reviewId");
		theQuery.setParameter("reviewId", id);
		theQuery.executeUpdate();
	}

}
