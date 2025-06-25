package jam.personal_folio.portfolio.domain.skill.repository;

import jam.personal_folio.portfolio.domain.skill.entity.PortfolioSkill;
import jam.personal_folio.portfolio.domain.skill.entity.Skill;
import jam.personal_folio.portfolio.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioSkillRepository extends JpaRepository<PortfolioSkill, Long> {

    List<PortfolioSkill> findByPortfolio(Portfolio portfolio);

    boolean existsByPortfolioAndSkill(Portfolio portfolio, Skill skill);

    Optional<PortfolioSkill> findByPortfolioAndSkill(Portfolio portfolio, Skill skill);
}
