package jam.personal_folio.portfolio.domain.career.repository;

import jam.personal_folio.portfolio.domain.career.entity.Career;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {
    List<Career> findByPortfolioId(Long portfolioId);
}
