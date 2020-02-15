package com.cg.ems.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeDaoMapImpl implements EmployeeDao {
         private Map<Integer,Employee> map;
         public EmployeeDaoMapImpl()
         {
        	 map=new HashMap <Integer,Employee>();
         }
	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		
		
		boolean flag=map.containsKey(employee.getEmployeeId());
		if(flag)
		{
			throw new EmployeeException("id already exist");
		}
		
		map.put(employee.getEmployeeId(),employee);
		return 0;
	}

	@Override
	public Employee findEmployeeId(int employeeId) throws EmployeeException {
	
		boolean flag=map.containsKey(employeeId);
		Employee employee =null;
		if(flag)
	
		{
			employee=map.get(employeeId);
		}
		
		else
		{
			throw new EmployeeException(employeeId+"Id not found");
		}
		
		return employee;
	}

	@Override
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException {
		
		Employee employee=null;
		boolean flag=map.containsKey(employee.getEmployeeId());
		
		if(flag)
		
		{
			employee=map.remove(employeeId);
			
		}
		else
		{
			throw new EmployeeException(employeeId+"Id not found");
		}
		
		
		
		
		
		return null ;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
	    Collection<Employee>col=map.values();
	    List<Employee> list=new ArrayList<Employee>();
	    return list;
		
		
		
		
		
		
		
		
		
		
		
	}

}
