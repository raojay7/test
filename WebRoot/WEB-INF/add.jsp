<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
  </head>
  <!-- 空value防止回显 -->
  <body>
	  <s:form action="/emp_save" method="post" theme="simple" namespace="/">
	  <table align="center" border="1" width="80%" cellpadding="5" cellspacing="0">
		<tr>
			<td>员工姓名</td>
			<td>
				<s:textfield id="empName" name="empName" value=""></s:textfield>
			</td>
		</tr>
		<tr>
			<td>员工薪水</td>
			<td>
				<s:textfield id="salary" name="salary" value=""></s:textfield>
			</td>
		</tr>
		
		<tr>
			<td>选择部门</td>
			<!-- 
  	 			 	Struts下拉列表标签：
	 			 		name="deptId"  下拉列表标签的名称(服务器根据这个名称获取选择的项的实际的值value值)
	 			 		headerKey   默认选择项的实际的值
	 			 		headerValue  默认下拉列表显示的内容
	 			 		list      下拉列表显示数据的集合
	 			 		listKey    集合对象的哪个属性作为下拉列表的实例的值，即value值
	 			 		listValue  集合对象的哪个属性作为下拉列表显示的值
	 			 		value      默认选择的项的设置 
  	 	-->
			<td>
				<s:select 
				name="deptId"
				headerKey="-1"
				headerValue="请选择"
				list="#request.listDept"
				listKey="id"
				listValue="name"
				value="-1"
				>
				</s:select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<s:submit value="添加员工"></s:submit>
			</td>
		</tr>
	  </table> 
	  </s:form>
  </body>
</html>