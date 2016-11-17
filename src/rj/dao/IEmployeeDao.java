package rj.dao;

import java.util.List;

import rj.entity.Employee;


/**
 * Ա��ģ��dao�ӿ����
 * 
 * 
 */
public interface IEmployeeDao {

	/**
	 * ����Ա��
	 * @param emp
	 */
	void save(Employee emp);

	/**
	 * ����Ա����Ϣ
	 * @param emp
	 */
	void update(Employee emp);

	/**
	 * ��������ɾ��
	 * @param id
	 */
	void delete(int id);

	/**
	 * ����������ѯ
	 * @param id
	 * @return
	 */
	Employee findById(int id);

	/**
	 * ��ѯȫ��
	 * @return
	 */
	List<Employee> getAll();

	/**
	 * ����Ա������������ѯ
	 * @param employeeName
	 * @return
	 */
	List<Employee> getAll(String employeeName);

}
