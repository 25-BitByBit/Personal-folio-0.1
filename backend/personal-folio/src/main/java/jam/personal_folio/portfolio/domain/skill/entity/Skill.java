package jam.personal_folio.portfolio.domain.skill.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "skills")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<PortfolioSkill> portfolioSkills = new ArrayList<>();

    public void addPortfolioSkill(PortfolioSkill portfolioSkill) {
        portfolioSkills.add(portfolioSkill);
        portfolioSkill.setSkill(this);
    }

    public void removePortfolioSkill(PortfolioSkill portfolioSkill) {
        portfolioSkills.remove(portfolioSkill);
        portfolioSkill.setSkill(null);
    }
}