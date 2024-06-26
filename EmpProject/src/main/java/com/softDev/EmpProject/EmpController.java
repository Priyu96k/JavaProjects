package com.softDev.EmpProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/")
public class EmpController {

//	List<Employee> employees = new ArrayList<>();

//	EmployeeService empService = new EmployeeServiceImpl();

//	Dependancy Injection

	@Autowired
    private EmployeeService empService;

	@GetMapping("employees")
	public List<Employee> getAllEmployee(){
//				employees.add(null);
		return empService.readEmp();
	}

	@GetMapping("employees/{id}")
	public Employee getEmployee(@PathVariable Long id){
//				
		return empService.empDetail(id);
	}
	
	@PostMapping("employees")
	public String createEmp(@RequestBody Employee employee) {
//		employees.add(employee)
		return empService.createEmp(employee);

//		return "Saved Successfully! ";
	}

	@DeleteMapping("employees/{id}")
	public String deleteEmp(@PathVariable Long id) {
		
//		System.out.println("Controller" +empService.deleteEmp(id));
		if(empService.deleteEmp(id)) {
			return "Delete Successfuly";
		}else {
			return "Not Found";
		}
	}
	
	@PutMapping("employees/{id}")
	public String updateEmp(@PathVariable Long id, @RequestBody Employee emp) {
		//TODO: process PUT request
		
		return empService.updateEmp(id, emp);
	}
}