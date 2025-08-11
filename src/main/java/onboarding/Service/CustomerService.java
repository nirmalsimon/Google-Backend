package onboarding.Service;

import onboarding.entity.Customer;
import onboarding.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        customer.setKycStatus("PENDING"); // Default status
        return customerRepository.save(customer);
    }
}
