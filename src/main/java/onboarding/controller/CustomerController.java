package onboarding.controller;

import onboarding.Service.CustomerService;
import onboarding.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }
//    @GetMapping("/customer/idnumber/{idNumber}")
//    public Customer getCustomerByIdNumber(@PathVariable String idNumber) {
//        return customerService.getCustomerByIdNumber(idNumber);
//    }


} 