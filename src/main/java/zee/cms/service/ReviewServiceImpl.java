package zee.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zee.cms.dao.ReviewDAO;
import zee.cms.entity.Review;


@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewDAO reviewDAO;

	@Autowired
	public ReviewServiceImpl(ReviewDAO reviewDAO) { this.reviewDAO = reviewDAO; }

	@Override
	@Transactional
	public List<Review> findAll() { return reviewDAO.findAll(); }

	@Override
	@Transactional
	public Review findById(int id) {
		return reviewDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Review review) {
		reviewDAO.save(review);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		reviewDAO.deleteById(id);
	}

}
