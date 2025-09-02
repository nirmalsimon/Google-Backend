package onboarding.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "kyc_status")
public class KycStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 👇 Link to Customer
    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    private String status; // e.g. "NEW", "IN_PROGRESS"

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private KycState kycStatus; // enum (PENDING/APPROVED)

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public KycState getKycStatus() { return kycStatus; }
    public void setKycStatus(KycState kycStatus) { this.kycStatus = kycStatus; }
}
