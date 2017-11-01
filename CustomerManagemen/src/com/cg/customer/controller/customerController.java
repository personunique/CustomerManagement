package com.cg.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.customer.model.Customer;
import com.cg.customer.service.ICustomerService;


@Controller
public class customerController {

	@Autowired
	ICustomerService service;
	
	
	
	@RequestMapping("/start")
	public String goToStart(Model m){
		m.addAttribute("cust",new Customer());
		return "customerRegForm";
	}
	
	@RequestMapping("/reg")
	public String registration(@ModelAttribute("cust") @Valid Customer cust, BindingResult result, Model m){
		System.out.println("hi");
		if(result.hasErrors()){
			return "customerRegForm";
		}
		else{
			service.addDetails(cust);
			m.addAttribute("k", cust);
			return "customerSuccess";
			
		}
		
	}
	
	
	
	
	/*@RequestMapping("/goFind")
	public String goToFind(){
		return "custIdFind";
	}*/
	@RequestMapping("/goFind")
	public ModelAndView goToFind(){
		
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdFind", "idList", idList);
	} 

	
	
	@RequestMapping("/find")
	public ModelAndView findById(@RequestParam("custId") int custId){
		
		Customer cust = service.retrieveById(custId);
		return new ModelAndView("customerSuccess", "k", cust);
	}
	
	
	@RequestMapping("/goFindAll")
	public ModelAndView findAll(){
		
		List<Customer> custList = service.retrieveDetails();
		return new ModelAndView("customerListSuccess", "list", custList);
	}
	
	
	
	
	@RequestMapping("/goDelete")
	public ModelAndView goToDelete(){
		List<Integer> idList= service.retrieveIds();
		return new ModelAndView("custIdDelete", "idList", idList);
				/*return "custIdDelete";*/
		
	}
	
	@RequestMapping("/delete")
	public String deleteById(@RequestParam("custId") int custId){
		Customer cust = service.retrieveById(custId);
		service.deleteDetails(cust);
		return "deleteCust";
	}
	
	/*@RequestMapping("/updatedetails")
	public String goToUpdate1(){
		return "custIdUpdate";
	}
	@RequestMapping("/update")
	public String goToUpdate(@RequestParam("custId") Customer id, Model m ){
		Customer c=service.getEmpId(id);
		m.addAttribute("key",c);
		return "edit";
		
	}*/
	@RequestMapping("/Update")
	public ModelAndView goToUpdate(){
		List<Integer> custId=service.retrieveIds();
		return new ModelAndView("custIdUpdate","custId",custId);

	}

	@RequestMapping("/update")
	public String updateById(@RequestParam("custId") int custId,Model m){
		Customer cust = service.retrieveById(custId);
		System.out.println(cust);
		m.addAttribute("customer", cust);
		return "UpdateDetailsForm";
	}
	
	@RequestMapping("/doUpdation")
	public String updateDetails(@ModelAttribute("customer") @Valid Customer cust,BindingResult result, Model model){
		
		if(result.hasErrors())
		{
			return "UpdateDetailsForm";
		}
		else{
			Customer customer = service.update(cust);
			model.addAttribute("k", customer);
			return "updateSuccess";
		}	
	}
}
	
	
