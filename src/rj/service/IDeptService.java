package rj.service;

import java.util.List;

import rj.entity.Dept;

/**
 * ����ģ��ҵ���߼���ӿ�
 *
 */
public interface IDeptService {

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
