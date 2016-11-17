package rj.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import rj.entity.Dept;
import rj.entity.Employee;
import rj.service.IDeptService;
import rj.service.IEmployeeService;

/**
 * ����������
 * 1Ա���б�չʾ
 * 2���Ա��
 * @author ��
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware{

	//1��װ����
	private Employee employee=new Employee();
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	
	//��װ�����ŵ�id�������б��ʵ��ֵ��
	private int deptId;
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	//ģ������
	public Employee getModel() {
		return employee;
	}
	//���տ������ʱ�������request��map
	private Map<String,Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	//2����service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	
	//1.0Ա���б�չʾ
	public String list(){
		//��ѯ����Ա��
		List<Employee> listEmp=employeeService.getAll();
		//���浽request��
		request.put("listEmp", listEmp);
		return "list";
	}
	
	
	//2.0--�������Ա��ҳ��
	public String viewAdd(){
		//��ѯ���в���
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	
	//2.1--���Ա������
	public String save(){
		//���ݲ���������ѯ
		Dept dept = deptService.findById(deptId);
		//���õ�Ա������
		employee.setDept(dept);
		//����service������Ա��
		employeeService.save(employee);
		return "listAction";//�ض��򣬷�ֹ���ظ��ύ
	}
	
	//3.0�����޸�ҳ��
	public String viewUpdate(){
		//��ȡ���޸ĵļ�¼��Ա����id
		int id=employee.getId();
		//1����id��ѯ
		Employee emp=employeeService.findById(id);
		//2��ѯ���еĲ���
		List<Dept> listDept = deptService.getAll();
		//���ݻ���
		ValueStack vs=ActionContext.getContext().getValueStack();//�õ�ֵջ����
		vs.pop();//�Ƴ�ջ��Ԫ��
		vs.push(emp);//��ջ
		
		//3����
		request.put("listDept", listDept);
		return "edit";
	}
	
	//3.1�޸Ĳ���
	public String update(){
		//1�ȸ��ݲ���id���õ����ţ������õ�Ա��������
		Dept dept=deptService.findById(deptId);
		//����
		employee.setDept(dept);
		//2����Ա��
		
		employeeService.update(employee);
		return "listAction";//�ض����б�
	}
	//4.0ɾ������
	public String delete(){
		employeeService.delete(employee.getId());
		
		return "listAction";
	}
}
