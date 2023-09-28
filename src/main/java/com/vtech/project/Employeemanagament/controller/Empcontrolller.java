package com.vtech.project.Employeemanagament.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vtech.project.Employeemanagament.Service.EmpService;
import com.vtech.project.Employeemanagament.entity.Employee;

@Controller
public class Empcontrolller{
	@Autowired
	private  EmpService service;
	
	@GetMapping("/")
	 public String home(Model m)
	 { 
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		 return "index";
	 }
	@GetMapping("/Add_emp")
	public String addEmpForm()
	{
		return "Add_emp";
	}
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);//show output in console
		service.addEmp(e);
		session.setAttribute("msg", "Employee details added successfully..");
		return "redirect:/";
		
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession ses)
	{
		service.addEmp(e);
		ses.setAttribute("msg", "Employee details edited successfully..");
		return "redirect:/";
		
	}
	@GetMapping("/delete/{id}")
	public String  deleteEmp(@PathVariable int id,HttpSession ses)
	{
		service.deleteEmp(id);
		ses.setAttribute("msg", "Employee values deleted successfully...");
		return "redirect:/";
	}
}