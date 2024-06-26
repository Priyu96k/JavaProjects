package com.softDev.EmpProject;

import java.util.List;


public interface EmployeeService {

	String createEmp(Employee employee);

	List<Employee> readEmp();

	boolean deleteEmp(Long id);

	String updateEmp(Long id, Employee emp);

	Employee empDetail(Long id);




}
