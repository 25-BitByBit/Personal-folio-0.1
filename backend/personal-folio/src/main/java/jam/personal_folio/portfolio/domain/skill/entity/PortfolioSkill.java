package jam.personal_folio.portfolio.domain.skill.entity;

import jakarta.persistence.*;
import jam.personal_folio.portfolio.entity.Portfolio;
import lombok.*;

@Entity
@Table(name = "portfolio_skills")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PortfolioSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    private Skill skill;

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public static PortfolioSkill create(Portfolio portfolio, Skill skill) {
        PortfolioSkill ps = new PortfolioSkill();
        ps.setPortfolio(portfolio);
        ps.setSkill(skill);
        skill.addPortfolioSkill(ps);
        return ps;
    }
}