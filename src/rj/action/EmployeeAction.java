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
 * 控制器开发
 * 1员工列表展示
 * 2添加员工
 * @author 隽
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>, RequestAware{

	//1封装数据
	private Employee employee=new Employee();
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	
	//封装请求部门的id（下拉列表的实际值）
	private int deptId;
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	//模型驱动
	public Employee getModel() {
		return employee;
	}
	//接收框架运行时传入代表request的map
	private Map<String,Object> request;
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	//2调用service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	
	
	//1.0员工列表展示
	public String list(){
		//查询所有员工
		List<Employee> listEmp=employeeService.getAll();
		//保存到request域
		request.put("listEmp", listEmp);
		return "list";
	}
	
	
	//2.0--进入添加员工页面
	public String viewAdd(){
		//查询所有部门
		List<Dept> listDept = deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	
	//2.1--添加员工数据
	public String save(){
		//根据部门主键查询
		Dept dept = deptService.findById(deptId);
		//设置到员工对象
		employee.setDept(dept);
		//调用service，保存员工
		employeeService.save(employee);
		return "listAction";//重定向，防止表单重复提交
	}
	
	//3.0进入修改页面
	public String viewUpdate(){
		//获取到修改的记录的员工的id
		int id=employee.getId();
		//1根据id查询
		Employee emp=employeeService.findById(id);
		//2查询所有的部门
		List<Dept> listDept = deptService.getAll();
		//数据回显
		ValueStack vs=ActionContext.getContext().getValueStack();//得到值栈对象
		vs.pop();//移除栈顶元素
		vs.push(emp);//入栈
		
		//3保存
		request.put("listDept", listDept);
		return "edit";
	}
	
	//3.1修改操作
	public String update(){
		//1先根据部门id，得到部门，在设置到员工属性中
		Dept dept=deptService.findById(deptId);
		//设置
		employee.setDept(dept);
		//2更新员工
		
		employeeService.update(employee);
		return "listAction";//重定向到列表
	}
	//4.0删除操作
	public String delete(){
		employeeService.delete(employee.getId());
		
		return "listAction";
	}
}
