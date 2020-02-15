package com.cg.ems.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoJdbcImpl;
import com.cg.ems.exception.EmployeeException;

class TestEmployeeDaoJdbcImpl {
  
	@Test
	public void testFindEmployeeIdExist() throws Exception 
	{
	
	
     EmployeeDao dao=new EmployeeDaoJdbcImpl();
      Employee employee =dao.findEmployeeId(1056); 
       assertEquals(1056,employee.getEmployeeId());
	}

	
	@Test
	public void testFindEmployeeIdNotExit()
	{
		EmployeeDao dao=new EmployeeDaoJdbcImpl();
		assertThrows(EmployeeException.class,()->dao.findEmployeeId(1059));
		
	}
	
	
	
}
