package onboarding.Service;

import onboarding.entity.Customer;
import onboarding.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        customer.setKycStatus("PENDING"); // Default status
        return customerRepository.save(customer);
    }


}
