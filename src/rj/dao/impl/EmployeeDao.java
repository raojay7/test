package rj.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import rj.dao.IEmployeeDao;
import rj.entity.Employee;

public class EmployeeDao implements IEmployeeDao {

	// ����ע��
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void delete(int id) {
		// HQL��ѯ���ִ�Сд�� ����/���������ϸ����ִ�Сд
		// ���ݿ�ؼ��ֲ�����
		sessionFactory.getCurrentSession()//
				.createQuery("delete from Employee where id=?")//
				.setParameter(0, id)//
				.executeUpdate();
	}

	public Employee findById(int id) {
		return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from Employee").list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAll(String employeeName) {
		return sessionFactory.getCurrentSession()//
			.createQuery("from Employee where empName like ?")//
			.setParameter(0, "%" +employeeName + "%")//
			.list();
	}

	public void save(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	public void update(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

}
