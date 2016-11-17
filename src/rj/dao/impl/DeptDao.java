package rj.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import rj.dao.IDeptDao;
import rj.entity.Dept;

public class DeptDao implements IDeptDao {
	
	// ÈÝÆ÷×¢Èë
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Dept findById(int id) {
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Dept> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Dept").list();
	}

}
