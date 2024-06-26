package com.softDev.EmpProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpRepository empRepo;
	
//	List<Employee> employees = new ArrayList<>();

	@Override
	public String createEmp(Employee employee) {
		EmpEntity empEntity = new EmpEntity();
		BeanUtils.copyProperties(employee, empEntity);
		empRepo.save(empEntity);
//		employees.add(employee);
		return "Saved Successfully!!";
	}

	@Override
	public List<Employee> readEmp() {
		List<EmpEntity> employeesList = empRepo.findAll();
		List<Employee> employees = new ArrayList();
		
		for (EmpEntity empEntity : employeesList) {
			
			Employee emp = new Employee();
			emp.setId(empEntity.getId());
			emp.setMobNo(empEntity.getEmail());
			emp.setName(empEntity.getName());
			emp.setEmail(empEntity.getEmail());
			
			employees.add(emp);
		}
		return employees;
	}
	

	@Override
	public boolean deleteEmp(Long id) {
		EmpEntity emp = empRepo.findById(id).get();
		empRepo.delete(emp);
//		List<Employee> readEmp();
		
		return true;

	}

	@Override
	public String updateEmp(Long id, Employee emp) {
		EmpEntity oldEmp = empRepo.findById(id).get();
		
		oldEmp.setEmail(emp.getEmail());
		oldEmp.setMobNo(emp.getMobNo());
		oldEmp.setName(emp.getName());
		
		empRepo.save(oldEmp);
		
		return "Update Successfully";
	}

	@Override
	public Employee empDetail(Long id) {
		EmpEntity DetailEmp = empRepo.findById(id).get();
		Employee empD = new Employee();
		BeanUtils.copyProperties(DetailEmp, empD);
		
		return empD;
		
	}

}
