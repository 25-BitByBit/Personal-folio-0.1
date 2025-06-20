package jam.personal_folio.portfolio.domain.language.repository;

import jam.personal_folio.portfolio.domain.language.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
    List<Language> findByPortfolioId(Long portfolioId);
}
