package rj.service.impl;

import java.util.List;

import rj.dao.IEmployeeDao;
import rj.entity.Employee;
import rj.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
	IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public void save(Employee emp) {
		employeeDao.save(emp);
	}

	public void update(Employee emp) {
		employeeDao.update(emp);
	}

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public List<Employee> getAll(String employeeName) {
		return employeeDao.getAll(employeeName);
	}

	public void delete(int id) {
		employeeDao.delete(id);
	}

	public void deleteMany(int[] ids) {
		if(ids!=null&&ids.length>0){
			for(int i:ids){
				employeeDao.delete(i);
			}
		}
	}

}
