package jam.personal_folio.portfolio.domain.project.repository;

import jam.personal_folio.portfolio.domain.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByPortfolioId(Long portfolioId);
}
