package com.cg.ems.dao;
import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import java.util.List;
public interface EmployeeDao {

	public int addEmployee(Employee employee)throws EmployeeException;
	
	public Employee findEmployeeId(int employeeId) throws EmployeeException;	
	
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException;
	
	public List<Employee> findAllEmployee() throws EmployeeException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
