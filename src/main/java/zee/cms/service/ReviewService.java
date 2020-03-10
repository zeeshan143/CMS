package zee.cms.service;

import java.util.List;

import zee.cms.entity.Review;

public interface ReviewService {

	public List<Review> findAll();
	public Review findById(int id);
	public void save(Review review);
	public void deleteById(int id);

}
