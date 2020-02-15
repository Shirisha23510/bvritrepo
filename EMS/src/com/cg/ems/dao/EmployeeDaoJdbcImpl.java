package com.cg.ems.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.util.DBUtil;
 
public class EmployeeDaoJdbcImpl implements EmployeeDao {
 
	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
	 int id=0;
	 try {
	 Connection connection=DBUtil.getConnection();
	 String cmd="insert into employee_tbl values(?,?,?)";
	 PreparedStatement pstmt=connection.prepareStatement(cmd);
     pstmt.setInt(1,employee.getEmployeeId());
     pstmt.setString(2, employee.getEmployeeName());
     pstmt.setDouble(3, employee.getSalary());
     pstmt.executeUpdate();
     pstmt.close();
     connection.close();
	}
	   catch(Exception e)
	{
		throw new EmployeeException(e.getMessage());
	}
      id=employee.getEmployeeId();
	return id;
	}

	@Override
	public Employee findEmployeeId(int employeeId) throws EmployeeException {
		Employee employee =new Employee();
		
		 try {
		 Connection connection=DBUtil.getConnection();
		 String cmd="select empid,empname,empsal from employee_tbl where empid=?";
		 PreparedStatement pstmt=connection.prepareStatement(cmd);
	     pstmt.setInt(1,employeeId);
	    
	  ResultSet rst=   pstmt.executeQuery();
	  if(rst.next())
	  {
		  int id=rst.getInt("empid");
		  String name=rst.getString("empname");
		  double sal =rst.getDouble("empsal");
		  employee.setEmployeeId(id);
		  employee.setEmployeeName(name);
		  employee.setSalary(sal);
	  }
	  else
	  {
		  throw new EmployeeException(employeeId+  "Not exit");
	  }
	    
	     connection.close();
		}
		   catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		} return employee;
	}
		

	@Override
	public Employee deleteEmployeeId(int employeeId) throws EmployeeException  {
		
		Employee employee=new Employee();
		
		 try {
		 Connection connection=DBUtil.getConnection();
		 String cmd="delete from employee_tbl where employeeid=(?)";
		 PreparedStatement pstmt=connection.prepareStatement(cmd);
	     pstmt.setInt(1,employeeId);
	     pstmt.executeUpdate();
	    
	     connection.close();
		}
		   catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}
	     return employee;
	}
	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		List<Employee>list=new ArrayList<Employee>();
		Employee employee=new Employee();
		try {
		 Connection connection=DBUtil.getConnection();
		 String cmd="select *from employee_tbl";
		 PreparedStatement pstmt=connection.prepareStatement(cmd);
	    
	    
	  ResultSet rst=   pstmt.executeQuery();
	  while(rst.next())
	  {
		  int id=rst.getInt("empid");
		  String name=rst.getString("empname");
		  double sal =rst.getDouble("empsal");
		  employee.setEmployeeId(id);
		  employee.setEmployeeName(name);
		  employee.setSalary(sal);
		  list.add(employee);
	  
		  connection.close();
	  }
		}
		   catch(Exception e)
		{
			throw new EmployeeException(e.getMessage());
		}
		   return list;
}}