package rj.service;

import rj.entity.Admin;

/**
 * ����Աҵ���߼���ӿ�
 * 
 * 
 */
public interface IAdminService {

	/**
	 * ע��
	 * @param admin
	 */
	void register(Admin admin);

	/**
	 * ��½
	 * @param admin
	 * @return
	 */
	Admin login(Admin admin);

}
