package cs544.exercise10_1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.HttpStatus;

import cs544.exercise10_1.customer.Customer;

@Controller
@RequestMapping(value="/customer")
public class CustomerConroller {
	
	private CustomerService customerService;
	
	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	@RequestMapping(value = "/customer", method = RequestMethod.POST) @ResponseStatus(HttpStatus.CREATED)
	public void addCustomer(@RequestBody Customer customer) {}
	
	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public  void deleteCustomer(@PathVariable("customerNumber") String customerNumber) {
		//RedirectView return customerService.deleteCustomer(customerNumber);
		
	}
	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.GET)
	public @ResponseBody Customer getCustomer(@PathVariable("customerNumber") String customerNumber, Model model) {
		
		return (Customer) model.addAttribute("customerNumber", customerNumber);
	}
	@RequestMapping(value = "/customers", method = RequestMethod.GET) 
	public @ResponseBody Collection<Customer> getCustomers(Model model) {
		
		return (Collection<Customer>) model.addAllAttributes(customerService.getCustomers());
		}
	@RequestMapping(value = "/customer/{customerNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void updateCustomer(@RequestBody Customer customer) {}
}
