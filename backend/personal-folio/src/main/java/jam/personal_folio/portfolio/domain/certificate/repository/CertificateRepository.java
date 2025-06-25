package jam.personal_folio.portfolio.domain.certificate.repository;

import jam.personal_folio.portfolio.domain.certificate.entity.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    List<Certificate> findByPortfolioId(Long portfolioId);
}
