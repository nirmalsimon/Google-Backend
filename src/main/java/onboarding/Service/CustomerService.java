package onboarding.Service;

import onboarding.entity.Customer;
import onboarding.repository.CustomerRepository;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger.*;
import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer) {
        customer.setKycStatus("PENDING"); // Default status
        log.info("Here ");
        return customerRepository.save(customer);
    }

//    public Customer getCustomerByIdNumber(String idNumber)
//    {
//        log.info("Fetching customer with ID Number: {}", idNumber);
//        return customerRepository.findByIdNumber(idNumber)
//                 new RuntimeException("Customer not found with ID Number: " + idNumber));
//    }
    }
//}
