package jam.personal_folio.portfolio.domain.tag.repository;

import jam.personal_folio.portfolio.domain.tag.entity.PortfolioTag;
import jam.personal_folio.portfolio.domain.tag.entity.Tag;
import jam.personal_folio.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioTagRepository extends JpaRepository<PortfolioTag, Long> {

    List<PortfolioTag> findByPortfolio(Portfolio portfolio);

    boolean existsByPortfolioAndTag(Portfolio portfolio, Tag tag);

    Optional<PortfolioTag> findByPortfolioAndTag(Portfolio portfolio, Tag tag);
}