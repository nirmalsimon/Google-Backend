package onboarding.Service;

import onboarding.entity.Customer;
import onboarding.entity.KycState;
import onboarding.entity.KycStatus;
import onboarding.repository.CustomerRepository;
import onboarding.repository.KycStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    private final CustomerRepository customerRepository;
    private final KycStatusRepository kycStatusRepository;

    // ✅ Constructor injection (preferred in Spring)
    public CustomerService(CustomerRepository customerRepository, KycStatusRepository kycStatusRepository) {
        this.customerRepository = customerRepository;
        this.kycStatusRepository = kycStatusRepository;
    }

    public Customer saveCustomer(Customer customer) {
        log.info("Saving new customer with ID Number: {}", customer.getIdNumber());

        // 1. Create default KYC record
        KycStatus kyc = new KycStatus();
        kyc.setStatus("NEW");  // Free text field (like DOCS_RECEIVED, VERIFIED, etc.)
        kyc.setKycStatus(KycState.PENDING); // ✅ Enum value (PENDING, APPROVED, REJECTED)
        kyc.setCustomer(customer); // link to customer

        // 2. Link both sides of the relationship
        customer.setKycStatus(kyc);

        // 3. Save customer (cascade will also save KYC)
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id) {
        log.info("Fetching customer by ID: {}", id);
        return customerRepository.findById(id).orElse(null);
    }
}
