package zee.cms.service;

import java.util.List;

import zee.cms.entity.Degree;

public interface DegreeService {

	public List<Degree> findAll();
	public Degree findById(int id);
	public void save(Degree degree);
	public void deleteById(int id);

}
