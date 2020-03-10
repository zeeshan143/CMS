package zee.cms.dao;

import java.util.List;

import zee.cms.entity.Degree;

public interface DegreeDAO {

	public List<Degree> findAll();
	public Degree findById(int id);
	public void save(Degree degree);
	public void deleteById(int id);

}
