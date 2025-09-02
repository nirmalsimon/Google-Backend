package onboarding.repository;

import onboarding.entity.KycStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KycStatusRepository extends JpaRepository<KycStatus, Long> {
}
