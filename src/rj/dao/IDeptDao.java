package rj.dao;

import java.util.List;

import rj.entity.Dept;


/**
 * ����ģ��dao�ӿ����
 * 
 * 
 */
public interface IDeptDao {

	/**
	 * ��ѯȫ��
	 * @return ����ȫ����Ϣ
	 */
	List<Dept> getAll();

	/**
	 * ����������ѯ
	 * @param id  ����
	 * @return ���ز�ѯ��Ľ��
	 */
	Dept findById(int id);

}
