package rj.service.impl;

import rj.dao.IAdminDao;
import rj.entity.Admin;
import rj.service.IAdminService;

public class AdminService implements IAdminService {

	//iocÈÝÆ÷×¢Èë
	IAdminDao adminDao;
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	public void register(Admin admin) {
		adminDao.save(admin);
	}

	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

}
