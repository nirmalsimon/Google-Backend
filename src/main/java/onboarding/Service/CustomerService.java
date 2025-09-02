package onboarding.Service;

import onboarding.entity.Customer;
import onboarding.entity.KycState;
import onboarding.entity.KycStatus;
import onboarding.repository.CustomerRepository;
import onboarding.repository.KycStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) {
        log.info("Saving customer: {}", customer.getName());

        // Create a new KYC entry
        KycStatus kycStatus = new KycStatus();
        kycStatus.setStatus("NEW");
        kycStatus.setKycStatus(KycState.PENDING);
        kycStatus.setCustomer(customer); // link back

        // link forward
        customer.setKycStatus(kycStatus);
        log.info("Customer BEFORE save: {}", customer);
        log.info("KYC BEFORE save: {}", customer.getKycStatus());

        // save customer (because of cascade, KycStatus will be saved too)
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
