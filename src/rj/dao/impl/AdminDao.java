package rj.dao.impl;

import org.hibernate.SessionFactory;

import rj.dao.IAdminDao;
import rj.entity.Admin;

public class AdminDao implements IAdminDao {

	// IOC»›∆˜(“¿¿µ)◊¢»ÎSessionFactory∂‘œÛ
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Admin findByAdmin(Admin admin) {
		return (Admin) sessionFactory.getCurrentSession()//
				.createQuery("from Admin where adminName=? and pwd=?")//
				.setString(0, admin.getAdminName())//
				.setString(1, admin.getPwd())//
				.uniqueResult();
	}

	public void save(Admin admin) {
		sessionFactory.getCurrentSession().save(admin);
	}

}
