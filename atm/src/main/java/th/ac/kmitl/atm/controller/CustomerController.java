package th.ac.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.atm.service.CustomerService;
import th.ac.kmitl.atm.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    //ArrayList<Customer> customers = new ArrayList<>();
    @GetMapping
    public String getCustomerPage(Model model) {
        /*List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"Peter",1234));
        customers.add(new Customer(2,"Nancy",2345));
        customers.add(new Customer(3,"Rick",3456));*/
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer";
    }
    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }


}
