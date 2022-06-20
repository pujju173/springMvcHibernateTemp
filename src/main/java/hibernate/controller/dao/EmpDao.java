package hibernate.controller.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import hibernate.controller.model.Emp;

@Component
public class EmpDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
		
	}
	@Transactional
	public void save(Emp e)
	{
		this.hibernateTemplate.save(e);
	}
	
	public List<Emp> getAll()
	{
		List<Emp> al1=this.hibernateTemplate.loadAll(Emp.class);
		return al1;
	}
	
	@Transactional
	public void delete(int id)
	{
		Emp e=this.hibernateTemplate.load(Emp.class,id);
		 this.hibernateTemplate.delete(e);
	}
	
	public Emp getOne(int id)
	{
		return this.hibernateTemplate.get(Emp.class,id);
	}
	
	
	

}
