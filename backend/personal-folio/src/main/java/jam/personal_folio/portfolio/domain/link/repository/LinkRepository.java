package jam.personal_folio.portfolio.domain.link.repository;

import jam.personal_folio.portfolio.domain.link.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    List<Link> findByPortfolioId(Long portfolioId);
}
