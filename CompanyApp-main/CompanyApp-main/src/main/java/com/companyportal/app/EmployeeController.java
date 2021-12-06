package com.companyportal.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();	
		
		model.addAttribute("employee", employee);
		return "employeeform";
		
		//return new ModelAndView("employeeform", "employee", employee);
		 
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee employee) {
		
		employeeService.saveEmployeeData(employee);
		return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		List<Employee> employeeList = employeeService.getEmployeesData();
				
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
	 @RequestMapping(value="/deleteEmployee/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id){    
	        employeeService.delete(id);    
	        return "redirect:/employeelist";    
	    } 
	 @RequestMapping(value="/updateEmployee", method = RequestMethod.GET)    
	    public String edit(@RequestParam("employeeId") int employeeId, Model m){    
	        Employee emp=employeeService.getEmployeeById(employeeId);    
	        m.addAttribute("employee",emp);  
	        return "editform";    
	    } 
	 @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@ModelAttribute Employee emp){    
	        employeeService.update(emp);    
	        return "redirect:/employeelist";    
	    }   
	 @RequestMapping(value = "/search", method = RequestMethod.GET)
		public String searchEmployee(@RequestParam("id") int employeeId,Model m){
			Employee employee = employeeService.getEmployeeById(employeeId);
			
			if(employee==null) {
				return "redirect:/employeelist";
			}
			else {
				m.addAttribute("employee", employee);
				return "searchform";
			}
		}
	       
	   
}
