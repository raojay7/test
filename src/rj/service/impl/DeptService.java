package rj.service.impl;

import java.util.List;

import rj.dao.IDeptDao;
import rj.entity.Dept;
import rj.service.IDeptService;

public class DeptService implements IDeptService {

	IDeptDao deptDao;
	public void setDeptDao(IDeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	
	public List<Dept> getAll() {
		return deptDao.getAll();
	}

	public Dept findById(int id) {
		return deptDao.findById(id);
	}

}
